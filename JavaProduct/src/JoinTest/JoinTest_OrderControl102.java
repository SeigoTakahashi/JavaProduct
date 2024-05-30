package JoinTest;

import java.util.ArrayList;

import dao.CustomerSearchDBAccess;
import model.Customer;

public class JoinTest_OrderControl102 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//項番1～4
		CustomerSearchDBAccess access = new CustomerSearchDBAccess();
		ArrayList<Customer> list = new ArrayList<Customer>();

		try {
			System.out.println("項番1～4");
			list = access.searchCustomerByTel("09012345678");
			
			for (Customer v : list) {
				System.out.println(v.getCustId());
				System.out.println(v.getCustName());
				System.out.println(v.getKana());
				System.out.println(v.getTel());
				System.out.println(v.getAddress());
			}

			list = access.searchCustomerByKana("ワタナベ");

			for (Customer v : list) {
				System.out.println(v.getCustId());
				System.out.println(v.getCustName());
				System.out.println(v.getKana());
				System.out.println(v.getTel());
				System.out.println(v.getAddress());
			}
			
			list = access.searchCustomer("09012345678", "アオキマユミ");

			for (Customer v : list) {
				System.out.println(v.getCustId());
				System.out.println(v.getCustName());
				System.out.println(v.getKana());
				System.out.println(v.getTel());
				System.out.println(v.getAddress());
			}

		} catch (Exception e) {
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
		}

	}

}
