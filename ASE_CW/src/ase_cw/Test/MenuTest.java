package ase_cw.Test;

import ase_cw.Model.Category;
import ase_cw.Model.Menu;
import ase_cw.Model.MenuItem;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests methods from the class representing a menu composed of food items proposed by the restaurant
 *
 * Date: 10/02/2016
 * Time: 2:38 PM
 *
 * @author Cécile Riquart
 * @version 1.0
 */
public class MenuTest {
    private Menu menu;
    private MenuItem menuItem1, menuItem2, menuItem3, menuItem4;

    @Before
    public void setUp() {
        menuItem1 = new MenuItem(Category.STARTER, "Toast", 1.8);
        menuItem2 = new MenuItem(Category.MAIN, "Roast Beef", 8.8);
        menuItem3 = new MenuItem(Category.DESSERT, "Ice cream", 3.50);
        menuItem4 = new MenuItem(Category.DRINKS, "Ricard", 10);

        menu = new Menu();
    }

    @After
    public void tearDown() {
        System.out.println(" ############# The end ###########");
    }

    @Test
    public void testAddValue() {
        menu.addValue(Category.STARTER, menuItem1);
        assertTrue("Test on addValue() failed", menu.getValue(Category.STARTER).contains(menuItem1));

    }

}
