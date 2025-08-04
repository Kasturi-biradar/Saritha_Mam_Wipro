package MAVEN_JDBC;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Jdbc_1 {
public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc1_with_maven_project_"; 
        String user = "root";
        String password = "Kasturi@8884213563";
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to DB");
            String insertsql = "INSERT INTO students(id,name,age) VALUES(?,?,?)";
            try(PreparedStatement pstmt = con.prepareStatement(insertsql)){
            	pstmt.setInt(1,104);
            	pstmt.setString(2, "Appu");
            	pstmt.setInt(3, 24);
            	int rows = pstmt.executeUpdate();
            	System.out.println("Inserted :" + rows);
            }
            String readsql = "SELECT * FROM students";
            try(Statement stmt = con.createStatement())
            {
            	ResultSet rs = stmt.executeQuery(readsql);
            	while(rs.next()) {
            		System.out.println(rs.getInt("id"));
            		System.out.println(rs.getString("name"));
            		System.out.println(rs.getInt("age"));
            	}
                String updateSql = "UPDATE students SET age = ? WHERE id = ?";
                try (PreparedStatement pstmt1 = con.prepareStatement(updateSql)) {
                    pstmt1.setInt(1, 22);  
                    pstmt1.setInt(2, 101); 
                    int rows = pstmt1.executeUpdate();
                    System.out.println(" Updated rows: " + rows);
                }
                String deleteSql = "DELETE FROM students WHERE id = ?";
                try (PreparedStatement pstmt2 = con.prepareStatement(deleteSql)) {
                    
                    pstmt2.setInt(1, 101); 
                    int rows = pstmt2.executeUpdate();
                    System.out.println(" Updated rows: " + rows);
                }
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
}