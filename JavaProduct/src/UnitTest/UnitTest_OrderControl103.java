package UnitTest;

import action.CustomerSearchAction;

public class UnitTest_OrderControl103 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		CustomerSearchAction test1 = new CustomerSearchAction();
		String[][] table1 = null;
		//execute
		try {
			//正常系
			String[] data1 = {"09012345678","アオキマユミ"};
			table1 = test1.execute(data1);
			for(String[] v1 : table1) {
				for(String v2 : v1) {
					System.out.println(v2);
				}
				System.out.println();
			}
			
			String[] data2 = {"0314142135",""};
			table1 = test1.execute(data2);
			for(String[] v1 : table1) {
				for(String v2 : v1) {
					System.out.println(v2);
				}
				System.out.println();
			}
			
			String[] data3 = {"","イトウハナエ"};
			table1 = test1.execute(data3);
			for(String[] v1 : table1) {
				for(String v2 : v1) {
					System.out.println(v2);
				}
				System.out.println();
			}
			
			String[] data4 = {"09012345678","イトウハナエ"};
			table1 = test1.execute(data4);
			System.out.println(table1);
			
			String[] data5 = {"",""};
			table1 = test1.execute(data5);
			System.out.println(table1);
			
			
			
		} catch(Exception e) {
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}

}
