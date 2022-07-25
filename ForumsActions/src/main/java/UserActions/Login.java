/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserActions;

import Beans.LoginBeans;
import Beans.UserBeans;
import CookieUtilities.Cookiex;
import DatabaseUtilities.Connect;
import java.sql.Connection;
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
public class Login extends Action{
    private long UID;
    @Override   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginBeans ub=(LoginBeans) form;
        String hashPassword=Security.Digest.passwordDigest(ub.getPassword());
        Connection connect=Connect.connectToDatabase();
        PreparedStatement ps=connect.prepareStatement("Select * from dbo.UserInfo where name=? and password=?");
        ps.setNString(1, ub.getName());
        ps.setString(2,hashPassword);
        ResultSet rs=ps.executeQuery();
          if(!rs.next()){
         connect.close();
         ActionMessages am=new ActionMessages();
         am.add("loginFailed",new ActionMessage("loginfailed",true));
         addMessages(request, am);
         return mapping.findForward("LoginFailed");
         }
         else{
                 
                 UID=rs.getLong("UID");
                 Cookie c=Cookiex.oneYearCookie("user", UID+"|"+hashPassword);
                   c.setPath("/");
            response.addCookie(c);
       connect.close();
     }
       return mapping.findForward("LoginSuccess");
}
}
