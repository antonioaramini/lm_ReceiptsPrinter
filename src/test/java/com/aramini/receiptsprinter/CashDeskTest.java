package com.aramini.receiptsprinter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * Unit tests for CashDesk class.
 */
public class CashDeskTest 
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
    
    @Test
    public void getTaxedPrice_10()
    {
    	MedicalProduct item = new MedicalProduct(8, "imported packet of headache pills", 12.79f, true);
    	assertEquals(13.44f, CashDesk.getTaxedPrice(item));
    }
    
    @Test
    public void createReceipt_Input1()
    {
    	InputParser inputParser = new InputParser();
    	String input = "1 book at 12.49\r\n" + "1 music CD at 14.99\r\n" + "1 chocolate bar at 0.85\r\n";
    	ShoppingBasket basket = inputParser.createBasketFromInputText(input);
    	Receipt receipt = CashDesk.createReceipt(basket);
    	
    	assertEquals("1 book: 12.49\n" + "1 music CD: 16.49\n" + "1 chocolate bar: 0.85\n" + "Sales Taxes: 1.50\n" + "Total: 29.83\n", receipt.toString());
    }
    
    @Test
    public void createReceipt_Input2()
    {
    	InputParser inputParser = new InputParser();
    	String input = "1 imported box of chocolates at 10.00\r\n" + "1 imported bottle of perfume at 47.50\r\n";
    	ShoppingBasket basket = inputParser.createBasketFromInputText(input);
    	Receipt receipt = CashDesk.createReceipt(basket);
    	
    	assertEquals("1 imported box of chocolates: 10.50\n" + "1 imported bottle of perfume: 54.65\n" + "Sales Taxes: 7.65\n" + "Total: 65.15\n", receipt.toString());
    }
    
    @Test
    public void createReceipt_Input3()
    {
    	InputParser inputParser = new InputParser();
    	String input = "1 imported bottle of perfume at 27.99\r\n" + "1 bottle of perfume at 18.99\r\n" + "1 packet of headache pills at 9.75\r\n" 
    				 + "1 imported box of chocolates at 11.25\r\n";
    	ShoppingBasket basket = inputParser.createBasketFromInputText(input);
    	Receipt receipt = CashDesk.createReceipt(basket);
    	
    	assertEquals("1 imported bottle of perfume: 32.19\n" + "1 bottle of perfume: 20.89\n" +	"1 packet of headache pills: 9.75\n" 
    			   + "1 imported box of chocolates: 11.85\n" + "Sales Taxes: 6.70\n" + "Total: 74.68\n", receipt.toString());
    }
    
    @Test
    public void createReceipt_Input4()
    {
    	InputParser inputParser = new InputParser();
    	String input = "2 book at 12.49\r\n" + "3 music CD at 14.99\r\n" + "2 chocolate bar at 0.85\r\n";
    	ShoppingBasket basket = inputParser.createBasketFromInputText(input);
    	Receipt receipt = CashDesk.createReceipt(basket);
    	
    	assertEquals("2 book: 24.98\n" + "3 music CD: 49.47\n" + "2 chocolate bar: 1.70\n" + "Sales Taxes: 4.50\n" + "Total: 76.15\n", receipt.toString());
    }
    
    @Test
    public void createReceipt_Input5()
    {
    	InputParser inputParser = new InputParser();
    	String input = "2 book at 12.49\r\n" + "3 music CD at 14.99\r\n" + "10 chocolate bar at 0.85\r\n";
    	ShoppingBasket basket = inputParser.createBasketFromInputText(input);
    	Receipt receipt = CashDesk.createReceipt(basket);
    	
    	assertEquals("2 book: 24.98\n" + "3 music CD: 49.47\n" + "10 chocolate bar: 8.50\n" + "Sales Taxes: 4.50\n" + "Total: 82.95\n", receipt.toString());
    }
    
}
