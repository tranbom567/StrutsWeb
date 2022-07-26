/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author PC
 */
public class UserBeans extends ValidatorForm{
    private String name,email,born,password;
    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setBorn(String born){
        this.born=born;
    }
    public void setPassword(String password){
       
      this.password=password;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getBorn(){
        return born;
    }
    public String getPassword(){
        return password;
    }
}
