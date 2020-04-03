package stackqueue;

public class ProductNode {

    // For this assignment, this lass needs only instance variables and a constructor

    Product product;
    ProductNode next;

    public ProductNode(Product product) {
        this.product = product;
        next = null;
    }

}
