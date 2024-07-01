package com.springimplant.main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCQ1 implements DriverAction{
	public static void main (String args[]) {
		try {
			String strURL = "jdbc:mysql://localhost:3306/jdbcdb";
			String strUsername = "root";
			String strPassword = "root@04G";
			DriverAction driAction = new JDBCQ1();
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver,driAction);
			Connection conJDBC = DriverManager.getConnection(strURL,strUsername,strPassword);
			Statement stmtStatement = conJDBC.createStatement();
			ResultSet rs = stmtStatement.executeQuery("select student_id from Student");
			System.out.println("student_id");
			while(rs.next()) {
				System.out.println(rs.getInt(1));
			}
			conJDBC.close();
			DriverManager.deregisterDriver(driver);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deregister() {
		// TODO Auto-generated method stub
		
	}
}
