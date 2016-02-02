/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * The collection that holds all the Order objects.
 * It is using a Map with the tableId as a key (Integer) and a TreeSet of OrderItems as the value
 * @author giannis
 */
public class CollectionFoodOrders {
    private Map<Integer, ? super Set<FoodOrder>> orderCol;
    private Menu menu;

    /**
     * Creates a new collection of orders
     * @param menu The Menu collection is passed in order to gain access to the prices later on
     */
    public CollectionFoodOrders(Menu menu){
        orderCol = new TreeMap<Integer, Set<FoodOrder>>();
        this.menu = menu;
    }

    /**
     * Returns the orders of the specified table
     * @param tableId The table from which the orders are requested
     * @return The orders made by the provided table in a TreeSet
     */
    public TreeSet<FoodOrder> getValue (Integer tableId){
        return (TreeSet<FoodOrder>) orderCol.get(tableId);
    }

    /**
     * Returns all the keys (TableId) from the collection of orders
     * @return the keys of the collection as a Set
     */
    public Set<Integer> getKeys(){
        return orderCol.keySet();
    }
    
    /**
     * Adds a collection of OrderItems to the collection, under the specified tableId
     * @param tableId The table under which the sub-set of orders will be placed
     * @param oi A collection (TreeSet) of OrderItems
     */
    public void addValues(Integer tableId, TreeSet<FoodOrder> oi){
        orderCol.put(tableId, oi);
    }
    
    /**
     * Adds an FoodOrder to the CollectionFoodOrders (Map). 
     * As the items are grouped by the tableId, if this is the first time the table is inserted, a <tableId, TreeSet of OrderItems> pair will be created first
     * @param tableId The key (the id of the table)
     * @param oi the Value (an FoodOrder object)
     */
    public void addValue(Integer tableId, FoodOrder oi){
        if (orderCol.containsKey(tableId)){
            this.getValue(tableId).add(oi);
        }else{
            TreeSet<FoodOrder> ts = new TreeSet<FoodOrder>();
            ts.add(oi);
            orderCol.put(tableId, ts);
        }
    }
    
    /**
     * Overridden method to print the bill.
     * @return All the orders of the collection as a String, in tabular format.
     */
    @Override
    public String toString(){
        String result= "";
        
        //Create the string formater to be applied to String.format
        String formater = "%-" 
                + Manager.ALINEA_DISHNAME + "s %-" 
                + Manager.DISHNAME_TEXT + "s %-" 
                + Manager.QUANTITY + "s %-1s %-" 
                + Manager.PRICE + "s %-1s %-" 
                + Manager.MAX_TOTAL + "s %-" 
                + Manager.CURRENCY_SIZE + "s";
        
        result += "TABLES SUMMARY\n";
        
        //Put all the tables in an (ordered) set
        Set<Integer> tables = this.getKeys();
        Set<FoodOrder> orders;

        //Get all the prices of all the dishes in pairs from the Menu class. As we are using a map, traversing the Map to get the price is O(1) complexity so its optimal.
        Map<String, Double> NamePricePair = menu.getValues();
        
        //For each table available
        for (Integer t : tables){    
            double tableTotal = 0.0;
            result += "TABLE " + t + " SUMMARY\n";
            orders = this.getValue(t);
            
            //For each order in this table, print the information required
            for (FoodOrder order : orders){
               double dishTotal = NamePricePair.get(order.getDishName()) * order.getQuantity();
               result += String.format(formater,"",order.getDishName(), order.getQuantity(),"*",NamePricePair.get(order.getDishName()) ,"=" ,dishTotal, Manager.CURRENCY) +"\n";
               tableTotal += dishTotal;
            }
        result += "\n";
        
        //Also print the summed total of the table, included the discounted price (if applicable - configured in the manager class)
        double discount = (Manager.DISCOUNT * tableTotal)/100;
        result += String.format(formater,"","Total for this table:","","","","",tableTotal, Manager.CURRENCY) +"\n";
        result += String.format(formater,"","Discount:","","","","",discount, Manager.CURRENCY) +"\n";
        result += String.format(formater,"","Discounted total:","","","","",tableTotal - discount, Manager.CURRENCY) +"\n\n\n";
        }
        
        return result;
    }
}

//class CustomComparator implements Comparator<Integer>{
// 
//    @Override
//    public int compare(Integer e1, Integer e2) {
//        return Integer.compare(e1, e2);
//    }
//}
    
