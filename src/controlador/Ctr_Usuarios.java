package controlador;

import Conexion.Conexionmysql;
import java.sql.Connection;
import modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Ctr_Usuarios {
    
    // metodo para guarda usuario
    public boolean guardar(Usuario objeto) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();
        try {
            //sentencia para guardar cliente
            String sql = "INSERT INTO usuarios (nombre, apellido, usuario, password, rol) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement consulta = cn.prepareStatement(sql);
            // Asignar los valores a los parámetros (empezando desde 1)
        consulta.setString(1, objeto.getNombre());
        consulta.setString(2, objeto.getApellido());
        consulta.setString(3, objeto.getUsuario());
        consulta.setString(4, objeto.getPassword());
        consulta.setString(5, objeto.getRol());

            // Ejecutar la consulta
            if (consulta.executeUpdate() > 0) {
                respuesta = true;  // El usuario se guardó correctamente
            }
            // Cerrar la conexión
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el usuario: " + e.getMessage());
        }
        return respuesta;
    }

    // metodo para consultar si existe el cliente
    public boolean existeUsuario(String usuario) {
        boolean respuesta = false;
        String sql = "select usuario from usuarios where usuario = '" + usuario + "';";
        Statement st;
        try {
            Conexionmysql conexion = new Conexionmysql();
            Connection cn = conexion.getConnection();
            st = cn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el usuario" + e);
        }
        return respuesta;
    }

    // metodo para iniciar sesion
    public boolean InicioSesion(Usuario objeto) {
        boolean respuesta = false;
        
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();
        String sql = "SELECT usuario, password FROM usuarios WHERE usuario = ? AND password = ?";
        PreparedStatement ps;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, objeto.getUsuario());
            ps.setString(2, objeto.getPassword());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Para obtener más información detallada del error
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e.getMessage());
        }
        return respuesta;
    }
    
    // metodo para actualizar cliente
    public boolean Actualizar(Usuario objeto, int idUsuario) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            // Preparar la consulta de actualización
            String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, usuario = ?, password = ?, rol = ? WHERE idUsuario = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Asignar valores a los parámetros
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getUsuario());
            consulta.setString(4, objeto.getPassword());
            consulta.setString(5, objeto.getRol());
            consulta.setInt(6, idUsuario);

            // Ejecutar la actualización y verificar si se afectó alguna fila
            if (consulta.executeUpdate() > 0) {
                respuesta = true;  // La actualización fue exitosa
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        } finally {
            // Cerrar la conexión
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return respuesta;
    }

    // Método para eliminar un cliente
    public boolean Eliminar(int idUsuario) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            // Preparar la consulta de eliminación
            String sql = "DELETE FROM usuarios WHERE idUsuario = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Asignar el valor del idUsuario al parámetro
            consulta.setInt(1, idUsuario);

            // Ejecutar la eliminación y verificar si se afectó alguna fila
            if (consulta.executeUpdate() > 0) {
                respuesta = true;  // La eliminación fue exitosa
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        } finally {
            // Cerrar la conexión
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return respuesta;
    }
    
}
