/*
 * TCSS 305
 * Assignment 2 - ShoppingCart
 */

package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
/**
 * This is the one of the class of shopping cart appication,
 * this cart is for checking the proper input.
 * @author Arjun Prajapati
 * @version October 13, 2017
 *
 */
public final class Item {
    /** Store the product Name. */
    private String myProduct;
    
   
    
    /** Store the price of the product. */
    private BigDecimal myPrice;
    
    /** Store the bulk quantity. */
    private int myBulkQuantity;
    
    /** Store the price of the bulk. */
    private BigDecimal myBulkPrice;
 
    /**
     * This is the constructor to store the product name and price.
     * @param theName , Name of the product
     * @param thePrice , Price of the product
     * @throws IllegalArgumentException, if thePrice is less than 0.
     * @throws NullPointException, if the theName is passed empty.
     */
    public Item(final String theName, final BigDecimal thePrice) {
        if (theName.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty.");
        }
        
        if (thePrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price can't be empty.");
        }
        myProduct = (String) Objects.requireNonNull(theName);
        myPrice = (BigDecimal) Objects.requireNonNull(thePrice);
        
    }

    /**
     8 This is the constructor to store the product name, price, bulk quantity and bulk price.
     * @param theName , Name of the product
     * @param thePrice , Price of the product
     * @param theBulkQuantity , Quantity of the bulk
     * @param theBulkPrice , Price of the bulk
     * @throws IllegalArgumentException , if the thePrice, 
     * theBulkQuantity and theBulkPrice are less than 0.
     * @throws NullPointException, if the name is passed empty.
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        this(theName, thePrice);
        
        if (theBulkQuantity < 0) {
            throw new IllegalArgumentException("Illegal input found for Bulk Quantity");
        }
        if (theBulkPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException
            ("Illegal input found for Bulk Price");
        }
        
        myBulkQuantity = theBulkQuantity;
        myBulkPrice = Objects.requireNonNull
                        (theBulkPrice, "Sorry, the Bulk Price can't be null.");
    }

    /**
     * This method returns the price of the product.
     * @return BigDecimal, Price of the product
     */
    public BigDecimal getPrice() {
        
        return myPrice;
    }
    
    /**
     * This method returns the quantity of the bulk.
     * @return integer , the quantity of the bulk
     */
    public int getBulkQuantity() {
        
        return myBulkQuantity;
    }
    
    /**
     * This method returns the price of bulk.
     * @return BigDecimal, price of the bulk.
     */
    public BigDecimal getBulkPrice() {
        
        return myBulkPrice;
    }

    /**
     * This method is to check if the items are in bulk or not.
     * @return boolean, true for bulk and false for not bulk item.
     */
    public boolean isBulk() {
        
        return myBulkPrice != null;
        
    }

    /**
     * String representation of object.
     * @return String
     */
    @Override
    public String toString() {
        
        final StringBuilder builder = new StringBuilder(128); 
        //builder.append(getClass().getSimpleName());
        builder.append(myProduct);
        builder.append(", ");
        
        
        // formatting the price into the currency(US Dollar). 
        final NumberFormat numberFormat = 
                        NumberFormat.getCurrencyInstance(Locale.US);
        final String price = numberFormat.format(myPrice);
        builder.append(price);
        
        if (isBulk()) {
            builder.append(" (");
            builder.append(myBulkQuantity);
            builder.append(" for ");
            final String bulkPrice = numberFormat.format(myBulkPrice);
            builder.append(bulkPrice);
            builder.append(")");
            
        }
        
        
        return builder.toString();
    }


    @Override
    public boolean equals(final Object theOther) {
        boolean returnValue = false;
        
        if (this == theOther) {
            return true;
        }
        
        if (theOther == null) {
            return false;
        }
        
        if (getClass() != theOther.getClass()) {
            return false;
        }
        
        final Item otherItem = (Item) theOther;
        
        if ((myBulkQuantity > 0) && (myBulkPrice != null)) {
            returnValue = myProduct.equals(otherItem.myProduct)
                       && myPrice.equals(otherItem.myPrice)
                       && myBulkQuantity == otherItem.myBulkQuantity
                       && myBulkPrice.equals(otherItem.myBulkPrice);
        } else {
            returnValue = myProduct.equals(otherItem.myProduct)
                            && myPrice.equals(otherItem.myPrice);
        }
        
        return returnValue;
    
    }


    @Override
    public int hashCode() {
        
        return Objects.hash(myProduct, myPrice, myBulkQuantity, myBulkPrice);
    }

}
