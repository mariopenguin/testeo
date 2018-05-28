package com.example.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;
@Component("conexJasper")
public class JasperReport {
	

	private Connection conn;
	
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public JasperReport()  {
		
	
		try {
			String dbUrl = "jdbc:mysql://localhost/proyectorrhh";
			String dbDriver = "com.mysql.jdbc.Driver";
			String dbUname = "springuser";
			String dbPwd = "ThePassword";
		
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
		}catch(Exception e) {
			
		}
	}
}