/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserActions;


import Beans.UserBeans;
import CookieUtilities.Cookiex;
import DatabaseUtilities.Connect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author PC
 */
public class SignUp extends Action{
    private String hashPass,available;
    private long ID;
    @Override public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserBeans ub=(UserBeans)form;
      hashPass=Security.Digest.passwordDigest(ub.getPassword());
        Connection connect=Connect.connectToDatabase();
        PreparedStatement ps=connect.prepareStatement("Insert into dbo.UserInfo(name,email,born,password) values(?,?,?,?)");
        PreparedStatement psID=connect.prepareStatement("Select UID from dbo.UserInfo where name=?");
     PreparedStatement psName=connect.prepareStatement("Select name from dbo.UserInfo where name=?");
     psName.setNString(1, ub.getName());
     ResultSet rs2=psName.executeQuery();
     
   
     if(rs2.next()){
         connect.close();
         ActionMessages am=new ActionMessages();
         am.add("nameError",new ActionMessage("UsernameAvailable",true));
         addMessages(request, am);
         return mapping.findForward("NameAvailable");
     }else{
        Date d=new Date(ParseUtilities.DateParse.StringToDate(ub.getBorn()).getTime());
        ps.setNString(1, ub.getName());
        ps.setString(2, ub.getEmail());
       ps.setDate(3, d);
       ps.setString(4, hashPass);
       ps.executeUpdate();
           psID.setNString(1, ub.getName());
            ResultSet rs=psID.executeQuery();
            rs.next();
            ID=rs.getLong("UID");
            System.out.println(ID);
            Cookie c=Cookiex.oneYearCookie("user", String.valueOf(ID+"|"+hashPass));
            c.setPath("/");
            response.addCookie(c);
       connect.close();
     }
       return mapping.findForward("SignUpSuccess");
    }
}
