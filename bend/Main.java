package bend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

//postgresql://postgres:[YOUR-PASSWORD]@db.seuzmhmgbjejszcirwjx.supabase.co:5432/postgres

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://db.seuzmhmgbjejszcirwjx.supabase.co:5432/postgres";
        String username = "postgres";
        String password = "";

        try{
            password = Files.readString(Path.of("db_passwd"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


        Connection conn = null;

        try {
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Conexión exitosa.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}