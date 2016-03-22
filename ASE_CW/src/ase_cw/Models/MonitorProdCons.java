/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw.Models;

import static ase_cw.ASE_CW.sleep_time;
import ase_cw.Views.MainPanel;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MonitorProdCons {

    private ArrayList<FoodOrder> notedOrders;
    private ArrayList<FoodOrder> readyOrders;
    private ArrayList<FoodOrder> servedOrders;
    CollectionFoodOrders orders;
    CollectionFoodOrders ordersProcessed;
    
    //Stop variables
    boolean outOfOrders = false;
    
    //Reference to panel for updates
    MainPanel panel;

    private static int capacityOfKitchen = 6;
    private final ReentrantLock Cerrojo = new ReentrantLock();
    private final Condition Eat = Cerrojo.newCondition();

    //For the table simulation
    private final static int NumCustomers = 3;
    private final static int NumChairs = 2;

    private static Semaphore semaforoEntrar;
    private static Semaphore[] semaforoTenedor;
    



    public MonitorProdCons(CollectionFoodOrders orders) {
        notedOrders = new ArrayList<>();
        readyOrders = new ArrayList<>();
        servedOrders = new ArrayList<>();
        this.orders = orders;
        this.ordersProcessed = new CollectionFoodOrders(orders.getMenu());
    }

    public void setPanel(MainPanel panel) {
        this.panel = panel;
    }

    public CollectionFoodOrders getOrders() {
        return orders;
    }
    
    public CollectionFoodOrders getOrdersProcessed(){
        return ordersProcessed;
    }

    /**
     * Each thread can be assimilated to a subject. Every action they performed is notify to a single observer
     * (c'est-à-dire LogSingletonObs)
     */
    public void notifyObserver() {

    }
    
    public void closeKitchen(){
        outOfOrders = true;
    }

    public synchronized void kitchen(int id) {
        if (outOfOrders && notedOrders.isEmpty()){
            panel.updateOutOfOrders();
            Thread.currentThread().stop();
            return;
        }
        FoodOrder dish;
        while (this.notedOrders.size() == 0) {
            //System.out.println("Kitchen: Bloqued, no orders available.");
            LogSingletonObs.getInstance().update("The kitchen is not working. It is waiting for orders");
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        dish = notedOrders.get(0);
        //MainPanel.printArray2(notedOrders);
        //System.out.println("Kitchen: Order for table#" + notedOrders.remove(0).getTableId() + " cooked and ready to serve.");
        LogSingletonObs.getInstance().update("In the kitchen. Cooks have completed the dish "+ dish.getDishName()+" for " +
                "table n°" +notedOrders.remove(0).getTableId()+ ". Ready to be served");
        panel.updateNoted(notedOrders);
        try {
            Thread.sleep(2*sleep_time);
        } catch (InterruptedException ex) {

        }
        this.readyOrders.add(dish);
        panel.updateReady(readyOrders);
        try {
            Thread.sleep(2*sleep_time);
        } catch (InterruptedException ex) {

        }
        this.notifyAll();
    }

    public synchronized void waiter(int id) {
        //Stop condition
        if (outOfOrders && readyOrders.isEmpty()){
            panel.printTablesClosed();
//            try {
//                ordersProcessed.showTableBill();
//            } catch (NoMatchingIDException ex) {
//                Logger.getLogger(MonitorProdCons.class.getName()).log(Level.SEVERE, null, ex);
//            }
            Thread.currentThread().stop();
            return;
        }
        
        FoodOrder dish;
        while (this.readyOrders.size() == 0) {
            //System.out.println("Waiter #" + id + " bloqued, no order to serve.");
            LogSingletonObs.getInstance().update("Waiter n° " + id + " is ready to serve customers ... but nothing has " +
                    "been ordered yet!");
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        dish = readyOrders.get(0);
        ordersProcessed.addValue(dish.getTableId(), dish);
        //System.out.println("Waiter #" + id + " dish served to table: " + readyOrders.remove(0).getTableId());
        //Notify the observer for updating te log file's content
        LogSingletonObs.getInstance().update("Waiter n° " + id + "has served the dish " + dish.getDishName() + " to the " +
                "table n° " + readyOrders.remove(0).getTableId());
        panel.updateReady(readyOrders);
        try {
            Thread.sleep(sleep_time);
        } catch (InterruptedException ex) {

        }
        this.notifyAll();
        Cerrojo.lock();
        try{
            //Notify the observer for the updating the kitchen & tables boxed
            //MainPanel.printArray(readyOrders);
            //MainPanel.update(dish, notedOrders, servedOrders);
            servedOrders.add(dish);
            Eat.signal();
        }finally{
            Cerrojo.unlock();
        }
    }

    //For the table simulation:

//    private static int tenedorIzq;
//    private static int tenedorDer;
    private static void createThread(int i, int tableN) {
        int cont = 0;
        Thread p = new Thread(() -> {
            try {
                clientEat(i, cont);
            } catch (InterruptedException ex) {
                Logger.getLogger(MonitorProdCons.class.getName()).log(Level.SEVERE, null, ex);
            }
        }, "Customer nº " + i + " from table " + tableN);
        p.start();
    }

    public static void clientEat(int i, int cont) throws InterruptedException {
        semaforoEntrar.acquire();

        int tenedorDer = i;
        int tenedorIzq = (i == 0) ? NumCustomers - 1 : i - 1;

        //System.out.println(Thread.currentThread().getName() + ": Preparing to eat.");

        Thread.sleep((long) Math.random());

        if ((i % NumCustomers) == 0) {
            //System.out.println(Thread.currentThread().getName() + ": get the right fork, nº " + tenedorDer);
            semaforoTenedor[tenedorDer].acquire();
            //System.out.println(Thread.currentThread().getName() + ": get the left fork, nº " + tenedorIzq);
            semaforoTenedor[tenedorIzq].acquire();

            System.out.println(Thread.currentThread().getName() + ": Im hungry, let´s eat");
            Thread.sleep(sleep_time);

            //System.out.println(Thread.currentThread().getName() + ": dropping right fork, nº " + tenedorDer);
            semaforoTenedor[tenedorDer].release();
            //System.out.println(Thread.currentThread().getName() + ": dropping left fork, nº " + tenedorIzq);
            semaforoTenedor[tenedorIzq].release();
        } else {
            //System.out.println(Thread.currentThread().getName() + ": get the left fork, nº " + tenedorIzq);
            semaforoTenedor[tenedorIzq].acquire();
            //System.out.println(Thread.currentThread().getName() + ": get the right fork, nº " + tenedorDer);
            semaforoTenedor[tenedorDer].acquire();

            System.out.println(Thread.currentThread().getName() + ": Im hungry, let´s eat");

            //System.out.println(Thread.currentThread().getName() + ": dropping left fork, nº " + tenedorIzq);
            semaforoTenedor[tenedorIzq].release();
            //System.out.println(Thread.currentThread().getName() + ": dropping right fork, nº " + tenedorDer);
            semaforoTenedor[tenedorDer].release();

        }
        cont++;
        semaforoEntrar.release();
    }

    public static void execute(int tableN) {
        semaforoEntrar = new Semaphore(NumChairs);
        semaforoTenedor = new Semaphore[NumCustomers];

        for (int i = 0; i < NumCustomers; i++) {
            semaforoTenedor[i] = new Semaphore(1);
        }

        for (int i = 0; i < NumCustomers; i++) {
            createThread(i, tableN);
        }
    }


    public synchronized void table(int id) {
        if (outOfOrders && servedOrders.isEmpty()){
            Thread.currentThread().stop();
            return;
        }
        int tableN;
        Cerrojo.lock();
        try{
            try {
                while(servedOrders.size()==0){
                    Eat.await();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MonitorProdCons.class.getName()).log(Level.SEVERE, null, ex);
            }
            tableN = servedOrders.get(0).getTableId();
            execute(tableN);
        }finally{
            Cerrojo.unlock();
        }
    }

    public FoodOrder getRandOrder(){
        FoodOrder order = null;
        int cont = 0;
        while(order == null && cont != 20){
            int number = ((Double) (Math.random() * 5)).intValue() + 1;
            TreeSet<FoodOrder> ordersToSelect = orders.getValue(number);
            order = ordersToSelect.pollFirst();
            cont ++;
        }
        return order;
    }

    public synchronized void noter(int id) {
        while (this.notedOrders.size() == capacityOfKitchen) {
            //System.out.println("Waiter taking notes #" + id + " blocked, the kitchen can get more orders.");
            LogSingletonObs.getInstance().update("Waiter n°" + id + " ready to take notes ... but he/she will have to " +
                    "wait because the kitchen can't get more orders (capacity of the kitchen = "+ capacityOfKitchen + ")");

            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        FoodOrder newOrder = getRandOrder();

        if(newOrder == null){
            System.out.println("There are no more orders");
            outOfOrders = true;
            Thread.currentThread().stop();
            return;
        }
        //System.out.println("Waiter taking notes #" + id + " order for table: " + newOrder.getTableId() + " noted.");
        LogSingletonObs.getInstance().update("Waiter n°"+ id + " taking notes. Order "+ newOrder.getDishName() +
                "for table: " + newOrder.getTableId() + " noted.");
        panel.updateNoted(notedOrders);
        this.notedOrders.add(newOrder);
        try {
            Thread.sleep(sleep_time);
        } catch (InterruptedException ex) {
        }
        this.notifyAll();

    }
}
