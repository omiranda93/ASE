package ase_cw;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

/**
 * Represents a menu composed of food items proposed by the restaurant
 *
 * Date: 31/01/2016
 * Time: 2:34 PM
 *
 * @author Cécile Riquart
 * @version 1.0
 */
public class Menu {

    /**
     * menu summarising all the menu items available in the restaurant
     */
    private Map<Category, ? super Set<MenuItem>> menu;

    /**
     * Empty constructor of a Menu
     */
    public Menu() {
        menu = new EnumMap<Category, Set<MenuItem>>(Category.class);
    }

    /**
     * Gets the menu of the restaurant
     * @return the menu proposed by the restaurant
     */
    public Map<Category, ? super Set<MenuItem>> getMenu() {
        return menu;
    }

    /**
     * TODO
     * @return
     */
    @Override
    public String toString() {
        //TODO
        return "";


    }

}
