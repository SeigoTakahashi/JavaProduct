/**
 * クラス名：	OrderRegisterDBAccess
 * 概要　　：	注文情報登録DAO
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;
import model.Item;
import model.OrderDetail;
import model.Tax;

public class OrderRegisterDBAccess extends ControlDBAccess {
	public void registerOrder(ArrayList<OrderDetail> list) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = createConnection();

		try {
			String sql = "INSERT INTO ORDERDETAIL VALUES (?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			for (OrderDetail orderdetail : list) {
				
				pstmt.setLong(1, orderdetail.getNo());
				
				Customer customer = orderdetail.getCustomer();
				pstmt.setInt(2, customer.getCustId());
				
				Item item = orderdetail.getItem();
				pstmt.setString(3, item.getItemId());
				
				pstmt.setString(4, orderdetail.getOrderDate());
				
				pstmt.setInt(5, orderdetail.getQuantity());
				
				TaxSearchDBAccess access = new TaxSearchDBAccess();
				Tax tax = access.searchCurrentTax();
				pstmt.setInt(6, tax.getTaxId());
				
				pstmt.setInt(7, orderdetail.getStatus());
				
			}

			int result = pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new SQLException("注文情報登録処理に失敗しました！");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new SQLException("注文情報登録処理に失敗しました！");
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new SQLException("注文情報登録処理に失敗しました！");
			}

			closeConnection(con);//場所確認
			//TODO 場所確認
		}

	}
}
