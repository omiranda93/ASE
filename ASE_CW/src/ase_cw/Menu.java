package ase_cw;

import java.util.*;

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
     * Gets the menu items of a specific category
     * @param category of the menu items to get
     * @return the menu items of a specific category
     */
    public TreeSet<MenuItem> getValue(Category category) {

        return ((TreeSet<MenuItem>) menu.get(category));
    }

    /**
     * Gets the categories (keys) available in the menu
     * @return the categories (keys) available in the menu
     */
    public Set<Category> getKeys() {

        return menu.keySet();
    }

    /**
     * Adds a set of menu items, whose category is the same, into the menu
     * @param key Category of the set of menu items to add
     * @param value Set of menu items of the same category to add
     */
    public void addValue(Category key, Set<MenuItem> value) {

        menu.put(key, value); //reminder : check that key = value.category !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    /**
     * Represents this menu as a String
     * @return the string that represents this menu
     */
    @Override
    public String toString() {
        Set<MenuItem> menu_items; //Set of menu items of one category
        String res; //String to be returned

        res = "\n"+Manager.MENU+"\n" + Manager.underlineString(Manager.MENU) +"\n"; //Title of the menu

        /* Getting all the different categories available in the menu
           Already ordered as specified in the Category enumclass  */
        Set<Category> categories = getKeys();

        //For all categories
        for (Category cat : categories) {

            res += "\n" + cat + "\n";

            menu_items = getValue(cat);

            //For all menu items
            for (MenuItem m_item : menu_items) {

                //Print the current menu item
                res += m_item.toString();
            }
        }

        return res;
    }

}
