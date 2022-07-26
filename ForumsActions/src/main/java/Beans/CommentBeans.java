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
public class CommentBeans extends ValidatorForm{
    private String forumsid;
    private String comment;
    public void setForumsid(String forumsid){
        this.forumsid=forumsid;
    }
    public void setComment(String comment){
        this.comment=comment;
    }
    public String getForumsid(){
        return forumsid;
    }
    public String getComment(){
        return comment;
    }
}
