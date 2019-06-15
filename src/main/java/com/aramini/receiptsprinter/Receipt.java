package com.aramini.receiptsprinter;

/*
 * Simple wrapper class for the text on the receipt.
 */
public class Receipt 
{
	private String receiptText;
	
	public Receipt()
	{
		receiptText="";
	}
	
	public void addLine(String line)
	{
		receiptText += line + "\n";
	}
	
	public String toString()
	{
		return receiptText;
	}
}
