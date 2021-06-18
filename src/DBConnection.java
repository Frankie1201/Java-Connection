
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection connect()
    {
        Connection con = null;
        try
        {
            String URL = "jdbc:mysql://localhost:3306/Truely_Terrific_Appetite_By_Francesca_Worsnop";//DB location
            String user = "root";//DB user name
            String pwd = "passwordR00T";//DB password
            
            con = (Connection) DriverManager.getConnection(URL , user , pwd);   
        }
        catch (Exception ex)
        {
            System.out.println("DB Error : "+ex);
        }
        return con;
    } 
    
}
