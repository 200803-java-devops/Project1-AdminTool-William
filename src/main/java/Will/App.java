package Will;

import java.util.Scanner;

import Will.SQL.DAO;
import Will.SQL.getter;

/**
 * Hello world!
 *
 */
public class App 
{
       // Driver Code 
       public static void main(String args[]) 
       { 
           int controller = 1;
           int controller2 = 0;
           int ID = 0;
            Scanner sc = new Scanner(System.in);
           while (controller == 1) {
               System.out.println("Please select an action");
               System.out.println(" 1. Download log \n 2. Exit");
                controller2 = sc.nextInt();

               if (controller2 == 1) {
                System.out.println("Punch in the ID for the log you want");
                ID = sc.nextInt();
                getter.getFile(ID);
               }

               System.out.println("Do you want to run through the menu again or exit? \n 1. loop again \n 2. exit");
               controller = sc.nextInt();

           }


           System.out.println("shutting down");
           DAO.closeResources();
           sc.close();

       } 
    }
