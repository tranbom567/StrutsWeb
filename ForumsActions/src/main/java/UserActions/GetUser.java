/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserActions;

import Beans.AvatarBeans;
import Beans.ForumsStore;
import Beans.UserBeans;
import CookieUtilities.Cookiex;
import DatabaseUtilities.Connect;
import ForumsUtils.Forums;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.ir.RuntimeNode;

/**
 *
 * @author PC
 */
public class GetUser extends HttpServlet{
    private String value,ID,password;
    private String name,img;
      @Override public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
       value=Cookiex.getCookieValue("user", request, null);
       UserBeans ub=new UserBeans();
         AvatarBeans ab=new AvatarBeans();
                
       if(value!=null&&!value.isEmpty()){
      String[]tokens=value.split("\\|");
      ID=tokens[0];
      password=tokens[1];
           try {
               Connection connect=Connect.connectToDatabase();
               PreparedStatement ps=connect.prepareStatement("Select * from dbo.UserInfo where UID=? AND password=?");
               ps.setLong(1, Long.valueOf(ID));
               ps.setString(2, password);
               ResultSet rs=ps.executeQuery();
       if(rs.next())
               name=rs.getNString("name");
               img=getAvatar(Long.valueOf(ID), connect);
               ub.setName(name);
               ab.setImagePath(img);
         
          
           } catch (SQLException ex) {
               Logger.getLogger(GetUser.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        request.setAttribute("UserCookie", ub);
       request.setAttribute("Avatar", ab);
      RequestDispatcher rd=request.getRequestDispatcher("/Home.jsp");
  rd.forward(request, response);
   }
      
     @Override public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
       value=Cookiex.getCookieValue("user", request, null);
       UserBeans ub=new UserBeans();
         AvatarBeans ab=new AvatarBeans();
         ForumsStore fs=new ForumsStore();
       if(value!=null&&!value.isEmpty()){
      String[]tokens=value.split("\\|");
      ID=tokens[0];
      password=tokens[1];
           try {
               Connection connect=Connect.connectToDatabase();
               PreparedStatement ps=connect.prepareStatement("Select * from dbo.UserInfo where UID=? AND password=?");
               ps.setLong(1, Long.valueOf(ID));
               ps.setString(2, password);
               ResultSet rs=ps.executeQuery();
       if(rs.next())
               name=rs.getNString("name");
               img=getAvatar(Long.valueOf(ID), connect);
               ub.setName(name);
               ab.setImagePath(img);
  
         fs.setForums(Forums.getForums(connect));
          connect.close();
           } catch (SQLException ex) {
               Logger.getLogger(GetUser.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
      
        request.setAttribute("UserCookie", ub);
       request.setAttribute("Avatar", ab);
            request.setAttribute("AllForums", fs);
      RequestDispatcher rd=request.getRequestDispatcher("/Home.jsp");
  rd.forward(request, response);
   }
     private String getAvatar(long ID,Connection connect) throws SQLException{
         PreparedStatement ps=connect.prepareStatement("Select image from dbo.UserAvatar Where UID=?");
         ps.setLong(1, ID);
        ResultSet rs=ps.executeQuery();
       String imagePath="/UploadAvatars/download.png";
       if(rs.next()){
         imagePath=rs.getNString("image");
       }
         
         return imagePath;
     }
}
