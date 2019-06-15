package com.aramini.receiptsprinter;

import java.util.ArrayList;
import javafx.util.Pair;

public class ShoppingBasket 
{
	private ArrayList<Pair<Item, Integer>> basket;
	
	public ShoppingBasket()
	{
		this.basket=new ArrayList<Pair<Item,Integer>>();
	}
	
	public void clearBasket()
	{
		basket.clear();
	}
	
	public void addItem(Pair<Item,Integer> item)
	{
		basket.add(item);
	}
	
	public ArrayList<Pair<Item, Integer>> getBasket()
	{
		return basket;
	}
	
}
