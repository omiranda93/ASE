package ase_cw.Test;

import ase_cw.Model.Category;

import ase_cw.Model.Manager;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test on the Manager class representing the manager of the system
 *
 * Date: 10/02/2016
 * Time: 6:31 PM
 *
 * @author Cécile Riquart
 * @version 1.0
 */
public class ManagerTest {
    private String underlinedString;

    @Before
    public void setUp() {
        underlinedString = "====";
    }

    @After
    public void tearDown() {
        System.out.println(" ############# The end ###########");
    }

    @Test
    public void testUnderlineString() {
        assertEquals("Test on underlineString() failed", underlinedString, Manager.underlineString("MENU"));
    }
}
