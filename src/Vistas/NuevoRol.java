package Vistas;

import Conexion.Conexionmysql;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class NuevoRol {

    private JInternalFrame frameRoles;
    private DefaultTableModel tableModel;
    private JTable tableUsuarios;

    public NuevoRol(JDesktopPane desktopPane) {
        // Crear un nuevo JInternalFrame para la lista de roles y otros datos
        frameRoles = new JInternalFrame("Lista de Usuarios", true, true, true, true);
        frameRoles.setSize(800, 500);
        frameRoles.setLocation(50, 50);

        // Crear el panel principal con un fondo de imagen
        ImageIcon fondoImagen = new ImageIcon("src/imagenes/fondo3.jpg");
        Image imagenEscalada = fondoImagen.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        JLabel fondoLabel = new JLabel(new ImageIcon(imagenEscalada));
        fondoLabel.setLayout(new BorderLayout());
        frameRoles.setContentPane(fondoLabel);

        // Panel de contenido con GridBagLayout para centrar el título
        JPanel panelRoles = new JPanel(new GridBagLayout());
        panelRoles.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Configurar el título centrado
        JLabel lblTitulo = new JLabel("Lista de Usuarios", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 16));
        lblTitulo.setForeground(Color.WHITE);
        gbc.gridwidth = 2;
        panelRoles.add(lblTitulo, gbc);

        // Crear y poblar la tabla de usuarios con datos de la base de datos
        String[] columnNames = {"ID", "Nombre", "Rol", "Usuario"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tableUsuarios = new JTable(tableModel);

        // Ajustar el tamaño de la tabla y ancho de columnas
        tableUsuarios.setRowHeight(25);
        tableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
        tableUsuarios.getColumnModel().getColumn(1).setPreferredWidth(150);
        tableUsuarios.getColumnModel().getColumn(2).setPreferredWidth(150);
        tableUsuarios.getColumnModel().getColumn(3).setPreferredWidth(100);

        cargarDatosUsuarios();

        // Añadir la tabla a un JScrollPane para permitir desplazamiento
        JScrollPane scrollPane = new JScrollPane(tableUsuarios);
        scrollPane.setPreferredSize(new Dimension(750, 350)); // Ajuste de tamaño del JScrollPane
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH; // Hacer que el JScrollPane ocupe todo el espacio
        panelRoles.add(scrollPane, gbc);

        // Botón para añadir nuevo rol, centrado y con estilo
        JButton btnAgregarRol = new JButton("Agregar Nuevo Rol");
        btnAgregarRol.setFont(new Font("Arial Black", Font.BOLD, 14));
        btnAgregarRol.setBackground(new Color(34, 139, 34)); 
        btnAgregarRol.setForeground(Color.BLACK);
        btnAgregarRol.setFocusPainted(false);
        btnAgregarRol.addActionListener(e -> mostrarDialogoAgregarRol());
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER; // Centrar el botón
        panelRoles.add(btnAgregarRol, gbc);

        fondoLabel.add(panelRoles, BorderLayout.CENTER);

        // Añadir el frame al desktopPane proporcionado
        desktopPane.add(frameRoles);
        frameRoles.setVisible(true);
    }

    private void cargarDatosUsuarios() {
        String sql = "SELECT idUsuario, nombre, rol, usuario FROM usuarios";

        try (Connection cn = new Conexionmysql().getConnection(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            tableModel.setRowCount(0);

            while (rs.next()) {
                int idUsuario = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String rol = rs.getString("rol");
                String usuario = rs.getString("usuario");

                tableModel.addRow(new Object[]{idUsuario, nombre, rol, usuario});
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos de usuarios: " + e.getMessage());
        }
    }

    private void mostrarDialogoAgregarRol() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Agregar Nuevo Rol");
        dialog.setSize(400, 200);
        dialog.setLocationRelativeTo(frameRoles);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new java.awt.Insets(5, 5, 5, 5);

        JLabel lblNombreRol = new JLabel("Nombre del Rol:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(lblNombreRol, gbc);

        JTextField txtNombreRol = new JTextField();
        txtNombreRol.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtNombreRol, gbc);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Arial Black", Font.BOLD, 14));
        btnGuardar.setBackground(new Color(34, 139, 34)); // Color verde
        btnGuardar.setForeground(Color.BLACK);
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(e -> {
            String nombreRol = txtNombreRol.getText();
            if (!nombreRol.isEmpty()) {
                if (!rolDuplicado(nombreRol)) {
                    guardarNuevoRol(nombreRol);
                    cargarDatosUsuarios();
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "El rol ya existe. Ingrese un nombre de rol diferente.");
                }
            } else {
                JOptionPane.showMessageDialog(dialog, "Por favor ingrese un nombre para el rol.");
            }
        });

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(btnGuardar, gbc);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private void guardarNuevoRol(String nombreRol) {
        String sql = "INSERT INTO roles (nombre) VALUES (?)";

        try (Connection cn = new Conexionmysql().getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, nombreRol);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(frameRoles, "Rol agregado exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar el rol: " + e.getMessage());
            JOptionPane.showMessageDialog(frameRoles, "Error al agregar el rol.");
        }
    }

    private boolean rolDuplicado(String nombreRol) {
        String sql = "SELECT COUNT(*) FROM roles WHERE nombre = ?";

        try (Connection cn = new Conexionmysql().getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, nombreRol);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar rol duplicado: " + e.getMessage());
        }
        return false;
    }
}
