package com.aramini.receiptsprinter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class CashDeckTest 
{
	
    @Test
    public void getTaxedPrice_1()
    {
    	Book item = new Book(1, "book", 12.49f, false);
    	assertEquals(12.49f, CashDesk.getTaxedPrice(item));
    }
    
    @Test
    public void getTaxedPrice_2()
    {
    	UncategorizedGood item = new UncategorizedGood(2, "music CD", 14.99f, false);
    	assertEquals(16.49f, CashDesk.getTaxedPrice(item));
    }
    
    @Test
    public void getTaxedPrice_3()
    {
    	Food item = new Food(3, "chocolate bar", 0.85f, false);
    	assertEquals(0.85f, CashDesk.getTaxedPrice(item));
    }
    
    @Test
    public void getTaxedPrice_4()
    {
    	Food item = new Food(4, "imported box of chocolates", 10.00f, true);
    	assertEquals(10.50f, CashDesk.getTaxedPrice(item));
    }
    
    @Test
    public void getTaxedPrice_5()
    {
    	UncategorizedGood item = new UncategorizedGood(5, "imported bottle of perfume", 47.50f, true);
    	assertEquals(54.65f, CashDesk.getTaxedPrice(item));
    }
    
    @Test
    public void getTaxedPrice_6()
    {
    	UncategorizedGood item = new UncategorizedGood(6, "imported bottle of perfume", 27.99f, true);
    	assertEquals(32.19f, CashDesk.getTaxedPrice(item));
    }
    
    @Test
    public void getTaxedPrice_7()
    {
    	UncategorizedGood item = new UncategorizedGood(7, "bottle of perfume", 18.99f, false);
    	assertEquals(20.89f, CashDesk.getTaxedPrice(item));
    }
    
    @Test
    public void getTaxedPrice_8()
    {
    	MedicalProduct item = new MedicalProduct(8, "packet of headache pills", 9.75f, false);
    	assertEquals(9.75f, CashDesk.getTaxedPrice(item));
    }
    
    @Test
    public void getTaxedPrice_9()
    {
    	Food item = new Food(9, "imported box of chocolates", 11.25f, true);
    	assertEquals(11.85f, CashDesk.getTaxedPrice(item));
    }
    
}
