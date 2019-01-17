/**
 * TCSS 305
 * Assignment 2 - ShoppingCart
 *
 */

package model;

import java.util.Objects;

/**
 * This is the one of the class of shopping cart appication,
 * this class is for storing item and the quantity. It also 
 * check the improper number of quantity.
 * This is the final class so, it can't be inherited.
 * @author Arjun Prajapati
 * @version October 13, 2017
 *
 *
 */
public final class ItemOrder {
    /** store the Item object. */
    private final Item myItem;
    
    /** stores the quantity of item. */
    private final int myQuantity;
    
   
   /**
    * This is the constructor to check the improper 
    * input for quantity and throw exception.
    * It store the item and quantity value from parameter. 
    * @param theItem , item name
    * @param theQuantity , quantity of item
    */
    public ItemOrder(final Item theItem, final int theQuantity) {
        if (theQuantity < 0) {
            throw new IllegalArgumentException
            ("Sorry, The Quantity should not be less than 0.");
        } else {
            myQuantity = theQuantity;
        }
        
        myItem = Objects.requireNonNull(theItem, "Sorry, The Item can't be null");
    }


    /**
     * This method return the Item.
     * @return Item
     */
    public Item getItem() {
        
        return myItem;
    }
    
    /**
     * This method the number of quantity. 
     * @return integer 
     */
    public int getQuantity() {
        
        return myQuantity;
    }


    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(128); 
        builder.append(getClass().getSimpleName());
        builder.append(myItem);
        builder.append(", ");
        builder.append(myQuantity);
        builder.append(".");
      
        return builder.toString();
    }

}
