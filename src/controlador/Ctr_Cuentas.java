package controlador;

import Conexion.Conexionmysql;
import modelo.Cuentas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Ctr_Cuentas {
    private Connection connection;

    public Ctr_Cuentas() {
        Conexionmysql conexion = new Conexionmysql();
        this.connection = conexion.getConnection();
    }

    // Método para registrar una cuenta en la base de datos
    public boolean registrarCuenta(Cuentas cuenta) {
        String sql = "INSERT INTO cuentas (tipo, descripcion, monto, fecha_vencimiento, estado) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, cuenta.getTipo());
            ps.setString(2, cuenta.getDescripcion());
            ps.setDouble(3, cuenta.getMonto());
            ps.setDate(4, new java.sql.Date(cuenta.getFechaVencimiento().getTime()));
            ps.setString(5, cuenta.getEstado());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener todas las cuentas de la base de datos
    public List<Cuentas> obtenerCuentas() {
        List<Cuentas> cuentas = new ArrayList<>();
        String sql = "SELECT * FROM cuentas";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cuentas cuenta = new Cuentas(
                    rs.getInt("id"),
                    rs.getString("tipo"),
                    rs.getString("descripcion"),
                    rs.getDouble("monto"),
                    rs.getDate("fecha_vencimiento"),
                    rs.getString("estado")
                );
                cuentas.add(cuenta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cuentas;
    }

    // Método para actualizar el estado de una cuenta en la base de datos
    public boolean actualizarCuenta(Cuentas cuenta) {
        String sql = "UPDATE cuentas SET tipo = ?, descripcion = ?, monto = ?, fecha_vencimiento = ?, estado = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, cuenta.getTipo());
            ps.setString(2, cuenta.getDescripcion());
            ps.setDouble(3, cuenta.getMonto());
            ps.setDate(4, new java.sql.Date(cuenta.getFechaVencimiento().getTime()));
            ps.setString(5, cuenta.getEstado());
            ps.setInt(6, cuenta.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar una cuenta de la base de datos por su ID
    public boolean eliminarCuenta(int id) {
        String sql = "DELETE FROM cuentas WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cuentas> filtrarCuentas(String criterio, String valor) {
    List<Cuentas> cuentasFiltradas = new ArrayList<>();

    // Obtener todas las cuentas
    List<Cuentas> cuentas = obtenerCuentas();

    for (Cuentas cuenta : cuentas) {
        switch (criterio) {
            case "ID":
                if (String.valueOf(cuenta.getId()).equals(valor)) {
                    cuentasFiltradas.add(cuenta);
                }
                break;
            case "Estado":
                if (cuenta.getEstado().equalsIgnoreCase(valor)) {
                    cuentasFiltradas.add(cuenta);
                }
                break;
            case "Fecha Vencimiento":
                if (cuenta.getFechaVencimiento() != null &&
                        cuenta.getFechaVencimiento().toString().equals(valor)) {
                    cuentasFiltradas.add(cuenta);
                }
                break;
            case "Descripción":
                if (cuenta.getDescripcion().toLowerCase().contains(valor.toLowerCase())) {
                    cuentasFiltradas.add(cuenta);
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Criterio de filtro no válido");
                break;
        }
    }
    return cuentasFiltradas;
}

   public Cuentas obtenerCuentaPorId(int id) {
    Cuentas cuenta = null;
    String sql = "SELECT * FROM cuentas WHERE id = ?";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            cuenta = new Cuentas(
                rs.getInt("id"),
                rs.getString("tipo"),
                rs.getString("descripcion"),
                rs.getDouble("monto"),
                rs.getDate("fecha_vencimiento"),
                rs.getString("estado")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return cuenta;
}


}
