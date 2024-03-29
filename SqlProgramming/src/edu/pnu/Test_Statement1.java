package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test_Statement1 {
	public static void main(String[] args) {
		
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			
			Statement st = con.createStatement();
			ResultSet rs1 = st.executeQuery("select * from city limit 10");
			
			while(rs1.next()) {
				System.out.print(rs1.getString("id")+", ");
				System.out.print(rs1.getString("name")+ ", ");
				System.out.print(rs1.getString("countrycode")+ ", ");
				System.out.print(rs1.getString("district")+", ");
				System.out.print(rs1.getString("population")+"\n");
			}
			System.out.println();
			rs1.close();
			
			ResultSet rs2= st.executeQuery("select * from country limit 10");
			
			while(rs2.next()) {
				System.out.print(rs2.getString("code")+", ");
				System.out.print(rs2.getString("name")+ ", ");
				System.out.print(rs2.getString("continent")+ ", ");
				System.out.print(rs2.getString("region")+", ");
				System.out.print(rs2.getString("surfacearea")+", ");
				System.out.print(rs2.getString("indepyear")+", ");
				System.out.print(rs2.getString("population")+ ", ");
				System.out.print(rs2.getString("lifeexpectancy")+ ", ");
				System.out.print(rs2.getString("gnp")+", ");
				System.out.print(rs2.getString("gnpold")+", ");
				System.out.print(rs2.getString("localname")+", ");
				System.out.print(rs2.getString("governmentform")+ ", ");
				System.out.print(rs2.getString("headofstate")+ ", ");
				System.out.print(rs2.getString("capital")+"\n");
			}
			System.out.println();
			rs2.close();
			
			ResultSet rs3 = st.executeQuery("select * from countrylanguage limit 10");
			while(rs3.next()) {
				System.out.print(rs3.getString("countrycode")+", ");
				System.out.print(rs3.getString("language")+ ", ");
				System.out.print(rs3.getString("IsOfficial")+ ", ");
				System.out.print(rs3.getString("Percentage")+"\n");
			}
			System.out.println();
			
			
			rs3.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("연결실패");
		}
		
	}
}
