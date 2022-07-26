/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserActions;

import Beans.CommentBeans;
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
public class Comment extends Action{
    private long UID;
    @Override public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        CommentBeans cb=(CommentBeans)form;
        String[]tokens=Cookiex.getCookieValue("user", request, "000|000").split("\\|");
        UID=Long.valueOf(tokens[0]);
        Connection connect=Connect.connectToDatabase();
        PreparedStatement ps=connect.prepareStatement("Insert into dbo.comments values(?,?,?)");
        ps.setLong(1, Long.valueOf(cb.getForumsid()));
        ps.setLong(2, UID);
        ps.setNString(3, cb.getComment().replace("\n", "\\n"));
        ps.executeUpdate();
        connect.close();
        return mapping.findForward("AddCommentSuccess");
    }
}
