package org.wipro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class SqlDemo {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	//1. load the driver
   
		Class.forName("oracle.jdbc.driver.OracleDriver");



	//2.connet to database
	Connection c = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","hr","Kambli@15");
	//3 write sql query
	String s = "select * from employees";
	//4. prepare the statment
	PreparedStatement prepareStatement = c.prepareStatement(s);
	
	//5 execute query 
	ResultSet rs = prepareStatement.executeQuery();
	//6.iterate the result
	while(rs.next()) {
		
		String string1 = rs.getString("First_Name");
		String string2 = rs.getString("Last_Name");
		System.out.println(string1);
		System.out.println(string2);
	}
	//7 close the db connection
	c.close();
}
}
