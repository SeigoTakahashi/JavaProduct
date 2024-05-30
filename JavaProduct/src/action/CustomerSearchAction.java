package action;

import java.util.ArrayList;

import dao.CustomerSearchDBAccess;
import model.Customer;
import model.OrderControlUtility;

public class CustomerSearchAction {

	public String[][] execute(String[] data) throws Exception {
		String tel = data[0].replaceAll("　| ", "");
		String kana = data[1].replaceAll("　| ", "");
		ArrayList<Customer> list = new ArrayList<Customer>();
		String[][] tableData = null;
		CustomerSearchDBAccess access = new CustomerSearchDBAccess();
		if ((!("".equals(data[0])) && ("".equals(data[1])))) {
			list = access.searchCustomerByTel(tel);
		} else if (("".equals(data[0]) && (!("".equals(data[1]))))) {
			list = access.searchCustomerByKana(kana);
		} else if ((!("".equals(data[0])) && (!("".equals(data[1]))))) {
			list = access.searchCustomer(tel, kana);
		}
		if(list != null && list.size() != 0) {
			tableData = OrderControlUtility.customerToArray(list);
		}
		

		return tableData;

	}
}
