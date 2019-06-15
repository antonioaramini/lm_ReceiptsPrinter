package com.aramini.receiptsprinter;

import java.util.Locale;

import javafx.util.Pair;

/*
 * Utility class used to compute the taxed price of items and to create the final receipt for a shopping basket.
 */
public class CashDesk 
{
	public static Receipt createReceipt(ShoppingBasket basket)
	{
		Receipt receipt = new Receipt();
		float taxes = 0f;
		float total = 0f;
		for(Pair<Item,Integer> pair:basket.getBasket())
		{
			String newReceiptLine = pair.getValue().toString() + " " + pair.getKey().getName() + ": ";
			float taxedPrice = CashDesk.getTaxedPrice(pair.getKey());
			taxes += pair.getValue() * (taxedPrice - pair.getKey().getPrice());
			total += pair.getValue() * taxedPrice;
			newReceiptLine += String.format(Locale.US, "%.2f", pair.getValue() * taxedPrice);
			receipt.addLine(newReceiptLine);
		}
		
		receipt.addLine("Sales Taxes: " + String.format(Locale.US, "%.2f", taxes));
		receipt.addLine("Total: " + String.format(Locale.US,  "%.2f", total));
		return receipt;
	}
	
	public static float getTaxedPrice(Item item)
	{
		float taxRate = item.isImported() ? 0.05f : 0f;
		if (item instanceof UncategorizedGood)
			taxRate += 0.1f;
		return (float)Math.ceil(taxRate*item.getPrice()*20)/20 + item.getPrice();
	}
	
}
