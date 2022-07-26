/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ForumsUtils;

import Beans.CommentsStoreBeans;
import Beans.ForumsInfoBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Forums {
    public static ArrayList getForums(Connection connect) throws SQLException{
        ArrayList<ForumsInfoBeans>al=new ArrayList<>();
        PreparedStatement ps=connect.prepareStatement("Select * from dbo.Forums");
        ResultSet rs=ps.executeQuery();
        String name="Guest";
        String img;
        String fix;
        while(rs.next()){
            ArrayList<CommentsStoreBeans>csb=getComments(connect, rs.getLong("ForumsID"));
            PreparedStatement loopName=connect.prepareStatement("Select name from dbo.UserInfo where UID=?");
                PreparedStatement Avatar=connect.prepareStatement("Select image from dbo.UserAvatar where UID=?");
            loopName.setLong(1, rs.getLong("UID"));
            ResultSet rs2=loopName.executeQuery();
            if(!rs2.next())
                name="Guest";
            else
            name=rs2.getNString("name");
            Avatar.setLong(1, rs.getLong("UID"));
                ResultSet rs3=Avatar.executeQuery();
                if(!rs3.next())
                    img="/UploadAvatars/download.png";
                else
            img=rs3.getNString("image");
            fix=rs.getNString("content").replace("\\n", "<p>");
            al.add(new ForumsInfoBeans(fix, name, rs.getLong("ForumsID"),img,csb));
        }
        return al;
    }
    private static ArrayList<CommentsStoreBeans>getComments(Connection connect,long ForumsID) throws SQLException{
        ArrayList<CommentsStoreBeans>al=new ArrayList<>();
        PreparedStatement ps=connect.prepareStatement("Select * from dbo.comments where ForumsID=?");
        ps.setLong(1, ForumsID);
        ResultSet rs=ps.executeQuery();
          String name="Guest";
        String img;
        while(rs.next()){
            PreparedStatement loopName=connect.prepareStatement("Select name from dbo.UserInfo where UID=?");
                PreparedStatement Avatar=connect.prepareStatement("Select image from dbo.UserAvatar where UID=?");
                  loopName.setLong(1, rs.getLong("UID"));
            ResultSet rs2=loopName.executeQuery();
            if(!rs2.next())
                name="Guest";
            else
            name=rs2.getNString("name");
            Avatar.setLong(1, rs.getLong("UID"));
                ResultSet rs3=Avatar.executeQuery();
                if(!rs3.next())
                    img="/UploadAvatars/download.png";
                else
            img=rs3.getNString("image");
                CommentsStoreBeans csb=new CommentsStoreBeans(rs.getNString("comment").replace("\\n", "<p>"), name, img);
                al.add(csb);
        }
        return al;
    }
}
