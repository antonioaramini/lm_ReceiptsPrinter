package com.aramini.receiptsprinter;

import javafx.util.Pair;

public class CashDesk 
{
	public static Receipt createReceipt(ShoppingBasket basket)
	{
		Receipt receipt = new Receipt();
		for(Pair<Item,Integer> pair:basket.getBasket())
		{
			
		}
		
		return receipt;
	}
	
	public static float getTaxedPrice(Item item)
	{
		return 0;
	}
	
}
