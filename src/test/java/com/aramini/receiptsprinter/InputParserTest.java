package com.aramini.receiptsprinter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aramini.receiptsprinter.exceptions.*;

import javafx.util.Pair;

/*
 * Unit tests for InputParser class.
 */
public class InputParserTest 
{
	private InputParser inputParser;
	
    @BeforeEach
    public void setUp()
    {
    	inputParser = new InputParser();
    }
	
    @Test
    public void getItemFromInputLineWithId_Throws()
    {
    	assertThrows(UnknownItemIdException.class, ()-> {inputParser.getItemFromInputLineWithId("1 123456");});
    }
    
    @Test
    public void getItemFromInputLineWithId_Success() throws UnknownItemIdException
    {
    	Pair<Item,Integer> p = inputParser.getItemFromInputLineWithId("1 123001");
    	
    	assertEquals(123001, p.getKey().getId());
    	assertEquals("music CD", p.getKey().getName());
    	assertEquals(14.99f, p.getKey().getPrice());
    	assertEquals(false, p.getKey().isImported());
    	assertEquals(1, p.getValue());
    	assertEquals(UncategorizedGood.class, p.getKey().getClass());
    }
    
    @Test
    public void getItemFromInputLine_MedicalProduct()
    {
    	Pair<Item,Integer> p = inputParser.getItemFromInputLine("1 packet of headache pills at 9.75");
    	
    	assertEquals("packet of headache pills", p.getKey().getName());
    	assertEquals(9.75f, p.getKey().getPrice());
    	assertEquals(false, p.getKey().isImported());
    	assertEquals(1, p.getValue());
    	assertEquals(MedicalProduct.class, p.getKey().getClass());
    }
    
    @Test
    public void getItemFromInputLine_Book()
    {
    	Pair<Item,Integer> p = inputParser.getItemFromInputLine("1 book at 12.49");
    	
    	assertEquals("book", p.getKey().getName());
    	assertEquals(12.49f, p.getKey().getPrice());
    	assertEquals(false, p.getKey().isImported());
    	assertEquals(1, p.getValue());
    	assertEquals(Book.class, p.getKey().getClass());
    }
    
    @Test
    public void getItemFromInputLine_Food()
    {
    	Pair<Item,Integer> p = inputParser.getItemFromInputLine("10 chocolate bar at 0.85");
    	
    	assertEquals("chocolate bar", p.getKey().getName());
    	assertEquals(0.85f, p.getKey().getPrice());
    	assertEquals(false, p.getKey().isImported());
    	assertEquals(10, p.getValue());
    	assertEquals(Food.class, p.getKey().getClass());
    }
    
    @Test
    public void getItemFromInputLine_UncategorizedGood()
    {
    	Pair<Item,Integer> p = inputParser.getItemFromInputLine("3 imported music CD at 4.56");
    	
    	assertEquals("imported music CD", p.getKey().getName());
    	assertEquals(4.56f, p.getKey().getPrice());
    	assertEquals(true, p.getKey().isImported());
    	assertEquals(3, p.getValue());
    	assertEquals(UncategorizedGood.class, p.getKey().getClass());
    }
    
    @Test
    public void createShoppingBasketFromInputTextWithId_Success() throws UnknownItemIdException
    {
    	String input = "1 123000\r\n" + "1 123001\r\n" + "1 123002\r\n";
    	ShoppingBasket basket = inputParser.createBasketFromInputTextWithId(input);
    	
    	assertEquals(3, basket.getBasket().size());
    	assertEquals(123000, basket.getBasket().get(0).getKey().getId());
    	assertEquals("book", basket.getBasket().get(0).getKey().getName());
    	assertEquals(12.49f, basket.getBasket().get(0).getKey().getPrice());
    	assertEquals(1, basket.getBasket().get(0).getValue());
    	assertEquals(123001, basket.getBasket().get(1).getKey().getId());
    	assertEquals("music CD", basket.getBasket().get(1).getKey().getName());
    	assertEquals(14.99f, basket.getBasket().get(1).getKey().getPrice());
    	assertEquals(1, basket.getBasket().get(1).getValue());
    	assertEquals(123002, basket.getBasket().get(2).getKey().getId());
    	assertEquals("chocolate bar", basket.getBasket().get(2).getKey().getName());
    	assertEquals(0.85f, basket.getBasket().get(2).getKey().getPrice());
    	assertEquals(1, basket.getBasket().get(2).getValue());
    }
    
    @Test
    public void createShoppingBasketFromInputText_Success()
    {
    	String input = "1 book at 12.49\r\n" + "1 music CD at 14.99\r\n" + "1 chocolate bar at 0.85\r\n";
    	ShoppingBasket basket = inputParser.createBasketFromInputText(input);
    	
    	assertEquals(3, basket.getBasket().size());
    	assertEquals("book", basket.getBasket().get(0).getKey().getName());
    	assertEquals(12.49f, basket.getBasket().get(0).getKey().getPrice());
    	assertEquals(1, basket.getBasket().get(0).getValue());
    	assertEquals("music CD", basket.getBasket().get(1).getKey().getName());
    	assertEquals(14.99f, basket.getBasket().get(1).getKey().getPrice());
    	assertEquals(1, basket.getBasket().get(1).getValue());
    	assertEquals("chocolate bar", basket.getBasket().get(2).getKey().getName());
    	assertEquals(0.85f, basket.getBasket().get(2).getKey().getPrice());
    	assertEquals(1, basket.getBasket().get(2).getValue());
    }
    
}
