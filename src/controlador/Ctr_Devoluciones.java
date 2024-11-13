package controlador;

import Conexion.Conexionmysql;
import java.sql.Connection;
import modelo.Devoluciones;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Date;

public class Ctr_Devoluciones {

    private Conexionmysql conexion;

    public Ctr_Devoluciones() {

        this.conexion = new Conexionmysql(); // Inicialización
    }

    // Método para registrar una nueva devolución en la base de datos
    public boolean registrarDevolucion(Devoluciones devolucion) {
        Connection cn = conexion.getConnection();
        String sql = "INSERT INTO devoluciones (id_factura, idProducto, nombre_producto, cantidad_devuelta, motivo, fecha_devolucion) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = cn.prepareStatement(sql)) {
            stmt.setInt(1, devolucion.getId_factura());
            stmt.setInt(2, devolucion.getIdProducto());
            stmt.setString(3, devolucion.getNombre_producto());
            stmt.setInt(4, devolucion.getCantidad_devuelta());
            stmt.setString(5, devolucion.getMotivo());
            stmt.setDate(6, new java.sql.Date(devolucion.getFecha_devolucion().getTime()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la devolución: " + e.getMessage());
            return false;
        }
    }

    // Método para buscar productos de una venta específica
    public ArrayList<Devoluciones> buscarVenta(int idVenta) {
        Connection cn = conexion.getConnection();
        String sql = "SELECT idProducto, nombre_producto, cantidad FROM detalle_venta WHERE idCabeceraVenta = ?";
        ArrayList<Devoluciones> productosVenta = new ArrayList<>();

        try (PreparedStatement stmt = cn.prepareStatement(sql)) {
            stmt.setInt(1, idVenta);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String nombreProducto = rs.getString("nombre_producto");
                int cantidad = rs.getInt("cantidad");
                Devoluciones producto = new Devoluciones(0, idVenta, idProducto, cantidad, nombreProducto, "", new Date());
                productosVenta.add(producto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la venta: " + e.getMessage());
        }
        return productosVenta;
    }

    // Método para actualizar la cantidad devuelta en detalle_venta y ajustar el subtotal
    public boolean actualizarCantidadYSubtotal(int idFactura, int idProducto, int cantidadDevuelta) {
        Connection cn = conexion.getConnection();
        String sql = "UPDATE detalle_venta SET cantidad = cantidad - ?, subtotal = subtotal - (? * precio_unitario) WHERE idCabeceraVenta = ? AND idProducto = ?";

        try (PreparedStatement stmt = cn.prepareStatement(sql)) {
            stmt.setInt(1, cantidadDevuelta);
            stmt.setInt(2, cantidadDevuelta);
            stmt.setInt(3, idFactura);
            stmt.setInt(4, idProducto);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la cantidad y subtotal en detalle de venta: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar el total a pagar en la cabecera de venta y los descuentos después de una devolución
    public boolean actualizarTotalAPagar(int id_factura) {
        Connection cn = conexion.getConnection();

        // Paso 1: Restar cantidades devueltas y actualizar el subtotal, IVA, y total a pagar en detalle_venta
        String sqlActualizarDetalleVenta
                = "UPDATE detalle_venta "
                + "SET cantidad = cantidad - ?, "
                + // Descontar la cantidad devuelta
                "subtotal = (cantidad - ?) * precio_unitario, "
                + // Recalcular el subtotal
                "iva = (subtotal * ?), "
                + // Recalcular el IVA (por ejemplo, 19% o 0.19)
                "total_apagar = subtotal + iva "
                + // Calcular el total con el IVA incluido
                "WHERE idCabeceraVenta = ? AND idProducto = ?";

        // Paso 2: Actualizar el valor total a pagar en la cabecera_venta
        String sqlActualizarCabeceraVenta
                = "UPDATE cabecera_venta "
                + "SET valor_pagar = (SELECT SUM(total_apagar) FROM detalle_venta WHERE idCabeceraVenta = ?) "
                + "WHERE idCabeceraVenta = ?";

        try {
            cn.setAutoCommit(false);  // Iniciar transacción

            try (PreparedStatement stmtDetalle = cn.prepareStatement(sqlActualizarDetalleVenta); PreparedStatement stmtCabecera = cn.prepareStatement(sqlActualizarCabeceraVenta)) {
                int cantidad = 0;
                int idProducto = 0;

                // Actualizar detalle de venta: pasar valores correspondientes a cantidad devuelta y porcentaje de IVA
                stmtDetalle.setInt(1, cantidad);  // Cantidad devuelta
                stmtDetalle.setInt(2, cantidad);  // Recalcular el subtotal con cantidad actualizada
                stmtDetalle.setDouble(3, 0.19);           // Suponiendo que el IVA es el 12% (cambiar según tu configuración)
                stmtDetalle.setInt(4, id_factura);        // ID de la cabecera de venta
                stmtDetalle.setInt(5, idProducto);        // ID del producto devuelto
                stmtDetalle.executeUpdate();

                // Actualizar cabecera de venta con el nuevo valor total a pagar
                stmtCabecera.setInt(1, id_factura);
                stmtCabecera.setInt(2, id_factura);
                stmtCabecera.executeUpdate();

                cn.commit();  // Confirmar transacción
                return true;
            } catch (SQLException e) {
                cn.rollback();  // Revertir cambios en caso de error
                JOptionPane.showMessageDialog(null, "Error al actualizar el total a pagar en cabecera de venta: " + e.getMessage());
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al gestionar la transacción: " + e.getMessage());
            return false;
        } finally {
            try {
                if (cn != null && !cn.isClosed()) {
                    cn.setAutoCommit(true); // Restaurar el modo de auto-commit
                    cn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }

    // Método para actualizar la cantidad en producto al devolver productos
    public boolean actualizarCantidadProducto(int idProducto, int cantidadDevuelta) {
        Connection cn = conexion.getConnection();
        String sql = "UPDATE productos SET cantidad = cantidad + ? WHERE idProducto = ?";

        try (PreparedStatement stmt = cn.prepareStatement(sql)) {
            stmt.setInt(1, cantidadDevuelta);
            stmt.setInt(2, idProducto);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la cantidad en producto: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un producto
    public boolean Eliminar(int id_devolucion) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            // Preparar la consulta de eliminación
            String sql = "DELETE FROM devoluciones WHERE id_devolucion = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Asignar el valor del idProducto al parámetro
            consulta.setInt(1, id_devolucion);

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
    // Método para actualizar los detalles de una devolución

    public boolean ActualizarDevolucion(Devoluciones devolucion, int id_devolucion) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            // Preparar la consulta de actualización
            String sql = "UPDATE devoluciones SET nombre_producto = ?, cantidad_devuelta = ?, motivo = ?, fecha_devolucion = ? WHERE id_devolucion = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Asignar los valores de los parámetros desde el objeto 'devolucion'
            consulta.setString(1, devolucion.getNombre_producto());       // Nombre del producto
            consulta.setInt(2, devolucion.getCantidad_devuelta());        // Cantidad devuelta
            consulta.setString(3, devolucion.getMotivo());                // Motivo de la devolución
            consulta.setDate(4, new java.sql.Date(devolucion.getFecha_devolucion().getTime())); // Fecha de la devolución
            consulta.setInt(5, id_devolucion);                            // ID de la devolución a actualizar

            // Ejecutar la actualización y verificar si se afectó alguna fila
            if (consulta.executeUpdate() > 0) {
                respuesta = true;  // La actualización fue exitosa
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar la devolución: " + e.getMessage());
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
