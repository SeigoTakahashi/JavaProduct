/**
 * クラス名：	ItemMenuDisplayAction
 * 概要　　：	商品情報表示アクション
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package action;

import java.util.ArrayList;

import dao.ItemMenuDisplayDBAccess;
import dao.TaxSearchDBAccess;
import model.Item;
import model.OrderControlUtility2;
import model.Tax;

public class ItemMenuDisplayAction {
	public String[][] execute() throws Exception {
		ItemMenuDisplayDBAccess access = new ItemMenuDisplayDBAccess();
		
		ArrayList<Item> list = access.searchAllItem();
		
		TaxSearchDBAccess taxAccess = new TaxSearchDBAccess();
		Tax tax = taxAccess.searchCurrentTax();
		
		for(int i = 0;i<list.size();i++) {
			int withoutTax = list.get(i).getPrice();
			int taxIn = (int)(withoutTax * (tax.getRate() + 1));
			list.get(i).setPrice(taxIn);
		}
		
		String[][] table = OrderControlUtility2.itemToArray(list);
		
		return table;
	}
}
