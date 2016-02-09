/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw;

import static ase_cw.Category.DESSERT;
import static ase_cw.Category.DRINKS;
import static ase_cw.Category.MAIN;
import static ase_cw.Category.STARTER;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author omiranda93
 */
public class TestIO {
    //Global variables
    //Depending on the OS you may need to change the paths
    private static String inputFileMenu = "menu.txt"; //"/Users/omiranda93/NetBeansProjects/ASE_CW/ASE_CW/src/ase_cw/menu.txt";
    private static String inputFileOrder = "orders.txt"; //"/Users/omiranda93/NetBeansProjects/ASE_CW/ASE_CW/src/ase_cw/orders.txt ";
    
    public void readMenu(Menu menu){
        BufferedReader readBuffer;
        String strRead;
        String splitArray[];
        TreeSet <MenuItem> starters = new TreeSet<>();
        TreeSet <MenuItem> mains = new TreeSet<>();
        TreeSet <MenuItem> desserts = new TreeSet<>();
        TreeSet <MenuItem> drinks = new TreeSet<>();
        try {
            readBuffer = new BufferedReader(new FileReader(inputFileMenu));

            while ((strRead = readBuffer.readLine()) != null) {
                splitArray = strRead.split(", ");
                switch(splitArray[2]){
                    case "Starter": starters.add(new MenuItem(STARTER, splitArray[0], Double.parseDouble(splitArray[1])));
                        break;
                    case "Main": mains.add(new MenuItem(MAIN, splitArray[0], Double.parseDouble(splitArray[1])));
                        break;
                    case "Dessert": desserts.add(new MenuItem(DESSERT, splitArray[0], Double.parseDouble(splitArray[1])));
                        break;
                    case "Drinks": drinks.add(new MenuItem(DRINKS, splitArray[0], Double.parseDouble(splitArray[1])));
                        break;      
                }
            }
            readBuffer.close();
            menu.addValues(STARTER, starters);
            menu.addValues(MAIN, mains);
            menu.addValues(DESSERT, desserts);
            menu.addValues(DRINKS, drinks);
            
        }catch (Exception e){
            System.out.println("There was an error loading the menu from file.");
        }
    }
    
    
    
    public void readOrders(CollectionFoodOrders orders){
        BufferedReader readbuffer = null;
        String strRead;
        String splitarray[];
        TreeSet <FoodOrder> table1 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table2 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table3 = new TreeSet<FoodOrder>();
        try {
            readbuffer = new BufferedReader(new FileReader(inputFileOrder));
            int i = 0;
            while ((strRead = readbuffer.readLine()) != null) {
                splitarray = strRead.split(", ");
                switch(splitarray[0]){
                    case "1": table1.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;
                    case "2": table2.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;
                    case "3": table3.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;      
                }
            }
            readbuffer.close();
            orders.addValues(1, table1);
            orders.addValues(2, table2);
            orders.addValues(3, table3);
        }catch (Exception e){
            System.out.println("There was an error loading the orders from file.");
        }
    }
}
