/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw;

/**
 * A single Order object
 * @author giannis
 */
public class FoodOrder implements Comparable<FoodOrder>{
    private String dish;
    private int tableId;
    private int quantity;
    
    /**
     * Empty constructor. Not used so far.
     */
    public FoodOrder(){}

    /**
     * Creates an OrderItem object with the given parameters
     * @param tableId the ID of the table the order was made
     * @param dish The dish name it was ordered
     * @param quantity How many times the dish was ordered
     */
    public FoodOrder(int tableId, String dish, int quantity){
        this.dish=dish;
        this.quantity=quantity;
        this.tableId=tableId;
    }
    
    /**
     * Sets the dish name parameter
     * @param d The name of the dish
     */
    public void setDish(String d){this.dish = d;}

    /**
     * Sets the Table ID parameter
     * @param t_id The ID of the table
     */
    public void setTableId(int t_id){this.tableId = t_id;}

    /**
     * Sets the quantity of the dish in the order
     * @param q How many times this dish has been ordered in this particular order
     */
    public void setQuantity(int q){this.quantity = q;}
    
    /**
     * Returns the Table ID
     * @return the TableId of this item
     */
    public int getTableId(){return this.tableId;}

    /**
     * Returns the Dish Name
     * @return the DishName of this item
     */
    public String getDishName(){return this.dish;}

    /**
     * Returns the Quantity 
     * @return the Quantity of this item
     */
    public int getQuantity(){return this.quantity;}

    
    /**
     * The overridden compare method (according to dishName)
     * @param o the object to compare with
     * @return the value 0 if the argument string is equal to this string; 
     * a value less than 0 if this string is lexicographically less than the string argument; 
     * and a value greater than 0 if this string is lexicographically greater than the string argument.
     */
    @Override
    public int compareTo(FoodOrder o) {
        return dish.compareTo(o.getDishName());
    }
    
    
}