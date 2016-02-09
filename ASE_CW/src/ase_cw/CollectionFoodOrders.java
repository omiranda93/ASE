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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * The collection that holds all the Order objects.
 * It is using a Map with the tableId as a key (Integer) and a TreeSet of OrderItems as the value
 * @author giannis
 */
public class CollectionFoodOrders {
    private Map<Integer, ? super Set<FoodOrder>> orderCol;
    private Menu menu;
    private double discount;
    
    //Get all the prices of all the dishes in pairs from the Menu class. As we are using a map, traversing the Map to get the price is O(1) complexity so its optimal.
    private Map<String, Double> NamePricePair = new TreeMap<String, Double>();

    /**
     * Creates a new collection of orders
     * @param menu The Menu collection is passed in order to gain access to the prices later on
     */
    public CollectionFoodOrders(Menu menu){
        orderCol = new TreeMap<Integer, Set<FoodOrder>>();
        this.menu = menu;
        NamePricePair = menu.getValues();
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
                
        result += "TABLES SUMMARY\n";
        
        //Put all the tables in an (ordered) set
        Set<Integer> tables = this.getKeys();
        
        //For each table available
        for (Integer t : tables){    
            result += getBill(t) + "\n";
        }
        
        return result;
    }
    
    public String getBill(int tableId){
        double bill=0;
        double dishTotal=0;
        String result="Table " + tableId + " Summary\n";
        
        //Create the string formater to be applied to String.format
        String formater = "%-" 
                + Manager.ALINEA_DISHNAME + "s %-" 
                + Manager.DISHNAME_TEXT + "s %-" 
                + Manager.QUANTITY + "s %-1s %-" 
                + Manager.PRICE + "s %-1s %-" 
                + Manager.MAX_TOTAL + "s %-" 
                + Manager.CURRENCY_SIZE + "s";
        
        Set<FoodOrder> orders = getValue(tableId);
            for (FoodOrder order : orders){
               dishTotal = NamePricePair.get(order.getDishName()) * order.getQuantity();
               result += String.format(formater,"",order.getDishName(), order.getQuantity(),"*",NamePricePair.get(order.getDishName()) ,"=" ,dishTotal, Manager.CURRENCY) +"\n";
               bill += dishTotal;
            }
        discount = (Manager.DISCOUNT * bill)/100;
        
        result += "\n";
        
        //Also print the summed total of the table, included the discounted price (if applicable - configured in the manager class)
        discount = (Manager.DISCOUNT * bill)/100;
        result += String.format(formater,"","Total for this table:","","","","",bill, Manager.CURRENCY) +"\n";
        result += String.format(formater,"","Discount:","","","","",discount, Manager.CURRENCY) +"\n";
        result += String.format(formater,"","Discounted total:","","","","",bill - discount, Manager.CURRENCY) +"\n\n";
        
        //Update the tables bill with the discount (if any)
        bill -= discount;
        
        return result;
    }
    
    public void showTableBill(){
        String id = JOptionPane.showInputDialog(null, "Enter table id");
                
        if (!this.getKeys().contains(Integer.valueOf(id))){
            JOptionPane.showMessageDialog(null, "Table ID not existant.");
            
        } else{
        
        System.out.println(getBill(Integer.valueOf(id)));
        JOptionPane.showMessageDialog(null,getBill(Integer.valueOf(id)));
        }
        
    }
}

//class CustomComparator implements Comparator<Integer>{
// 
//    @Override
//    public int compare(Integer e1, Integer e2) {
//        return Integer.compare(e1, e2);
//    }
//}
    
