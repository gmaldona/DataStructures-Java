package hashmap;

public class NonTaxableProduct extends Product{

    private String nontaxable;
    // From previous assignment
    public NonTaxableProduct(String name, String isbn, Double unitPrice) {
        super(name, isbn, unitPrice);
    }
    // Implement values() method


    @Override
    public String values() {
        return getProductName() + ":" + getIsbn() + ":" + getUnitPrice() + ":nontaxable";
    }
}