package com.aramini.receiptsprinter;

/*
 * Class used to model book objects.
 * It's easy to think of attributes that can be specifically associated to books, such as the editor, the number of pages, etc.
 * Those attributes were not added because they are not relevant for the assignment.
 */
public class Book extends Item 
{
	public Book()
	{
		
	}
	
	public Book(int id, String name, float price, boolean isImported) 
	{
		super(id, name, price, isImported);
	}


}
