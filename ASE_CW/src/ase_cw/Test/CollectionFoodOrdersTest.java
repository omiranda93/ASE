/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw.Test;

import ase_cw.Model.Category;
import ase_cw.Model.CollectionFoodOrders;
import ase_cw.Model.FoodOrder;
import ase_cw.Model.InvalidQuantityException;
import ase_cw.Model.Manager;;
import ase_cw.Model.Menu;
import ase_cw.Model.MenuItem;
import ase_cw.Model.WrongCategoryException;
import java.util.Set;
import java.util.TreeSet;
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
 * @author giannis
 */
public class CollectionFoodOrdersTest {
    private Menu menu;
    private MenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5;
    private FoodOrder o1, o2, o3, o4, o5;
    private String sampleBill;
    
    String formater = "%-" 
        + Manager.ALINEA_DISHNAME + "s %-" 
        + Manager.DISHNAME_TEXT + "s %-" 
        + Manager.QUANTITY + "s %-1s %-" 
        + Manager.PRICE + "s %-1s %-" 
        + Manager.MAX_TOTAL + "s %-" 
        + Manager.CURRENCY_SIZE + "s";
    
    public CollectionFoodOrdersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       menu = new Menu();
       menuItem1 = new MenuItem(Category.STARTER, "Toast", 1.8);
       menuItem2 = new MenuItem(Category.MAIN, "Roast Beef", 8.8);
       menuItem3 = new MenuItem(Category.DESSERT, "Chocolate mousse", 2.50);
       menuItem4 = new MenuItem(Category.DRINKS, "Ricard", 10);
       menuItem5 = new MenuItem(Category.DRINKS, "Coca-Cola", 0.8);
       
        try {
            menu.addValues(Category.DRINKS, new TreeSet<MenuItem>() {{add(menuItem4); add(menuItem5);}});
            menu.addValues(Category.DESSERT, new TreeSet<MenuItem>() {{add(menuItem3);}});
        } catch (WrongCategoryException ex) {
            Logger.getLogger(CollectionFoodOrdersTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        try {
            o1 = new FoodOrder(3, "Beef Enchiladas", 2);
            o2 = new FoodOrder(1, "Beef Enchiladas", 1);
            o3 = new FoodOrder(1, "Chocolate mousse", 4);
            o4 = new FoodOrder(2, "Ricard", 1);
            o5 = new FoodOrder(2, "Coca-Cola", 2);
        } catch (InvalidQuantityException ex) {
            Logger.getLogger(CollectionFoodOrdersTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       sampleBill="Table 2 Summary\n";
       sampleBill += String.format(formater,"","Coca-Cola", "2","*",0.8 ,"=" ,1.6, "GBP") +"\n";
       sampleBill += String.format(formater,"","Ricard", "1","*",10.0 ,"=" ,10.0, "GBP") +"\n\n";
       sampleBill += String.format(formater,"","Total for this table:","","","","",11.6, "GBP") +"\n";
       sampleBill += String.format(formater,"","Discount: " + 0 + "%","","","","","0.0", "GBP") +"\n";
       sampleBill += String.format(formater,"","Discounted total:","","","","",11.6, "GBP") +"\n\n";
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getValue method, of class CollectionFoodOrders.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Integer tableId = 1;
        CollectionFoodOrders instance = new CollectionFoodOrders(menu);
        instance.addValue(o2.getTableId(), o2);
        instance.addValue(o3.getTableId(), o3);
        TreeSet<FoodOrder> expResult = new TreeSet<FoodOrder>(){{add(o2); add(o3);}};
        TreeSet<FoodOrder> result = instance.getValue(tableId);;
        assertEquals("getValue failed", expResult, result);
    }

    /**
     * Test of getKeys method, of class CollectionFoodOrders.
     */
    @Test
    public void testGetKeys() {
        System.out.println("getKeys");
        CollectionFoodOrders instance = new CollectionFoodOrders(menu);
        instance.addValue(o1.getTableId(), o1);
        instance.addValue(o2.getTableId(), o2);
        instance.addValue(o3.getTableId(), o3);
        Set<Integer> expResult = new TreeSet<Integer>(){{add(1); add(3);}};
        Set<Integer> result = instance.getKeys();
        assertEquals(expResult, result);
    }

    /**
     * Test of addValues method, of class CollectionFoodOrders.
     */
    @Test
    public void testAddValues() {
        System.out.println("addValues");
        Integer tableId = 1;
        TreeSet<FoodOrder> oi = new TreeSet<FoodOrder>(){{add(o2); add(o3);}};
        CollectionFoodOrders instance = new CollectionFoodOrders(menu);
        instance.addValues(tableId, oi);
        assertEquals(oi, instance.getValue(tableId));
    }

    /**
     * Test of addValue method, of class CollectionFoodOrders.
     */
    @Test
    public void testAddValueNonExistant() {
        System.out.println("addValue");
        Integer tableId = 3;
        CollectionFoodOrders instance = new CollectionFoodOrders(menu);
        instance.addValue(1, o2);
        instance.addValue(1, o3);
        instance.addValue(tableId, o1);
        assertTrue(instance.getValue(tableId).contains(o1));
    }
    
    @Test
    public void testAddValueExistant() {
        System.out.println("addValue");
        Integer tableId = 1;
        CollectionFoodOrders instance = new CollectionFoodOrders(menu);
        instance.addValue(1, o2);
        instance.addValue(tableId, o3);
        assertTrue(instance.getValue(tableId).contains(o3));
    }

    /**
     * Test of toString method, of class CollectionFoodOrders.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CollectionFoodOrders instance = new CollectionFoodOrders(menu);
        instance.addValue(o4.getTableId(), o4);
        instance.addValue(o5.getTableId(), o5);
        String expResult = "TABLES SUMMARY\n" + sampleBill+ "\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBill method, of class CollectionFoodOrders.
     */
    @Test
    public void testGetBill() {
        System.out.println("getBill");

        int tableId = 2;
        CollectionFoodOrders instance = new CollectionFoodOrders(menu);
        instance.addValue(o4.getTableId(), o4);
        instance.addValue(o5.getTableId(), o5);
        String result = instance.getBill(tableId);
        assertEquals(sampleBill, result);
    }

    /**
     * Test of showTableBill method, of class CollectionFoodOrders.
     */
//    @Test
//    public void testShowTableBill() {
//        System.out.println("showTableBill");
//        CollectionFoodOrders instance = null;
//        instance.showTableBill();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of showDishCounter method, of class CollectionFoodOrders.
     */
    @Test
    public void testShowDishCounter() {
        System.out.println("showDishCounter");
        CollectionFoodOrders instance = new CollectionFoodOrders(menu);
        instance.addValue(o4.getTableId(), o4);
        instance.addValue(o5.getTableId(), o5);
        String expResult = String.format("%-60s %-3s", "Dish name", "Times ordered") + "\n";
        expResult += Manager.underlineString(expResult) + "\n";
        expResult += String.format("%-60s %-3s", "Coca-Cola", 2) + "\n";
        expResult += String.format("%-60s %-3s", "Ricard", 1) + "\n";
        String result = instance.showDishCounter();
        assertEquals(expResult, result);
    }

    /**
     * Test of showUnorderedDishes method, of class CollectionFoodOrders.
     */
    @Test
    public void testShowUnorderedDishes() {
        System.out.println("showUnorderedDishes");
        CollectionFoodOrders instance = new CollectionFoodOrders(menu);
        instance.addValue(o4.getTableId(), o4);
        instance.addValue(o5.getTableId(), o5);
        String expResult = "List of unoredered dishes:\n" + Manager.underlineString("List of unoredered dishes:")+"\n";
        expResult += "Chocolate mousse\n\n";
        String result = instance.showUnorderedDishes();
        assertEquals(expResult, result);
    }

    /**
     * Test of showOrdersProfit method, of class CollectionFoodOrders.
     */
    @Test
    public void testShowOrdersProfit() {
        System.out.println("showOrdersProfit");
        CollectionFoodOrders instance = new CollectionFoodOrders(menu);
        instance.addValue(o4.getTableId(), o4);
        instance.addValue(o5.getTableId(), o5);
        instance.addValue(o3.getTableId(), o3);
        String expResult = "* u *";
        String result = instance.showOrdersProfit();
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
