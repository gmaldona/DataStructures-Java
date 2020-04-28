package hashmap;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Write your testing code here

    XmlReader myXmlReader = new XmlReader("data.xml");
    HashMap<String, Account> accounts = myXmlReader.getAccounts();
    HashMap<String, Product> products = myXmlReader.getProducts();


    }
}
