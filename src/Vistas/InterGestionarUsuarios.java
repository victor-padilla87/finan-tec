package Vistas;

import Conexion.Conexionmysql;
import controlador.Ctr_Cliente;
import controlador.Ctr_Usuarios;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

public class InterGestionarUsuarios extends javax.swing.JInternalFrame {

    private int idUsuario;

    public InterGestionarUsuarios() {
        initComponents();
        this.setSize(new Dimension(1200, 500));
        this.setTitle("Gestionar Usuarios");

        this.CargarTablaUsuarios();
        this.CargarComboSeleccioneRol();

        // metodo para insertar imagen por medio de codigo
        ImageIcon wallpaper = new ImageIcon("src/imagenes/fondo3.jpg");
        Icon Icono = new ImageIcon(wallpaper.getImage().getScaledInstance(1200, 500, WIDTH));
        jLabel_wallpaper.setIcon(Icono);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_GestionUsuarios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_contraseña = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        jComboBox_seleccione_rol = new javax.swing.JComboBox<>();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestionar Usuarios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTable_GestionUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jTable_GestionUsuarios.setForeground(new java.awt.Color(0, 0, 0));
        jTable_GestionUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_GestionUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1150, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1170, 250));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 70, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Apellido:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Rol:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 150, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Contraseña:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 150, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Correo:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 90, -1));

        txt_nombre.setBackground(new java.awt.Color(255, 255, 255));
        txt_nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 190, 25));

        txt_contraseña.setBackground(new java.awt.Color(255, 255, 255));
        txt_contraseña.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 190, 25));

        txt_correo.setBackground(new java.awt.Color(255, 255, 255));
        txt_correo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 190, 25));

        txt_apellido.setBackground(new java.awt.Color(255, 255, 255));
        txt_apellido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 190, 25));

        jButton_Actualizar.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        jButton_Actualizar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(34, 210, 62));
        jButton_Actualizar.setText("Actualizar");
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 110, 40));

        jButton_Eliminar.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        jButton_Eliminar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton_Eliminar.setForeground(new java.awt.Color(221, 11, 10));
        jButton_Eliminar.setText("Elimanar");
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, 110, 40));

        jComboBox_seleccione_rol.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_seleccione_rol.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jComboBox_seleccione_rol.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox_seleccione_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Rol:", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox_seleccione_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 190, 25));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 1170, 160));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        if (txt_nombre.getText().isEmpty() || txt_apellido.getText().isEmpty() || txt_correo.getText().isEmpty() || txt_contraseña.getText().isEmpty() || jComboBox_seleccione_rol.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Complete todo los caompos");
        } else {
            Usuario usuario = new Usuario();
            Ctr_Usuarios controlUsuarios = new Ctr_Usuarios();

            usuario.setNombre(txt_nombre.getText().trim());
            usuario.setApellido(txt_apellido.getText().trim());
            usuario.setUsuario(txt_correo.getText().trim());
            usuario.setPassword(txt_contraseña.getText().trim());
            usuario.setRol(jComboBox_seleccione_rol.getSelectedItem().toString());
            usuario.setIdUsuario(idUsuario);

            if (controlUsuarios.Actualizar(usuario, idUsuario)) {
                JOptionPane.showMessageDialog(null, "Cliente Actualizado");
                this.CargarTablaUsuarios();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar el Usuario");
                this.Limpiar();
            }
        }

    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed

        Ctr_Usuarios controlUsuarios = new Ctr_Usuarios();

        if (idUsuario == 0) {
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un Usuario");
        } else {

            if (controlUsuarios.Eliminar(idUsuario)) {
                JOptionPane.showMessageDialog(null, "Usuario Eliminado");
                this.CargarTablaUsuarios();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar el usuario");
                this.Limpiar();
            }
        }
        
    }//GEN-LAST:event_jButton_EliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JComboBox<String> jComboBox_seleccione_rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_GestionUsuarios;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_contraseña;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    // Limpiar los campos del formulario
    private void Limpiar() {
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_contraseña.setText("");
        txt_correo.setText("");
        jComboBox_seleccione_rol.getSelectedItem();
    }
    
    // metodo para cargar el combo provvedores

    private void CargarComboSeleccioneRol() {

        // Obtener la conexión a la base de datos
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();
        String sql = "Select * from usuarios";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_seleccione_rol.removeAllItems();
            jComboBox_seleccione_rol.addItem("Seleccione rol:");
            while (rs.next()) {
                jComboBox_seleccione_rol.addItem(rs.getString("rol"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar los roles" + e);
        }

    }


// metodo para cargar la tabla usuarios
    private void CargarTablaUsuarios() {
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT * FROM usuarios";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            // Obtener referencia a la tabla existente
            InterGestionarUsuarios.jTable_GestionUsuarios.setModel(model);
            InterGestionarUsuarios.jScrollPane1.setViewportView(InterGestionarUsuarios.jTable_GestionUsuarios);

            // Añadir columnas al modelo
            model.addColumn("N");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Usuario");
            model.addColumn("Contraseña");
            model.addColumn("Rol");

            // Cargar los datos en el modelo
            while (rs.next()) {
                Object fila[] = new Object[6];
                fila[0] = rs.getInt("idUsuario");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("apellido");
                fila[3] = rs.getString("usuario");
                fila[4] = rs.getString("password");
                fila[5] = rs.getString("rol");

                model.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        jTable_GestionUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_GestionUsuarios.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idUsuario = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosUsuarioSeleccionado(idUsuario);
                }
            }
        });
    }

    private void EnviarDatosUsuarioSeleccionado(int idUsuario) {

        try {
            // Crear la conexión
            Conexionmysql conexion = new Conexionmysql();
            Connection cn = conexion.getConnection();

            // Preparar la consulta con el parámetro idCategoria
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM usuarios WHERE idUsuario = ?");

            // Asignar el valor del parámetro
            pst.setInt(1, idUsuario);

            // Ejecutar la consulta
            ResultSet rs = pst.executeQuery();

            // Si se encuentra el usuario, cargar la informacion en el campo de texto
            if (rs.next()) {
                txt_nombre.setText(rs.getString("nombre"));
                txt_apellido.setText(rs.getString("apellido"));
                txt_correo.setText(rs.getString("usuario"));
                txt_contraseña.setText(rs.getString("password"));
                jComboBox_seleccione_rol.getSelectedItem();

            }

            // Cerrar la conexión
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al seleccionar el cliente: " + e.getMessage());
        }
    }

}
