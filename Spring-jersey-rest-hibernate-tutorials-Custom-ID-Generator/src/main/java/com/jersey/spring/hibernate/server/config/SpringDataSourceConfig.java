package com.jersey.spring.hibernate.server.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jersey.spring.hibernate.server.model.TicketBooking;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.jersey.spring.hibernate")
public class SpringDataSourceConfig {

	/**
	 * Configure data sources.
	 * @return
	 */
	@Bean
	public DataSource getDatasource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ticket_booking_system");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;
	}

	/**
	 * configure session factory to get the session factory of the application 
	 * @return
	 * @throws IOException
	 */
	@Bean
	public SessionFactory getSessionFactory() throws IOException{

		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setHibernateProperties(getHibernateProperties());
		sessionFactoryBean
		.setAnnotatedClasses(
				new Class[] { 
						TicketBooking.class
				});
		sessionFactoryBean.setDataSource(getDatasource());
		sessionFactoryBean.afterPropertiesSet();

		return sessionFactoryBean.getObject();
	}

	/**
	 * properties to be applied to configure a successful hibernate connection to mySQL 
	 * @return
	 */
	private static Properties getHibernateProperties() {

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		hibernateProperties.put("hibernate.show_sql", true);
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		return hibernateProperties;
	}

	/**
	 *  configure transaction 
	 * @return
	 * @throws IOException
	 */
	@Bean
	public HibernateTransactionManager getTransactionManager() throws IOException{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory());

		return transactionManager;
	}
}
