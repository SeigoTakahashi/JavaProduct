package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;

public class CustomerSearchDBAccess extends ControlDBAccess {

	public ArrayList<Customer> searchCustomerByTel(String tel) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();

		con = createConnection();
		try {
			String sql = "SELECT CUSTID, CUSTNAME, KANA, TEL, ADDRESS FROM CUSTOMER WHERE TEL = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tel);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				Customer customer = new Customer(rs.getInt("CUSTID"), rs.getString("CUSTNAME"), rs.getString("KANA"),
						rs.getString("TEL"), rs.getString("ADDRESS"));
				list.add(customer);

			}

		} catch (SQLException e) {
			throw new SQLException("顧客情報検索処理に失敗しました！");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new SQLException("顧客情報検索処理に失敗しました！");
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new SQLException("顧客情報検索処理に失敗しました！");
			}

			closeConnection(con);//場所確認
			//TODO 場所確認
		}

		return list;
	}

	public ArrayList<Customer> searchCustomerByKana(String kana) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();

		con = createConnection();
		try {
			String sql = "SELECT CUSTID, CUSTNAME, KANA, TEL, ADDRESS FROM CUSTOMER WHERE KANA LIKE ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + kana + "%");
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				Customer customer = new Customer(rs.getInt("CUSTID"), rs.getString("CUSTNAME"), rs.getString("KANA"),
						rs.getString("TEL"), rs.getString("ADDRESS"));
				list.add(customer);

			}

		} catch (SQLException e) {
			throw new SQLException("顧客情報検索処理に失敗しました！");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new SQLException("顧客情報検索処理に失敗しました！");
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new SQLException("顧客情報検索処理に失敗しました！");
			}
			closeConnection(con);
		}

		return list;
	}

	public ArrayList<Customer> searchCustomer(String tel, String kana) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();

		con = createConnection();
		try {
			String sql = "SELECT CUSTID, CUSTNAME, KANA, TEL, ADDRESS FROM CUSTOMER WHERE TEL = ? AND KANA LIKE ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tel);
			pstmt.setString(2, "%" + kana + "%");
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				Customer customer = new Customer(rs.getInt("CUSTID"), rs.getString("CUSTNAME"), rs.getString("KANA"),
						rs.getString("TEL"), rs.getString("ADDRESS"));
				list.add(customer);

			}

		} catch (SQLException e) {
			throw new SQLException("顧客情報検索処理に失敗しました！");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(con);
		}

		return list;
	}

}
