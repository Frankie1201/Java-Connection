
public class ManagerMain {
    
    public static void main(String[] args) {
        
        ManagerQuery obj = new ManagerQuery();
        
        //1. display all data
        obj.display();
        
        //2. delete record
        //int delete = obj.delete(1005);
        //if(delete == 1)
        //{
            //System.out.println("row deleted succesfully;");
        //}
        //else
        //{
           // System.out.println("Can not delete. Id could not match");
       // }
        
        
        //3. display all data after delete
        //obj.display();
        
        //4.Update
        int update = obj.update(1006 , 1800.00);
        if (update == 1)
        {
            System.out.println("row update successfully");
        }
       else
        {
            System.out.println("can not delete");
        }
        
        System.out.println("==================");
        
        //3. display all data
        obj.display();
    }
}
