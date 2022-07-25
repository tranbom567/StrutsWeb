/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserActions;

import Beans.ForumsBeans;
import CookieUtilities.Cookiex;
import DatabaseUtilities.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author PC
 */
public class AskQuestion extends Action{
    private long UID;
     @Override public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
         ForumsBeans fb=(ForumsBeans)form;
         String fix=fb.getContent().replace("\n", "\\n");
         String value=Cookiex.getCookieValue("user", request, null);
         String[]tokens=value.split("\\|");
         UID=Long.valueOf(tokens[0]);
         Connection connect=Connect.connectToDatabase();
         PreparedStatement ps=connect.prepareStatement("Insert into dbo.Forums(UID,content) values(?,?)");
         ps.setLong(1, UID);
         ps.setNString(2, fix);
         ps.executeUpdate();
         connect.close();
         return mapping.findForward("AskQuestionSuccess");
    }
}
