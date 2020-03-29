package linkedlist;

public class TaxableProduct extends Product{

    public TaxableProduct(String name, String isbn, double unitPrice) {
        super(name, isbn, unitPrice);
    }

    // Implement values() method
    @Override
    public String values() {
        return getProductName() + ":" + getIsbn() + ":" + getUnitPrice() + ":taxable"; // Fix return string -- JPE
    }
}

