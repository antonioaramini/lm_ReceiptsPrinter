package com.aramini.receiptsprinter;

/*
 * Class used to model food objects.
 * It's easy to think of attributes that can be specifically associated to food, such as the weight, the expiration date, etc.
 * Those attributes were not added because they are not relevant for the assignment.
 */
public class Food extends Item 
{
	public Food()
	{
		
	}
	
	public Food(int id, String name, float price, boolean isImported) 
	{
		super(id, name, price, isImported);
	}

	

}
