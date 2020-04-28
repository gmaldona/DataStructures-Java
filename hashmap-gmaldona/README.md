# CSC 241 Hashmaps
In this assignment, we will implement a simple database 
of accounts and products using an underlying
Hashmap. The XML Parser will be used to read the contents
of an input file and add the entries to the appropriate
structure.

Implement all the classes and methods defined in the specification below.

## Specification

### XmlHandler
The `startElement()` and `endElment()` methods must be modified to instantiate 
the appropraite object based on the XML tag (`qName`), create the necessary 
associations, and add references to the appropriate 
structure (one of two HashMaps).

- Account references should be stored in a HashMap 
using the account number as the key
- Customer references should be associated with their account
- Product references should be stored in their HashMap
using the ISBN as the key 

### XmlReader
This class has been modified slightly from a previous assignment, but no further 
modifications should be necessary

### Other Classes
The following classes are required. However, they can be copied from a recent 
assignment and should need no modification
- Account
- CommercialAccount
- Customer
- NonCommercialAccount
- NonTaxableProduct
- Product
- TaxableNy (interface)
- TaxableProduct

### Main
This class contains a `main()` method that you can use for testing. Here is an example
of what is possible using the various HashMap methods, but you are free to experiment.
```$xslt
---=== All Account Numbers in the Database ===---
234-56-789
123-45-678
234-56-788

---=== Account Lookups ===---
Looking up 234-56-790 ...
The account was not found: 234-56-790
Looking up 234-56-788 ...
Account found
	Account Number: 234-56-788
	Account Type: Commercial
	Customer Last Name: Morgan
	Customer First Name: Stephen

---=== All Product ISBNs in the Database ===---
567-890-12
234-567-89
678-901-23
345-678-90
123-456-78
901-234-56
456-789-01
012-345-67
890-123-45
789-012-34

---=== Product Lookups ===---
Looking up 678-901-23 ...
Product found
	ISNB: 678-901-23
	Product Type: Taxable
	Product Name: Almond Joy
	Price: 0.94
Looking up 678-901-24 ...
The product was not found: 678-901-24
```
## Testing
GitHub will run a series of tests on your code when you commit and push to your 
repository. If necessary, use the error messages detailed in the
testing to isolate and correct errors.
