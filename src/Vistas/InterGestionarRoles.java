package Vistas;

import Conexion.Conexionmysql;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class InterGestionarRoles extends JInternalFrame {

    private JTable tableRoles;
    private JButton btnActualizar, btnEliminar;
    private DefaultTableModel model;

    public InterGestionarRoles() {
        // Configuraciones del JInternalFrame
        super("Gestionar Roles", true, true, true, true);
        setSize(500, 400);
        setLocation(10, 10);

        // Configuración de la tabla
        model = new DefaultTableModel(new String[]{"ID", "Nombre del Rol"}, 0);
        tableRoles = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableRoles);

        // Botones
        btnActualizar = new JButton("Actualizar Rol");
        btnEliminar = new JButton("Eliminar Rol");

        // Cambiar el color de fondo y el estilo de fuente de los botones
        btnActualizar.setBackground(Color.GREEN);
        btnActualizar.setFont(new Font("Arial Black", Font.BOLD, 14));
        btnEliminar.setBackground(Color.GREEN);
        btnEliminar.setFont(new Font("Arial Black", Font.BOLD, 14));

        JPanel panel = new JPanel();
        panel.add(btnActualizar);
        panel.add(btnEliminar);

        add(scrollPane, "Center");
        add(panel, "South");

        cargarRoles();

        // Eventos
        btnActualizar.addActionListener(e -> actualizarRol());
        btnEliminar.addActionListener(e -> eliminarRol());
    }

    // Métodos cargarRoles, actualizarRol, y eliminarRol permanecen iguales.
    private void cargarRoles() {
        try {
            Conexionmysql conexion = new Conexionmysql();
            Connection cn = conexion.getConnection();
            String query = "SELECT * FROM roles";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // Limpiar la tabla antes de agregar los datos nuevos
            DefaultTableModel model = (DefaultTableModel) tableRoles.getModel();
            model.setRowCount(0);

            // Cargar los datos en la tabla
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("id"), rs.getString("nombre")});
            }

            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar roles: " + ex.getMessage());
        }
    }

    private void actualizarRol() {
        int selectedRow = tableRoles.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tableRoles.getValueAt(selectedRow, 0);
            String nuevoNombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre del rol:");

            if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                try {
                    Conexionmysql conexion = new Conexionmysql();
                    Connection cn = conexion.getConnection();
                    String query = "UPDATE roles SET nombre = ? WHERE id = ?";
                    PreparedStatement ps = cn.prepareStatement(query);
                    ps.setString(1, nuevoNombre);
                    ps.setInt(2, id);

                    int rowsAffected = ps.executeUpdate();
                    if (rowsAffected > 0) {
                        // Actualizar el valor en la tabla
                        tableRoles.setValueAt(nuevoNombre, selectedRow, 1);
                        JOptionPane.showMessageDialog(this, "Rol actualizado correctamente.");
                    }

                    ps.close();
                    cn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar rol: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un rol para actualizar.");
        }
    }

    private void eliminarRol() {
        int selectedRow = tableRoles.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) tableRoles.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este rol?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Conexionmysql conexion = new Conexionmysql();
                    Connection cn = conexion.getConnection();
                    String query = "DELETE FROM roles WHERE id = ?";
                    PreparedStatement ps = cn.prepareStatement(query);
                    ps.setInt(1, id);

                    int rowsAffected = ps.executeUpdate();
                    if (rowsAffected > 0) {
                        // Remover la fila de la tabla
                        ((DefaultTableModel) tableRoles.getModel()).removeRow(selectedRow);
                        JOptionPane.showMessageDialog(this, "Rol eliminado correctamente.");
                    }

                    ps.close();
                    cn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar rol: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un rol para eliminar.");
        }
    }

}
