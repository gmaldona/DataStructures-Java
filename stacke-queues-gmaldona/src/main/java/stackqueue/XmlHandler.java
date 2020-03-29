package stackqueue;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class XmlHandler extends DefaultHandler {

    private OrderQueue orders = new OrderQueue();  // queue of orders
    private Customer dummyCustomer = new Customer("Evans", "Brian", "123 W Brdige St", "13126");
    private Account dummyAccount = new NonCommercialAccount("123-45-678", dummyCustomer);
    private Order currentOrder; // Reference to the current Order being processed
    //private OrderItem currentOrderItem; // Reference to the current OrderItem being processed
    private ProductStack products = new ProductStack();
    private Product currentProduct;  // Reference to the current Product


    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        //System.out.println("Start element:" + qName);

        // Handle the order qName

        // Handle the product qName
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("End element:" + qName);

        // Handle the order qName
        // Enqueue the current order  to the orders queue

        // Handle the product qName
        // Push the current product to the products stack
    }

    // Return a reference to the order queue
    public OrderQueue getOrders() {
        return orders;
    }

    // Retur a reference to the product stack
    public ProductStack getProducts() {
        return products;
    }

}


