package linkedlist;

public abstract class Product {

    // Use code from "associations" assignment
    private String name;
    private String ISBN;
    private double unitPrice;

    // A constructor method that initializes the product name, ISBN number, and unit price
    public Product(String name, String ISBN, double unitPrice) {
        this.name = name;
        this.ISBN = ISBN;
        this.unitPrice = unitPrice;
    }

    // getProductName() - Returns a String that is the name of the product
    public String getProductName() {
        return name;
    }
    // getIsbn() - Returns a String representing the ISBN (barcode) number
    public String getIsbn() {
        return ISBN;
    }
    // getUnitPrice() - Returns a possible decimal value indicating the unit price for each product
    public double getUnitPrice() {
        return unitPrice;
    }

    public String values() {
        return getProductName() + ":" + getIsbn() + ":" + getUnitPrice() + ":taxable"; // Fix return string -- JPE
    }
}
