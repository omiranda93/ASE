/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw.Models;

/**
 *
 * @author Varito
 */
public class HiloTable extends Thread {

    private MonitorProdCons monitor;
    private int id;

    public HiloTable(MonitorProdCons initMonitor, int id) {
        this.monitor = initMonitor;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            this.monitor.table(id);
        }
    }
}
