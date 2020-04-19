/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void testCustomers() {
        // Test the example XML file
        XmlReader xr = null;
        try {
            xr = new XmlReader("customers.xml");
        } catch (Exception e) {
            //System.out.println("Exception-jpe: " + e);
            fail("Could not initialize an XmlReader");
        }
        assertNotNull(xr, "Could not initialize XmlReader");

        // Try to get an array of customers
        CustomerBst customers = xr.getCustomers();

        // Expected Values
//     <customer lastName="Evans" firstName="James" streetAddress="123 Main St." zipCode="13126">
//     <account commercial="true" taxId="NY-1234" accountNumber="123-45-678"/>
//    </customer>
//    <customer firstName="Stephen" lastName="Albert"  streetAddress="234 Elm St." zipCode="13126">
//        <account accountNumber="234-56-789" commercial="false"/>
//    </customer>
//    <customer firstName="Stephen" lastName="Morgan"  zipCode="19144" streetAddress="345 Pine St.">
//        <account commercial="true" accountNumber="234-56-788" taxId="PA-2345"/>
//    </customer>
        Customer c1 = new Customer("Evans", "James", "123 Main St.", "13126");
        Account a1 = new CommercialAccount("123-45-678", c1, "NY-1234");
        c1.setAccount(a1);

        assertTrue(customers.contains(c1));

        Customer c2 = new Customer("Albert", "Stephen", "234 Elm St.", "13126");
        Account a2 = new NonCommercialAccount("234-56-789", c2);
        c2.setAccount(a2);

        assertTrue(customers.contains(c2));

        Customer c3 = new Customer("Morgan", "Stephen", "345 Pine St.", "19144");
        Account a3 = new CommercialAccount("234-56-788", c3, "PA-2345");
        c3.setAccount(a3);

        assertTrue(customers.contains(c3));

        // Teet traversals
        String expected = "[Albert:Stephen:234-56-789][Evans:James:123-45-678][Morgan:Stephen:234-56-788]";
        assertEquals(expected, customers.inOrder());

        expected = "[Evans:James:123-45-678][Albert:Stephen:234-56-789][Morgan:Stephen:234-56-788]";
        assertEquals(expected, customers.preOrder());

        expected = "[Albert:Stephen:234-56-789][Morgan:Stephen:234-56-788][Evans:James:123-45-678]";
        assertEquals(expected, customers.postOrder());

        // Test first remove
        customers.remove(c1);
        expected = "[Albert:Stephen:234-56-789][Morgan:Stephen:234-56-788]";
        assertEquals(expected, customers.inOrder());

        //System.out.println("INORDER after c1treeStr = treeStr + "[" + customer.toString() + "]";: " + customers.inOrder());

        // Test second remove
        customers.remove(c2);
        expected = "[Morgan:Stephen:234-56-788]";
        assertEquals(expected, customers.inOrder());

        //System.out.println("INORDER after c2: " + customers.inOrder());

        // Test third remove
        customers.remove(c3);
        expected = "";
        assertEquals(expected, customers.inOrder());

        //System.out.println("INORDER after c3: " + customers.inOrder());

        // Test fourth remove on empty tree
        customers.remove(c3);
        expected = "";
        assertEquals(expected, customers.inOrder());


        //
//
//        Customer[] expected = new Customer[3];
//        expected[0] = new Customer("Evans","James", "123 Main St.", "13126");
//        expected[0].setAccount(new CommercialAccount("123-45-678", expected[0], "NY-1234" ));
//
//        expected[1] = new Customer( "Evans", "Stephen", "234 Elm St.", "13126");
//        expected[1].setAccount(new NonCommercialAccount("234-56-789", expected[1]));
//
//        expected[2] = new Customer( "Evans", "Stephen", "345 Pine St.", "19144");
//        expected[2].setAccount(new CommercialAccount("234-56-788", expected[2], "PA-2345"));
//
//        // Ensure XML parsing produced the same objects
//        this.compareCustomers(expected, customers);
//
//        // Do comparisons among elements
//        assertTrue(customers[0].compareTo(customers[1]) < 0, "C0->C1: COMPARETO should be negative");
//        assertTrue(customers[1].compareTo(customers[0]) > 0, "C1->C0: COMPARETO should be positive");
//        assertTrue(customers[1].compareTo(customers[2]) > 0, "C1->C2: COMPARETO should be positive");
//        assertTrue(customers[2].compareTo(customers[1]) < 0, "C2->C1: COMPARETO should be negative");
    }

//    @Test void testCustomer21(){
//        // Test the example XML file
//        XmlReader xr = null;
//        try {
//            xr = new XmlReader("./src/test/java/bst/customers-2.xml");
//        } catch (Exception e) {
//            //System.out.println("Exception-jpe: " + e);
//            fail("Could not initialize an XmlReader");
//        }
//        assertNotNull(xr, "Could not initialize XmlReader");
//
//        // Try to get an array of customers
//        Customer[] customers = null;
//        try {
//            customers = xr.getCustomers();
//        } catch (Exception e) {
//            System.out.println("Custoemrs array exception");
//        }
//
//        assertNotNull(customers, "Could not get Customer array");
//
//        // Expected values
//        Customer[] expected = new Customer[4];
//        expected[0] = new Customer("Evans","James", "123 Main St.", "13126");
//        expected[0].setAccount(new NonCommercialAccount("123-45-678", expected[0]));
//
//        expected[1] = new Customer( "Evans", "Stephen", "234 Elm St.", "13126");
//        expected[1].setAccount(new NonCommercialAccount("234-56-789", expected[1]));
//
//        expected[2] = new Customer( "Evans", "Stephen", "345 Pine St.", "19144");
//        expected[2].setAccount(new NonCommercialAccount("234-56-788", expected[2]));
//
//        expected[3] = new Customer( "Edwards", "Larry", "456 Maple St.", "21212");
//        expected[3].setAccount(new NonCommercialAccount("345-67-890", expected[3]));
//
//        // Ensure XML parsing produced the same objects
//        this.compareCustomers(expected, customers);
//
//        // Do comparisons among elements
//        assertTrue(customers[0].compareTo(customers[1]) < 0, "C0->C1: COMPARETO should be negative");
//        assertTrue(customers[1].compareTo(customers[0]) > 0, "C1->C0: COMPARETO should be positive");
//        assertTrue(customers[1].compareTo(customers[2]) > 0, "C1->C2: COMPARETO should be positive");
//        assertTrue(customers[2].compareTo(customers[1]) < 0, "C2->C1: COMPARETO should be negative");
//        assertTrue(customers[2].compareTo(customers[3]) > 0, "C2->C3: COMPARETO should be positive");
//        assertTrue(customers[3].compareTo(customers[2]) < 0, "C3->C2: COMPARETO should be negative");
//
//    }


//
//    @Test void testOrders2(){
//        XmlReader xr = null;
//        try {
//            xr = new XmlReader("./src/test/java/comparable/orders-2.xml");
//        } catch (Exception e) {
//            //System.out.println("Exception-jpe: " + e);
//            fail("Could not initialize an XmlReader");
//        }
//        assertNotNull(xr, "Could not initialize XmlReader");
//
//        // Try to get products array
//        Order[] orders = null;
//        try {
//            orders = xr.getOrders();
//        } catch (Exception e) {
//            System.out.println("Orders array exception");
//        }
//
//        assertNotNull(orders, "Could not get Order array");
//
//        OrderData od1 = new OrderData("abc-123", 3.08);
//        OrderData od2 = new OrderData("abc-234", 21.6);
//
//        OrderData[] expected = {od1, od2};
//        this.compareOrders(expected, orders);
//
//    }
//
//    @Test void testOrders2b(){
//        XmlReader xr = null;
//        try {
//            xr = new XmlReader("./src/test/java/comparable/orders-2b.xml");
//        } catch (Exception e) {
//            //System.out.println("Exception-jpe: " + e);
//            fail("Could not initialize an XmlReader");
//        }
//        assertNotNull(xr, "Could not initialize XmlReader");
//
//        // Try to get products array
//        Order[] orders = null;
//        try {
//            orders = xr.getOrders();
//        } catch (Exception e) {
//            System.out.println("Orders array exception");
//        }
//
//        assertNotNull(orders, "Could not get Order array");
//
//        OrderData od1 = new OrderData("abc-123", 3.08);
//        OrderData od2 = new OrderData("abc-234", 20.0);
//
//        OrderData[] expected = {od1, od2};
//        this.compareOrders(expected, orders);
//
//    }
//
//    @Test void testOrders4(){
//        XmlReader xr = null;
//        try {
//            xr = new XmlReader("./src/test/java/comparable/orders-4.xml");
//        } catch (Exception e) {
//            //System.out.println("Exception-jpe: " + e);
//            fail("Could not initialize an XmlReader");
//        }
//        assertNotNull(xr, "Could not initialize XmlReader");
//
//        // Try to get products array
//        Order[] orders = null;
//        try {
//            orders = xr.getOrders();
//        } catch (Exception e) {
//            System.out.println("Orders array exception");
//        }
//
//        assertNotNull(orders, "Could not get Order array");
//
//        OrderData od1 = new OrderData("abc-123", 3.08);
//        OrderData od2 = new OrderData("abc-234", 20);
//        OrderData od3 = new OrderData("abc-345", 23.76);
//        OrderData od4 = new OrderData("abc-456", 2080);
//
//        OrderData[] expected = {od1, od2, od3, od4};
//        this.compareOrders(expected, orders);
//
//    }

    private void compareCustomers(Customer[] expected, Customer[] actual) {
        // Ensure same length
        System.out.println("LENGTHS-" + expected.length + ":" + actual.length);
        if (expected.length != actual.length) {
            // Abort -- different lengths
            fail("Result does not contain the expected number of customers");
        }

        // Compare elements
        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i].compareTo(actual[i]) == 0, "Mismatched customer or account data");
            //assertEquals(expected[i], actual[i]);
        }
    }
}
