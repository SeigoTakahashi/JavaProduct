package JoinTest;

import java.util.ArrayList;

import model.Customer;
import model.OrderControlUtility;

public class JoinTest_OrderControl101 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	
		//項番1～5
		ArrayList<Customer> list = new ArrayList<Customer>();
		Customer customer = new Customer(1,"西島康介","ニシジマコウスケ","01234567890","東京都荒川区西日暮里");
		
		list.add(customer);
		String[][] tableData = OrderControlUtility.customerToArray(list);
		
		System.out.println("項番1～5");
		System.out.println(tableData[0][0]);
		System.out.println(tableData[0][1]);
		System.out.println(tableData[0][2]);
		System.out.println(tableData[0][3]);
		
		
		
		
		
		

	}

}
