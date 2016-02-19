package ase_cw.Model;

/**
 * Represents a menu composed of food items proposed by the restaurant
 *
 * Date: 19/02/2016
 * Time: 10:28 AM
 *
 * @author Cécile Riquart
 * @version 1.0
 */
public class NoMatchingIDException extends Exception {

    public NoMatchingIDException(String unknownID){
        super("There is no table with ID: "+unknownID+"\n");
    }
}
