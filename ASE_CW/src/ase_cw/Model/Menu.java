package ase_cw.Model;

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
        menu = new EnumMap<>(Category.class);
    }

    /**
     * Gets the categories (keys) available in the menu
     * @return the categories (keys) available in the menu
     */
    public Set<Category> getKeys() {

        return menu.keySet();
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
     * Gets all the menu items of the menu in one set
     * @return a set of all the menu items available
     */
    public Map<String, Double> getValues() {  
        Map<String, Double> map = new TreeMap<String, Double>();
        
        for (Map.Entry<Category, ? super Set<MenuItem>> entry : menu.entrySet()){
            for (MenuItem m : (TreeSet<MenuItem>) entry.getValue()){
                map.put(m.getName(), m.getPrice());
            }
        }
        return map;
    }

    /**
     * Adds a set of menu items, whose category is the same, into the menu
     * @param key Category of the set of menu items to add
     * @param values Set of menu items of the same category to add
     */
    public void addValues(Category key, Set<MenuItem> values) {

        menu.put(key, values); //reminder : check that key = value.category !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    /**
     * Adds a menu item into the menu
     * @param key Category of the menu item to add
     * @param value Menu item to add
     */
    public void addValue(Category key, MenuItem value) {

        this.getValue(key).add(value);
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
