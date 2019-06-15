package com.aramini.receiptsprinter;

/*
 * Parent class for all buyable goods; contains all the shared attributes.
 */
public abstract class Item 
{
	private int id;
	private String name;
	private float price;
	private boolean isImported;

	public Item()
	{
		
	}
	
	public Item(int id,String name,float price,boolean isImported)
	{
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setImported(isImported);
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public float getPrice() 
	{
		return price;
	}

	public void setPrice(float price) 
	{
		this.price = price;
	}

	public boolean isImported() 
	{
		return isImported;
	}

	public void setImported(boolean isImported) 
	{
		this.isImported = isImported;
	}
	
	
}
