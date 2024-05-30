/**
 * クラス名：	DeliveryConfirmAction
 * 概要　　：	配達情報確認アクション
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package action;

import java.util.ArrayList;

import dao.DeliveryConfirmDBAccess;
import model.OrderDetail;

public class DeliveryConfirmAction {
	
	public ArrayList<OrderDetail> execute(String custId) throws Exception {
		int args = Integer.parseInt(custId);
		DeliveryConfirmDBAccess access = new DeliveryConfirmDBAccess();
		ArrayList<OrderDetail> list = access.searchDeliveryByCustID(args);
		return list;
		
	}
}
