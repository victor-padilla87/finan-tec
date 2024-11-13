package Conexion;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Conexionmysql {
    
    private static final String URL = "jdbc:mysql://localhost:3305/ayctienda";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection connection;

    // Constructor
    public Conexionmysql() {
        this.connection = getConexion(); // Inicializa la conexión al crear una instancia
    }

    // Método para obtener la conexión
    public static Connection getConexion() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cn;
    }

    // Método para cerrar la conexión
    public void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para obtener la conexión desde la instancia
    public Connection getConnection() {
        return this.connection;
    }

    public Connection conectar() {
      Connection con = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3305/ayctienda", "root", "");
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
    return con;
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
   
 }


 
    

    

    

   



