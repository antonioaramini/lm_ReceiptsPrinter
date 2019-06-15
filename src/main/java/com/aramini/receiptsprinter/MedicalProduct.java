package com.aramini.receiptsprinter;

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
