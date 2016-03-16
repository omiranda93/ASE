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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
        
        //Change the simulation speed (TODO)
        System.out.println("SUCCESS!!!!");
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
     
}
