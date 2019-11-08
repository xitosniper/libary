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
public class ImageException extends Exception{
    /**
     * Exception of image
     * @param mess 
     */
    public ImageException(String mess){
        super("Image Exception: " + mess);
    }
}
