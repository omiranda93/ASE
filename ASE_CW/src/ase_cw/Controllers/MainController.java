/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw.Controllers;

import ase_cw.Model.*;
import ase_cw.Views.*;
/**
 *
 * @author giannis
 */
public class MainController {
    private MainPanel view;
    
    public MainController(MainPanel view){
        this.view = view;
    }
    
    public void startAppliction(){
        MainPanel view = new MainPanel();
        view.setVisible(true);
    }
     
}
