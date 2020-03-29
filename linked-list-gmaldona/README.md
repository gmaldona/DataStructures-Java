# CSC 241 Linked List

In this assignment, we will first add some classes that provide
a linked list of products, then modify our XML file reader to use them. A linked 
list is a recursive data structure, meaning that it is designed in terms of
itself. 

We will first define a `ProductNode` class wherein each instance has a reference to a `Product` 
and another reference to the next node. A value of `null` for the next node means that the instance is 
the last node in the list. We will also define a "wrapper" class called `ProductList` that
contains a reference to the first node. Finally, we will add methods to each of these classes
(details below).

We will again use the Java Simple API 
for XML, or Java SAX, to read and process our XML input file. This provides 
you additional opportunities to work with event driven 
programing. The Java SAX documentation can be found here:

http://www.saxproject.org/

Follow the specification below and make the necessary changes and additions.

## Specification

### ProductNode
This is a new class. Each `ProductNode` represents a node in a linked list. As such, it
needs a `Product` reference and a reference to the next node. Implement the following 
methods:
* `add(Product)` - This recursive method adds a new product node to the end of the list
* `size()` - This recursive method returns the number of nodes in the list from the calling 
object's perspective
* `sum()` - This recursive method returns the sum of the unit prices for products in the list
from the calling object's perspective
*  `toString()` - This recursive method returns a string representing the products in the
list from the calling object's perspective

### ProductList
This is a new class. It is used to hold a reference to the first `ProductNode` in the 
list, called `head`. A value of `null` indicates that the list is empty. Implement the
methods:
* `add(Product)` - This recursive method adds a new product node to the end of the list
* `size()` - This recursive method returns the number of nodes in the list
* `sum()` - This recursive method returns the sum of the unit prices for products in the list
*  `toString()` - This recursive method returns a string representing the products in the
list

### Product, NonTaxableProduct, and TaxableProduct
Use these classes from the `xml-input` assignment, but no modifications should be necessary

### XmlHandler
This class must be modified to work with the new `productList` object. It has minor
modifications from the `xml-input` assignment:
- startElement - This method should identify the different types of products and instantiate 
the `currentProduct`.
- endElement - This method should add the `currentProduct` to the `productList`.
- getCustomers - This method should return the `productList` generated from
the input file.

### XmlReader
This class has been modified slightly from the previous assignments, but 
no further modifications should be necessary.

### Main
This class includes a `main()` method that you can use for testing. But, make sure
that you have effectively used the debugger before running this method!

### Unneeded Classes
The following classes need not be included in this assignment:
* Order
* OrderItem
* TaxableNy (interface)

## Example Output
If all the above methods are implemented properly, the program will output 
the following based on the included `products.xml` input file:
```
Size: 2
Sum: 1.98
---=== Product List ===---
Snickers:123-456-78:0.99:taxable
Reeses:123-456-78:0.99:nontaxable

```

## Testing
When you push your code back to your repository, GitHub will initiate a series of
tests to verify the correct operation of each of the required methods.
