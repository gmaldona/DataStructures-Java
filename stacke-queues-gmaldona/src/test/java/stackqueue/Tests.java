/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package stackqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {
    @Test
    void testOrderQueue() {
        Order o1 = new Order("12345678", null);
        Order o2 = new Order("12345678", null);
        OrderQueue oq = new OrderQueue();
        int assertionNum = 0;
        assertTrue(oq.isEmpty(), "Newly instantaited OrderQueue is not empty - " + (++assertionNum));
        assertEquals(null, oq.peek(), "Peek on empty queue is not null - "  + (++assertionNum));
        assertEquals(null, oq.dequeue(), "Dequeue on empty queue is not null - " + (++assertionNum));
        // Enqueue first item
        oq.enqueue(o1);
        assertTrue(!oq.isEmpty(), "Queue should not be empty - "  + (++assertionNum));
        assertEquals(o1, oq.peek(), "Peek does not return correct order reference - "  + (++assertionNum));
        // Enqueue second item
        oq.enqueue(o2);
        assertTrue(!oq.isEmpty(), "Queue should not be empty - "  + (++assertionNum));
        assertEquals(o1, oq.peek(), "Peek does not return correct order reference - "  + (++assertionNum)); // Should have first element
        // First dequeue
        Order temp = oq.dequeue();
        assertEquals(o1, temp, "Dequeue returned incorrect order - "  + (++assertionNum));
        assertTrue(!oq.isEmpty(), "Queue should not be empty - "  + (++assertionNum));
        assertEquals(o2, oq.peek(), "Peek does not return correct order reference - "  + (++assertionNum)); // Should have first element
        // second dequeue
        temp = oq.dequeue();
        assertEquals(o2, temp, "Dequeue returned incorrect order - "  + (++assertionNum));
        assertTrue(oq.isEmpty(), "Queue should be empty - " +  (++assertionNum));
        assertEquals(null, oq.peek(), "Peek should return null - "  + (++assertionNum)); // Should have first element
    }

    @Test
    void testOrderData() {
        int assertionNum = 0;
        XmlReader myReader = new XmlReader("data.xml");
        // Get the order queue
        OrderQueue orders = myReader.getOrders();
        assertTrue(!orders.isEmpty(), "Queue should not be empty - " +  + (++assertionNum));
        assertEquals("123-456", orders.peek().getOrderNumber(), "Peek returned unexpected order - "  + (++assertionNum));
        // Dequeue the first order
        Order o1 = orders.dequeue();
        assertEquals("123-456", o1.getOrderNumber(), "Dequeue returned unexpected order - "  + (++assertionNum));
        // Dequeue the second order
        Order o2 = orders.dequeue();
        assertEquals("234-567", o2.getOrderNumber(), "Dequeue returned unexpected order - "  + (++assertionNum));
        // Dequeue the third order
        Order o3 = orders.dequeue();
        assertEquals("345-678", o3.getOrderNumber(), "Dequeue returned unexpected order - "  + (++assertionNum));
        // Queue should now be empty
        assertTrue(orders.isEmpty(), "Empty queue expected - " + (++assertionNum));
        assertEquals(null, orders.peek(), "Peek returned a non-null value - "  + (++assertionNum));
    }

    @Test
    void testProductStack(){
        int assertionNum = 0;
        ProductStack products = new ProductStack();
        assertTrue(products.isEmpty(), "Product stack should be empty - " + (++assertionNum));
        // Push first product
        Product p1 = new NonTaxableProduct("p1", "isbn1", 0.99);
        products.push(p1);
        assertTrue(!products.isEmpty(),  "Product stack should not be empty - " + (++assertionNum));
        assertEquals("p1:isbn1:0.99:nontaxable", products.peek().values(), "Peek returned unexpected product - " + (++assertionNum));
        // Push next product
        Product p2 = new TaxableProduct("p2", "isbn2", 0.99);
        products.push(p2);
        assertTrue(!products.isEmpty(),  "Product stack should not be empty - " + (++assertionNum));
        assertEquals("p2:isbn2:0.99:taxable", products.peek().values(), "Peek returned unexpected product - " + (++assertionNum));
        // First pop
        Product temp = products.pop();
        assertTrue(!products.isEmpty(),  "Product stack should not be empty - " + (++assertionNum));
        assertEquals("p2:isbn2:0.99:taxable", temp.values(), "Pop returned unexpected product - " + (++assertionNum));
        // Second pop
        temp = products.pop();
        assertTrue(products.isEmpty(),  "Product stack should be empty - " + (++assertionNum));
        assertEquals("p1:isbn1:0.99:nontaxable", temp.values(), "Pop returned unexpected product - " + (++assertionNum));
        // Last pop
        temp = products.pop();
        assertTrue(products.isEmpty(),  "Product stack should be empty - " + (++assertionNum));
        assertEquals(null, temp, "Pop returned a non-null value - " + (++assertionNum));
    }

    @Test
    void testProductData(){
        int assertionNum = 0;
        XmlReader myReader = new XmlReader("data.xml");
        ProductStack products = myReader.getProducts();
        assertTrue(!products.isEmpty(), "Product stack should not be empty - " + (++assertionNum));
        assertEquals("Almond Joy:34567890:0.99:nontaxable", products.peek().values(), "Peek returned unexpected product - " + (++assertionNum));
        // First pop
        Product temp = products.pop();
        assertTrue(!products.isEmpty(),  "Product stack should not be empty - " + (++assertionNum));
        assertEquals("Almond Joy:34567890:0.99:nontaxable", temp.values(), "Pop returned unexpected product - " + (++assertionNum));
        // Second pop
        temp = products.pop();
        assertTrue(!products.isEmpty(),  "Product stack should not be empty - " + (++assertionNum));
        assertEquals("Reeses:23456789:0.99:nontaxable", temp.values(), "Pop returned unexpected product - " + (++assertionNum));
        // Last pop
        temp = products.pop();
        assertTrue(products.isEmpty(),  "Product stack should be empty - " + (++assertionNum));
        assertEquals("Snickers:12345678:0.99:taxable", temp.values(), "Pop returned unexpected product - " + (++assertionNum));
    }

}
