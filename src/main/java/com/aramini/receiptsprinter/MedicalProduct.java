package com.aramini.receiptsprinter;

/*
 * Class used to model medical objects.
 * It's easy to think of attributes that can be specifically associated to medical products, such as the expiration date, the pharmaceutical company, etc.
 * Those attributes were not added because they are not relevant for the assignment.
 */
public class MedicalProduct extends Item 
{
	public MedicalProduct()
	{
		
	}
	
	public MedicalProduct(int id, String name, float price, boolean isImported) 
	{
		super(id, name, price, isImported);
	}


}
