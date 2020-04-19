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

    public void remove(Customer customer) {
        if (root != null) {
            root = root.remove(customer);
        }
    }

    public String inOrder() {
        if (root != null) {
            return root.inOrder();
        }
        else {
            return "";
        }
    }

    public String preOrder() {
        if (root != null) {
            return root.preOrder();
        }
        else {
            return "";
        }
    }
    public String postOrder() {
        if (root != null) {
            return root.postOrder();
        }
        else {
            return "";
        }
    }

}
