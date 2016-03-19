package ase_cw.Views;

import ase_cw.Models.Manager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Cécile Riquart
 * Date: 3/19/16
 * Time: 9:31 AM
 * Records any event in the simulation (start, order arrives in the kitchen, orders move to table) and write these
 * information into a text file. LogSingletonObs also plays the role of the subject in the observer pattern
 */
public class LogSingletonObs {

    private static volatile LogSingletonObs instance;
    private String all_events;

    /**
     * Constructor : Initially the event variable is empty (!= null !!!)
     */
    private LogSingletonObs() {
        this.all_events = "";
    }

    /**
     * Gets instance
     * @return the instance of LogSingletonObs
     */
    public static LogSingletonObs getInstance() {
        if (instance == null) {
            synchronized (LogSingletonObs.class) {
                if (instance == null) {
                    instance = new LogSingletonObs();
                }
            }
        }
        return instance;
    }

    /**
     * Gets all the events recorded since the call of thi method
     * @return all the events recorded (since the call of this method)
     */
    public String getEvents() {
        return all_events;
    }

    /**
     *  Gets update from the subject = thread
     */
    public void update(String event) {
        all_events += "\n" + event;
    }


    /**
     * Write all log events into an output file
     * @param logs : all events in one string
     */
    public void writeLogFile (String logs){
        BufferedWriter writer = null;
        try {
            //To execute this from the id comment the following name and change the direction, up in the declaration and in the new filereader
            String path = System.getProperty("user.dir");
            writer = new BufferedWriter(new FileWriter(path+"/"+ Manager.PATH_LOG_FILE));
            writer.write(logs);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(LogSingletonObs.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }
}
