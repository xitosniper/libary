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
public class TypeException extends Exception{
    /**
     * Constructor TypeException 
     * @param massage
     */
    public TypeException(String massage) {
        super("Type Exception: "+ massage);
    }   
}
