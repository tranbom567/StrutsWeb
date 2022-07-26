/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import org.apache.struts.validator.ValidatorForm;

/**
 *
 * @author PC
 */
public class LoginBeans extends ValidatorForm{
    private String name,password;
    public void setName(String name){
        this.name=name;
    }
  
    public void setPassword(String password){
       
      this.password=password;
    }
    public String getName(){
        return name;
    }
  
    public String getPassword(){
        return password;
    }
}
