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

import com.jersey.spring.hibernate.server.model.mappedBy.ContractEmployee;
import com.jersey.spring.hibernate.server.model.mappedBy.Employee;
import com.jersey.spring.hibernate.server.model.mappedBy.RegularEmployee;
import com.jersey.spring.hibernate.server.model.tableperclasshierarchey.Animal;
import com.jersey.spring.hibernate.server.model.tableperclasshierarchey.Cat;
import com.jersey.spring.hibernate.server.model.tableperclasshierarchey.Dog;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Laptop;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Mobile;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.OperatingSystem;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Phones;
import com.jersey.spring.hibernate.server.model.tableperconcreteclass.Tablets;


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
		dataSource.setUrl("jdbc:mysql://localhost:3306/hibernate_inheritance");
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
										Employee.class,
										RegularEmployee.class,
										ContractEmployee.class,
										Animal.class,
										Cat.class,
										Dog.class,
										Mobile.class,
										OperatingSystem.class,
										Laptop.class,
										Phones.class,
										Tablets.class
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
