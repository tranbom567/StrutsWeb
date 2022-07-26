/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author PC
 */
public class CommentsStoreBeans {
    private String comments,avatar,name;
 
    public CommentsStoreBeans(String comments,String name,String avatar){
        this.comments=comments;
        this.name=name;
        this.avatar=avatar;
    }
    public String getComments(){
        return comments;
    }
    public String getAvatar(){
        return avatar;
    }
    public String getName(){
        return name;
    }
}
