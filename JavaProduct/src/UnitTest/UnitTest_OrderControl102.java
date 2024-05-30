package UnitTest;

import java.util.ArrayList;

import dao.CustomerSearchDBAccess;
import model.Customer;

public class UnitTest_OrderControl102 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//searchCustomerByTel
		CustomerSearchDBAccess test1 = new CustomerSearchDBAccess();
		ArrayList<Customer> list1 = new ArrayList<Customer>();
		try {
			//正常系
			list1 = test1.searchCustomerByTel("09012345678");
			System.out.println(list1.size() + "件");
			for (Customer v : list1) {
				System.out.println(v.getCustId());
				System.out.println(v.getCustName());
				System.out.println(v.getKana());
				System.out.println(v.getTel());
				System.out.println(v.getAddress());
			}

			list1 = test1.searchCustomerByTel("0314142135");
			System.out.println(list1.size() + "件");
			for (Customer v : list1) {
				System.out.println(v.getCustId());
				System.out.println(v.getCustName());
				System.out.println(v.getKana());
				System.out.println(v.getTel());
				System.out.println(v.getAddress());
			}

			list1 = test1.searchCustomerByTel("08088523487");
			System.out.println(list1.size() + "件");

			//異常系
			list1 = test1.searchCustomerByTel(null);
			System.out.println(list1.size() + "件");

		} catch (Exception e) {
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
		}

		//searchCustomerByKana
		CustomerSearchDBAccess test2 = new CustomerSearchDBAccess();
		ArrayList<Customer> list2 = new ArrayList<Customer>();
		try {
			//正常系
			list2 = test2.searchCustomerByKana("ワタナベ");
			System.out.println(list2.size() + "件");
			for (Customer v : list2) {
				System.out.println(v.getCustId());
				System.out.println(v.getCustName());
				System.out.println(v.getKana());
				System.out.println(v.getTel());
				System.out.println(v.getAddress());
			}

			list2 = test2.searchCustomerByKana("イトウハナエ");
			System.out.println(list2.size() + "件");
			for (Customer v : list2) {
				System.out.println(v.getCustId());
				System.out.println(v.getCustName());
				System.out.println(v.getKana());
				System.out.println(v.getTel());
				System.out.println(v.getAddress());
			}

			list2 = test2.searchCustomerByKana("タカハシセイゴ");
			System.out.println(list2.size() + "件");

			//異常系
			list2 = test2.searchCustomerByKana(null);
			System.out.println(list2.size() + "件");

		} catch (Exception e) {
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
		}

		//searchCustomer
		CustomerSearchDBAccess test3 = new CustomerSearchDBAccess();
		ArrayList<Customer> list3 = new ArrayList<Customer>();
		try {
			//正常系
			list3 = test3.searchCustomer("09012345678", "アオキマユミ");
			System.out.println(list3.size() + "件");
			for (Customer v : list3) {
				System.out.println(v.getCustId());
				System.out.println(v.getCustName());
				System.out.println(v.getKana());
				System.out.println(v.getTel());
				System.out.println(v.getAddress());
			}

			list3 = test3.searchCustomer("08088523487", "タカハシセイゴ");
			System.out.println(list3.size() + "件");

			list3 = test3.searchCustomer("09012345678", "タカハシセイゴ");
			System.out.println(list3.size() + "件");

			list3 = test3.searchCustomer("08088523487", "アオキマユミ");
			System.out.println(list3.size() + "件");

			list3 = test3.searchCustomer("09087654321", "タカハシユウヤ");
			System.out.println(list3.size() + "件");
			for (Customer v : list3) {
				System.out.println(v.getCustId());
				System.out.println(v.getCustName());
				System.out.println(v.getKana());
				System.out.println(v.getTel());
				System.out.println(v.getAddress());
			}

			//異常系
			list3 = test3.searchCustomer(null, null);
			System.out.println(list3.size() + "件");

		} catch (Exception e) {
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
		}

	}

}
