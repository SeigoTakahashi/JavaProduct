/**
 * クラス名：	TaxSearchDBAccess
 * 概要　　：	消費税検索DAO
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

import model.Tax;

public class TaxSearchDBAccess extends ControlDBAccess{
	
	public Tax searchCurrentTax() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Tax tax = new Tax();

		con = createConnection();
		try {
			String sql = "SELECT * FROM TAX WHERE ENDDATE IS NULL;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				tax.setTaxId(rs.getInt("TAXID"));
				tax.setRate(rs.getDouble("RATE"));
				tax.setEndDate(rs.getString("ENDDATE"));
			}
			

		} catch (SQLException e) {
			throw new SQLException("消費税検索処理に失敗しました！");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new SQLException("消費税検索処理に失敗しました！");
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				throw new SQLException("消費税検索処理に失敗しました！");
			}

			closeConnection(con);//場所確認
			//TODO 場所確認
		}
		
		return tax;

	}
		
	
}
