package controlador;

import Conexion.Conexionmysql;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import modelo.Categoria;

public class Ctr_Categoria {

    // metodo para registrar categoria
    public boolean guardar(Categoria objeto) {
        boolean respuesta = false;
        // Obtener la conexión a la base de datos
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into categorias values(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar la categoria" + e);
        }
        return respuesta;
    }

    // metodo para consultar si existe la categoria
    public boolean existeCategoria(String categoria) {
        boolean respuesta = false;
        String sql = "select descripcion from categorias where descripcion = '" + categoria +"';";
        Statement st;

        try {
            Conexionmysql conexion = new Conexionmysql();
            Connection cn = conexion.getConnection();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            respuesta = true;
            }
            
            
        } catch (SQLException e) {
            System.out.println("Error al consultar categoria" + e);
        }
        return respuesta;
    }
    
    // metodo para actualizar categoria
    public boolean Actualizar(Categoria objeto, int idCategoria) {
         boolean respuesta = false;
    // Obtener la conexión a la base de datos
    Conexionmysql conexion = new Conexionmysql();
    Connection cn = conexion.getConnection();
    
    try {
        // Preparar la consulta de actualización
        PreparedStatement consulta = cn.prepareStatement("UPDATE categorias SET descripcion = ? WHERE idCategoria = ?");
        
        // Asignar valores a los parámetros
        consulta.setString(1, objeto.getDescripcion());  // Asignar la descripción de la categoría
        consulta.setInt(2, idCategoria);                 // Asignar el ID de la categoría
        
        // Ejecutar la actualización y verificar si se afectó alguna fila
        if (consulta.executeUpdate() > 0) {
            respuesta = true;  // La actualización fue exitosa
        }
        
        // Cerrar la conexión
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al actualizar la categoría: " + e.getMessage());
    }
    
    return respuesta;
    }
    
    // Método para eliminar una categoría
public boolean Eliminar(int idCategoria) {
    boolean respuesta = false;
    // Obtener la conexión a la base de datos
    Conexionmysql conexion = new Conexionmysql();
    Connection cn = conexion.getConnection();
    
    try {
        // Preparar la consulta de eliminación
        PreparedStatement consulta = cn.prepareStatement("DELETE FROM categorias WHERE idCategoria = ?");
        
        // Asignar el valor del idCategoria al parámetro
        consulta.setInt(1, idCategoria);
        
        // Ejecutar la eliminación y verificar si se afectó alguna fila
        if (consulta.executeUpdate() > 0) {
            respuesta = true;  // La eliminación fue exitosa
        }
        
        // Cerrar la conexión
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al eliminar la categoría: " + e.getMessage());
    }
    
    return respuesta;
}
}
