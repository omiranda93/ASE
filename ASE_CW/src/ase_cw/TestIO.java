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
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author omiranda93
 */
public class TestIO {
    //Global variables
    //Depending on the OS you may need to change the paths
    private static String inputFileMenu = "/Users/omiranda93/NetBeansProjects/ASE/src/ase/menu.txt";
    private static String inputFileOrder = "/Users/omiranda93/NetBeansProjects/ASE/src/ase/orders.txt";
    
    public void readMenu(HashMap menu){
        BufferedReader readbuffer = null;
        String strRead;
        String splitarray[];
        TreeSet <MenuItem> starters = new TreeSet<MenuItem>();
        TreeSet <MenuItem> mains = new TreeSet<MenuItem>();
        TreeSet <MenuItem> desserts = new TreeSet<MenuItem>();
        TreeSet <MenuItem> drinks = new TreeSet<MenuItem>();
        try {
            readbuffer = new BufferedReader(new FileReader(inputFileMenu));
            int i = 0;
            while ((strRead = readbuffer.readLine()) != null) {
                splitarray = strRead.split(", ");
                switch(splitarray[2]){
                    case "Starter": starters.add(new MenuItem(STARTER, splitarray[0], Double.parseDouble(splitarray[1])));
                        break;
                    case "Main": mains.add(new MenuItem(MAIN, splitarray[0], Double.parseDouble(splitarray[1])));
                        break;
                    case "Dessert": desserts.add(new MenuItem(DESSERT, splitarray[0], Double.parseDouble(splitarray[1])));
                        break;
                    case "Drinks": drinks.add(new MenuItem(DRINKS, splitarray[0], Double.parseDouble(splitarray[1])));
                        break;      
                }
            }
            readbuffer.close();
            menu.put("Starter", starters);
            menu.put("Main", mains);
            menu.put("Dessert", desserts);
            menu.put("Drink", drinks);
        }catch (Exception e){
            System.out.println("There was an error loading the menu from file.");
        }
    }
}
