package bst;

public class CustomerBst {

 CustomerNode root;

    public CustomerBst() {
        this.root = null;
    }

    public void insert(Customer customer) {
        if (root == null) {
            root = new CustomerNode(customer);
        }
        else {
            root.insert(customer);
        }
    }

    public boolean contains(Customer customer) {
        if (root == null) {
            return false;
        }
        else {
            return root.contains(customer);
        }
    }

}
