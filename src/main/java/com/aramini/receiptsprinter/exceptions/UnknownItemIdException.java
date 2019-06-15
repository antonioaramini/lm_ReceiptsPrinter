package com.aramini.receiptsprinter.exceptions;

public class UnknownItemIdException extends Exception 
{
	public UnknownItemIdException(String errorMessage)
	{
		super(errorMessage);
	}
}
