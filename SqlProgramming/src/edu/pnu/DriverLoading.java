package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DriverLoading {
	public static void main(String[] args) {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
						
			System.out.println("Success to Loading");
			con.close();
		}
		catch(Exception e){
			System.out.println("Fail to Loading");
			System.out.println(e.getMessage());
		}
	}
}