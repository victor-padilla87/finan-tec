
package controlador;

import Conexion.Conexionmysql;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Ctr_CofiguracionFacturas {
    
    // Método para configurar el encabezado de la factura
    public void configurarEncabezado(String nombreEmpresa, String direccion, String telefono, String logoPath) {
        try {
            // Conexión a la base de datos
            Conexionmysql conexion = new Conexionmysql();
            Connection cn = conexion.getConnection();

            // Consulta para actualizar la configuración del encabezado
            String query = "UPDATE configuracion_factura SET nombre_empresa = ?, direccion = ?, telefono = ?, logo = ? WHERE id_configuracion = 1";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, nombreEmpresa);
            pst.setString(2, direccion);
            pst.setString(3, telefono);
            pst.setString(4, logoPath);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Encabezado de la factura configurado correctamente.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al configurar el encabezado: " + e.getMessage());
        }
    }

    // Método para configurar el pie de página de la factura
    public void configurarPieDePagina(String textoPie) {
        try {
            // Conexión a la base de datos
            Conexionmysql conexion = new Conexionmysql();
            Connection cn = conexion.getConnection();

            // Consulta para actualizar el pie de página
            String query = "UPDATE configuracion_factura SET pie_pagina = ? WHERE id_configuracion = 1";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, textoPie);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Pie de página de la factura configurado correctamente.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al configurar el pie de página: " + e.getMessage());
        }
    }

    // Método para configurar el formato de numeración de la factura
    public void configurarNumeracionFactura(String prefijo, int numeroInicial) {
        try {
            // Conexión a la base de datos
            Conexionmysql conexion = new Conexionmysql();
            Connection cn = conexion.getConnection();

            // Consulta para actualizar la numeración
            String query = "UPDATE configuracion_factura SET prefijo = ?, numero_inicial = ? WHERE id_configuracion = 1";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, prefijo);
            pst.setInt(2, numeroInicial);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Formato de numeración de factura configurado correctamente.");
            }

 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al configurar la numeración de la factura: " + e.getMessage());
        }
    }

    // Método para configurar los impuestos
    public void configurarImpuesto(double porcentajeImpuesto) {
        try {
            // Conexión a la base de datos
            Conexionmysql conexion = new Conexionmysql();
            Connection cn = conexion.getConnection();

            // Consulta para actualizar el impuesto
            String query = "UPDATE configuracion_factura SET porcentaje_impuesto = ? WHERE id_configuracion = 1";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setDouble(1, porcentajeImpuesto);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Impuesto configurado correctamente.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al configurar el impuesto: " + e.getMessage());
        }
    }

    // Método para configurar descuentos globales
    public void configurarDescuento(double porcentajeDescuento) {
        try {
            // Conexión a la base de datos
            Conexionmysql conexion = new Conexionmysql();
            Connection cn = conexion.getConnection();

            // Consulta para actualizar el descuento global
            String query = "UPDATE configuracion_factura SET porcentaje_descuento = ? WHERE id_configuracion = 1";
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setDouble(1, porcentajeDescuento);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Descuento global configurado correctamente.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al configurar el descuento: " + e.getMessage());
        }
    }

    // Método para guardar la configuración general de la factura
    public void guardarConfiguracion() {
        // Este método puede llamar a otros métodos de configuración para guardar todas las configuraciones de una vez
        configurarEncabezado("Mi Empresa", "Dirección Ejemplo", "123456789", "src/imagenes/logo.jpg");
        configurarPieDePagina("Gracias por su compra.");
        configurarNumeracionFactura("FAC", 1001);
        configurarImpuesto(0.19);  // 18% de impuesto
        configurarDescuento(0.0); // 10% de descuento global
    }
    
}
