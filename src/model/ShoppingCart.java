/**
 * TCSS 305
 * Assignment 2 - ShoppingCart
 *
 */

package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;


/**
 * This is the one of the class of shopping cart appication,
 * The main purpose of this class is to calculate
 * the total making sure that correct amount is calculated 
 * for members and non-members.
 * @author Arjun Prajapati
 * @version October 13, 2017
 *
 *
 */
public class ShoppingCart {
    /**  to store the value and item. */
    private Map<Item, BigDecimal> myCart; 
    
    /** to set the membership. */
    private boolean myMembership;
    
   
    /**
     * This is the constructor to initialize the Map.
     */
    public ShoppingCart() {
        myCart = new HashMap<Item, BigDecimal>();
        
    }

    /**
     * This method adds the item and quantity to the map
     * which is passed from the parameter theOrder.
     * @param theOrder , get the value from ItemOrder
     */
    public void add(final ItemOrder theOrder) {
        myCart.put(theOrder.getItem(), new BigDecimal(theOrder.getQuantity()));
        
        
    }

    /**
     * This method is for setting membership for the calculation.
     * @param theMembership , true for member else false
     */
    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
    }

    /**
     * This method return whether the member or not for discount.
     * @return getmyMembership
     */
    public boolean getmyMembership() {
        return myMembership;
    }
    
    /**
     * This method is to calculate the total price of item in cart.
     * @return BigDecimal
     */
    public BigDecimal calculateTotal() {

        BigDecimal orderTotal = BigDecimal.ZERO;
       
        for (final Item item: myCart.keySet()) {
            final BigDecimal price = item.getPrice();
            
            if (myMembership) {
                if (item.isBulk()) {
                    final BigDecimal bulkPrice = item.getBulkPrice();
                    final int bulkQuantity = item.getBulkQuantity();
                    final BigDecimal quantity = myCart.get(item);
                    
                    
                    final BigDecimal bulkNumber = quantity.divideToIntegralValue
                                  (new BigDecimal(bulkQuantity));
                    final BigDecimal remaining = quantity.
                                    subtract(bulkNumber.multiply(new BigDecimal
                                    (item.getBulkQuantity())));
                    orderTotal = orderTotal.add((bulkNumber.multiply(bulkPrice)).add
                                  (remaining.multiply(price)));
                   
                } else {
                    orderTotal = orderTotal.add(price.multiply(myCart.get(item)));
                }
            }
            if (!myMembership) {
                orderTotal = orderTotal.add(price.multiply(myCart.get(item)));
            }
        }
         
        return orderTotal.setScale(2, RoundingMode.HALF_EVEN);
    }
        
        
        
    
    /**
     * This method is to clear all data from myCart.
     */
    public void clear() {
        myCart = new HashMap<Item, BigDecimal>(); 
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(128); 
        builder.append(myCart);
        
        return builder.toString();
        
        
    }

}
