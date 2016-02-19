/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw.Test;

import java.util.Set;
import java.util.TreeSet;

import ase_cw.Model.*;
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
    
    private Menu menu;
    private MenuItem menuItem1, menuItem2, menuItem3, menuItem4;
    private Set<MenuItem> menuItems1, menuItems2;
    private CollectionFoodOrders orders;
    private FoodOrder fOrder1, fOrder2, fOrder3, fOrder4;
    private Set<FoodOrder> fOrders1, fOrders2;
    
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
        
        menuItem1 = new MenuItem(Category.STARTER, "Toast", 1.8);
        menuItem2 = new MenuItem(Category.MAIN, "Roast Beef", 8.8);
        menuItem3 = new MenuItem(Category.DESSERT, "Ice cream", 3.50);
        menuItem4 = new MenuItem(Category.DRINKS, "Ricard", 10);
        
        menu = new Menu();
        
         menuItems1 = new TreeSet<MenuItem>() {{
            add(menuItem4); add(menuItem3);
        }};

        menuItems2 = new TreeSet<MenuItem>() {{
            add(menuItem2);
        }};
        
//        fOrder1 = new FoodOrder(1, "Toast", 2);
//        fOrder2 = new FoodOrder(1, "Roast Beef", 1);
//        fOrder3 = new FoodOrder(3, "Ice cream", 14);
//        fOrder4 = new FoodOrder(5, "Ricard", 3);
        
        orders = new CollectionFoodOrders(menu);
        
        fOrders1 = new TreeSet<FoodOrder>() {{
            add(fOrder1); add(fOrder3);
        }};
        
        fOrders2 = new TreeSet<FoodOrder>() {{
            add(fOrder3);
        }};
        
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
        assertEquals("Test on readMenu() failed", menu);
    }

    /**
     * Test of readOrders method, of class TestIO.
     */
    @Test
    public void testReadOrders() {
        System.out.println("readOrders");
        TestIO instance = new TestIO();
        instance.readOrders(orders);
        assertEquals("Test on readOrders() failed", orders);
    }
    
}
