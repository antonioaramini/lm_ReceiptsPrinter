package com.aramini.receiptsprinter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aramini.receiptsprinter.exceptions.*;

import javafx.util.Pair;


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
    	assertEquals(GenericItem.class, p.getKey().getClass());
    }
    
    @Test
    public void getItemFromInputLine_SuccessMedicalProduct()
    {
    	Pair<Item,Integer> p = inputParser.getItemFromInputLine("1 packet of headache pills at 9.75");
    	
    	assertEquals("packet of headache pills", p.getKey().getName());
    	assertEquals(9.75f, p.getKey().getPrice());
    	assertEquals(false, p.getKey().isImported());
    	assertEquals(1, p.getValue());
    	assertEquals(MedicalProduct.class, p.getKey().getClass());
    }
    
    @Test
    public void getItemFromInputLine_SuccessBook()
    {
    	Pair<Item,Integer> p = inputParser.getItemFromInputLine("1 book at 12.49");
    	
    	assertEquals("book", p.getKey().getName());
    	assertEquals(12.49f, p.getKey().getPrice());
    	assertEquals(false, p.getKey().isImported());
    	assertEquals(1, p.getValue());
    	assertEquals(Book.class, p.getKey().getClass());
    }
    
    @Test
    public void getItemFromInputLine_SuccessFood()
    {
    	Pair<Item,Integer> p = inputParser.getItemFromInputLine("10 chocolate bar at 0.85");
    	
    	assertEquals("chocolate bar", p.getKey().getName());
    	assertEquals(0.85f, p.getKey().getPrice());
    	assertEquals(false, p.getKey().isImported());
    	assertEquals(10, p.getValue());
    	assertEquals(Food.class, p.getKey().getClass());
    }
    
    @Test
    public void getItemFromInputLine_SuccessGenericItem()
    {
    	Pair<Item,Integer> p = inputParser.getItemFromInputLine("3 imported music CD at 4.56");
    	
    	assertEquals("imported music CD", p.getKey().getName());
    	assertEquals(4.56f, p.getKey().getPrice());
    	assertEquals(true, p.getKey().isImported());
    	assertEquals(3, p.getValue());
    	assertEquals(GenericItem.class, p.getKey().getClass());
    }
}
