package com.aramini.receiptsprinter;

import java.util.HashMap;
import java.util.HashSet;

import com.aramini.receiptsprinter.exceptions.UnknownItemIdException;

import javafx.util.*;

public class InputParser 
{
	// Mapping Id of Item to the Item itself.
	private HashMap<Integer, Item> itemsMap;
	
	private HashSet<String> bookKeywords;
	private HashSet<String> foodKeywords;
	private HashSet<String> medProdKeywords;
	
	public InputParser()
	{
		initHashMap();
		initHashSets();
	}
	
	private void initHashMap()
	{
		itemsMap = new HashMap<Integer, Item>();
		
		itemsMap.put(123000, new Book(123000, "book", 12.49f, false));
		itemsMap.put(123001, new UncategorizedGood(123001, "music CD", 14.99f, false));
		itemsMap.put(123002, new Food(123002, "chocolate bar", 0.85f, false));
		itemsMap.put(123003, new Food(123003, "imported box of chocolates", 10.00f, true));
		itemsMap.put(123004, new UncategorizedGood(123004, "imported bottle of perfume", 47.50f, true));
		itemsMap.put(123005, new UncategorizedGood(123005, "imported bottle of perfume", 27.99f, true));
		itemsMap.put(123006, new Book(123006, "bottle of perfume", 18.99f, false));
		itemsMap.put(123007, new Book(123007, "packet of headache pills", 9.75f, false));
		itemsMap.put(123008, new Book(123008, "box of imported chocolates", 11.25f, true));
	}
	
	private void initHashSets()
	{
		bookKeywords = new HashSet<String>();
		bookKeywords.add("book");
		
		foodKeywords = new HashSet<String>();
		foodKeywords.add("chocolate");
		
		medProdKeywords = new HashSet<String>();
		medProdKeywords.add("headache");
	}
	
	public Pair<Item,Integer> getItemFromInputLineWithId(String inputLine) throws UnknownItemIdException
	{
		Integer quantity = Integer.parseInt(inputLine.substring(0, inputLine.indexOf(' ')));
		Integer itemId = Integer.parseInt(inputLine.substring(inputLine.indexOf(' ')+1));
		if (itemsMap.get(itemId) == null)
			throw new UnknownItemIdException("Item ID is unknown!");
		
		return new Pair<Item,Integer>(itemsMap.get(itemId),quantity);
	}
	
	
	public Pair<Item,Integer> getItemFromInputLine(String inputLine)
	{
		Integer quantity = Integer.parseInt(inputLine.substring(0, inputLine.indexOf(' ')));
		Float itemPrice = Float.parseFloat(inputLine.substring(inputLine.lastIndexOf("at")+3));
		boolean isItemImported = inputLine.toLowerCase().contains("imported");
		String itemName = inputLine.substring(inputLine.indexOf(' ')+1, inputLine.lastIndexOf("at")-1);
		String[] itemKeywords = itemName.split("\\s+");
		Item item = null;
		
		for(String k:itemKeywords)
		{
			if (bookKeywords.contains(k.toLowerCase()))
			{
				item = new Book();
				break;
			}
			else if (foodKeywords.contains(k.toLowerCase()))
			{
				item = new Food();
				break;
			}
			else if (medProdKeywords.contains(k.toLowerCase()))
			{
				item = new MedicalProduct();
				break;
			}
		}
		if (item == null)
			item = new UncategorizedGood();
		
		item.setName(itemName);
		item.setPrice(itemPrice);
		item.setImported(isItemImported);
		
		return new Pair<Item,Integer>(item,quantity);
	}
	
	public ShoppingBasket createBasketFromInputTextWithId(String inputText) throws UnknownItemIdException
	{
		ShoppingBasket basket = new ShoppingBasket();
		String[] lines = inputText.split("\r\n");
		for(String l:lines)
			basket.addItem(getItemFromInputLineWithId(l));
		
		return basket;
	}
	
	public ShoppingBasket createBasketFromInputText(String inputText)
	{
		ShoppingBasket basket = new ShoppingBasket();
		String[] lines = inputText.split("\\r?\\n");
		for(String l:lines)
			basket.addItem(getItemFromInputLine(l));
		
		return basket;
	}
	
}
