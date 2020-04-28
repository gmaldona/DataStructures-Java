package hashmap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;

public class XmlHandler extends DefaultHandler {

    private HashMap<String, Account> accounts = new HashMap();
    private HashMap<String,Product> products = new HashMap();
    private Account currentAccount;
    private Customer currentCustomer;
    private Product currentProduct;

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        System.out.println("Start element:" + qName);



        // Handle the account element
        if (qName.equals("account")) {
            boolean commercial = Boolean.parseBoolean(attributes.getValue("commercial"));
            String taxID = attributes.getValue("taxId");
            String accountNumber = attributes.getValue("accountNumber");

            if (commercial) {
                currentAccount = new CommercialAccount(accountNumber, currentCustomer, taxID);
            }
            else {
                currentAccount = new NonCommercialAccount(accountNumber, currentCustomer);
            }
        }

            // Handle the customer element
        if (qName.equals("customer")) {
            String lastName = attributes.getValue("lastName");
            String firstName = attributes.getValue("firstName");
            String streetAddress = attributes.getValue("streetAddress");
            String zipCode = attributes.getValue("zipCode");

            currentCustomer = new Customer(lastName, firstName, streetAddress, zipCode);
        }
            // Hamdle the product element
        if (qName.equals("product")) {
            String name = attributes.getValue("name");
            String isbn = attributes.getValue("isbn");
            double price = Double.parseDouble(attributes.getValue("unitPrice"));
            boolean taxable = Boolean.parseBoolean(attributes.getValue("taxable"));

            if (taxable) {
                currentProduct = new TaxableProduct(name, isbn, price);
            }
            else {
                currentProduct = new NonTaxableProduct(name, isbn, price);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element:" + qName);
            // Handle account element
        if (qName.equals("account")) {
            accounts.put(currentAccount.getAccountNumber(), currentAccount);
        }
            // Handle customer element
        if (qName.equals("customer")) {

        }
            // Handle product element
        if (qName.equals("product")) {
            products.put(currentProduct.getIsbn(), currentProduct);
        }
    }

    // Return a reference to the account hashmap
    public HashMap<String,Account> getAccounts() {
        return accounts;
    }

    // Return a reference to the product hashmap
    public HashMap<String, Product> getProducts() {
        return products;
    }

}


