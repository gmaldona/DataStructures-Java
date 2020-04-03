package stackqueue;

public class OrderNode {

    // Instnce variables
    Order order;
    OrderNode next;
    // Constructor
    public OrderNode(Order order) {
        this.order = order;
        next = null;
    }
}
