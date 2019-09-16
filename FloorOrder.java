/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imfloored;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Sarah
 */
public final class FloorOrder {

    private static final NumberFormat CF = NumberFormat.getCurrencyInstance(Locale.US);
    
    public enum FloorType {
        Wood, Carpet, Lava
    }
    public static final double DEFAULT_PRICE = 8.50;
    public static final double MIN_PRICE = 0;
    public static final double MAX_PRICE = 9999.99;
    public static final String DEFAULT_TYPE = "Item";
    
    private static final double WOOD_PRICE = 8.50;
    private static final double CARPET_PRICE = 10.50;
    private static final double LAVA_PRICE = 50.00;
    
    
    private final Customer customer = new Customer();
    
    private FloorType floorType;
    private double sizeCost;
    
    private double total = 0;
    private boolean overrideTotal = false;
    private int id =-1;
    
    public FloorOrder() {
        clearOrder();
    }
    public FloorOrder(int id) {
        this.id= id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCostOverride(boolean overrideTotal) {
        this.overrideTotal = overrideTotal;
    }
    public void setFirstName(String firstName){
        customer.setFirstName(firstName); 
    }
    public String getFirstName() {
        return customer.getFirstName();
    }
    public void setLastName(String lastName) {
        customer.setLastName(lastName); 
    }
    public String getLastName() {
        return customer.getLastName();
    }
    public String getFullName() {
        return customer.getFullName();
    }
    
    public void setTotal(double total) {
        this.total = total;
        overrideTotal = true;
    }
    public double getTotal() {
        if (!overrideTotal) {
            calculateTotalCost();
        }
        return total;
    }
    public String getTotalCost() {
        calculateTotalCost();
        return CF.format(total);
    }
    public void setFloorType(FloorType size) {
         floorType = size;
    }
    public String getFloorType() {
        String str;
        switch (floorType) {
             case Wood:
                 str = "Wood";
                 break;
             case Carpet:
                 str = "Carpet";
                 break;
             case Lava:
                 str = "Lava";
                 break;
             default:
                str = "Wood";
                 break; 
         }
        return str;
    }
    private void calculateTotalCost() {
        total = 0;
        switch (floorType) {
             case Wood:
                 sizeCost = WOOD_PRICE;
                 break;
             case Carpet:
                 sizeCost = CARPET_PRICE;
                 break;
             case Lava:
                 sizeCost = LAVA_PRICE;
                 break;
             default:
                sizeCost = WOOD_PRICE;
                break; 
         }
        total = sizeCost;
        
      
    }
    public void setFloorType(String type) {
        if(type.compareToIgnoreCase("wood") == 0) {
            floorType = floorType.Wood;
        }
        else if (type.compareToIgnoreCase("carpet") == 0) {
            floorType = floorType.Carpet;
        }
        else if (type.compareToIgnoreCase("lava") == 0) {
            floorType = floorType.Lava;
        }
        else {
            floorType = floorType.Wood;
        }
    }
    public void clearOrder() {
        setFloorType(floorType.Wood);
        
    }
    public String getOrderInformation() {
        StringBuilder str = new StringBuilder();
        getTotal();
        str.append("Flooring order for:\n");
        str.append(customer.getFullName());
       
       
        str.append ("\nType: ");
        str.append(getFloorType());
        str.append(": ");
        str.append(CF.format(floorType));
        str.append("\nTotal: ");
        str.append(CF.format(total));
        return str.toString();
    }
    @Override
    public String toString() {
        return customer.toString();
    }
    
}
