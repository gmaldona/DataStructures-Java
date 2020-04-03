package stackqueue;

// Class now implements TaxableNy interface
public class OrderItem implements TaxableNy {

    // start with code from previous "assocations" assignment
    Product product;
    int quantity;

    // A constructor that initializes the product and quantity
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // getProduct() - Returns a reference to the Product object purchased
    public Product getProduct() {
        return product;
    }
    // getQuantity() - Returns an integer indicating how many products were purchased
    public int getQuantity() {
        return quantity;
    }
    // getPrice() - Returns the price of this item, based on the unit price of the product and the quantity
    public double getPrice() {

        if (product instanceof TaxableProduct) {
            return (product.getUnitPrice() * quantity) + (product.getUnitPrice() * quantity * getSalesTaxNy());
        }
        if (product instanceof  NonTaxableProduct) {
            return product.getUnitPrice() * quantity;
        }
        //return (product.getUnitPrice() * quantity +  + (product.getUnitPrice() * quantity * getSalesTaxNy()));
        return 0.0;
    }
    // Introduce a new constructor that accepts only quantity paramter

    public OrderItem(int quantity) {
        this.quantity = quantity;
    }

    // getPrice() - Revise this method so that it returns the proce based on the unit price of the product, quantity,
    // and any applicable sales tax

    // Introduce a method to set Product

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public double getSalesTaxNy() {
        return NYS_TAX;
    }

    // Implement method(s) required by the interface
}