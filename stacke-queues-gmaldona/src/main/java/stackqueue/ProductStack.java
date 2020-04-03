package stackqueue;

public class ProductStack {

    // Instance variables
    ProductNode top;
    // Constructor
    public ProductStack() {
        top = null;
    }
    // push -- push an item to the top
    public void push(Product product) {
        ProductNode temp = new ProductNode(product);
        temp.next = top;
        top = temp;
    }
    // pop -- remove top element
    public Product pop() {
        if (top != null) {
            ProductNode temp = top;
            top = top.next;
            return temp.product;
        }
        else {
            return null;
        }
    }

    // peek -- examine the top element, but don't pop it
    public Product peek() {
        if (top != null) {
            return top.product;
        }
        else {
            return null;
        }
    }


    // isEmpty -- determine is stack is empty
    public boolean isEmpty() {
        return top == null;
    }

}
