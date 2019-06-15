package com.aramini.receiptsprinter;

import java.util.HashMap;

public class ShoppingBasket 
{
	private HashMap<Item, Integer> basket;
	
	public ShoppingBasket()
	{
		this.basket=new HashMap<Item, Integer>();
	}
	
	public void clearBasket()
	{
		basket.clear();
	}
	
	public void addItem(Item item)
	{
		if (basket.containsKey(item))
			basket.put(item, basket.get(item)+1);
		else
			basket.put(item, 1);
	}
	
	public void removeItem(Item item)
	{
		basket.remove(item);
	}
}
