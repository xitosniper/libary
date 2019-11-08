/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author haumqce130436@fpt.edu.vn
 */
public class PlaceException extends Exception{
    /**
     * Constructor PlaceException
     * @param massage 
     */
    public PlaceException(String massage) {
        super("Place Exception: " + massage);
    }
    
}
