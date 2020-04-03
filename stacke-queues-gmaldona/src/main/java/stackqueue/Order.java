package stackqueue;

import java.util.ArrayList;

public class Order {

    // Bring in code from previous "associations" assignment
    private String accountNumber;
    private OrderItem[] products;
    private Account account;
    private String orderNumber;

    //  A constructor that initializes the account number and an empty collection of items
    public Order(Account account, String orderNumber) {
        this.accountNumber = account.getAccountNumber();
        this.account = account;
        products = new OrderItem[0];
        this.orderNumber = orderNumber;
    }

    public Order(String accountNumber, String orderNumber) {
        this.accountNumber = accountNumber;
        this.orderNumber = orderNumber;
    }

    // getAccount() - Returns a refernece to the Account object associated with this order
    public Account getAccount() {
        return account;
    }

    // addItem(OrderItem item) - Adds an order item (above) to this order
    public void addItem(OrderItem item) {
        int index = products.length + 1;
        OrderItem[] productHolder = products;
        products = new OrderItem[index];
        for (int i = 0; i < productHolder.length; i++) {
            products[i] = productHolder[i];
        }
        products[index - 1] = item;
    }

    // getItems() - Returns an array of OrderItem object references listing all purchases
    public OrderItem[] getItems() {
        return products;
    }

    // getTotal() - Returns the price of all items purchased
    public double getTotal() {
        double total = 0;
        for (OrderItem product : products) {
            total = total + product.getPrice();
        }
        return total;
    }

    // Add method to get orderNumber


    public String getOrderNumber() {
        return orderNumber;
    }
}
