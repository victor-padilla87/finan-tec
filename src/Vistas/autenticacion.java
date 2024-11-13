package Vistas;

import Conexion.Conexionmysql;
import java.awt.Frame;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class autenticacion extends javax.swing.JDialog {

    private Conexionmysql conexionmysql;
    private boolean authenticated = false;
    private String moduloDestino;  // Variable para saber qué módulo abrir

    public autenticacion(Frame parent, boolean modal, String moduloDestino) {
        super(parent, modal);
        this.moduloDestino = moduloDestino; // Guardar el módulo al que se desea acceder
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

// Método para autenticar al usuario
    private void autenticarUsuario() throws java.sql.SQLException {
        conexionmysql = new Conexionmysql();
        String user = txtUsuario.getText();
        String pass = new String(txtPassword.getPassword());

        try (Connection cn = conexionmysql.conectar()) {
            String query = "SELECT rol FROM usuarios WHERE rol = ? AND password = ?";

            try (java.sql.PreparedStatement pst = cn.prepareStatement(query)) {
                pst.setString(1, user);
                pst.setString(2, pass);

                try (java.sql.ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        authenticated = true; // Autenticación exitosa
                    } else {
                        authenticated = false; // Fallo en la autenticación
                        JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jButton_aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Autenticacion"));

        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuario"));

        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder("Contraseña"));

        jButton_aceptar.setBackground(new java.awt.Color(0, 255, 255));
        jButton_aceptar.setText("Aceptar");
        jButton_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(txtUsuario))
                .addGap(104, 104, 104))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jButton_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aceptarActionPerformed
        try {
            autenticarUsuario(); // Método para autenticar al usuario

            if (authenticated) {
                this.dispose(); // Cerrar el diálogo de autenticación al autenticarse correctamente

                // Normalizamos el valor de moduloDestino eliminando espacios y convirtiendo a minúsculas
                String modulo = moduloDestino.trim().toLowerCase();

                // Abre el módulo correspondiente
                switch (modulo) {
                    case "facturacion":
                        ModuloFacturacion MF = new ModuloFacturacion(null, true);
                        MF.setVisible(true);
                        break;
                    case "inventario":
                        MenuInventario MI = new MenuInventario();
                        MI.setVisible(true);
                        break;
                    case "usuarios_roles":
                        MenuUsuarios_Roles UR = new MenuUsuarios_Roles();
                        UR.setVisible(true);
                        break;
                    case "PuntoDeVenta":
                        PuntoDeVenta PV = new PuntoDeVenta();
                        PV.setVisible(true);
                        break; 
                        case "Nomina":
                        Nomina nomina = new Nomina();
                        nomina.setVisible(true);
                        break;
                        case "Modulo Transacciones":
                        ModuloTransacciones transacciones = new ModuloTransacciones();
                        transacciones.setVisible(true);
                        break;
                    default:
                        return;  // Evitar continuar si el módulo no es reconocido 
                }

                this.setAlwaysOnTop(false);  // Asegura que no esté sobre las demás ventanas
            } else {
                JOptionPane.showMessageDialog(this, "Módulo no reconocido", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } catch (java.sql.SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de conexión: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        // Limpiar los campos si la autenticación falla
        this.txtUsuario.setText("");
        this.txtPassword.setText("");

    }//GEN-LAST:event_jButton_aceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(autenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(autenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(autenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(autenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                autenticacion dialog = new autenticacion(new javax.swing.JFrame(), true, "inventario");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_aceptar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public boolean isAuthenticated() {
        return authenticated;
    }

}
