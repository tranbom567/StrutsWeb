/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class ForumsInfoBeans {
    private String content,username,avatar;
    private long forumsid;
    private ArrayList<CommentsStoreBeans>comments;
    public ForumsInfoBeans(String content,String username,long forumsid,String avatar,ArrayList<CommentsStoreBeans>comments){
        this.content=content;
        this.username=username;
        this.forumsid=forumsid;
        this.avatar=avatar;
        this.comments=comments;
    }
    public String getContent(){
        return content;
    }
    public String getUsername(){
        return username;
    }
    public String getAvatar(){
        return avatar;
    }
     public long getForumsid(){
        return forumsid;
    }
     public ArrayList<CommentsStoreBeans> getComments(){
         return comments;
     }
}
