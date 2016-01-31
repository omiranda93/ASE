/*

*Cecile's part
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw;

/**
 * Represents a food item figuring on the menu of the restaurant
 *
 * Date: 31/01/2016
 * Time: 1:54 PM
 *
 * @author Cécile Riquart
 * @version 1.0
 */
public class MenuItem implements Comparable<MenuItem> {

    /**
     * A menu item is characterised by:
     * - a category (starter, main, dessert, drinks),
     * - a name: the name of the dish
     * - a price (in pound sterling, £)
     */
    private Category category;
    private String dishName;
    private double price;

    /**
     * Constructor of a menu item
     * @param category Category of the menu item
     * @param dishName Name of the menu item
     * @param price Price of the menu item (expressed in pound sterling £)
     */
    public MenuItem(Category category, String dishName, double price) {
        this.category = category;
        this.dishName = dishName;
        this.price = price;
    }

    /**
     * Gets the category of this menu item
     * @return this menu item's category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Gets the dish name of this menu item
     * @return this menu item's dish name
     */
    public String getName() {
        return dishName;
    }

    /**
     * Gets the price of this menu item
     * @return this menu item's price
     */
    public double getPrice() {
        return price;
    }

    /**
     *  Sets the category of this menu item
     * @param category New category of this menu item
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Sets the name of this menu ite
     * @param dishName New name of this menu item
     */
    public void setName(String dishName) {
        this.dishName = dishName;
    }

    /**
     * Sets the price of this menu item
     * @param price New price of this menu item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Compares this menu item with another one.
     * The comparison is based on the alphabetical order of the dish names
     * @param o The other menu item with which this menu item is compared to
     * @return a value less than 0 if the dish name's argument is after this menu item's dish name according to the
     *         alphabet order
     *         0 if the dish name's argument equals to this menu item's dish name,
     *         a value greater than 0 if the dish name's argument is before this menu item's dish name according to the
     *         alphabet order
     */
    @Override
    public int compareTo(MenuItem o) {
        return dishName.compareTo(o.getName());
    }

    /**
     * TODO
     * @return
     */
    @Override
    public String toString() {
        //TODO
        /*return (getCategory() + "\n"
            +   String.format("%65s", String.format("%-30s %-30.2f %n", getName(), getPrice())));
        */
        return "";
    }
}
