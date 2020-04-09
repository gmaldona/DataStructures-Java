package bst;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class XmlHandler extends DefaultHandler {

//    private ArrayList<Customer> customers = new ArrayList<Customer>();  // ArrayList of all Customers
    private Customer currentCustomer; // Reference to the current Customer being processed
    private Account currentAccount; // Reference to the current Account being processed
    private CustomerBst customerBst = new CustomerBst();

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        System.out.println("Start element:" + qName);

        String lastName;
        String firstName;
        String address;
        String zipCode ;

        Boolean isCommercial;
        String taxID ;
        String accountNumber;

            // Handle the customer element
            if (qName.equals("customer")) {

                //values
                lastName = attributes.getValue("lastName");
                firstName = attributes.getValue("firstName");
                address = attributes.getValue("streetAddress");
                zipCode = attributes.getValue("zipCode");

                //Customer object
                currentCustomer = new Customer(lastName, firstName, address, zipCode);
            }

            // Handle account element
            if (qName.equals("account")) {

                //values
                isCommercial = Boolean.parseBoolean(attributes.getValue("commercial"));
                taxID = attributes.getValue("taxId");
                accountNumber = attributes.getValue("accountNumber");

                //Checks to see if the account is commercial or not and then creates the object
                if (isCommercial) {
                    currentAccount = new CommercialAccount(accountNumber, currentCustomer, taxID);
                } else {
                    currentAccount = new NonCommercialAccount(accountNumber, currentCustomer);
                }
            }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element:" + qName);

            // Handle customer element
            if (qName.equals("customer")) {
                // Add currentCustomer to list of customer
                customerBst.insert(currentCustomer);
            }
            // Handle account element
            if (qName.equals("account")) {
            // Associate currentAccount with currentCustomer
                currentCustomer.setAccount(currentAccount);
             }
    }

    // Return a reference to array list
    public CustomerBst getCustomers() {
        return customerBst;
    }
}
