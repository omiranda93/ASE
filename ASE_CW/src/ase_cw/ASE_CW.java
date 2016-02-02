/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw;

import java.util.*;

/**
 *
 * @author omiranda93
 */
public class ASE_CW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        //################################################### TEST MENU ################################################
        MenuItem m1 = new MenuItem(Category.MAIN, "Quiche Lorraine", 14);
        MenuItem m2 = new MenuItem(Category.DESSERT, "Fondant aux chocolats", 4);
        MenuItem m3 = new MenuItem(Category.MAIN, "Pizza", 1.2);
        MenuItem m4 = new MenuItem(Category.STARTER, "Oysters", 15.15);
        MenuItem m5 = new MenuItem(Category.DRINKS, "Ricard", 20);
        MenuItem m6 = new MenuItem(Category.STARTER, "Sushi", 12.10);
        MenuItem m7 = new MenuItem(Category.DESSERT, "Tropezienne", 13);
        MenuItem m8 = new MenuItem(Category.DRINKS, "Vodka", 7);
//
//        //Bug examples
//        MenuItem m9 = new MenuItem(Category.MAIN, "Way_Too_Long_Name_That_Wont_Fit_On_The_Bill_Blablablablablablabla", 13);
//        MenuItem m10 = new MenuItem(Category.DRINKS, "Thing", 7777777777.7777777);
//
        Menu menu = new Menu();
        Set<MenuItem> starters = new TreeSet<MenuItem>();
        Set<MenuItem> mains = new TreeSet<MenuItem>();
        Set<MenuItem> desserts = new TreeSet<MenuItem>();
        Set<MenuItem> drinks = new TreeSet<MenuItem>();

        starters.add(m4); starters.add(m6);
        mains.add(m1); mains.add(m3);
        desserts.add(m7); desserts.add(m2);
        drinks.add(m5); drinks.add(m8);

        menu.addValues(Category.DESSERT, desserts);
        menu.addValues(Category.MAIN, mains);
        menu.addValues(Category.STARTER, starters);
        menu.addValues(Category.DRINKS, drinks);

        TreeSet<MenuItem> enorme_test = menu.getValues();

        System.out.println("########################### " +enorme_test.size());
        for (MenuItem m : enorme_test) {
           System.out.println(m.toString());
        }
        System.out.println("###########################");

//
//        MenuItem m11 = new MenuItem(Category.DESSERT, "Fondant aux chocolats", 111); //Isn't added thanks to the set container !
//        menu.addValue(Category.DESSERT, m2);
//
//        System.out.println(menu.toString());

//        System.out.println("Res compare = " + m1.compareTo(m2));
//        System.out.println("Cat : " + m1.getCategory() + " and its ordinal value (better for comparing/switch) : "+m1.getCategory().ordinal());

//        System.out.println(m1.toString());
//        System.out.println(m2.toString());

        /* Check must be done when storing the things read in MenuItem
            - Number format (unit price): ---.--
            - Number size (unit price): 3.2
            - Dish name must not be too long < Manager.MENU_DISHNAME
           Check must be done before starting reading anything
            - Currency : three-letters ISO 4217 --> propose the user to change it before continuing or quit
            - Currency exists --> propose the user to change it before continuing or quit
            - Check that the global constants in the Manager class won't overtake Manager.WIDTH_BILL
        */
//        System.out.println(m9.toString());
//        System.out.println(m10.toString());


        //################################################# END TEST MENU ##############################################
        
        //################################################# BEGIN TEST TestIO ##############################################
        /*TestIO reader =new TestIO();
        Menu menu = new Menu();
        reader.readMenu(menu);
        System.out.println(menu.toString());*/
        //################################################# END TEST TestIO ##############################################
    }
    
}
