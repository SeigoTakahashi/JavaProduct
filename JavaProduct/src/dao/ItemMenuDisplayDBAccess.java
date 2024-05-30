/**
 * クラス名：	ItemMenuDisplayDBAccess
 * 概要　　：	商品情報表示DAO
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

import model.Item;

public class ItemMenuDisplayDBAccess extends ControlDBAccess {

	public ArrayList<Item> searchAllItem() throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Item> list = new ArrayList<Item>();

		con = createConnection();
		try {
			String sql = "SELECT * FROM ITEM;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next() == true) {
				Item item = new Item(rs.getString("ITEMID"), rs.getString("ITEMNAME"), rs.getString("SIZE"),
						rs.getInt("PRICE"));
				list.add(item);

			}

		} catch (SQLException e) {
			throw new SQLException("商品情報表示処理に失敗しました！");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new SQLException("商品情報表示処理に失敗しました！");
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new SQLException("商品情報表示処理に失敗しました！");
			}

			closeConnection(con);//場所確認
			//TODO 場所確認
		}

		return list;

	}
}
