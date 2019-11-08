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
public class PostException extends Exception{
    /**
     * Exception of post
     * @param mess 
     */
    public PostException(String mess) {
        super("Post Exception: " + mess);
    }
}
