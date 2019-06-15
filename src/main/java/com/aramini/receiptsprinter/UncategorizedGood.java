package com.aramini.receiptsprinter;

/*
 * Class used to model all those goods that don't fall under the other three categories (Books, Food and Medical products).
 * These items can have a number of different attributes depending on the kind of object itself.
 * This category was created for conveniently handling the assignment, but realistically other categories should exist.
 */
public class UncategorizedGood extends Item 
{
	public UncategorizedGood()
	{
		
	}

	public UncategorizedGood(int id, String name, float price, boolean isImported) 
	{
		super(id, name, price, isImported);
	}

	

}
