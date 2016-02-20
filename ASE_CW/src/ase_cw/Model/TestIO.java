/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw.Model;

import static ase_cw.Model.Category.DESSERT;
import static ase_cw.Model.Category.DRINKS;
import static ase_cw.Model.Category.MAIN;
import static ase_cw.Model.Category.STARTER;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omiranda93
 */
public class TestIO {
    //Global variables
    //Depending on the OS the paths might need to change
    private static final String inputFileMenu = "ASE_CW/src/ase_cw/menu.txt";
    private static final String inputFileOrder = "ASE_CW/src/ase_cw/orders.txt";
    private static final String outputFile = "ASE_CW/src/ase_cw/output.txt";
    
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
                splitArray = strRead.split("/ ");
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
            System.out.println(menu.getValues().size()+" #############");
            
        }catch (IOException e1){
            System.out.println("There was an error loading the menu from file.");
            System.exit(1);
        } catch (WrongCategoryException e2) {
            System.out.println(e2.getMessage());
        } catch (NumberFormatException e3){
            System.out.println("One or more prices in the text file are not a price or are wrongly introduced.");
        }
    }
    
    
    
    public void readOrders(CollectionFoodOrders orders) throws NoMatchingIDException{
        BufferedReader readbuffer = null;
        String strRead;
        String splitarray[];
        TreeSet <FoodOrder> table1 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table2 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table3 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table4 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table5 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table6 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table7 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table8 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table9 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table10 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table11 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table12 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table13 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table14 = new TreeSet<FoodOrder>();
        TreeSet <FoodOrder> table15 = new TreeSet<FoodOrder>();

        try {
            readbuffer = new BufferedReader(new FileReader(inputFileOrder));
            int i = 0;
            while ((strRead = readbuffer.readLine()) != null) {
                splitarray = strRead.split("/ ");
                switch(splitarray[0]){
                    case "1": table1.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;
                    case "2": table2.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;
                    case "3": table3.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;      
                    case "4": table4.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;      
                    case "5": table5.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;      
                    case "6": table6.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;      
                    case "7": table7.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;      
                    case "8": table8.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;      
                    case "9": table9.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;      
                    case "10": table10.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;      
                    case "11": table11.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;      
                    case "12": table12.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;      
                    case "13": table13.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;      
                    case "14": table14.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;      
                    case "15": table15.add(new FoodOrder(Integer.parseInt(splitarray[0]), splitarray[1], Integer.parseInt(splitarray[2])));
                        break;   
                    default: throw new NoMatchingIDException(splitarray[0]);
                }
            }
            readbuffer.close();
            orders.addValues(1, table1);
            orders.addValues(2, table2);
            orders.addValues(3, table3);
            orders.addValues(4, table4);
            orders.addValues(5, table5);
            orders.addValues(6, table6);
            orders.addValues(7, table7);
            orders.addValues(8, table8);
            orders.addValues(9, table9);
            orders.addValues(10, table10);
            orders.addValues(11, table11);
            orders.addValues(12, table12);
            orders.addValues(13, table13);
            orders.addValues(14, table14);
            orders.addValues(15, table15);
        }catch (InvalidQuantityException e1){
            System.out.println(e1.getMessage());
        }catch (IOException e2){
            System.out.println("There was an error loading the orders from file.");
            System.exit(1);
        } catch (NumberFormatException e3){
            System.out.println("One of the quantities introduced is not a number. The file could not be loaded.");
        }
    }
    
    public void writeToFile (String menu, String orders, String numberDish, String unorderedDishes, String profits){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(menu);
            writer.write("-----------------------------------------------------------------------------------\n");
            writer.write(orders);
            writer.write("-----------------------------------------------------------------------------------\n");
            writer.write(numberDish);
            writer.write("-----------------------------------------------------------------------------------\n");
            writer.write(unorderedDishes);
            writer.write("-----------------------------------------------------------------------------------\n");            
            writer.write(profits);
            writer.write("-----------------------------------------------------------------------------------\n");            
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(TestIO.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }
}
