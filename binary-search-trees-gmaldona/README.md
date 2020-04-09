# CSC 241 Binary Search Tree (Part 1)

In this assignment, we will adapt our XML handler so that it can build
a binary search tree of customers, Use the source code for the `comparable` assignment
as a starting point. You will recall that in this assignment we made the
Customer class implement the `Comparable` interface, thus permitting us
to order two Customer objects relative to each other. We are now going to use
this principle to place Customer object references into a binary search tree
according to the rules of node placement.

Modify the code from this previous assignment according to the following
specification.

## Specification

### CustomerNode
This class represents a node in the binary search tree that contains a reference to
a Customer object, and references to both left and right child nodes. It requires the
following methods:
- insert(Customer) : Insert a new Customer into the tree, placing it in the
appropriate subtree based on the comparison of the new Customer to the Customer
object reference held in the given node. If necessary, recursively call the method
on the approriate child node.
- contains(Customer) : This method checks to see if a Customer object with the same
properties (not necessarily a reference to the same object) exsits in the subtree 
rooted at the given node. If necessary, recursively call the method on the
appropriate child node. It must return a boolean value.

### CustomerBst
This class defines a reference to the root of a binary search tree of `CustomerNode` object
references. It requires the following methods:
- insert(Customer) : Determine if the tree is empty, and if so, create the first
`CustomerNode` in the tree. Otherwise, call the `insert` method on the existing
root node.
- contains(Customer) : Determine if the tree is empty, and if so, return `false`.
Otherwise, call the `contains` method on the root node and return its reported 
value.

### XmlHandler
Modify the handler so that it calls the `insert` method on the tree when an
end element for a customer is encountered. This is a minimal change from the
previous assignment.

### Main
This class includes a `main()` method that you may use for testing.

### Other Classes
The following classes are required, but are unchanged from the previous
assignment, or require no modification.
- Account
- CommercialAccount
- Customer
- NonCommercialAccount
- XmlReader

## Testing
When you push your code back to your repository, GitHub will initiate a series of
tests to verify the correct operation of each of the required methods.
