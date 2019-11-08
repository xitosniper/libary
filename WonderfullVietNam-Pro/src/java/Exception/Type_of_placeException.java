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
public class Type_of_placeException extends Exception{
    /**
     * Constructor Type_of_placeException
     * @param massage 
     */
    public Type_of_placeException(String massage) {
        super("Type_of_place Exception: "+massage);
    }
    
}
