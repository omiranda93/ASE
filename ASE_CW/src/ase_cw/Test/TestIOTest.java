/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw.Test;

import java.util.Set;
import java.util.TreeSet;

import ase_cw.Model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author omiranda93
 */
public class TestIOTest {
    
    private Menu menu,menu2;
    private MenuItem m1, m2, m3, m4,m5, m6, m7,m8, m9, m10,m11, m12, m13,m14, m15,
    m16,m17, m18, m19,m20, m21, m22,m23, m24, m25,m26, m27, m28,m29, m30,
    m31,m32, m33, m34,m35, m36, m37,m38, m39, m40;
    private CollectionFoodOrders orders,ordersCol;

    //Bug examples
    MenuItem mi9 = new MenuItem(Category.MAIN, "Way_Too_Long_Name_That_Wont_Fit_On_The_Bill_Blablablablablablabla", 13);
    MenuItem mi10 = new MenuItem(Category.DRINKS, "Thing", 7777777777.7777777);

    private TestIO instance;
    
    @Before
    public void setUp() {

        m1 = new MenuItem(Category.STARTER, "Smoked Salmon", 6.00);
        m2 = new MenuItem(Category.MAIN, "Chicken Balerno", 8.00);
        m3 = new MenuItem(Category.MAIN, "Roast Beef", 10.00);
        m4 = new MenuItem(Category.DRINKS, "Coffee and Mints", 2.5);
        m5 = new MenuItem(Category.STARTER, "Carrot Soup", 3.5);
        m6 = new MenuItem(Category.DESSERT, "Pudding", 4.00);
        m7 = new MenuItem(Category.DRINKS, "Coke", 2.00);
        m8 = new MenuItem(Category.STARTER, "DIY British beef crostini", 5.00);
        m9 = new MenuItem(Category.STARTER, "Cheesy sprout fondue", 5.50);
        m10 = new MenuItem(Category.STARTER, "Lobster, green bean & radicchio salad", 5.50);
        m11 = new MenuItem(Category.STARTER, "Classic potted shrimps", 3.00);
        m12 = new MenuItem(Category.STARTER, "Watercress & celeriac soup with goat's cheese croutons", 6.00);
        m13 = new MenuItem(Category.STARTER, "Creamy cucumber with gravadlax", 3.50);
        m14 = new MenuItem(Category.STARTER, "Chicken liver & pineau pate", 7.00);
        m15 = new MenuItem(Category.STARTER, "Seared scallops with leeks & lemon chilli butter", 5.00);
        m16 = new MenuItem(Category.MAIN, "Beef Enchiladas", 9.00);
        m17 = new MenuItem(Category.MAIN, "Beer and Brown Sugar Kielbasa & Sauerkraut", 8.50);
        m18 = new MenuItem(Category.DRINKS, "Cider", 3.00);
        m19 = new MenuItem(Category.DRINKS, "Guinness", 4.00);
        m20 = new MenuItem(Category.DESSERT, "Dairy-free avocado chocolate mousse", 4.00);
        m21 = new MenuItem(Category.MAIN, "Coconut Shrimp with Mango Dipping Sauce", 7.00);
        m22 = new MenuItem(Category.MAIN, "General Tso’s Chicken", 11.00);
        m23 = new MenuItem(Category.DRINKS, "Dr Pepper", 2.00);
        m24 = new MenuItem(Category.DRINKS, "Beer", 2.50);
        m25 = new MenuItem(Category.DESSERT, "Chocolate & mint cheesecake", 3.50);
        m26 = new MenuItem(Category.MAIN, "Crab Cakes with Remoulade Sauce", 9.50);
        m27 = new MenuItem(Category.MAIN, "Frito Pie", 9.00);
        m28 = new MenuItem(Category.DRINKS, "Fanta lemon", 2.00);
        m29 = new MenuItem(Category.MAIN, "Favorite Meatloaf", 8.50);
        m30 = new MenuItem(Category.DESSERT, "Chocolate mousse", 2.5);
        m31 = new MenuItem(Category.DESSERT, "Choc a block", 3.00);
        m32 = new MenuItem(Category.MAIN, "Greek Lamb Gyros with Tzatziki Sauce", 13.00);
        m33 = new MenuItem(Category.DRINKS, "Fanta orange", 2.00);
        m34 = new MenuItem(Category.DESSERT, "Chocolate-Mint Bars", 5.00);
        m35 = new MenuItem(Category.DESSERT, "Oatmeal Pecan Pie", 4.00);
        m36 = new MenuItem(Category.DESSERT, "Chocolate banoffee pie", 5.00);
        m37 = new MenuItem(Category.DESSERT, "Sticky date pudding", 6.00);
        m38 = new MenuItem(Category.DRINKS, "Red wine", 3.00);
        m39 = new MenuItem(Category.MAIN, "Crab Cakes with Remoulade Sauce", 9.5);
        m40 = new MenuItem(Category.DESSERT, "Chocolate Cake", 4.50);

        instance = new TestIO();
        menu = new Menu();
        menu2 = new Menu();
        orders = new CollectionFoodOrders(menu);
        ordersCol = new CollectionFoodOrders(menu);

        try {
            menu2.addValue(Category.STARTER, m1);
            menu2.addValue(Category.MAIN, m2);
            menu2.addValue(Category.MAIN, m3);
            menu2.addValue(Category.DRINKS, m4);
            menu2.addValue(Category.STARTER, m5);
            menu2.addValue(Category.DESSERT, m6);
            menu2.addValue(Category.DRINKS, m7);
            menu2.addValue(Category.STARTER, m8);
            menu2.addValue(Category.STARTER, m9);
            menu2.addValue(Category.STARTER, m10);
            menu2.addValue(Category.STARTER, m11);
            menu2.addValue(Category.STARTER, m12);
            menu2.addValue(Category.STARTER, m13);
            menu2.addValue(Category.STARTER, m14);
            menu2.addValue(Category.STARTER, m15);
            menu2.addValue(Category.MAIN, m16);
            menu2.addValue(Category.MAIN, m17);
            menu2.addValue(Category.DRINKS, m18);
            menu2.addValue(Category.DRINKS, m19);
            menu2.addValue(Category.DESSERT, m20);
            menu2.addValue(Category.MAIN, m21);
            menu2.addValue(Category.MAIN, m22);
            menu2.addValue(Category.DRINKS, m23);
            menu2.addValue(Category.DRINKS, m24);
            menu2.addValue(Category.DESSERT, m25);
            menu2.addValue(Category.MAIN, m26);
            menu2.addValue(Category.MAIN, m27);
            menu2.addValue(Category.DRINKS, m28);
            menu2.addValue(Category.MAIN, m29);
            menu2.addValue(Category.DESSERT, m30);
            menu2.addValue(Category.DESSERT, m31);
            menu2.addValue(Category.MAIN, m32);
            menu2.addValue(Category.DRINKS, m33);
            menu2.addValue(Category.DESSERT, m34);
            menu2.addValue(Category.DESSERT, m35);
            menu2.addValue(Category.DESSERT, m36);
            menu2.addValue(Category.DESSERT, m37);
            menu2.addValue(Category.DRINKS, m38);
            menu2.addValue(Category.MAIN, m39);
            menu2.addValue(Category.DESSERT, m40);
        } catch (WrongCategoryException ex) {
            Logger.getLogger(TestIOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FoodOrder o1 = new FoodOrder(3, "Roast Beef", 1);
            FoodOrder o2 = new FoodOrder(1, "Smoked Salmon", 2);
            FoodOrder o3 = new FoodOrder(1, "Carrot Soup", 1);
            FoodOrder o4 = new FoodOrder(1, "Roast Beef", 2);
            FoodOrder o5 = new FoodOrder(3, "Chocolate Cake", 1);
            FoodOrder o6 = new FoodOrder(2, "Carrot Soup", 1);
            FoodOrder o7 = new FoodOrder(2, "Roast Beef", 1);
            ordersCol.addValue(o1.getTableId(), o1);
            ordersCol.addValue(o2.getTableId(), o2);
            ordersCol.addValue(o3.getTableId(), o3);
            ordersCol.addValue(o4.getTableId(), o4);
            ordersCol.addValue(o5.getTableId(), o5);
            ordersCol.addValue(o6.getTableId(), o6);
            ordersCol.addValue(o7.getTableId(), o7);
        
        } catch (InvalidQuantityException ex) {
            Logger.getLogger(TestIOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        

    }
    
    @After
    public void tearDown() {
        System.out.println(" ############# The end ###########");
    }

    /**
     * Test of readMenu method, of class TestIO.
     */
    @Test
    public void testReadMenu() {
        System.out.println("readMenu");
        //TestIO instance = new TestIO();
        instance.readMenu(menu);
        assertEquals(menu2.toString(), menu.toString());
    }

    /**
     * Test of readOrders method, of class TestIO.
     */
    @Test
    public void testReadOrders() {
        System.out.println("readOrders");
        //TestIO instance = new TestIO();
        try {
            instance.readOrders(orders);
        } catch (NoMatchingIDException ex) {
            System.out.println(ex.getMessage());
        }
        assertEquals(ordersCol, orders);
    }
    
}
