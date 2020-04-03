package stackqueue;

public abstract class Account {

    private String accountNumber;
    private Customer customer;
    private double balance;


    // A constructor that initializes the account number and Customer, and sets the balance to zero.
    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0;
    }

    // getAccountNumber() - Returns a String representing the account number.
    public String getAccountNumber() {
        return this.accountNumber;
    }

    // getCustomer() - Returns a reference to the Customer object associated with this account
    public Customer getCustomer() {
        return this.customer;
    }

    // getBalance() - Returns the avaiable balance (may be a decimal value)
    public double getBalance() {
        return this.balance;
    }



}
