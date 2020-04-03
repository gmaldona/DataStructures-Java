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
    private OrderItem currentOrderItem; // Reference to the current OrderItem being processed
    private ProductStack products = new ProductStack();
    private Product currentProduct;  // Reference to the current Product


    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
       //System.out.println("Start element:" + qName);

        // Handle the order qName
        String orderNumber;
        if (qName.equals("order")) {
            orderNumber = attributes.getValue("orderNumber");
            currentOrder = new Order(dummyAccount, orderNumber);

        }
        // Handle the product qName
        if (qName.equals("product")) {
            String name, isbn;
            double unitPrice;
            Boolean taxable;
            name = attributes.getValue("name");
            isbn = attributes.getValue("isbn");
            unitPrice = Double.parseDouble(attributes.getValue("unitPrice"));
            taxable = Boolean.parseBoolean(attributes.getValue("taxable"));


            if (taxable) {
                currentProduct = new TaxableProduct(name, isbn, unitPrice);

            }
            else {
                currentProduct = new NonTaxableProduct(name, isbn, unitPrice);
            }

            currentOrderItem = new OrderItem(currentProduct, 1);
            currentOrder.addItem(currentOrderItem);
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("End element:" + qName);

        // Handle the order qName
        if (qName.equals("order")) {
            // Enqueue the current order  to the orders queue
            orders.enqueue(currentOrder);
        }
        // Handle the product qName
        if (qName.equals("product")) {
            // Push the current product to the products stack
            products.push(currentProduct);
        }
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


