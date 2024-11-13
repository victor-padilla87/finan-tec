package Vistas;

import Conexion.Conexionmysql;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ListaDeUsuarios {

    private JInternalFrame frameRoles;

    public ListaDeUsuarios(JDesktopPane desktopPane) {
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
        panelRoles.setOpaque(false); // Fondo transparente para ver imagen
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Configurar el título centrado
        JLabel lblTitulo = new JLabel("Lista de Usuarios", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 16));
        lblTitulo.setForeground(Color.WHITE);
        gbc.gridwidth = 2; // Para centrar el título en la primera fila
        panelRoles.add(lblTitulo, gbc);

        // Crear y poblar la tabla de usuarios con datos de la base de datos
        String[] columnNames = {"N", "Nombre", "Rol", "Usuario"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable tableUsuarios = new JTable(tableModel);
        cargarDatosUsuarios(tableModel);

        // Añadir la tabla a un JScrollPane para permitir desplazamiento
        JScrollPane scrollPane = new JScrollPane(tableUsuarios);
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelRoles.add(scrollPane, gbc);

        fondoLabel.add(panelRoles, BorderLayout.CENTER);

        // Añadir el frame al desktopPane proporcionado
        desktopPane.add(frameRoles);
        frameRoles.setVisible(true);
    }

    // Método para cargar los datos de usuarios desde la base de datos en el modelo de la tabla
    private void cargarDatosUsuarios(DefaultTableModel tableModel) {
        String sql = "SELECT idUsuario, nombre, rol, usuario FROM usuarios"; 

        try (Connection cn = new Conexionmysql().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Limpiar datos anteriores
            tableModel.setRowCount(0);

            while (rs.next()) {
                // Extraer datos de cada fila
                int id = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String rol = rs.getString("rol");
                String usuario = rs.getString("usuario");
                

                // Añadir fila al modelo de la tabla
                tableModel.addRow(new Object[]{id, nombre, rol, usuario});
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos de usuarios: " + e.getMessage());
        }
    }
}
