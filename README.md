# ReceiptsPrinter

Basic application to compute taxed prices of goods based on their type and create a receipt of the whole shopping basket.

## Requirements

Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. 
Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.

When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), 
finishing with the total cost of the items, and the total amounts of sales taxes paid. 
The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) 
amount of sales tax.

INPUT:

Input 1:  
1 book at 12.49  
1 music CD at 14.99  
1 chocolate bar at 0.85  

Input 2:  
1 imported box of chocolates at 10.00  
1 imported bottle of perfume at 47.50  

Input 3:  
1 imported bottle of perfume at 27.99  
1 bottle of perfume at 18.99  
1 packet of headache pills at 9.75  
1 box of imported chocolates at 11.25  

OUTPUT

Output 1:  
1 book : 12.49  
1 music CD: 16.49  
1 chocolate bar: 0.85  
Sales Taxes: 1.50  
Total: 29.83  

Output 2:  
1 imported box of chocolates: 10.50  
1 imported bottle of perfume: 54.65  
Sales Taxes: 7.65  
Total: 65.15  

Output 3:  
1 imported bottle of perfume: 32.19  
1 bottle of perfume: 20.89  
1 packet of headache pills: 9.75  
1 imported box of chocolates: 11.85  
Sales Taxes: 6.70  
Total: 74.68  

## My considerations  

First, it comes very natural to define classes for the goods. A generic and abstract Item class from which all the "real" products inherit allows to group shared attributes and to easily apply polymorphism.  
Classes inheriting from Item:  
- Book
- Food
- MedicalProduct
- UncategorizedItem

It must be said that in a real scenario it doesn't make sense to receive only the name of the item as an input 
as that can create issues (e.g. how do we distinguish two items with the same name?).
In a real scenario we should receive either the barcode or the ID of the item to uniquely identify it (and its 
properties, such as the price).
In addition, a strong assumption of the InputParser is that the input text is properly formatted (i.e. the string is 
checked before being sent to the backend system, thus the parser denies any possibility of bad formatting).
Given these considerations, two methods are provided for reading the input:
1) createBasketFromInputTextWithId (In case the input is in the form "_Quantity_ _ItemID_")  
2) createBasketFromInputText		  (In case the input is in the form "_Quantity_ _ItemName_ at _ItemPrice_")  

The first method should normally rely on a database query to retrieve the item information given its primary key (the ID).
For this assignment I simplify by using an hashmap with the objects of interest for the final result.

The second method relies on dictionaries (concretely implemented as hashsets) containing keywords that can appear 
in the item name and thus helping in categorizing the item itself.  
Clearly the dictionaries I use only contain the keywords needed for the final result of the assignment;
in order to have a "general" solution the dictionaries should be way bigger.

I strongly advise not to use the second method in a real environment as it doesn't scale well 
(how big should the dictionaries be to fully cover the goods catalogue?).  
The first method (DB query) should always be the one of choice.
