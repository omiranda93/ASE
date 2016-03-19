/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw.Controllers;

import ase_cw.Models.*;
import ase_cw.Views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static ase_cw.ASE_CW.TIME_STEP;
/**
 *
 * @author giannis
 */
public class Controller implements ChangeListener, ActionListener{
    
    //Variable which represent the number of threads doing each function
    private static final int nKitchens = 1;
    private static final int nWaitersNote = 2;
    private static final int nWaiters = 2;
    private static final int nTables = 10;
    
    private MainPanel view;
    private MonitorProdCons model;
    
    public Controller(MainPanel view, MonitorProdCons model) throws WrongDimensionsBillException{
        this.view = view;
        this.model = model;

    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        int speed = view.getSlider().getValue()/5;
        //Change the simulation speed (TODO)
        TIME_STEP = TIME_STEP * speed;
        System.out.println("Simulation speed set to: x" + speed);
        view.getSpeedLabel().setText("x" + speed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == view.getButtonStart()){
            
        //Initialise the threads
            for (int i = 0; i < nWaiters; i++) {
                new HiloWaiter(model, i).start();
            }
            for (int i = 0; i < nKitchens; i++) {
                new HiloConsumidor(model, i).start();
            }
            for (int i = 0; i < nWaitersNote; i++) {
                new HiloProductor(model, i).start();
            }
            for (int i = 0; i < nTables; i++) {
                new HiloTable(model, i).start();
            }
        }
    }

    /**
     * Gets update from the subject = serving waiters thread
     * @param dish: food item to transfer from the kitchen box to its table box
     */
    public static void update(FoodOrder dish, ArrayList<FoodOrder> kitchen, ArrayList<FoodOrder> served) {
        //Remove the item from the kitchen
        //System.out.println("truc "+dish.getTableId() + " & "+dish.getDishName());
        kitchen.remove(kitchen.indexOf(dish));
        //System.out.println("kitchen = " + kitchen.size());

        //Add the item to the served dishes list
        served.add(dish);   //Added at the end
        //System.out.println("machin-chouette = " + served.size());
        //Methods for displaying contents into boxes <HERE!>
    }
     
}
