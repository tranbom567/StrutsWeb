/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author PC
 */
public class Digest {
    
    public static String passwordDigest(String password) throws NoSuchAlgorithmException{
        MessageDigest md=MessageDigest.getInstance("SHA-224");
        md.update(password.getBytes(StandardCharsets.UTF_8));
       byte[]data=md.digest(password.getBytes(StandardCharsets.UTF_8));
       StringBuilder sb=new StringBuilder();
       for(byte d:data){
           sb.append(Integer.toHexString(d));
       }
       return sb.toString();
    }
}
