package JoinTest;

import control.KiddaLaController;

public class JoinTest_OrderControl106 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//項番1～3
		KiddaLaController controller = new KiddaLaController();

		try {
			System.out.println("項番1～3");

			String[] data1 = { "0314142135", "" };
			String[][] tableData1 = controller.customerSearch(data1);
			System.out.println(tableData1[0][0]);
			System.out.println(tableData1[0][1]);
			System.out.println(tableData1[0][2]);
			System.out.println(tableData1[0][3]);

			String[] data2 = { "", "イトウハナエ" };
			String[][] tableData2 = controller.customerSearch(data2);
			System.out.println(tableData2[0][0]);
			System.out.println(tableData2[0][1]);
			System.out.println(tableData2[0][2]);
			System.out.println(tableData2[0][3]);

			String[] data3 = { "09012345678", "アオキマユミ" };
			String[][] tableData3 = controller.customerSearch(data3);
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
