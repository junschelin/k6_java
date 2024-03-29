package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryByStatment {
	public static void main(String[] args) {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			// driver 가져오기
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			
			
			Statement st = con.createStatement();
			// 읽어온 결과의 전부를 가지는 객체
			// executeQuery : select할 때
			ResultSet rs = st.executeQuery("select id, name, countrycode, district, population from city limit 10");
			
			while(rs.next()) {
				// 커서 프로세싱 : data 행 하나씩 이동하면서 읽어들이는 것
				
				System.out.print(rs.getString("id")+", ");
				System.out.print(rs.getString("name")+", ");
				System.out.print(rs.getString("countrycode")+", ");
				System.out.print(rs.getString("district")+", ");
				System.out.print(rs.getString("population") + "\n");
			}
			rs.close();
			st.close();
			con.close();
		}
		catch(Exception e){
			System.out.println("Fail to Loading");
			System.out.println(e.getMessage());
		}
	}
}
