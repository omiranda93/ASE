package ase_cw.Model;


/**
 * Represents the manager of the system
 *
 * Date: 31/01/2016
 * Time: 6:43 PM
 *
 * @author Cécile Riquart
 * @version 1.0
 */
public class Manager {

    /**
     * Tuneable
     * WIDTH_BILL : Width of the bill = the maximum number of characters found per row
     * ALINEA_DISHNAME : "Tabulation" before displaying the dish name of menu items
     * DISHNAME_TEXT : Width of the dish name column when displaying the menu or space avaialable for some text
     * PRICE : Width of the price column when displaying the menu  and the unit price in the orders
     * ALINEA_PRICE : "Tabulation" before displaying the unit price of each ordered item
     * CURRENCY_SIZE : Width of the currency whether it's for displaying the menu or details of orders
     * CURRENCY : ISO 4217 format of the currency used
     * QUANTITY : Width of the quantity when displaying the details of the orders made
     * MAX_TOTAL : Width of the maximum size of totals (final or not)
     * MENU: Title of the menu
     * TABLE_SUMMARY : Title of the order summary
     * DISCOUNT : Discount (why not set a rule for this ???????????????????????????????????????????????????????????????)
     */
    public static final int WIDTH_BILL = 120;
    public static final int ALINEA_DISHNAME = 2;
    public static final int DISHNAME_TEXT = 50;
    public static final int PRICE = 6; // Format : ---,--
    public static final int ALINEA_PRICE = 4;
    public static final int CURRENCY_SIZE = 3;  //ISO 4217
    public static final String CURRENCY = "GBP";    //ISO 4217
    public static final int QUANTITY = 2;
    public static final int MAX_TOTAL = 6;
    public static final String MENU = "MENU";
    public static final String TABLE_SUMMARY = "TABLES SUMMARY";
    //public static int DISCOUNT = 10;

    /**
     * "Underline" with the "=" symbol a string
     * @param s String to "underline"
     * @return The string which is "underlined"
     */
    public static String underlineString(String s) {

        return (new String(new char[s.length()]).replace("\0", "="));
    }
    
    /**
     * Calculate the percentage of the discount according to the bill amount
     * @param bill The bill on which the discount is to be applied
     * @return the discount as a percentage
     */
    public static int calculateDiscount(double bill){
        int discount=0;
        
        if (bill >= 20 && bill < 50){
            discount = 5;
        }else if(bill >= 51 && bill < 70){
            discount = 10;
        }else if(bill >=71){
            discount = 20;
        }
        
        return discount;
    }

    /**
     * Checks whether the dimensions provided for the layout of the bill are correct.
     * May lead to an exception if not
     * @return true if the layout of the bill is correct, false otherwise
     */
//    public boolean checkDimensionsBill() {
//
//        int menu_format = (ALINEA_DISHNAME + DISHNAME_TEXT + PRICE + CURRENCY_SIZE + 3);
//
//        int orders_format = DISHNAME_TEXT + QUANTITY + ALINEA_PRICE + PRICE + MAX_TOTAL + 7;
//
//        /* NB : No need to check the frequency report and the total summary format because they are "sub objects" of
//        menu or table summary layout */
//
//        return ((menu_format <= WIDTH_BILL) || (orders_format <= WIDTH_BILL));
//    }
}
