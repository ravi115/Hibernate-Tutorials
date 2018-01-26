package com.jersey.spring.hibernate.server.id.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

@Component
public class CustomIdentifier implements IdentifierGenerator {

	private String defaultPrefix = "MOV-";

	private int defaultNumber = 1;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		String movieID = "";
		String digits = "";
		Connection connection = session.connection();
		
		try {
			PreparedStatement stmt = connection
					.prepareStatement("select movie_id from ticket_booking order by created_at desc limit 1");
			
			ResultSet result = stmt.executeQuery();
			
			if(null != result && result.next() ) {
				
				movieID = result.getString("movie_id");
				
				System.out.println("<---- ID Retrived is ------->\n"+movieID);
				
				String prefix = movieID.substring(0, 4);
				String[] str  = movieID.split(prefix);
				digits = String.format("%07d", Integer.parseInt(str[1]) + 1);
				movieID = prefix.concat(digits);
			}else {
				digits = String.format("%07d", defaultNumber);
				movieID = defaultPrefix.concat(digits);
			}
				
		}catch(Exception e) {
			System.out.println("caught Exception is : " + e.getMessage());
		}

		return movieID;
	}

}
