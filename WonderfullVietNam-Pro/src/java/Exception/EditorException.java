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
public class EditorException extends Exception{
    /**
     * Exception of editor
     * @param mess 
     */
    public EditorException(String mess){
        super("Editor Exception: " + mess);
    }
}
