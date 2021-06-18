import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class COrderQuery {
    
    //1. insert -> int
    public int insert(int OrderID, String Cname, String CPhone, String CAddress, String ItemID, int QTY, double Total, String Date)
    {
        int row_insert = 0;
        try
        {
            Connection con = DBConnection.connect();//get connection
            Statement stmt = con.createStatement();
            
            String qry = "insert into COrder(OrderID,Cname,CPhone,CAddress,ItemID,QTY,Total,Date) values("+OrderID+" , '"+Cname+"' , '"+CPhone+"' , '"+CAddress+"' , '"+ItemID+"' , "+QTY+" , "+Total+" , '"+Date+"')";
            
            row_insert = stmt.executeUpdate(qry);
            
        }
        catch(Exception ex)
        {
            System.out.println("Insert Error :"+ex);
        }
        
        return row_insert;
    }
    
    //2. update -> int
    public int update(int OrderID , String up_CPhone)
    {
        int row_update = 0;
        try
        {
            Connection con = DBConnection.connect();//get connection
            Statement stmt = con.createStatement();
            
            String qry = "update COrder set CPhone="+up_CPhone+" where OrderID="+OrderID;
            
            row_update = stmt.executeUpdate(qry);
        }
        catch(Exception ex)
        {
            System.out.println("Update Error :"+ex);
        }
        
        return row_update;
    }
    
    //3. delete -> int
    public int delete(int OrderID)
    {
        int row_delete = 0;
        try
        {
            Connection con = DBConnection.connect();//get connection
            Statement stmt = con.createStatement();
            
            String qry = "delete from COrder where OrderID="+OrderID;
            
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
            
            String qry = "select * from COrder";
            
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
                int o = rs.getInt(1);
                String n = rs.getString(2);
                String p = rs.getString(3);
                String a = rs.getString(4);
                String i = rs.getString(5);
                int q = rs.getInt(6);
                double t = rs.getDouble(7);
                String d = rs.getString(8);
                
                System.out.println("ORDERID :"+o);
                System.out.println("CUSTOMER NAME :"+n);
                System.out.println("CUSTOMER PHONE NO. :"+p);
                System.out.println("CUSTOMER ADDRESS :"+a);
                System.out.println("ITEMID :"+i);
                System.out.println("QUANTITY :"+q);
                System.out.println("TOTAL :"+t);
                System.out.println("DATE :"+d);
                
                
                System.out.println("========================");
                
            }//while ends
            
        }
        catch(Exception ex)
        {
            System.out.println("Display Error :"+ex);
        }
    
    }     
}
