/**
 * クラス名：	KiddaLaController
 * 概要　　：	KIDDA-LA業務システムコントローラ
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package control;

import java.util.ArrayList;

import action.CustomerSearchAction;
import action.CustomerSearchDisplayAction;
import action.DeliveryConfirmAction;
import action.ItemMenuDisplayAction;
import action.MainMenuDisplayAction;
import action.OrderInputDisplayAction;
import action.OrderRegisterAction;
import action.PrintOutAction;
import model.Customer;
import model.OrderDetail;
import view.DeliveryConfirmFrame;

public class KiddaLaController {

	public static void customerSearchDisplay() {
		CustomerSearchDisplayAction action = new CustomerSearchDisplayAction();
		action.execute();
	}

	public static String[][] customerSearch(String[] data) throws Exception {
		CustomerSearchAction action = new CustomerSearchAction();
		String[][] tableData = action.execute(data);
		return tableData;
	}

	public static void mainMenuDisplay() {
		MainMenuDisplayAction action = new MainMenuDisplayAction();
		action.execute();
	}

	public static Customer orderInputDisplay(String custId) throws Exception {
		OrderInputDisplayAction action = new OrderInputDisplayAction();
		Customer customer = action.execute(custId);
		return customer;
	}

	public static int customerModify(Customer customer) throws Exception {
		return 0;
	}

	public static void printOut(DeliveryConfirmFrame frame) throws Exception {
		PrintOutAction action = new PrintOutAction();
		action.execute(frame);
	}

	public static int deliveryComplete(String custId) throws Exception {
		return 0;
	}
	
	public static String[][] itemMenuDisplay() throws Exception{
		ItemMenuDisplayAction action = new ItemMenuDisplayAction();
		String[][] table = action.execute();
		return table;
	}
	
	public static ArrayList<OrderDetail> orderRegister(ArrayList<OrderDetail> orderDetailList) throws Exception{
		OrderRegisterAction action = new OrderRegisterAction(); 
		ArrayList<OrderDetail> list = action.execute(orderDetailList);
		return list;
	}
	
	public static ArrayList<OrderDetail> deliveryConfirm(String custId) throws Exception {
		DeliveryConfirmAction action = new DeliveryConfirmAction();
		ArrayList<OrderDetail> list = action.execute(custId);
		return list;
	}
}
