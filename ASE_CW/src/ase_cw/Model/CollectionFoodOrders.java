/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw.Model;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 * The collection that holds all the Order objects.
 * It is using a Map with the tableId as a key (Integer) and a TreeSet of OrderItems as the value
 * @author giannis
 */
public class CollectionFoodOrders {
    private Map<Integer, ? super Set<FoodOrder>> orderCol;
    private Menu menu;
    private double discount;
    
    //statistic variables
    
    
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
    
    /**
     * Returns a string representation of the bill for a given table in tabular format.
     * @param tableId The table we need the bill for
     * @return  A table with the details of the tables bill.
     */
    public String getBill(int tableId){
        double bill=0;
        double dishTotal=0;
        int discountPerc=0;
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
            discountPerc = Manager.calculateDiscount(bill);
        discount = (discountPerc * bill)/100;
        
        result += "\n";
        
        //Also print the summed total of the table, included the discounted price (if applicable - configured in the manager class)
        //discount = (Manager.DISCOUNT * bill)/100;
        result += String.format(formater,"","Total for this table:","","","","",bill, Manager.CURRENCY) +"\n";
        result += String.format(formater,"","Discount: " + discountPerc + "%","","","","",discount, Manager.CURRENCY) +"\n";
        result += String.format(formater,"","Discounted total:","","","","",bill - discount, Manager.CURRENCY) +"\n\n";
        
        //Update the tables bill with the discount (if any)
        bill -= discount;
        
        return result;
    }
    
    /**
     * Shows a dialog, prompting the user to enter a table ID and show a window with the 
     * bill for the provided table
     */
    public void showTableBill(){
        String id = JOptionPane.showInputDialog(null, "Enter table id");
                
        if (!this.getKeys().contains(Integer.valueOf(id))){
            JOptionPane.showMessageDialog(null, "Table ID not existant.");
            
        } else{
        
        System.out.println(getBill(Integer.valueOf(id)));
        JOptionPane.showMessageDialog(null,getBill(Integer.valueOf(id)));
        }
        
    }
    
    /**
     * Creates a frequency report of how many times each dish has been order in total within
     * the day. 
     * @return A String table showing how many times each dish has been ordered.
     */
    public String showDishCounter(){
        String result = String.format("%-60s %-3s", "Dish name", "Times ordered") + "\n";
        result += Manager.underlineString(result) + "\n";
        Map<String, Integer> quantityOrders = new TreeMap<String, Integer>();
        
        //First build a Map of all distinct food names and set the counter to 0
        for (Map.Entry<Integer, ? super Set<FoodOrder>> entry : orderCol.entrySet()){
            for (FoodOrder o : (TreeSet<FoodOrder>) entry.getValue()){
                quantityOrders.put(o.getDishName(), 0);    
            }
        }
        
        //Then for each of these foods, search the order collection again and for everytime found, add its quantity to the counter (as a value of the map) 
        for (Map.Entry<String, Integer> foodList : quantityOrders.entrySet()){
            for (Map.Entry<Integer, ? super Set<FoodOrder>> entry : orderCol.entrySet()){
                for (FoodOrder o : (TreeSet<FoodOrder>) entry.getValue()){
                    if (o.getDishName().equals(foodList.getKey())){
                        foodList.setValue(foodList.getValue() + o.getQuantity());
                    }   
                }
            }
        }
        
        //Iterate through the produced Map to build the table for output.
        for (Map.Entry<String, Integer> foodList : quantityOrders.entrySet()){
            result += String.format("%-60s %-3s", foodList.getKey(), foodList.getValue()) + "\n"; 
        }
        
        return result;
    }
    
    /**
     * Creates a report showing the dishes that have not been ordered
     * @return a list formated string representation of the unordered dishes.
     */
    public String showUnorderedDishes(){
        String result="List of unoredered dishes:\n" + Manager.underlineString("List of unoredered dishes:")+"\n";
        Map<String, Integer> orders = new TreeMap<String, Integer>();
        Set<String> orderList = new TreeSet<>(), unordered = new TreeSet<>();
        
        //First build a Map of all distinct food names and set the counter to 0
        for (Map.Entry<Integer, ? super Set<FoodOrder>> entry : orderCol.entrySet()){
            for (FoodOrder o : (TreeSet<FoodOrder>) entry.getValue()){
                orderList.add(o.getDishName());    
            }
        }
      
        //Then add all dishes that do not exist in the orders
        for (Map.Entry<String, Double> entry : NamePricePair.entrySet()){
            if (!orderList.contains(entry.getKey())){
                //unordered.add(entry.getKey());
                result += entry.getKey() +"\n";
            }
        }
        
        return result +"\n";
        
    }
    
    /**
     * Creates a report showing the dishes in orther of profit
     * @return a list formated string representation of the dishes ordered by profit.
     */
    public String showOrdersProfit(){
        String result = String.format("%-60s %-6s", "Dish name", "Profit") + "\n";
        result += Manager.underlineString(result) + "\n";
        Map<String, Double> quantityOrders = new TreeMap<String, Double>();
        TreeMap<Double, String> orderedOrders = new TreeMap<Double, String>();
        //First build a Map of all distinct food names and set the counter of profit to 0
        for (Map.Entry<Integer, ? super Set<FoodOrder>> entry : orderCol.entrySet()){
            for (FoodOrder o : (TreeSet<FoodOrder>) entry.getValue()){
                quantityOrders.put(o.getDishName(), 0.0);    
            }
        }
        
        //Then for each of these foods, search the order collection again and for everytime found, add its quantity multiplied by the price to the pricecounter (as a value of the map) 
        for (Map.Entry<String, Double> foodList : quantityOrders.entrySet()){
            for (Map.Entry<Integer, ? super Set<FoodOrder>> entry : orderCol.entrySet()){
                for (FoodOrder o : (TreeSet<FoodOrder>) entry.getValue()){
                    if (o.getDishName().equals(foodList.getKey())){
                        foodList.setValue(foodList.getValue() + (o.getQuantity()*NamePricePair.get(o.getDishName())));
                    }   
                }
            }
        }
        //Now I am going to order the dishes by profit
        for (Map.Entry<String, Double> foodList : quantityOrders.entrySet()){
            orderedOrders.put(foodList.getValue(), foodList.getKey());
        }
        
        //Iterate through the produced Map to build the table for output.
        for (Map.Entry<Double, String> foodList : orderedOrders.entrySet()){
            result += String.format("%-60s %-6s %-3s", foodList.getValue(), foodList.getKey(), Manager.CURRENCY) + "\n"; 
        }
        
        return result;
        
    }
}

//class CustomComparator implements Comparator<Integer>{Ενημερωσε αυριο η οποτε μαθεις!
// 
//    @Override
//    public int compare(Integer e1, Integer e2) {
//        return Integer.compare(e1, e2);
//    }
//}
    
