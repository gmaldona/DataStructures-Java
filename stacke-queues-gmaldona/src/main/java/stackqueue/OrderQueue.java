package stackqueue;

public class OrderQueue {

    // Insatnce variables
    OrderNode front, back;
    // Constructor
    public OrderQueue() {
        front = null;
        back = null;
    }
    // isEmpty -- check if queue has any eleemnts
    public boolean isEmpty() {
        return front == null && back == null;
    }
    // enqueue -- add item to the back of the queue
    public void enqueue(Order order) {

        // Create the new node
        OrderNode newOrder = new OrderNode(order);
        // Check if queue is empty
        if (back == null) {
            // If so, add first element
            front = newOrder;
            back = newOrder;
        }
        // Otherwise, link to current back node
        else {
            // Update back
            back.next = newOrder;
            back = newOrder;
        }
    }

    // dequeue -- remove the node at front and return an Order reference
    public Order dequeue() {
        // Check if queue is empty
        if  (front == null) {
            // If so, return null
            return null;
        }
        else {
            // Otherwise, store the order at the front temporarily and update front and back referneces, as needed
            OrderNode temp = front;
            front = front.next;
            if (front == null){
                back = null;
            }
            // Finally, return the former first order
            return temp.order;
        }
    }


    // peek -- return a reference to the first item, but don't dequeue it
    public Order peek() {
        if (front == null) {
            return null;
        }
        else {
            return front.order;
        }
    }
}
