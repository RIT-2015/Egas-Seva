/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EncryptionMaster;

/**
 *
 * @author Somesh Mishra
 */

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class DESEncryptionMaster {
    private static Cipher ecipher;
    private static Cipher dcipher;
     private static SecretKey myDesKey;
    
    
    public DESEncryptionMaster() throws InvalidKeyException {
     try {
            ecipher = Cipher.getInstance("DES");
            dcipher = Cipher.getInstance("DES");
            ecipher.init(Cipher.ENCRYPT_MODE, getKey());
            dcipher.init(Cipher.DECRYPT_MODE, getKey());

        } catch (javax.crypto.NoSuchPaddingException e) {
        } catch (java.security.NoSuchAlgorithmException e) {
        } 
    }
    
    public static SecretKey getKey () throws NoSuchAlgorithmException{
        if (myDesKey == null){
             
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
             myDesKey = keygenerator.generateKey();
             return myDesKey;
        }

            return myDesKey;
    }
    
    public String encrypt(String str) throws IllegalBlockSizeException {
        try {
            // Encode the string into bytes using utf-8
            byte[] utf8 = str.getBytes("UTF8");

            // Encrypt
            byte[] enc = ecipher.doFinal(utf8);

            // Encode bytes to base64 to get a string
            return new sun.misc.BASE64Encoder().encode(enc);
        } catch (javax.crypto.BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (java.io.IOException e) {
        }
        return null;
    }

    public String decrypt(String str) {
        try {
            // Decode base64 to get bytes
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

            // Decrypt
            byte[] utf8 = dcipher.doFinal(dec);

            // Decode using utf-8
            return new String(utf8, "UTF8");
        } catch (javax.crypto.BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (java.io.IOException e) {
        }
        return null;
    }
    
}
