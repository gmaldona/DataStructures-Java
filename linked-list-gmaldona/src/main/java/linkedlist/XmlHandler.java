package linkedlist;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlHandler extends DefaultHandler {

    ProductList productList = new ProductList(); // An empty product list
    Product currentProduct = null;  // Reference to the current Product


    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        //System.out.println("Start element");
        String name = "";
        String isbn = "";
        double unitPrice = 0.0;
        boolean taxable = false;
        // Check if this is an opening element for a product
        if (qName.equals("product")) {
            // If so, store each of its attribute values
            name = attributes.getValue("name");
            isbn = attributes.getValue("isbn");
            unitPrice = Double.parseDouble(attributes.getValue("unitPrice"));
            taxable = Boolean.parseBoolean(attributes.getValue("taxable"));
        }
        // Determine type of product (taxable vs. nontaxable)
        if (taxable == true) {
            currentProduct = new TaxableProduct(name, isbn, unitPrice);
        }
        else {
            currentProduct = new NonTaxableProduct(name, isbn, unitPrice);
        }
        System.out.println();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("End element");

        // check if this is a closing element for a product
        if (qName.equals("product")) {
            // If so, add the current product to the product list
            productList.add(currentProduct);
            System.out.println();
        }

    }

    // Return a reference to the product list
    public ProductList getProducts() {
        return productList;
    }
}


