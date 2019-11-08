/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author DELL
 */
public class LocationException extends Exception{
    /**
     * Exception of location
     * @param mess 
     */
    public LocationException(String mess){
        super("Location Exception: " + mess);
    }   
}
