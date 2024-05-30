package JoinTest;

import action.CustomerSearchAction;

public class JoinTest_OrderControl105 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		//項番1～2
				CustomerSearchAction action = new CustomerSearchAction();
				

				try {
					System.out.println("項番1～2");
					
					String[] data1 = {"0314142135",""};
					String[][]tableData1 = action.execute(data1);
					System.out.println(tableData1[0][0]);
					System.out.println(tableData1[0][1]);
					System.out.println(tableData1[0][2]);
					System.out.println(tableData1[0][3]);
					
					String[] data2 = {"","イトウハナエ"};
					String[][]tableData2 = action.execute(data2);
					System.out.println(tableData2[0][0]);
					System.out.println(tableData2[0][1]);
					System.out.println(tableData2[0][2]);
					System.out.println(tableData2[0][3]);

					String[] data3 = {"09012345678","アオキマユミ"};
					String[][]tableData3 = action.execute(data3);
					System.out.println(tableData3[0][0]);
					System.out.println(tableData3[0][1]);
					System.out.println(tableData3[0][2]);
					System.out.println(tableData3[0][3]);

				} catch (Exception e) {
					System.out.println(e.getClass().getName());
					System.out.println(e.getMessage());
				}
		

	}

}
