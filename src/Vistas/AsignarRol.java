package Vistas;

import Conexion.Conexionmysql;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AsignarRol extends JInternalFrame {

    public AsignarRol() {
        setTitle("Asignar Rol a Usuario");
        setSize(500, 300);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Cargar la imagen de fondo y escalarla
        ImageIcon fondoImagen = new ImageIcon("src/imagenes/fondo3.jpg");
        Image imagenEscalada = fondoImagen.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        JLabel fondoLabel = new JLabel(new ImageIcon(imagenEscalada));
        fondoLabel.setLayout(new BorderLayout());

        // Crear un panel de contenido con fondo transparente
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblUsuario = new JLabel("Seleccionar Usuario:");
        lblUsuario.setForeground(Color.WHITE);
        JComboBox<String> comboUsuarios = new JComboBox<>();
        cargarUsuarios(comboUsuarios);

        JLabel lblRol = new JLabel("Seleccionar Rol:");
        lblRol.setForeground(Color.WHITE);
        JComboBox<String> comboRoles = new JComboBox<>();
        cargarRoles(comboRoles);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblUsuario, gbc);

        gbc.gridx = 1;
        panel.add(comboUsuarios, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblRol, gbc);

        gbc.gridx = 1;
        panel.add(comboRoles, gbc);

        JButton btnAsignar = new JButton("Asignar Rol");
        btnAsignar.setBackground(Color.GREEN);
        btnAsignar.setFont(new Font("Arial Black", Font.BOLD, 14));
        btnAsignar.addActionListener(e -> {
            String usuarioSeleccionado = (String) comboUsuarios.getSelectedItem();
            String rolSeleccionado = (String) comboRoles.getSelectedItem();

            if (usuarioSeleccionado != null && rolSeleccionado != null) {
                asignarRol(usuarioSeleccionado, rolSeleccionado);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor seleccione un usuario y un rol.");
            }
        });

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(btnAsignar, gbc);

        fondoLabel.add(panel, BorderLayout.CENTER);
        setContentPane(fondoLabel);
    }

    private void cargarUsuarios(JComboBox<String> combo) {
        String sql = "SELECT usuario FROM usuarios";
        try (Connection cn = new Conexionmysql().getConnection(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                combo.addItem(rs.getString("usuario"));
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar los usuarios: " + e.getMessage());
        }
    }

    private void cargarRoles(JComboBox<String> combo) {
        String sql = "SELECT nombre FROM roles";
        try (Connection cn = new Conexionmysql().getConnection(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                combo.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar los roles: " + e.getMessage());
        }
    }

    private void asignarRol(String usuario, String rol) {
        String sql = "UPDATE usuarios SET rol = ? WHERE usuario = ?";
        try (Connection cn = new Conexionmysql().getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, rol);
            ps.setString(2, usuario);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Rol asignado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al asignar el rol: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error al asignar el rol.");
        }
    }
}
