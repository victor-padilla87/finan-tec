package controlador;

import Conexion.Conexionmysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Proveedor;

/**
 *
 * @author User WOM (EIASA)
 */
public class Ctr_Proveedor {

    // metodo para guarda los proveedores
    public boolean guardarProveedores(Proveedor objeto) {
        boolean respuesta = false;
    Conexionmysql conexion = new Conexionmysql();
    Connection cn = conexion.getConnection();
    
    try {
        // Cambiar la consulta para insertar los datos en la tabla proveedores
        String sql = "INSERT INTO proveedores (nombre, direccion, telefono, email, descripcion, estado) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement consulta = cn.prepareStatement(sql);

        // Asignar los valores a los parámetros (no se incluye idProveedor porque es auto-incremental)
        consulta.setString(1, objeto.getNombre());
        consulta.setString(2, objeto.getDireccion());
        consulta.setString(3, objeto.getTelefono());
        consulta.setString(4, objeto.getEmail());
        consulta.setString(5, objeto.getDescripcion());  
        consulta.setString(6, objeto.getEstado());       

        // Ejecutar la consulta
        if (consulta.executeUpdate() > 0) {
            respuesta = true;  // El proveedor se guardó correctamente
        }

        // Cerrar la conexión
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al guardar el proveedor: " + e.getMessage());
    }

    return respuesta;
    }

    // metodo para consultar si existe el proveedor
    public boolean existeProveedor(String proveedor) {
        boolean respuesta = false;
        String sql = "select nombre from proveedores where nombre = '" + proveedor + "';";
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
            System.out.println("Error al consultar proveedor" + e);
        }
        return respuesta;
    }

    // metodo para actualizar categoria
    public boolean Actualizar(Proveedor objeto, int idProveedor) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            // Preparar la consulta de actualización
            String sql = "UPDATE proveedores SET nombre = ?, direccion = ?, telefono = ?, email = ?, descripcion = ?, estado = ? WHERE idProveedor = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Asignar valores a los parámetros
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getDireccion());
            consulta.setString(3, objeto.getTelefono());
            consulta.setString(4, objeto.getEmail());
            consulta.setString(5, objeto.getDescripcion());
            consulta.setString(6, objeto.getEstado());
            consulta.setInt(7, idProveedor);

            // Ejecutar la actualización y verificar si se afectó alguna fila
            if (consulta.executeUpdate() > 0) {
                respuesta = true;  // La actualización fue exitosa
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el proveedor: " + e.getMessage());
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

    // Método para eliminar un producto
    public boolean Eliminar(int idProveedor) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            // Preparar la consulta de eliminación
            String sql = "DELETE FROM proveedores WHERE idProveedor = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Asignar el valor del idProveedor al parámetro
            consulta.setInt(1, idProveedor);

            // Ejecutar la eliminación y verificar si se afectó alguna fila
            if (consulta.executeUpdate() > 0) {
                respuesta = true;  // La eliminación fue exitosa
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el proveedor: " + e.getMessage());
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
