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
public class ForumsBeans extends ValidatorForm{
    private String content;
    public void setContent(String content){
        this.content=content;
    }
    public String getContent(){
        return content;
    }
}
