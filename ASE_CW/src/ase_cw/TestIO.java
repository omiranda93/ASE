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
import java.util.TreeSet;

/**
 *
 * @author omiranda93
 */
public class TestIO {
    //Global variables
    //Depending on the OS you may need to change the paths
    private static String inputFileMenu = "menu.txt"; //"/Users/omiranda93/NetBeansProjects/ASE_CW/ASE_CW/src/ase_cw/menu.txt";
    private static String inputFileOrder = "ASE_CW/src/ase_cw/orders.txt"; //"/Users/omiranda93/NetBeansProjects/ASE_CW/ASE_CW/src/ase_cw/orders.txt ";
    
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
}
