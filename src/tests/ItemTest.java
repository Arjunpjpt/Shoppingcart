package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import model.Item;
import model.ShoppingCart;
import org.junit.Before;
import org.junit.Test;


/**
 * This test class is to test the Test Class.
 * @author Arjun Prajapati
 * @version October 13, 2017
 *
 */
public class ItemTest {

    /** To test the item. */
    private Item myItemNotBulk;
    
    /** This is the object for the Item class. */
    private Item myItem;
    
    /**
     * This method is to run before the test.
     */
    @Before
    public void setUp() {
        myItem = new Item("Core Java", new BigDecimal("30.00"), 5, new BigDecimal("25.00"));
        myItemNotBulk = new Item("Core Java", new BigDecimal("30.00"));
        
    }
    
    /**
     * To test the constructor by passing empty name.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testItemConstructorEmptyName() {
        new Item("", new BigDecimal("30.00"));
    }

    /**
     * To test the constructor by passing negative price.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testItemConstructorNegativePrice() {
        new Item("Core Java", new BigDecimal("-20.00"));
        
    }

    /**
     * To test the constructor by passing null name.
     */
    @Test (expected = NullPointerException.class)
    public void testItemConstructorNullName() {
        new Item(null, new BigDecimal("30.00"));
    }
    
    /**
     * To test the constructor by passing null price.
     */
    @Test (expected = NullPointerException.class)
    public void testItemConstructorNullPrice() {
        new Item("Core Java", null);
    }
    
    /**
     * To test the constructor by passing negative Bulk Quantity.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testItemConstructorNegativeBulkQuantity() {
        new Item("Core Java", new BigDecimal("30.00"),
                 -20, new BigDecimal("25.00"));
       
    }
    
    /**
     * To test the constructor by passing negative Bulk Price.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testItemConstructorNegativeBulkPrice() {
        new Item("Core Java", new BigDecimal("30.00"),
                 5, new BigDecimal("-20.00"));
    
    }
    
    /**
     * To test the constructor by passing null bulk price.
     */
    @Test (expected = NullPointerException.class)
    public void testItemConstructorNullBulkPrice() {
        new Item("Core Java", new BigDecimal("30.00"),
                 5, null);
    }
    
    /**
     * To check the data enter from constructor equals.
     */
    @Test
    public void testItemConstructorData() {
        assertEquals(new BigDecimal("30.00"), myItem.getPrice());
        assertEquals(5, myItem.getBulkQuantity());
        assertEquals(new BigDecimal("25.00"), myItem.getBulkPrice());
        
    }
    
    /**
     * To check the price of an item.
     */
    @Test
    public void testGetPrice() {
        assertEquals(new BigDecimal("30.00"), myItem.getPrice());
    }

     /**
     * To check the BulkQuantity.
     */
    @Test
    public void testGetBulkQuantity() {
        assertEquals(5, myItem.getBulkQuantity());
    }

    /**
     * To check the bulk price.
     */
    @Test
    public void testGetBulkPrice() {
        assertEquals(new BigDecimal("25.00"), myItem.getBulkPrice());
    }

    /**
     * Method to check if the items are in Bulk.
     */
    @Test
    public void testIsBulkTrue() {
        assertEquals(true, myItem.isBulk());
    }

    /**
     * Method to check if the items are in Bulk.
     */
    @Test
    public void testIsBulkFalse() {
        myItem = new Item("Hard Disk", new BigDecimal("24.00"));
        assertEquals(false, myItem.isBulk());
    }
    
    /**
     * This test method is to check if the string representation of test object.
     */
    @Test
    public void testToString() {
        
        assertEquals("Core Java, $30.00 (5 for $25.00)", myItem.toString());
        assertEquals("Core Java, $30.00" , myItemNotBulk.toString());

    }
    
    /**
     * This method is to test for the equality of equal method.
     */
    @Test
    public void testEqualObj() {
        assertEquals(myItem, myItem);
        final Item otherItem = new Item("Core Java", 
                                          new BigDecimal("30.00"), 5, new BigDecimal("25.00"));
       
        assertEquals("equals() fails a test of the symmetric property.", otherItem, myItem);
        
    }
    
    /**
     * This method is to test for the not equality of equal method.
     */
    @Test
    public void testNotEqualObj() {
        assertNotEquals(myItem, null);
        assertNotEquals(myItem, ShoppingCart.class);
    }
    
    /**
     * This method is to test for the not equality of equal method.
     */
    @Test
    public void testEqualBoolean() {
        assertFalse(myItemNotBulk.equals(new Item("Java", new BigDecimal("10.00"))));
        assertTrue(myItemNotBulk.equals(new Item("Core Java", new BigDecimal("30.00"))));
        
        assertFalse(myItem.equals(new Item("CJava", new BigDecimal("30.00"),
                                           5, new BigDecimal("25.00"))));
        assertFalse(myItemNotBulk.equals(new Item("CJava", new BigDecimal("30.00"))));
        
        assertFalse(myItem.equals(new Item("Core Java", new BigDecimal("20.00"), 
                                           5, new BigDecimal("25.00"))));
        assertFalse(myItemNotBulk.equals(new Item("Core Java", new BigDecimal("20.00"))));
        
        assertFalse(myItem.equals(new Item("Core Java", new BigDecimal("30.00"),
                                           0, new BigDecimal("25.00"))));
        
        assertFalse(myItem.equals(new Item("Core Java", new BigDecimal("30.00"),
                                           5, new BigDecimal("20.00"))));
        
    }
    
   
    
    /**
     * This method is to check the HashCode method.
     */
    @Test
    public void testHashCode() {
        final Item newItem = new Item("Core Java", new BigDecimal("30.00"));
        assertEquals(true, newItem.hashCode() == myItemNotBulk.hashCode());
        assertEquals(false, newItem.hashCode() == myItem.hashCode());
    }


}
