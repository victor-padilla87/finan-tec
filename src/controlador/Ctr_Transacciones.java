package controlador;

import modelo.Transacciones;
import Conexion.Conexionmysql;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class Ctr_Transacciones {
    private Connection connection;

    public Ctr_Transacciones() {
        Conexionmysql conexion = new Conexionmysql();
        this.connection = conexion.getConnection(); // Inicializa la conexión
        if (this.connection == null) {
            System.out.println("Error: la conexión a la base de datos es nula.");
        }
    }


    // Crear una nueva transacción
    public boolean registrarTransaccion(Transacciones transaccion) {
        String query = "INSERT INTO transacciones (tipo_transaccion, monto, descripcion) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, transaccion.getTipo_transaccion());
            ps.setDouble(2, transaccion.getMonto());
            ps.setString(3, transaccion.getDescripcion());
            ps.executeUpdate();
            return true; // Éxito
        } catch (SQLException ex) {
            System.out.println("Error al registrar la transacción: " + ex.getMessage());
            return false; // Error
        }
    }

    // Obtener todas las transacciones
    public List<Transacciones> obtenerTransacciones() {
        List<Transacciones> listaTransacciones = new ArrayList<>();
        String query = "SELECT * FROM transacciones";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Transacciones transaccion = new Transacciones(
                        rs.getInt("id"),
                        rs.getString("tipo_transaccion"),
                        rs.getDouble("monto"),
                        rs.getString("fecha"),
                        rs.getString("descripcion")
                );
                listaTransacciones.add(transaccion);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener las transacciones: " + ex.getMessage());
        }
        return listaTransacciones;
    }

    // Obtener una transacción por ID
    public Transacciones obtenerTransaccionPorId(int id) {
        Transacciones transaccion = null;
        String query = "SELECT * FROM transacciones WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    transaccion = new Transacciones(
                            rs.getInt("id"),
                            rs.getString("tipo_transaccion"),
                            rs.getDouble("monto"),
                            rs.getString("fecha"),
                            rs.getString("descripcion")
                    );
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener la transacción por ID: " + ex.getMessage());
        }
        return transaccion;
    }

    // Actualizar una transacción
    public boolean actualizarTransaccion(Transacciones transaccion) {
        String query = "UPDATE transacciones SET tipo_transaccion = ?, monto = ?, descripcion = ? WHERE id = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            
            ps.setString(1, transaccion.getTipo_transaccion());
            ps.setDouble(2, transaccion.getMonto());
            ps.setString(3, transaccion.getDescripcion());
            ps.setInt(4, transaccion.getId());
            int rowsUpdated = ps.executeUpdate();
            
            return rowsUpdated > 0; // Retorna true si se actualizó
            
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la transacción: " + ex.getMessage());
            return false; // Error
        }
    }

    // Eliminar una transacción por ID
    public boolean eliminarTransaccion(int id) {
        String query = "DELETE FROM transacciones WHERE id = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0; // Retorna true si se eliminó
            
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la transacción: " + ex.getMessage());
            return false; // Error
        }
    }
}
