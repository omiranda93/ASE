/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw.Model;

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
public class ManagerTest {
    
    private MenuItem menuItem4, menuItem5;
    private String stringMenu;
    private String sampleBill;
    private String stringNumberOrders;
    private String stringUnordered;
    private String stringProfit;
    
    String formater = "%-" 
        + Manager.ALINEA_DISHNAME + "s %-" 
        + Manager.DISHNAME_TEXT + "s %-" 
        + Manager.QUANTITY + "s %-1s %-" 
        + Manager.PRICE + "s %-1s %-" 
        + Manager.MAX_TOTAL + "s %-" 
        + Manager.CURRENCY_SIZE + "s";
    
    public ManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        menuItem4 = new MenuItem(Category.DRINKS, "Ricard", 10);
        menuItem5 = new MenuItem(Category.DRINKS, "Coca-Cola", 0.8);
        
        stringMenu = "\n" + Manager.MENU + "\n" + Manager.underlineString(Manager.MENU) + "\n\n" + "STARTER\n\nMAIN\n" +
                "\nDESSERT\n\nDRINKS\n" + menuItem5.toString() + menuItem4.toString();
       sampleBill="Table 2 Summary\n";
       sampleBill += String.format(formater,"","Coca-Cola", "2","*",0.8 ,"=" ,1.6, "GBP") +"\n";
       sampleBill += String.format(formater,"","Ricard", "1","*",10.0 ,"=" ,10.0, "GBP") +"\n\n";
       sampleBill += String.format(formater,"","Total for this table:","","","","",11.6, "GBP") +"\n";
       sampleBill += String.format(formater,"","Discount: " + 0 + "%","","","","","0.0", "GBP") +"\n";
       sampleBill += String.format(formater,"","Discounted total:","","","","",11.6, "GBP") +"\n\n";
    }
    
    @After
    public void tearDown() {
        System.out.println(" ############# The end ###########");
    }

    /**
     * Test of underlineString method, of class Manager.
     */
    @Test
    public void testUnderlineString() {
        System.out.println("underlineString");
        String s = "";
        String expResult = "";
        String result = Manager.underlineString(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateDiscount method, of class Manager.
     */
    @Test
    public void testCalculateDiscount() {
        System.out.println("calculateDiscount");
        double bill = 0.0;
        int expResult = 0;
        int result = Manager.calculateDiscount(bill);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInteger method, of class Manager.
     */
    @Test
    public void testIsInteger() {
        System.out.println("isInteger");
        String s = "";
        boolean expResult = false;
        boolean result = Manager.isInteger(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkDimensionsBill method, of class Manager.
     */
    @Test
    public void testCheckDimensionsBill() throws WrongDimensionsBillException {
        System.out.println("checkDimensionsBill");
        Manager instance = new Manager();
        boolean expResult = false;
        boolean result = instance.checkDimensionsBill();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printAll method, of class Manager.
     */
    @Test
    public void testPrintAll() {
        System.out.println("printAll");
        Manager.printAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMenu method, of class Manager.
     */
    @Test
    public void testPrintMenu() {
        System.out.println("printMenu");
        Manager.printMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printBills method, of class Manager.
     */
    @Test
    public void testPrintBills() {
        System.out.println("printBills");
        Manager.printBills();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printDishCounter method, of class Manager.
     */
    @Test
    public void testPrintDishCounter() {
        System.out.println("printDishCounter");
        Manager.printDishCounter();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printUnorderedDishes method, of class Manager.
     */
    @Test
    public void testPrintUnorderedDishes() {
        System.out.println("printUnorderedDishes");
        Manager.printUnorderedDishes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printProfitDishes method, of class Manager.
     */
    @Test
    public void testPrintProfitDishes() {
        System.out.println("printProfitDishes");
        Manager.printProfitDishes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guiTable method, of class Manager.
     */
    @Test
    public void testGuiTable() {
        System.out.println("guiTable");
        Manager.guiTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
