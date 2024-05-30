package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ControlDBAccess {
	
	protected Connection createConnection() throws Exception {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/KIDDA_LA",
					"user1",
					"pass1");

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("DB接続処理に失敗しました！");
		} catch (SQLException e) {
			throw new SQLException("DB接続処理に失敗しました！");
		}

		return con;
	}
	
	protected void closeConnection(Connection con) throws Exception {

		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			throw new SQLException("DB接続処理に失敗しました！");
		}

	}

}
