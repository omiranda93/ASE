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

        //################################################### TEST MENU ################################################
        MenuItem m1 = new MenuItem(Category.MAIN, "Quiche Lorraine", 14);
        MenuItem m2 = new MenuItem(Category.DESSERT, "Fondant aux chocolats", 4);
        MenuItem m3 = new MenuItem(Category.MAIN, "Pizza", 1.2);
        MenuItem m4 = new MenuItem(Category.STARTER, "Oysters", 15.15);
        MenuItem m5 = new MenuItem(Category.DRINKS, "Ricard", 20);
        MenuItem m6 = new MenuItem(Category.STARTER, "Sushi", 12.10);
        MenuItem m7 = new MenuItem(Category.DESSERT, "Tropezienne", 13);
        MenuItem m8 = new MenuItem(Category.DRINKS, "Vodka", 7);

        Menu menu = new Menu();
        Set<MenuItem> starters = new TreeSet<MenuItem>();
        Set<MenuItem> mains = new TreeSet<MenuItem>();
        Set<MenuItem> desserts = new TreeSet<MenuItem>();
        Set<MenuItem> drinks = new TreeSet<MenuItem>();

        starters.add(m4); starters.add(m6);
        mains.add(m1); mains.add(m3);
        desserts.add(m2); desserts.add(m7);
        drinks.add(m5); drinks.add(m8);

        menu.getMenu().put(Category.DESSERT, desserts);

        System.out.println("Res compare = " + m1.compareTo(m2));
        System.out.println("Cat : " + m1.getCategory() + " and its ordinal value (better for comparing/switch) : "+m1.getCategory().ordinal());

        System.out.println("To string : \n" + m1.toString());
        System.out.println("To string : \n" + m2.toString());
    }
    
}
