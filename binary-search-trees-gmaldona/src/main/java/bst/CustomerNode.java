package bst;

public class CustomerNode {

    // Use BstDemo as a guide

    Customer customer;
    CustomerNode left, right;

    public CustomerNode(Customer customer) {
        this.customer = customer;
        this.left = this.right = null; 
    } 

    public void insert(Customer customer) {
        if (customer.compareTo(this.customer) <= 0) {
            if (left == null) {
                this.left = new CustomerNode(customer);
            }
            else {
                left.insert(customer);
            }
        }
        else {
            if (right == null) {
                right = new CustomerNode(customer);
            }
            else {
                right.insert(customer);
            }
        }
    }

    public boolean contains(Customer customer) {
        if (customer.compareTo(this.customer) == 0) {
            return true;
        }
        else if (customer.compareTo(this.customer) < 0) {
            if (left == null) {
                return false;
            }
            else {
                return left.contains(customer);
            }
        }
        else {
            if (right == null) {
                return false;
            }
            else {
                return right.contains(customer);
            }
        }
    }
}
