
public class ItemMain {
    
    public static void main(String[] args) {
        
        ItemQuery obj = new ItemQuery();
        
        // 1 Display date
        obj.display();
        
        //2.Update
        int update = obj.update("B101", 7.20);
        if (update == 1)
        {
            System.out.println("row update successfully");
        }
       else
        {
            System.out.println("can not update");
        }
        
        System.out.println("=====================");
        
        //3.Update Display
        obj.display();
        
    }
    
}
