/**
 * クラス名：	OrderRegisterAction
 * 概要　　：	注文情報登録アクション
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package action;

import java.util.ArrayList;

import dao.DeliveryConfirmDBAccess;
import dao.OrderInputDisplayDBAccess;
import dao.OrderRegisterDBAccess;
import dao.TaxSearchDBAccess;
import model.Customer;
import model.OrderDetail;
import model.Tax;

public class OrderRegisterAction {
	public ArrayList<OrderDetail> execute(ArrayList<OrderDetail> orderDetailList) throws Exception {
		OrderRegisterDBAccess access = new OrderRegisterDBAccess();
		
		TaxSearchDBAccess taxAccess = new TaxSearchDBAccess();
		Tax tax = taxAccess.searchCurrentTax();
		OrderInputDisplayDBAccess customerAccess = new OrderInputDisplayDBAccess(); 
		int custId = 0;
		for(OrderDetail orderdetail : orderDetailList) {
			orderdetail.setTax(tax);
			Customer customer = customerAccess.searchCustomerById(orderdetail.getCustomer().getCustId());
			orderdetail.setCustomer(customer);
			custId = customer.getCustId();
		}
		access.registerOrder(orderDetailList);
		DeliveryConfirmDBAccess deliveryAccess = new DeliveryConfirmDBAccess();
		ArrayList<OrderDetail> list = deliveryAccess.searchDeliveryByCustID(custId);
		return list;
	}
}
