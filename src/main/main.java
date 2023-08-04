
package main;

import Manager.BrandList;
import Manager.CarList;
import java.io.IOException;

public class main {
    
    public static void main(String[] args) throws IOException 
    {    
        BrandList a= new BrandList();
        CarList b=new CarList();
        a.loadFile();
        b.readFile();

        int choice; 
        do
        {   
            b.loadDataInto(a);
            choice =Menu.Menu();
            System.out.println("__________________________________");
            switch(choice)
            {  
                
                case 1: 
                {  
                    a.ListAll();;
                    break; 
                }
                case 2: 
                {   
                    a.addNew();
                    break;
                }
                case 3: 
                {   a.searchOld();
                    break;
                }
                case 4: 
                {   a.updateOld();
                    break;
                }
                case 5: 
                {   
                    a.saveFile();
                    break;
                }
                case 6: 
                {   
                    b.ListSort();
                    break;
                }
                case 7: 
                {   
                    b.ListBasedName(a);
                    break;
                }
                case 8: 
                {   
                    b.addNew(a);
                    break;
                }
                case 9: 
                {   b.removeOld(a);
                    break;
                }
                case 10: 
                {   b.updateCar(a);
                    break;
                }
                case 11: 
                {   
                    b.saveFile();
                    break;
                }
                case 12: 
                {   
                    System.out.println("Good Bye! See you later!!");
                    break;
                }
            }
            System.out.println("__________________________________");
        } while (choice!=12); 
    }
    
}
