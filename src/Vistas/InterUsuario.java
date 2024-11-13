/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Conexion.Conexionmysql;
import controlador.Ctr_Usuarios;
import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author User WOM (EIASA)
 */
public class InterUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form InterUsuario
     */
    public InterUsuario() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Nuevo Usuario");
        
        this.CargarComboRoles();

        // metodo para insertar imagen por medio de codigo
        ImageIcon wallpaper = new ImageIcon("src/imagenes/fondo3.jpg");
        Icon Icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        jLabel_wallpaper.setIcon(Icono);
        this.repaint();

        txt_contraseña.setVisible(true);
        txt_passwor_visible.setVisible(false);

        txt_confirmar_contraseña.setVisible(true);
        txt_passwor_visible1.setVisible(false);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        jComboBox_seleccione_rol = new javax.swing.JComboBox<>();
        jButton_agregarUsuario = new javax.swing.JButton();
        jButton_cancelar = new javax.swing.JButton();
        txt_contraseña = new javax.swing.JPasswordField();
        txt_confirmar_contraseña = new javax.swing.JPasswordField();
        jCheckBox_verClave = new javax.swing.JCheckBox();
        txt_passwor_visible1 = new javax.swing.JTextField();
        jCheckBox_password_visible = new javax.swing.JCheckBox();
        txt_passwor_visible = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agregar Nuevo Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 250, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Nombre:");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 30));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Contraseña:");
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 30));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Correo:");
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 30));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Apellidos:");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 30));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Confirmar Contraseña:");
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 30));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 190, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Rol:");
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 30));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 200, 30));

        txt_nombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 210, 30));

        txt_correo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 210, 30));

        txt_apellido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 210, 30));

        jComboBox_seleccione_rol.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jComboBox_seleccione_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Rol:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_seleccione_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_seleccione_rolActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_seleccione_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 210, 30));

        jButton_agregarUsuario.setBackground(new java.awt.Color(3, 124, 4));
        jButton_agregarUsuario.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton_agregarUsuario.setText("Agregar Usuario");
        jButton_agregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_agregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 210, 40));

        jButton_cancelar.setBackground(new java.awt.Color(237, 29, 9));
        jButton_cancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 210, 40));

        txt_contraseña.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txt_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 210, 30));

        txt_confirmar_contraseña.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_confirmar_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_confirmar_contraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_confirmar_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 210, 30));

        jCheckBox_verClave.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jCheckBox_verClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_verClaveMouseClicked(evt);
            }
        });
        getContentPane().add(jCheckBox_verClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 155, 20, 20));

        txt_passwor_visible1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txt_passwor_visible1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 210, 30));

        jCheckBox_password_visible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_password_visibleMouseClicked(evt);
            }
        });
        jCheckBox_password_visible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_password_visibleActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox_password_visible, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 149, 20, 30));

        txt_passwor_visible.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txt_passwor_visible, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 210, 30));

        jLabel_wallpaper.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_agregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarUsuarioActionPerformed
        if (txt_nombre.getText().isEmpty() || txt_apellido.getText().isEmpty() || txt_contraseña.getText().isEmpty()
                || txt_confirmar_contraseña.getText().isEmpty() || txt_correo.getText().isEmpty()
                || jComboBox_seleccione_rol.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        } else {
            // validar que el usuario no exista en la base de datos
            Usuario usuario = new Usuario();
            Ctr_Usuarios controlUsuarios = new Ctr_Usuarios();
            if (!controlUsuarios.existeUsuario(txt_correo.getText().trim())) {
                usuario.setNombre(txt_nombre.getText().trim());
                usuario.setApellido(txt_apellido.getText().trim());
                usuario.setUsuario(txt_correo.getText().trim());
                usuario.setPassword(txt_contraseña.getText().trim());
                usuario.setRol(jComboBox_seleccione_rol.getSelectedItem().toString());

                if (controlUsuarios.guardar(usuario)) {
                    JOptionPane.showMessageDialog(null, "Usuario registrado.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error a registra el usuario.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "el usuario ya se encuentra registardo");
            }
            this.Limpiar();
        }
    }//GEN-LAST:event_jButton_agregarUsuarioActionPerformed

    private void txt_confirmar_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_confirmar_contraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_confirmar_contraseñaActionPerformed

    private void jCheckBox_password_visibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_password_visibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_password_visibleActionPerformed

    private void jCheckBox_password_visibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_password_visibleMouseClicked
        if (jCheckBox_password_visible.isSelected()) {
            // Mostrar la contraseña como texto plano
            txt_contraseña.setEchoChar((char) 0);
        } else {
            // Volver a ocultar la contraseña
            txt_contraseña.setEchoChar('*'); // 
        }
    }//GEN-LAST:event_jCheckBox_password_visibleMouseClicked

    private void jCheckBox_verClaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_verClaveMouseClicked
        if (jCheckBox_verClave.isSelected()) {
            // Mostrar la contraseña como texto plano
            txt_confirmar_contraseña.setEchoChar((char) 0);
        } else {
            // Volver a ocultar la contraseña
            txt_confirmar_contraseña.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox_verClaveMouseClicked

    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
        // Limpiar los campos 
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_contraseña.setText("");
        txt_confirmar_contraseña.setText("");
        txt_correo.setText("");

        // Seleccionar el primer elemento o limpiar la selección del JComboBox
        jComboBox_seleccione_rol.setSelectedIndex(0); // Selecciona el primer ítem, que se espera sea "Seleccione Rol:"

        // Cierra el diálogo
        this.dispose();
    }//GEN-LAST:event_jButton_cancelarActionPerformed

    private void jComboBox_seleccione_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_seleccione_rolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_seleccione_rolActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_agregarUsuario;
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JCheckBox jCheckBox_password_visible;
    private javax.swing.JCheckBox jCheckBox_verClave;
    private javax.swing.JComboBox<String> jComboBox_seleccione_rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JPasswordField txt_confirmar_contraseña;
    private javax.swing.JPasswordField txt_contraseña;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_passwor_visible;
    private javax.swing.JTextField txt_passwor_visible1;
    // End of variables declaration//GEN-END:variables

//metodo para limpiar los campos
    private void Limpiar() {
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_contraseña.setText("");
        txt_confirmar_contraseña.setText("");
        txt_correo.setText("");
        jComboBox_seleccione_rol.setSelectedItem("Seleccione Rol:");

    }
    
    // metodo para cargar el combo roles

    private void CargarComboRoles() {

        // Obtener la conexión a la base de datos
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();
        String sql = "Select * from usuarios";
        Statement st;

        try {
            st = cn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            jComboBox_seleccione_rol.removeAllItems();
            jComboBox_seleccione_rol.addItem("Seleccione Rol:");
            while (rs.next()) {
                jComboBox_seleccione_rol.addItem(rs.getString("rol"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar los roles" + e);
        }

    }
}
