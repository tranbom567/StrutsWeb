/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserActions;

import CookieUtilities.Cookiex;
import DatabaseUtilities.Connect;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author PC
 */
 @MultipartConfig(
    fileSizeThreshold = 1024*1024*1,
            maxFileSize = 1024*1024*100,
            maxRequestSize = 1024*1024*1000
    )
public class SetAvatar extends HttpServlet{
   private String defaultAVTPath="C:\\UploadAvatars\\Sample_User_Icon.png";
     @Override public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
      String cookie=Cookiex.getCookieValue("user", request, "Guest");
      String[]tokens=cookie.split("\\|");
      long ID=Long.valueOf(tokens[0]);
       try {
           Connection connect=Connect.connectToDatabase();
           PreparedStatement ps=connect.prepareStatement("Insert into dbo.UserAvatar values(?,?)");
       if(request.getParameter("defAvatar")!=null){
       ps.setLong(1, ID);
       ps.setNString(2, "/UploadAvatars/download.png");
       ps.executeUpdate();
       connect.close();
       }else{
           Part p=request.getPart("avatar");
       String filename=p.getSubmittedFileName();
       for(Part part:request.getParts())
          part.write("C:\\Users\\PC\\Desktop\\NTT Forums\\UploadAvatars\\"+filename);
       ps.setLong(1, ID);
       ps.setNString(2, "/UploadAvatars/"+filename);
        ps.executeUpdate();
        connect.close();
       }
       RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/JSP/index.jsp");
       rd.forward(request, response);
       
       }catch (SQLException ex) {
           Logger.getLogger(SetAvatar.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
     
}
