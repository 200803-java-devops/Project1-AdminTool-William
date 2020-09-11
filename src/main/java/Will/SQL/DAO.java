package Will.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    
    static Connection connection = null; // Our connection to the database
    static PreparedStatement stmt = null; // We use prepared statements to help protect against SQL injection

    public static byte[] getFile(int id) {
        byte[] content = null;

        try {
            connection = DBconnect.getConnection();
            String sql = "SELECT * FROM logs WHERE \"Id\" = ?;";
            stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
                content = rs.getBytes("file");		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return content;	
    }

//<---------------------------------->
public static String getFilename(int id) {
    String filename = "";

    try {
        connection = DBconnect.getConnection();
        String sql = "SELECT * FROM logs WHERE \"Id\" = ?;";
        stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            filename = rs.getString("filename");		
        }
        
    } catch (SQLException e) {
        e.printStackTrace();

    }
    
    return filename;	
}


    public static void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}

    
}
