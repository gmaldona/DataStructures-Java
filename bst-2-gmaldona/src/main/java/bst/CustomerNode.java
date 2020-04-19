package bst;

import java.util.Random;

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

    public CustomerNode remove(Customer customer) {

        if (customer.compareTo(this.customer) < 0) {
            if (left != null) {
                left = left.remove(customer);
            }
        }
        else if (customer.compareTo(this.customer) > 0) {
            if (right != null) { 
                right = right.remove(customer);
            }
        }
        else { 
            if (left == null && right == null) {
                return null;
            }
            else if (left != null && right == null) { 
                return left;
            }
            else if (left == null && right != null) {
                return right;
            }
            else {
                Random r = new Random();

                if (r.nextBoolean()) {
                    this.customer = left.rightMost();
                    left = left.remove(this.customer);
                }
                else {
                    this.customer = right.leftMost();
                    right = right.remove(this.customer);
                }
            }
        }
        return this;
    }

    protected Customer rightMost() {
        if (right == null) {
            return this.customer;
        }
        else {
            return right.rightMost();
        }
    }

    protected Customer leftMost() {
        if (left == null) {
            return customer;
        }
        else {
            return left.leftMost();
        }
    }

    public String inOrder() {

        String treeStr = "";

        if (left != null) {
            treeStr = treeStr + left.inOrder();
        }

        treeStr = treeStr + "[" + customer.toString() + "]";

        if (right != null) {
            treeStr = treeStr + right.inOrder();
        }
        return treeStr;
    }

    public String preOrder() {
        String treeStr = "";

        treeStr = treeStr + "[" + customer.toString() + "]";

        if (left != null) {
            treeStr = treeStr + left.inOrder();
        }

        if (right != null) {
            treeStr = treeStr + right.inOrder();
        }
        return treeStr;

    }

    public String postOrder() {
        String treeStr = "";
        if (left != null) {
            treeStr = treeStr + left.inOrder();
        }


        if (right != null) {
            treeStr = treeStr + right.inOrder();
        }
        treeStr = treeStr + "[" + customer.toString() + "]";
        return treeStr;

    }
     
}
