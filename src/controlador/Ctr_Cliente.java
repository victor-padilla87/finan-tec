package controlador;

import Conexion.Conexionmysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cliente;

public class Ctr_Cliente {

    // metodo para guarda cliente
    public boolean guardar(Cliente objeto) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();
        try {
            //sentencia para guardar cliente
            String sql = "INSERT INTO clientes VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement consulta = cn.prepareStatement(sql);
            // Asignar los valores a los parámetros
            consulta.setInt(1, 0);  // Suponiendo que es un valor autogenerado
            consulta.setString(2, objeto.getCedula());
            consulta.setString(3, objeto.getNombre());
            consulta.setString(4, objeto.getApellido());
            consulta.setString(5, objeto.getDireccion());
            consulta.setString(6, objeto.getTelefono());
            consulta.setString(7, objeto.getCorreo());

            // Ejecutar la consulta
            if (consulta.executeUpdate() > 0) {
                respuesta = true;  // El cliente se guardó correctamente
            }
            // Cerrar la conexión
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el cliente: " + e.getMessage());
        }
        return respuesta;
    }

    // metodo para consultar si existe el cliente
    public boolean existeCliente(String cedula) {
        boolean respuesta = false;
        String sql = "select cedula from clientes where cedula = '" + cedula + "';";
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
            System.out.println("Error al consultar el cliente" + e);
        }
        return respuesta;
    }

    // metodo para actualizar cliente
    public boolean Actualizar(Cliente objeto, int idCliente) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            // Preparar la consulta de actualización
            String sql = "UPDATE clientes SET cedula = ?, nombre = ?, apellido = ?, direccion = ?, telefono = ?, email = ?  WHERE idCliente = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Asignar valores a los parámetros
            consulta.setString(1, objeto.getCedula());
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getDireccion());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getCorreo());
            consulta.setInt(7, idCliente);

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
    public boolean Eliminar(int idCliente) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            // Preparar la consulta de eliminación
            String sql = "DELETE FROM clientes WHERE idCliente = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Asignar el valor del idCliente al parámetro
            consulta.setInt(1, idCliente);

            // Ejecutar la eliminación y verificar si se afectó alguna fila
            if (consulta.executeUpdate() > 0) {
                respuesta = true;  // La eliminación fue exitosa
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
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
