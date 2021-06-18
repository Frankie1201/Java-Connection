
public class COrderMain {
    
    public static void main(String[] args) {
        
        COrderQuery obj = new COrderQuery();
        
        // 1 Display date
        obj.display();
        
        //2 Update
        int update = obj.update(14, "222111");
        if (update == 1)
        {
            System.out.println("row update successfully");
        }
       else
        {
            System.out.println("can not update");
        }
        
        System.out.println("=====================");
        
        // 3 Display Update
        obj.display();
        
    }
    
}
