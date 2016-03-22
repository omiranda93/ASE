/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw.Views;

import ase_cw.Controllers.*;
import ase_cw.Models.*;
import ase_cw.Models.WrongDimensionsBillException;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author giannis
 */
public class MainPanel extends javax.swing.JFrame {

    private static MonitorProdCons model;
    private final Controller controller;
    private static ArrayList<FoodOrder> notedOrders;
    private static ArrayList<FoodOrder> readyOrders;
    private static ArrayList<FoodOrder> servedOrders;
        
    public MainPanel(MonitorProdCons model) throws WrongDimensionsBillException {
        this.model = model;
        this.controller = new Controller(this, model);
        initComponents();
        this.setVisible(true);
        
        //Init slider position
        sliderSimSpeed.setValue(0);
        
        //Register object listeners
        sliderSimSpeed.addChangeListener(controller);
        btnStart.addActionListener(controller);
        btnStop.addActionListener(controller);
        btnCloseKitchen.addActionListener(controller);
        btnReqBill.addActionListener(controller);
    }
    
    public JButton getButtonStart(){
        return this.btnStart;
    }
    
    public JButton getButtonStop(){
        return this.btnStop;
    }
    
    public JButton getButtonCloseKitchen(){
        return this.btnCloseKitchen;
    }
    
    public JTextField getTxtReqBill(){
        return this.txtTableBill;
    }
    
    public TextArea getBillArea(){
        return this.billPanel;
    }
    
    public JButton getButtonReqBill(){
        return this.btnReqBill;
    }
    
    public JSlider getSlider(){
        return this.sliderSimSpeed;
    }
    
    public JLabel getSpeedLabel(){
        return this.lbSimSpeed;
    }

    public void setTextAreas(String value) {
        kitchenFrame.setText(value);
        tbl1Frame.setText(value);
        tbl2Frame.setText(value);
        tbl3Frame.setText(value);
        tbl4Frame.setText(value);
        tbl5Frame.setText(value);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kitchenFrame = new java.awt.TextArea();
        jLabel1 = new javax.swing.JLabel();
        tbl2Frame = new java.awt.TextArea();
        tbl4Frame = new java.awt.TextArea();
        tbl1Frame = new java.awt.TextArea();
        tbl5Frame = new java.awt.TextArea();
        tbl3Frame = new java.awt.TextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        sliderSimSpeed = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbSimSpeed = new javax.swing.JLabel();
        billPanel = new java.awt.TextArea();
        lbBill = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnCloseKitchen = new javax.swing.JButton();
        btnReqBill = new javax.swing.JButton();
        txtTableBill = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        waiterFrame = new java.awt.TextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        kitchenFrame.setEditable(false);
        kitchenFrame.setName("kitchenFrame"); // NOI18N

        jLabel1.setText("KICHEN");

        tbl2Frame.setEditable(false);

        tbl4Frame.setEditable(false);

        tbl1Frame.setEditable(false);

        tbl5Frame.setEditable(false);

        tbl3Frame.setEditable(false);

        jLabel2.setText("TABLE 1");

        jLabel3.setText("TABLE 2");

        jLabel4.setText("TABLE 3");

        jLabel5.setText("TABLE 4");

        jLabel6.setText("TABLE 5");

        btnStart.setText("START");

        btnStop.setText("STOP");

        sliderSimSpeed.setMaximum(2);
        sliderSimSpeed.setMinimum(-2);
        sliderSimSpeed.setMinorTickSpacing(1);
        sliderSimSpeed.setPaintLabels(true);
        sliderSimSpeed.setPaintTicks(true);
        sliderSimSpeed.setSnapToTicks(true);
        sliderSimSpeed.setToolTipText("");
        sliderSimSpeed.setValue(0);

        jLabel7.setText("Select simulation speed");

        jLabel8.setText("Simulation speed:");

        lbSimSpeed.setText("x1.0");

        billPanel.setEditable(false);

        lbBill.setText("BILL");

        jLabel9.setText("<html>Enter tableID for specific table <br>0 - for complete report</html>");

        btnCloseKitchen.setText("Close Kitchen");

        btnReqBill.setText("Request Bill");
        btnReqBill.setEnabled(false);

        txtTableBill.setBackground(new java.awt.Color(255, 255, 255));
        txtTableBill.setEnabled(false);

        jLabel10.setText("WAITER'S DISH");

        waiterFrame.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(kitchenFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addComponent(billPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbBill)
                    .addComponent(jLabel10)
                    .addComponent(waiterFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbl3Frame, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbl4Frame, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbl5Frame, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tbl1Frame, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnStart)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnStop))
                                    .addComponent(jLabel7)
                                    .addComponent(sliderSimSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbSimSpeed)))))
                        .addGap(142, 142, 142))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbl2Frame, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCloseKitchen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnReqBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(7, 7, 7)
                                .addComponent(txtTableBill, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbl1Frame, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnStart)
                                    .addComponent(btnStop))
                                .addGap(23, 23, 23)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sliderSimSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lbSimSpeed))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tbl2Frame, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCloseKitchen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnReqBill)
                                    .addComponent(txtTableBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbl3Frame, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbl4Frame, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kitchenFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(waiterFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbl5Frame, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(billPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents



    public void updateNoted(ArrayList<FoodOrder> kitchen) {
        notedOrders = kitchen;
        printKitchen();
    }
    public void updateReady(ArrayList<FoodOrder> kitchen) {
        readyOrders = kitchen;
        printWaiter();
    }
    public void updateServed(ArrayList<FoodOrder> kitchen) {
        servedOrders = kitchen;
        printTables();
    }
    
    public void updateOutOfOrders() {
        printKitchenCloseOrder();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainPanel(model).setVisible(true);
                } catch (WrongDimensionsBillException ex) {
                    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea billPanel;
    private javax.swing.JButton btnCloseKitchen;
    private javax.swing.JButton btnReqBill;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private java.awt.TextArea kitchenFrame;
    private javax.swing.JLabel lbBill;
    private javax.swing.JLabel lbSimSpeed;
    private javax.swing.JSlider sliderSimSpeed;
    private java.awt.TextArea tbl1Frame;
    private java.awt.TextArea tbl2Frame;
    private java.awt.TextArea tbl3Frame;
    private java.awt.TextArea tbl4Frame;
    private java.awt.TextArea tbl5Frame;
    private javax.swing.JTextField txtTableBill;
    private java.awt.TextArea waiterFrame;
    // End of variables declaration//GEN-END:variables

    public static String printArray(ArrayList<FoodOrder> e) {
        String s = "";
        //s += e.size() + "#################################\n";
        for (FoodOrder f : e) {
            s += "TABLE ID: "+f.getTableId() + " | ITEM: " + f.getDishName() + " | QUANTITY: "+ f.getQuantity() + "\n";
        }
        return s;
    }
    
    public void printKitchen(){
        kitchenFrame.setText(printArray(notedOrders));
    }
    public void printWaiter(){
        waiterFrame.setText(printArray(readyOrders));
    }
    public void printKitchenCloseOrder(){
        kitchenFrame.setText("There are no more orders, closing...");
    }
    public void printWaiterClosed(){
        waiterFrame.setText("There are no more orders, closing...");
    }
    public void printTables(){
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        for (FoodOrder f : servedOrders) {
            switch(f.getTableId()){
                case 1: s1 += "TABLE ID: "+f.getTableId() + " | ITEM: " + f.getDishName() + " * "+ f.getQuantity() +"\n";
                    break;
                    
                case 2: s2 += "TABLE ID: "+f.getTableId() + " | ITEM: " + f.getDishName() + " * "+ f.getQuantity() +"\n";
                    break;
                    
                case 3: s3 += "TABLE ID: "+f.getTableId() + " | ITEM: " + f.getDishName() + " * "+ f.getQuantity() +"\n";
                    break;
                    
                case 4: s4 += "TABLE ID: "+f.getTableId() + " | ITEM: " + f.getDishName() + " * "+ f.getQuantity() +"\n";
                    break;
                    
                case 5: s5 += "TABLE ID: "+f.getTableId() + " | ITEM: " + f.getDishName() + " * "+ f.getQuantity() +"\n";
                    break;
            }
            
        }
        tbl1Frame.setText(s1);
        tbl2Frame.setText(s2);
        tbl3Frame.setText(s3);
        tbl4Frame.setText(s4);
        tbl5Frame.setText(s5);
    }
    public void printTablesClosed(){
        tbl1Frame.setText("The clients left, cleaning up table...");
        tbl2Frame.setText("The clients left, cleaning up table...");
        tbl3Frame.setText("The clients left, cleaning up table...");
        tbl4Frame.setText("The clients left, cleaning up table...");
        tbl5Frame.setText("The clients left, cleaning up table...");
    }
    
}
