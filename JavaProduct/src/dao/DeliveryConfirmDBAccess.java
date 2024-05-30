/**
 * クラス名：	DeliveryConfirmDBAccess
 * 概要　　：	配達確認DAO
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

public class DeliveryConfirmDBAccess extends ControlDBAccess{
	
	public ArrayList<OrderDetail> searchDeliveryByCustID(int custId) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderDetail> list = new ArrayList<OrderDetail>();

		con = createConnection();
		try {
			String sql = "SELECT * FROM ORDERDETAIL "
					+ "INNER JOIN ITEM ON ORDERDETAIL.ITEMID = ITEM.ITEMID "
					+ "INNER JOIN TAX ON ORDERDETAIL.TAXID = TAX.TAXID "
					+ "INNER JOIN CUSTOMER ON ORDERDETAIL.CUSTID = CUSTOMER.CUSTID "
					+ "WHERE ORDERDETAIL.CUSTID = ? AND ORDERDETAIL.STATUS = 1;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, custId);
			rs = pstmt.executeQuery();
			while (rs.next() == true) {
				Customer customer = new Customer(rs.getInt("CUSTID"), rs.getString("CUSTNAME"), rs.getString("KANA"),
						rs.getNString("TEL"), rs.getString("ADDRESS"));
				Item item = new Item(rs.getString("ITEMID"), rs.getString("ITEMNAME"), rs.getString("SIZE"),
						rs.getInt("PRICE"));
				Tax tax = new Tax(rs.getInt("TAXID"), rs.getDouble("RATE"), rs.getString("ENDDATE"));
				OrderDetail orderdetail = new OrderDetail(rs.getLong("NO"), customer, item, rs.getString("ORDERDATE"),
						rs.getInt("QUANTITY"), tax, rs.getInt("STATUS"));
				list.add(orderdetail);

			}

		} catch (SQLException e) {
			throw new SQLException("配達情報確認処理に失敗しました！");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new SQLException("配達情報確認処理に失敗しました！");
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new SQLException("配達情報確認処理に失敗しました！");
			}

			closeConnection(con);//場所確認
			//TODO 場所確認
		}

		return list;
	}
}
