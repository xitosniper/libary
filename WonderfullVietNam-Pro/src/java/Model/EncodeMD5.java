/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author DELL
 */
public class EncodeMD5 {
    /**
     * Encode data user inputed by MD5
     * @param userInput
     * @return 
     */
    public static String getMD5(String userInput) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashData = md.digest(userInput.getBytes());
            //convert byte array into signum representation
            BigInteger number = new BigInteger(1, hashData);
            
            //convert hashData into hex value
            String hashText = number.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(EncodeMD5.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
}
