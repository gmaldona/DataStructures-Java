package hashmap;

public class CommercialAccount extends Account {

    private String taxId;

    // Constructor
    public CommercialAccount(String accountNumber, Customer customer, String taxId) {
        // Initialize parent variables
        super(accountNumber, customer);
        // Initialize tax id
        this.taxId = taxId;
    }

    public String getTaxId(){
        return this.taxId;
    }

    @Override
    public int compareTo(Integer integer) {
        return 0;
    }

}