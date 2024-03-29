package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Q. 국가코드가‘KOR’인도시를찾아인구수를역순으로표시하세요.
//	 • 도시명, 인구수

public class Test_Statement3 {
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
			ResultSet rs = st.executeQuery("select name, population from city where countrycode = \"KOR\" order by population desc");
			
			while(rs.next()) {
				System.out.print(rs.getString("name")+", ");
				System.out.println(rs.getString("population"));
			}
			
			rs.close();
			st.close();
			con.close();
		
		
		}
		catch (Exception e) {
			System.out.println("연결실패");
		}
		
		
	}
}
