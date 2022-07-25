/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class Connect {
    private static String url="jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=NTTForums;user=sa;password=duy08hoang";
    public static Connection connectToDatabase() throws SQLException{
        Connection connection=DriverManager.getConnection(url);
        return connection;
    }
}
