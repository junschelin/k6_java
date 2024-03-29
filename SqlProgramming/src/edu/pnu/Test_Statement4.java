package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;


public class Test_Statement4 {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("Table Name : ");
			String tblname = sc.next();
			test(tblname);
		}
	}
	
	
	public static void test(String tblname) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "scott", "tiger");
			
			st = con.createStatement();
			rs = st.executeQuery("select * from " + tblname + " limit 10");
			
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			while(rs.next()) {
				for (int i = 1; i <= count; i++) {
					System.out.print(rs.getString(i) + ((i==count)?"":", "));
				}
				System.out.println();
			}
		}
		catch(Exception e){
			System.out.println("Loading Failed");
		}
	}
}
