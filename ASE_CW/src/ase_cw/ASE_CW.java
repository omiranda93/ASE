/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw;

import ase_cw.Models.Manager;
import ase_cw.Models.WrongDimensionsBillException;

/**
 *
 * @author omiranda93
 */
public class ASE_CW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            Manager manager = new Manager();
            manager.printAll();
            manager.guiTable();
            manager.writeInFile();
        } catch (WrongDimensionsBillException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
