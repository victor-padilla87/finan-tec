package controlador;

import Conexion.Conexionmysql;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Impuestos;
import java.sql.ResultSet;

public class Ctr_Impuestos {

    private Connection connection;

    public Ctr_Impuestos() {
        Conexionmysql conexion = new Conexionmysql();
        this.connection = conexion.getConnection();
    }

    public boolean registrarImpuesto(Impuestos impuesto) {
        // Orden correcto de las columnas en la consulta SQL
        String sql = "INSERT INTO impuestos (descripcion, tipoImpuesto, monto, fecha_vencimiento, referenciaPago, estado) VALUES (?, ?, ?, ?, ?, ?)";
        ResultSet generatedKeys = null;

        try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            // Asignación de valores en el orden correcto
            ps.setString(1, impuesto.getDescripcion()); // descripcion
            ps.setString(2, impuesto.getTipoImpuesto()); // tipoImpuesto
            ps.setDouble(3, impuesto.getMonto()); // monto

            // Validación de fecha de vencimiento
            if (impuesto.getFecha_vencimiento() != null) {
                ps.setDate(4, new java.sql.Date(impuesto.getFecha_vencimiento().getTime())); // fecha_vencimiento
            } else {
                ps.setNull(4, java.sql.Types.DATE);
            }

            // Validación de referencia de pago
            String referenciaPago = impuesto.getReferenciaPago();
            if (referenciaPago == null || referenciaPago.trim().isEmpty()) {
                ps.setString(5, "Sin Referencia"); // referencia_pago
            } else {
                ps.setString(5, referenciaPago); // referencia_pago
            }

            // Asignación del estado
            ps.setString(6, impuesto.getEstado()); // estado

            // Ejecución del PreparedStatement
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                // Recuperar el ID generado automáticamente
                generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    impuesto.setId(generatedId); // Asignar el ID al objeto
                }
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el ResultSet si fue creado
            if (generatedKeys != null) {
                try {
                    generatedKeys.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public List<Impuestos> obtenerImpuesto() {
        List<Impuestos> impuestos = new ArrayList<>();
        String sql = "SELECT * FROM impuestos";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Impuestos impuesto = new Impuestos(
                        rs.getInt("id"),
                        rs.getString("tipoImpuesto"),
                        rs.getString("descripcion"),
                        rs.getDouble("monto"),
                        rs.getDate("fecha_vencimiento"),
                        rs.getString("referenciaPago"),
                        rs.getString("estado")
                );
                impuestos.add(impuesto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return impuestos;
    }

    public boolean actualizarImpuesto(Impuestos impuesto) {
        String sql = "UPDATE impuestos SET tipoImpuesto = ?, descripcion = ?, monto = ?, fecha_vencimiento = ?, referenciaPago = ?, estado = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, impuesto.getTipoImpuesto());
            ps.setString(2, impuesto.getDescripcion());
            ps.setDouble(3, impuesto.getMonto());
            ps.setDate(4, new java.sql.Date(impuesto.getFecha_vencimiento().getTime()));
            ps.setString(5, impuesto.getReferenciaPago());
            ps.setString(6, impuesto.getEstado());
            ps.setInt(7, impuesto.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Impuestos obtenerImpuestoPorId(int id) {
        Impuestos impuesto = null;
        String sql = "SELECT * FROM impuestos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Asignamos también el ID al objeto impuesto
                impuesto = new Impuestos(
                        rs.getInt("id"), rs.getString("tipoImpuesto"),
                        rs.getString("descripcion"),
                        rs.getDouble("monto"),
                        rs.getDate("fecha_vencimiento"),
                        rs.getString("referenciaPago"),
                        rs.getString("estado")
                );
                impuesto.setId(rs.getInt("id")); // Asignación del ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return impuesto;
    }

    public boolean eliminarImpuesto(int id) {
        String sql = "DELETE FROM impuestos WHERE id = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);
            int resultado = pst.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
