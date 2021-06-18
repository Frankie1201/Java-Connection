import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

//table queries
public class ManagerQuery {
    
    //1. insert -> int
    public int insert(int MId, String Name, String Shift, double Salary)
    {
        int row_insert = 0;
        try
        {
            Connection con = DBConnection.connect();//get connection
            Statement stmt = con.createStatement();
            
            String qry = "insert into Manager(MId,Name,Shift,Salary) values("+MId+" , '"+Name+"' , '"+Shift+"' , "+Salary+")";
            
            row_insert = stmt.executeUpdate(qry);
            
        }
        catch(Exception ex)
        {
            System.out.println("Insert Error :"+ex);
        }
        
        return row_insert;
    }
    
    //2. update -> int
    public int update(int MId , double up_Salary)
    {
        int row_update = 0;
        try
        {
            Connection con = DBConnection.connect();//get connection
            Statement stmt = con.createStatement();
            
            String qry = "update Manager set Salary="+up_Salary+" where MId="+MId;
            
            row_update = stmt.executeUpdate(qry);
        }
        catch(Exception ex)
        {
            System.out.println("Update Error :"+ex);
        }
        
        return row_update;
    }
    
    //3. delete -> int
    public int delete(int MId)
    {
        int row_delete = 0;
        try
        {
            Connection con = DBConnection.connect();//get connection
            Statement stmt = con.createStatement();
            
            String qry = "delete from Manager where MId="+MId;
            
            row_delete = stmt.executeUpdate(qry);
        }
        catch(Exception ex)
        {
            System.out.println("Delete Error :"+ex);
        }
        
        return row_delete;
    }
    
    //4. select -> void
    public void display()
    {
        try
        {
            Connection con = DBConnection.connect();//get connection
            Statement stmt = con.createStatement();
            
            String qry = "select * from Manager";
            
            ResultSet rs = stmt.executeQuery(qry);//return ResultSet-> holds all rows from table
            
            //read all data
            //next() -> check if next row is present
            while(rs.next())
            {
                //read data by column
//                int i = rs.getInt("sid");
//                String f = rs.getString("firstName");
//                String l = rs.getString("lastName");
//                int s = rs.getInt("score");
//              
                int m = rs.getInt(1);
                String n = rs.getString(2);
                String s = rs.getString(3);
                double y = rs.getDouble(4);
                
                System.out.println("MID :"+m);
                System.out.println("NAME :"+n);
                System.out.println("SHIFT :"+s);
                System.out.println("SALARY :"+y);
                
                System.out.println("========================");
                
            }//while ends
            
        }
        catch(Exception ex)
        {
            System.out.println("Display Error :"+ex);
        }
    }
    
}
