package linkedlist;

public class ProductNode {

    // Product reference stored in this node
    // Reference to the next node

    Product product;
    ProductNode next;

    // Constructor
    public ProductNode(Product product) {
        this.product = product;
        next = null;
    }

    // Recursive add method -- add a new product node to the end of the list
    public void add(Product node) {
        if (next == null) {
            next = new ProductNode(node);
        }
        else {
            next.add(node);
        }
        System.out.println();
    }
    
    // Recursive size method -- count the number of nodes, starting with this one
    public int size() {
    
        // Check if there is a next node
        if (next == null) {
        // If not, return 1
            return 1;
        }
        // Otherwise, recursively count from this node
        else {
            return 1 + next.size();
        }
    }

    // Recursive sum method -- sum the unit prices of all products in the list
    public double sum() {
     // Check if there is a next node
        if (next == null) {
            // If not, return the price of the current product
            return this.product.getUnitPrice();
        }
        // Otherwise, compute the sum starting with this node
        else {
            return this.product.getUnitPrice() + next.sum();
        }
    }

    @Override
    public String toString() {
        // Check if there is a next node
        if (next == null) {
        // If not, return the values string
            return this.product.values();
        }
        // Otherwise, return the values of this node, a "new line" character, and the string returned by the next node
        else {
            return this.product.values() + "\n" + next.toString();
        }
    }
}
