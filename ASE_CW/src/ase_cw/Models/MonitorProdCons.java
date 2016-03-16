/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ase_cw.Models;

import static ase_cw.ASE_CW.TIME_STEP;
import com.sun.jmx.remote.util.OrderClassLoaders;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Varito
 */
public class MonitorProdCons {

    private ArrayList<FoodOrder> notedOrders;
    private ArrayList<FoodOrder> readyOrders;
    private ArrayList<FoodOrder> servedOrders;
    CollectionFoodOrders orders;
    
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
    }

    MonitorProdCons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public synchronized void consumidor(int id) {
        FoodOrder dish;
        while (this.notedOrders.size() == 0) {
            System.out.println("Kitchen: Bloqued, no orders available.");
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        dish = notedOrders.get(0);
        System.out.println("Kitchen: Order for table#" + notedOrders.remove(0).getTableId() + " cooked and ready to serve.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {

        }
        this.readyOrders.add(dish);
        this.notifyAll();
    }
    
    public synchronized void waiter(int id) {
        FoodOrder dish;
        while (this.readyOrders.size() == 0) {
            System.out.println("Waiter #" + id + " bloqued, no order to serve.");
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        dish = readyOrders.get(0);
        System.out.println("Waiter #" + id + " dish served to table: " + readyOrders.remove(0).getTableId());
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {

        }
        this.notifyAll();
        Cerrojo.lock();
        try{
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
                entrar(i, cont);
            } catch (InterruptedException ex) {
                Logger.getLogger(MonitorProdCons.class.getName()).log(Level.SEVERE, null, ex);
            }
        }, "Customer nº " + i + " from table " + tableN);
        p.start();
    }

    public static void entrar(int i, int cont) throws InterruptedException {
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
            Thread.sleep(1000);

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
        int number = ((Double) (Math.random() * 10)).intValue() + 1;
        TreeSet<FoodOrder> ordersToSelect = orders.getValue(number);
        FoodOrder order = ordersToSelect.pollFirst();
        return order;
    }
    
    public synchronized void productor(int id) {
        while (this.notedOrders.size() == capacityOfKitchen) {
            System.out.println("Waiter taking notes #" + id + " blocked, the kitchen can get more orders.");
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        FoodOrder newOrder = getRandOrder();
        System.out.println("Waiter taking notes #" + id + " order for table: " + newOrder.getTableId() + " noted.");
        this.notedOrders.add(newOrder);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {

        }
        this.notifyAll();
    }
}
