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
public class UserException extends Exception{
    /**
     * Exception of user
     * @param mess 
     */
    public UserException(String mess) {
        super("User Exception: " + mess);
    }
}
