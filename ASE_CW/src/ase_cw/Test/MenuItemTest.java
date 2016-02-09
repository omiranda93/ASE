package ase_cw.Test;

import ase_cw.Model.Category;
import ase_cw.Model.MenuItem;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Represents a food item figuring on the menu of the restaurant
 *
 * Date: 09/02/2016
 * Time: 8:16 PM
 *
 * @author Cécile Riquart
 * @version 1.0
 */
public class MenuItemTest {

    private MenuItem menuItem;
    private MenuItem otherMenuItem1;
    private MenuItem otherMenuItem2;
    private MenuItem otherMenuItem3;

    @Before
    public void setUp() {
        menuItem = new MenuItem(Category.DESSERT, "Crème Brûlée", 4.50);
        otherMenuItem1 = new MenuItem(Category.MAIN, "Crème Brûlée", 12.7);
        otherMenuItem2 = new MenuItem(Category.MAIN, "Boeuf bourguignon", 1.2);
        otherMenuItem3 = new MenuItem(Category.MAIN, "Quiche lorraine", 4);
    }

    @After
    public void tearDown() {
        System.out.println(" ############# The end ###########");
    }

    @Test
    public void testConstructor() {
        assertTrue("Test on constructor() failed", ((menuItem.getName().equals("Crème Brûlée") &&
                (menuItem.getPrice() == 4.50)) && (menuItem.getCategory().equals(Category.DESSERT))));
    }

    @Test
    public void testGetCategory() {
        assertEquals("Test on getName() failed", Category.DESSERT, menuItem.getCategory());
    }

    @Test
    public void testGetName() {
        assertEquals("Test on getCategory() failed", "Crème Brûlée", menuItem.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals("Test on getPrice() failed", 4.50, menuItem.getPrice(), 0.0);
    }

    @Test
    public void testEqual() {
        int result = menuItem.compareTo(otherMenuItem1);
        assertTrue("Is expected to be equal", result == 0);
    }

    @Test
    public void testGreaterThan() {
        int result = menuItem.compareTo(otherMenuItem2);
        assertTrue("Is expected to be greater than", result >= 1);
    }

    @Test
    public void testLessThan() {
        int result = menuItem.compareTo(otherMenuItem3);
        assertTrue("Is expected to be less than", result <= -1);
    }

    @Test
    public void testToString() {
        //TODO
    }

}
