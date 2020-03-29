package linkedlist;

public class ProductList {
    // Instance variables

    ProductNode head;

    // Constructor -- create an empty list
    public ProductList() {
        head = null; 
    }
    // add method -- create first node, or delegate to first node
    public void add(Product node) {

    // Check if list is empty
        if (head == null) {
     // If so, instantiate first node
            head = new ProductNode(node);
            System.out.println();
        }
     // Otherwise, call node's add method to begin recursion
        else {
            head.add(node);
        }
        System.out.println();
    }
    // size method -- returns the size of the list
    public int size() {
        // Check if list is empty
        if (head == null) {
            // If so, return zero
            return 0;
        }
        // Otherwise, call the first node's size method to begin recursion
        else {
           return head.size();
        }
    }

    // sum method -- returns sum of all unit prices
    public double sum() {
        // Check if list is empty
        if (head == null) {
            // If so, return zero
            return 0;
        }
        else {
            // Otherwise, call the first node's sum method to begin recursion
            return head.sum();
        }
    }

    @Override
    public String toString() {
        // Check if the list is empty
        if (head == null) {
        // If so, return an empty string
            return "";
        }
        else {
            // Otherwise, return the string returned by the first node
            return head.toString();
        }
    }

}
