package controlador;

import Conexion.Conexionmysql;
import modelo.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.CabeceraVenta;

public class Ctr_RegistroVenta {

    public boolean guardar(CabeceraVenta cabeceraVenta, int idCliente) {
        String sql = "INSERT INTO cabecera_venta (idCliente, valor_pagar, fecha_venta, estado) VALUES (?, ?, ?, ?)";

        try {
            // Obtener la conexión a la base de datos
            Conexionmysql conexion = new Conexionmysql();
            Connection cn = conexion.getConnection();

            // Preparar la consulta
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, cabeceraVenta.getIdCliente(idCliente)); // Establece el ID del cliente
            ps.setDouble(2, cabeceraVenta.getValorPagar()); // Establece el valor total a pagar
            ps.setString(3, cabeceraVenta.getFechaVenta()); // Establece la fecha de la venta
            ps.setInt(4, cabeceraVenta.getEstado()); // Establece el estado de la venta

            // Ejecutar la consulta
            ps.executeUpdate();
            return true; // Si todo sale bien, devolver true
        } catch (SQLException e) {
            System.out.println("Error al guardar la cabecera de la venta: " + e.getMessage());
            return false; // Devolver false si hay un error
        }
    }

    public boolean guardarDetalle(DetalleVenta detalleVenta) {

        String sql = "INSERT INTO detalle_venta (idCabeceraVenta, idProducto, nombre_producto, cantidad, precio_unitario, subtotal, descuento, iva, total_apagar, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Obtener la conexión a la base de datos
            Conexionmysql conexion = new Conexionmysql();
            Connection cn = conexion.getConnection();

            // Preparar la consulta
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, detalleVenta.getIdCabecerVenta());  // ID de la cabecera de venta
            ps.setInt(2, detalleVenta.getIdProducto());      // ID del producto
            ps.setString(3, detalleVenta.getNombre_Producto());       // Nombre del producto
            ps.setInt(4, detalleVenta.getCantidad());        // Cantidad de productos
            ps.setDouble(5, detalleVenta.getPrecioUnitario());// Precio unitario
            ps.setDouble(6, detalleVenta.getSubtotal());     // Subtotal
            ps.setDouble(7, detalleVenta.getDescuento());    // Descuento
            ps.setDouble(8, detalleVenta.getIva());          // IVA
            ps.setDouble(9, detalleVenta.getTotalApagar());  // Total a pagar
            ps.setInt(10, detalleVenta.getIdEstado());        // Estado

            // Ejecutar la consulta
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al guardar el detalle de la venta: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(CabeceraVenta cabeceraVenta, int idVenta) {

        boolean resultado = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        // Consulta SQL para actualizar el cliente, la fecha y el estado de la venta
        String sql = "UPDATE cabecera_venta SET idCliente = ?, estado = ? WHERE idCabeceraVenta = ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            int idCliente = 0;

            // Asignar los valores al PreparedStatement
            pst.setInt(1, cabeceraVenta.getIdCliente(idCliente));  // Actualiza el cliente
            pst.setInt(2, cabeceraVenta.getEstado());     // Actualiza el estado
            pst.setInt(3, idVenta);                       // Filtra por idVenta

            // Ejecutar la actualización
            int rowsAffected = pst.executeUpdate();

            // Si se actualizó al menos una fila, devuelve true
            if (rowsAffected > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la cabecera de la venta: " + e.getMessage());
        } finally {
            try {
                if (cn != null && !cn.isClosed()) {
                    cn.close();  // Cerrar la conexión
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }

        return resultado;
    }

}
