import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class ItemQuery {
    
    //1. insert -> int
    public int insert(String ItemID, String Dish, double Price, String Category)
    {
        int row_insert = 0;
        try
        {
            Connection con = DBConnection.connect();//get connection
            Statement stmt = con.createStatement();
            
            String qry = "insert into Item(ItemID,Dish,Price,Category) values('"+ItemID+"' , '"+Dish+"' , "+Price+" , '"+Category+"')";
            
            row_insert = stmt.executeUpdate(qry);
            
        }
        catch(Exception ex)
        {
            System.out.println("Insert Error :"+ex);
        }
        
        return row_insert;
    }
    
    //2. update -> int
    public int update(String ItemID , double up_Price)
    {
        int row_update = 0;
        try
        {
            Connection con = DBConnection.connect();//get connection
            Statement stmt = con.createStatement();
            
            String qry = "update Item set Price="+up_Price+" where ItemID='"+ItemID+"'";
            
            row_update = stmt.executeUpdate(qry);
        }
        catch(Exception ex)
        {
            System.out.println("Update Error :"+ex);
        }
        
        return row_update;
    }
    
    //3. delete -> int
    public int delete(String ItemID)
    {
        int row_delete = 0;
        try
        {
            Connection con = DBConnection.connect();//get connection
            Statement stmt = con.createStatement();
            
            String qry = "delete from Item where ItemID="+ItemID;
            
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
            
            String qry = "select * from Item";
            
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
                String i = rs.getString(1);
                String d = rs.getString(2);
                double p = rs.getDouble(3);
                String c = rs.getString(4);
                
                System.out.println("ITEMID :"+i);
                System.out.println("DISH :"+d);
                System.out.println("PRICE :"+p);
                System.out.println("CATEGORY :"+c);
                
                System.out.println("========================");
                
            }//while ends
            
        }
        catch(Exception ex)
        {
            System.out.println("Display Error :"+ex);
        }
    }
}
