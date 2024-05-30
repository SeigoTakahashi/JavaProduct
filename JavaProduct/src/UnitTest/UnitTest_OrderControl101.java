package UnitTest;

import model.Customer;

public class UnitTest_OrderControl101 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		//Customerコンストラクタ
		//正常系
		Customer test1 = new Customer(1, "青木まゆみ", "アオキマユミ", "09012345678", "東京都千代田区神田小川町1-1-1");
		System.out.println(test1.getCustId());
		System.out.println(test1.getCustName());
		System.out.println(test1.getKana());
		System.out.println(test1.getTel());
		System.out.println(test1.getAddress());
		//異常系
		Customer test2 = new Customer(0,null,null,null,null);
		System.out.println(test2.getCustId());
		System.out.println(test2.getCustName());
		System.out.println(test2.getKana());
		System.out.println(test2.getTel());
		System.out.println(test2.getAddress());
		
		Customer test3 = new Customer();
		
		//custId
		//正常系
		test3.setCustId(2);
		System.out.println(test3.getCustId());
		//異常系
		test3.setCustId(0);
		System.out.println(test3.getCustId());
		
		//custName
		//正常系
		test3.setCustName("青木まゆみ");
		System.out.println(test3.getCustName());
		//異常系
		test3.setCustName(null);
		System.out.println(test3.getCustName());
		
		//kana
		//正常系
		test3.setKana("アオキマユミ");
		System.out.println(test3.getKana());
		//異常系
		test3.setKana(null);
		System.out.println(test3.getKana());
		
		//tel
		//正常系
		test3.setTel("09012345678");
		System.out.println(test3.getTel());
		//異常系
		test3.setTel(null);
		System.out.println(test3.getTel());
		
		//address
		//正常系
		test3.setAddress("東京都千代田区神田小川町1-1-1");
		System.out.println(test3.getAddress());
		//異常系
		test3.setAddress(null);
		System.out.println(test3.getAddress());
		
		
		
		
		
		
		

	}

}
