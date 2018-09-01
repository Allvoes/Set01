

package DB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtils implements Serializable{
    
     public DBUtils() {
    }
    
    //static: sinh ra vung nho co san va chi su dung vung nho do
    public static Connection makeConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Test","sa","123");
            return conn;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
