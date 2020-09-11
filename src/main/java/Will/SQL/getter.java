package Will.SQL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class getter {

    public static void getFile(int id) {
        // Path of a file 
        String filename = DAO.getFilename(id);
         String FILEPATH = "C:/Users/a/Desktop/Revature/bootcamp projects/p1.1/LOGS/" + filename; 
         File file = new File(FILEPATH); 
  
        try { 
  
            // Initialize a pointer 
            // in file using OutputStream 
            OutputStream os = new FileOutputStream(file); 
  
            // Starts writing the bytes in it 
            os.write(DAO.getFile(id)); 
            System.out.println("File downloaded successfully to " + FILEPATH); 
  
            // Close the file 
            os.flush();
            os.close(); 
        } 
  
        catch (Exception e) { 
            System.out.println("Exception: " + e); 
        } 
    } 
  
 
} 

