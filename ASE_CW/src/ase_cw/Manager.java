package ase_cw;


/**
 * Created with IntelliJ IDEA.
 * User: cecile
 * Date: 1/31/16
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Manager {

    /**
     * Tuneable
     * WIDTH_BILL : Width of the bill = the maximum number of characters found per row
     * ALINEA_DISHNAME : "Tabulation" before displaying the dish name of menu items
     * MENU_DISHNAME : Width of the dish name column when displaying the menu
     * PRICE : Width of the price column when displaying the menu  and the unit price in the orders
     * CURRENCY_SIZE : Width of the currency whether it's for displaying the menu or details of orders
     * QUANTITY : Width of the quantity when displaying the details of the orders made
     * MENU: Title of the menu
     */
    public static final String WIDTH_BILL = "120";
    public static final String ALINEA_DISHNAME = "2";
    public static final String MENU_DISHNAME = "50";
    public static final String PRICE = "6"; // Format : ---,--
    public static final String CURRENCY_SIZE = "3";  //ISO 4217
    public static final String CURRENCY = "GBP";    //ISO 4217
    public static final String QUANTITY = "2";
    public static final String MENU = "MENU";

    /**
     *
     * @param s String to "underline"
     * @return The string which is "underlined"
     */
    public static String underlineString(String s) {

        return (new String(new char[s.length()]).replace("\0", "="));

    }
}
