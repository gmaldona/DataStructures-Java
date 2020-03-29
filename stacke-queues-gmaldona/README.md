# CSC 241 Stacks and Queues
In this assignment, we will implement both a stack and a queue using an underlying
linked list. In addition, we will use our XML parser to read a file containing 
information about orders and products, and add this information to the appropriate 
structure.

Implement all of the classes and methods defined in the specification below.

## Specification

### ProductNode
This is a simplified version of the class used for the linked list assignment. In
this asssignment, we need only the instance variables and a constructor that
initializes them.

### ProductStack
This class maintains a `ProductNode` instance variable called `top` that references the 
top stack element. The remaining stack elements are linked to the first element
via its `next` instance variable. Implement each of the following methods:
- `push(Product)` - Pushes the named product reference to the top of the stack
while preserving any existing stack elements. It must also be able to handle
an empty stack.
- `pop()` - Returns the product reference in the top stack element, or `null` if 
the stack is empty. The method must preseve the other stack elements
- `peek()` - Similar to `pop()` in that is returns the product reference in the
top stack element, but does not remove it. It returns `null` if the stack is empty
- `isEmpty()` - Returns a boolean indicating whether the stack contains any elements.

### OrderNode
This class defines elements in a linked list of orders. We need only the instance 
variables and a constructor that initializes them.

### OrderQueue
This class maintains two `OrderNode` inststance variables called `front` and `back`,
representing the front and back of our queue. Implement each of these methods:
- `enqueue(Order)` - Adds the named order reference to the back of the queue.
It must preserve any existing queue elements, and be able to correctly handle
situations when the queue is empty.
- `dequeue()` - Removes the first queue element and returns a refenrence to the 
order contained in in. It should return `null` if the queue is empty
- peek() - Like `dequeue`, it returns the order in the first queue element, but
it does not remove it. It should also return `null` if the queue is empty.
- isEmpty() - returns a boolean indicating whether the queue contains any elements

### XmlHandler
The `startElement()` and `endElment()` methods must be modified to instantiate 
the current product or order, and add it to the appropriate 
structure (stack or queue, respectively).

### XmlReader
This class has been modified slightly from a previous assignment, but no further 
modifications should be neccesary

### Other Classes
The folowing classes are also required. However, they can be copied from the 
`interfaces` assignment
- Account
- CommercialAccount
- Customer
- NonCommercialAccount
- NonTaxableProduct
- Order
- OrderItem
- OrderNode
- OrderQueue
- Product
- TaxableNy (interface)
- TaxableProduct

### Main
This class contains a `main()` method that you can use for testing. When the
program is implemented correctly, it shoukd output the following:
```$xslt
DEQUEUE: 123-456
PEEK: 234-567
POP: Almond Joy:34567890:0.99:nontaxable
PEEK: Reeses:23456789:0.99:nontaxable
```

## Testing
GitHub will run a series of tests on your code when you commit and push to your 
repository. If necessary, use the error messages detailed in the
testing to isolate and correct errors.
