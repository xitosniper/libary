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
public class RoleException extends Exception{
    /**
     * Exception of role
     * @param mess 
     */
    public RoleException(String mess) {
        super("Role Exception: " + mess);
    }
}
