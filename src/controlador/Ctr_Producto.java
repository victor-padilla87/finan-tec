package controlador;

import Conexion.Conexionmysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

public class Ctr_Producto {

    // metodo para guarda los productos
    public boolean guardar(Producto objeto) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();
        try {
            // Corregir el nombre de la tabla 'productos' y reducir el número de parámetros
            String sql = "INSERT INTO productos VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Asignar los valores a los parámetros
            consulta.setInt(1, 0);  // Suponiendo que es un valor autogenerado
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getDescripcion());
            consulta.setDouble(4, objeto.getPrecioCompra());
            consulta.setDouble(5, objeto.getPrecioUnitario());
            consulta.setInt(6, objeto.getCantidad());
            consulta.setDouble(7, objeto.getPorcentajeIva());
            consulta.setDouble(8, objeto.getDescuento());
            consulta.setString(9, objeto.getProveedor());

            // Ejecutar la consulta
            if (consulta.executeUpdate() > 0) {
                respuesta = true;  // El producto se guardó correctamente
            }

            // Cerrar la conexión
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el producto: " + e.getMessage());
        }

        return respuesta;
    }

    // metodo para consultar si existe el producto
    public boolean existeProducto(String producto) {
        boolean respuesta = false;
        String sql = "select nombre from productos where nombre = '" + producto + "';";
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
            System.out.println("Error al consultar producto" + e);
        }
        return respuesta;
    }

    // metodo para actualizar categoria
    public boolean Actualizar(Producto objeto, int idProducto) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            // Preparar la consulta de actualización
            String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio_compra = ?, precio_unitario = ?, cantidad = ?, porcentaje_iva = ?, proveedor = ? WHERE idProducto = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Asignar valores a los parámetros
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getDescripcion());
            consulta.setDouble(3, objeto.getPrecioCompra());
            consulta.setDouble(4, objeto.getPrecioUnitario());
            consulta.setInt(5, objeto.getCantidad());
            consulta.setDouble(6, objeto.getPorcentajeIva());
            consulta.setString(7, objeto.getProveedor());
            consulta.setInt(8, idProducto);

            // Ejecutar la actualización y verificar si se afectó alguna fila
            if (consulta.executeUpdate() > 0) {
                respuesta = true;  // La actualización fue exitosa
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
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
    public boolean Eliminar(int idProducto) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            // Preparar la consulta de eliminación
            String sql = "DELETE FROM productos WHERE idProducto = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Asignar el valor del idProducto al parámetro
            consulta.setInt(1, idProducto);

            // Ejecutar la eliminación y verificar si se afectó alguna fila
            if (consulta.executeUpdate() > 0) {
                respuesta = true;  // La eliminación fue exitosa
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
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
    // Método para actualizar el stock de un producto

    public boolean ActualizarStock(Producto producto, int idProducto) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            // Preparar la consulta de actualización
            String sql = "UPDATE productos SET cantidad = ? WHERE idProducto = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Asignar los valores de los parámetros
            consulta.setInt(1, producto.getCantidad()); // Cantidad nueva del producto
            consulta.setInt(2, idProducto); // ID del producto a actualizar

            // Ejecutar la actualización y verificar si se afectó alguna fila
            if (consulta.executeUpdate() > 0) {
                respuesta = true;  // La actualización fue exitosa
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
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
