/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserActions;

import Beans.AvatarBeans;
import Beans.UserBeans;
import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class DeleteCookie extends HttpServlet{
    @Override public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        UserBeans ub=null;
        AvatarBeans ab=new AvatarBeans();
        ab.setImagePath("/UploadAvatars/download.png");
    
       request.setAttribute("UserCookie",ub);
          request.setAttribute("Avatar",ab);
        Cookie c=new Cookie("user", "000|000");
        c.setMaxAge(0);
        c.setPath("/");
        response.addCookie(c);
        response.sendRedirect("http://piewebsite.tk/");
    }
}
