package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Test_Statement2 {

	public static void main(String[] args) {
		System.out.println("== getCity ==\n");
		getCity();
		System.out.println("\n== getCountry ==\n");
		getCountry();
		System.out.println("\n== getLang ==\n");
		getLang();

	}

	public static void getCity() {

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
			ResultSetMetaData meta = rs1.getMetaData();
			int count = meta.getColumnCount();

			while (rs1.next()) {
				for (int i = 1; i <= count; i++) {
					System.out.print(rs1.getString(i) + ((i == count) ? "\n" : ", "));
				}
			}
			rs1.close();
			st.close();
			con.close();

		} catch (Exception e) {
			System.out.println("연결실패");
		}

	}

	public static void getCountry() {

		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";

			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);

			Statement st = con.createStatement();
			ResultSet rs2 = st.executeQuery("select * from country limit 10");
			ResultSetMetaData meta = rs2.getMetaData();
			int count = meta.getColumnCount();

			while (rs2.next()) {
				for (int i = 1; i <= count; i++) {
					System.out.print(rs2.getString(i) + ((i == count) ? "\n" : ", "));
				}
			}

			rs2.close();
			st.close();
			con.close();

		} catch (Exception e) {
			System.out.println("연결실패");
		}

	}

	public static void getLang() {

		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";

			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);

			Statement st = con.createStatement();
			ResultSet rs3 = st.executeQuery("select * from countrylanguage limit 10");
			ResultSetMetaData meta = rs3.getMetaData();
			int count = meta.getColumnCount();

			while (rs3.next()) {
				for (int i = 1; i <= count; i++) {
					System.out.print(rs3.getString(i) + ((i == count) ? "\n" : ", "));
				}
			}

			rs3.close();
			st.close();
			con.close();

		} catch (Exception e) {
			System.out.println("연결실패");
		}

	}
}
