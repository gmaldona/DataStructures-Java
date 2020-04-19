# CSC 241 Binary Search Tree (Part 2)

In this assignment, we will adapt our binary search tree (BST) to inclde
the remove and traversal methods.

Modify the code from this previous assignment according to the following
specification.

## Specification

### CustomerNode
This class represents a node in the binary search tree that contains a reference to
a Customer object, and references to both left and right child nodes. It requires the
addtion of following methods:
- remove(Customer) : This method removes the tree node containing a customer
that matches the values of the supplied parameter. The removal must preserve 
the remaining nodes and tree structure. 
- inOrder() : This method performs an in order traversal of the tree and returns 
a string
- preOrder() : This method performs an pre order traversal of the tree and returns 
a string 
- postOrder() : This method performs an post order traversal of the tree and returns 
a string

### CustomerBst
This class defines a reference to the root of a binary search tree of `CustomerNode` object
references. It requires the following methods:
- remove(Customer) : This method removes the tree node containing a customer
that matches the values of the supplied parameter. The removal must preserve 
the remaining nodes and tree structure. 
- inOrder() : This method performs an in order traversal of the tree and returns 
a string
- preOrder() : This method performs an pre order traversal of the tree and returns 
a string 
- postOrder() : This method performs an post order traversal of the tree and returns 
a string

### Main
This class includes a `main()` method that you may use for testing. If all the
methods are operating properly, the output should look like this:
```$xslt
---=== In Order ===---
[Albert:Stephen:234-56-789][Evans:James:123-45-678][Morgan:Stephen:234-56-788]
---=== Pre Order ===---
[Evans:James:123-45-678][Albert:Stephen:234-56-789][Morgan:Stephen:234-56-788]
---=== Post Order ===---
[Albert:Stephen:234-56-789][Morgan:Stephen:234-56-788][Evans:James:123-45-678]
The customer was found
After remove, the customer was not found

```

### Other Classes
The following classes are required, but are unchanged from the previous
assignment, or require no modification.
- Account
- CommercialAccount
- Customer
- NonCommercialAccount
- XmlHandler
- XmlReader

## Testing
When you push your code back to your repository, GitHub will initiate a series of
tests to verify the correct operation of each of the required methods.
