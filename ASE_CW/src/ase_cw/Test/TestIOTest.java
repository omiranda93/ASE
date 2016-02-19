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
    private CollectionFoodOrders orders,ordersCol;

    MenuItem m1 = new MenuItem(Category.MAIN, "Quiche Lorraine", 14);
    MenuItem m2 = new MenuItem(Category.DESSERT, "Fondant aux chocolats", 4);
    MenuItem m3 = new MenuItem(Category.MAIN, "Pizza", 1.2);
    MenuItem m4 = new MenuItem(Category.STARTER, "Oysters", 15.15);
    MenuItem m5 = new MenuItem(Category.DRINKS, "Ricard", 20);
    MenuItem m6 = new MenuItem(Category.STARTER, "Sushi", 12.10);
    MenuItem m7 = new MenuItem(Category.DESSERT, "Tropezienne", 13);
    MenuItem m8 = new MenuItem(Category.DRINKS, "Vodka", 7);

    //Bug examples
    MenuItem m9 = new MenuItem(Category.MAIN, "Way_Too_Long_Name_That_Wont_Fit_On_The_Bill_Blablablablablablabla", 13);
    MenuItem m10 = new MenuItem(Category.DRINKS, "Thing", 7777777777.7777777);



    

    public TestIOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        try {
            menu2.addValue(Category.MAIN, m1);
            menu2.addValue(Category.DESSERT, m2);
            menu2.addValue(Category.MAIN, m3);
            menu2.addValue(Category.STARTER, m4);
            menu2.addValue(Category.DRINKS, m5);
            menu2.addValue(Category.STARTER, m6);
            menu2.addValue(Category.DESSERT, m7);
            menu2.addValue(Category.DRINKS, m8);
            menu2.addValue(Category.MAIN, m9);
            menu2.addValue(Category.DRINKS, m10);
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
        TestIO instance = new TestIO();
        instance.readMenu(menu);
        assertEquals(menu2, menu);
    }

    /**
     * Test of readOrders method, of class TestIO.
     */
    @Test
    public void testReadOrders() {
        System.out.println("readOrders");
        TestIO instance = new TestIO();
        try {
            instance.readOrders(orders);
        } catch (NoMatchingIDException ex) {
            System.out.println(ex.getMessage());
        }
        assertEquals(ordersCol, orders);
    }
    
}
