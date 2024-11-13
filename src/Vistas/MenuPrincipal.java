package Vistas;

import Conexion.Conexionmysql;
import java.sql.Connection;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class MenuPrincipal extends javax.swing.JFrame {

    private String[] imagePaths = {"/imagenes/imagen1.jpg", "/imagenes/imagen2.jpg", "/imagenes/imagen3.jpg"};
    private int currentImageIndex = 0;
    private Timer timer;

    public MenuPrincipal() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(new Dimension(1200, 600));
        this.setTitle("Menu Principal");

        // Cambiar el fondo de la ventana a blanco
        getContentPane().setBackground(Color.WHITE);

        // Inicia la carga de imágenes y el carrusel
        loadAndShowImage(currentImageIndex);
        startImageCarousel();
    }

    private void loadAndShowImage(int index) {
        URL imageUrl = getClass().getResource(imagePaths[index]);
        if (imageUrl == null) {
            System.out.println("No se pudo encontrar la imagen: " + imagePaths[index]);
        } else {
            ImageIcon icon = new ImageIcon(imageUrl);
            Image image = icon.getImage();

            // Escalar la imagen para que se ajuste al tamaño del JLabel
            Image scaledImage = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);

            // Configurar JLabel para mostrar la imagen correctamente
            Label1.setIcon(icon);
            Label1.setOpaque(true);
            Label1.setHorizontalAlignment(JLabel.CENTER);
            Label1.setVerticalAlignment(JLabel.CENTER);

            Label1.repaint();
        }
    }

    private void startImageCarousel() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                currentImageIndex = (currentImageIndex + 1) % imagePaths.length;  // Cambia al siguiente índice de imagen
                loadAndShowImage(currentImageIndex);  // Carga y muestra la siguiente imagen
            }
        }, 0, 3000); // Cambia la imagen cada 3 segundos (3000 ms)
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton_PuntodeVenta = new javax.swing.JButton();
        jButton_Nomina = new javax.swing.JButton();
        jButton_moduloTransacciones = new javax.swing.JButton();
        jButton_Cuentas_porPagarYCobrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton_Inventario = new javax.swing.JButton();
        jButton_Facturacion = new javax.swing.JButton();
        jButton_UsuariosyRoles = new javax.swing.JButton();
        jButton_PagoImpuestos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Label1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Software Contable Finan Tec Bienvenido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 430));

        jButton_PuntodeVenta.setBackground(new java.awt.Color(0, 255, 255));
        jButton_PuntodeVenta.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton_PuntodeVenta.setText("Punto De Venta");
        jButton_PuntodeVenta.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton_PuntodeVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PuntodeVentaActionPerformed(evt);
            }
        });

        jButton_Nomina.setBackground(new java.awt.Color(0, 255, 255));
        jButton_Nomina.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton_Nomina.setText("Nomina");
        jButton_Nomina.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton_Nomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NominaActionPerformed(evt);
            }
        });

        jButton_moduloTransacciones.setBackground(new java.awt.Color(0, 255, 255));
        jButton_moduloTransacciones.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton_moduloTransacciones.setText("Transacciones");
        jButton_moduloTransacciones.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton_moduloTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_moduloTransaccionesActionPerformed(evt);
            }
        });

        jButton_Cuentas_porPagarYCobrar.setBackground(new java.awt.Color(0, 255, 255));
        jButton_Cuentas_porPagarYCobrar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton_Cuentas_porPagarYCobrar.setText("Cuentas/pagar/cobrar");
        jButton_Cuentas_porPagarYCobrar.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton_Cuentas_porPagarYCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Cuentas_porPagarYCobrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_PuntodeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Nomina, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_moduloTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Cuentas_porPagarYCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jButton_PuntodeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton_Nomina, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton_moduloTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton_Cuentas_porPagarYCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 200, 430));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(150, 430));

        jButton_Inventario.setBackground(new java.awt.Color(0, 255, 255));
        jButton_Inventario.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton_Inventario.setText("Inventario");
        jButton_Inventario.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton_Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InventarioActionPerformed(evt);
            }
        });

        jButton_Facturacion.setBackground(new java.awt.Color(0, 255, 255));
        jButton_Facturacion.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton_Facturacion.setText("Facturacion");
        jButton_Facturacion.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton_Facturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FacturacionActionPerformed(evt);
            }
        });

        jButton_UsuariosyRoles.setBackground(new java.awt.Color(0, 255, 255));
        jButton_UsuariosyRoles.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton_UsuariosyRoles.setText("Gestion De Roles");
        jButton_UsuariosyRoles.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton_UsuariosyRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UsuariosyRolesActionPerformed(evt);
            }
        });

        jButton_PagoImpuestos.setBackground(new java.awt.Color(0, 255, 255));
        jButton_PagoImpuestos.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton_PagoImpuestos.setText("Pago Impuestos");
        jButton_PagoImpuestos.setPreferredSize(new java.awt.Dimension(100, 50));
        jButton_PagoImpuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PagoImpuestosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_UsuariosyRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Facturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_PagoImpuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jButton_Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton_Facturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton_UsuariosyRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton_PagoImpuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 50, 200, 430));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        Label1.setBackground(new java.awt.Color(255, 255, 255));
        Label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Label1.setPreferredSize(new java.awt.Dimension(709, 389));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 710, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_FacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FacturacionActionPerformed
        // Crear una instancia de autenticación para el módulo de facturación
        autenticacion autenticacionDialog = new autenticacion(null, true, "facturacion");
        autenticacionDialog.setVisible(true); // Mostrar el diálogo modal y esperar a que se cierre

        // Verificar si la autenticación fue exitosa
        if (autenticacionDialog.isAuthenticated()) {
            ModuloFacturacion MF = new ModuloFacturacion(null, true);
            MF.setVisible(true);

            // Cerrar la ventana de autenticación y la ventana de inicio de sesión
            autenticacionDialog.dispose();
            this.dispose();
        } else {
            System.out.println("Acceso denegado a la facturación");
        }
        this.dispose();
    }//GEN-LAST:event_jButton_FacturacionActionPerformed

    private void jButton_NominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NominaActionPerformed
        // Crear una instancia de autenticación para el módulo de inventario
        autenticacion autenticacionDialog = new autenticacion(null, true, "Punto de Venta");
        autenticacionDialog.setVisible(true); // Mostrar el diálogo modal y esperar a que se cierre

        // Verificar si la autenticación fue exitosa
        if (autenticacionDialog.isAuthenticated()) {
            // Obtener la conexión a la base de datos
            Conexionmysql conexion = new Conexionmysql();
            Connection cn = conexion.getConnection();

            // Crear una instancia de MenuNomina y pasar la conexión
            MenuNomina nomina = new MenuNomina();
            nomina.setVisible(true);

            // Cerrar la ventana de autenticación y la ventana de inicio de sesión
            autenticacionDialog.dispose();
        } else {
            System.out.println("Acceso denegado al punto de venta");
        }

        this.setAlwaysOnTop(false);  // Esto asegura que no esté sobre las demás ventanas
        this.dispose();
    }//GEN-LAST:event_jButton_NominaActionPerformed

    private void jButton_PuntodeVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PuntodeVentaActionPerformed
        // Crear una instancia de autenticación para el módulo de inventario
        autenticacion autenticacionDialog = new autenticacion(null, true, "Punto de Venta");
        autenticacionDialog.setVisible(true); // Mostrar el diálogo modal y esperar a que se cierre

        // Verificar si la autenticación fue exitosa
        if (autenticacionDialog.isAuthenticated()) {
            PuntoDeVenta puntoVenta = new PuntoDeVenta();
            puntoVenta.setVisible(true);

            // Cerrar la ventana de autenticación y la ventana de inicio de sesión
            autenticacionDialog.dispose();

        } else {
            System.out.println("Acceso denegado al punto de venta");
        }
        this.setAlwaysOnTop(false);  // Esto asegura que no esté sobre las demás ventanas
        this.dispose();
    }//GEN-LAST:event_jButton_PuntodeVentaActionPerformed

    private void jButton_UsuariosyRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UsuariosyRolesActionPerformed
        // Crear una instancia de autenticación para el módulo de inventario
        autenticacion autenticacionDialog = new autenticacion(null, true, "Gestion roles");
        autenticacionDialog.setVisible(true); // Mostrar el diálogo modal y esperar a que se cierre

        // Verificar si la autenticación fue exitosa
        if (autenticacionDialog.isAuthenticated()) {
            MenuUsuarios_Roles MenuUsuarios_Roles = new MenuUsuarios_Roles();
            MenuUsuarios_Roles.setVisible(true);

            // Cerrar la ventana de autenticación y la ventana de inicio de sesión
            autenticacionDialog.dispose();

        } else {
            System.out.println("Acceso denegado al Gestion de usuarios y roles");
        }
        this.setAlwaysOnTop(false);  // Esto asegura que no esté sobre las demás ventanas
        this.dispose();
    }//GEN-LAST:event_jButton_UsuariosyRolesActionPerformed

    private void jButton_InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InventarioActionPerformed
        // Crear una instancia de autenticación para el módulo de inventario
        autenticacion autenticacionDialog = new autenticacion(null, true, "inventario");
        autenticacionDialog.setVisible(true); // Mostrar el diálogo modal y esperar a que se cierre

        // Verificar si la autenticación fue exitosa
        if (autenticacionDialog.isAuthenticated()) {
            Nomina inventario = new Nomina();
            // Cerrar la ventana de autenticación y la ventana de inicio de sesión
            autenticacionDialog.dispose();

        } else {
            System.out.println("Acceso denegado al inventario");
        }
        this.setAlwaysOnTop(false);  // Esto asegura que no esté sobre las demás ventanas
        this.dispose();
    }//GEN-LAST:event_jButton_InventarioActionPerformed

    private void jButton_moduloTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_moduloTransaccionesActionPerformed
        // Crear una instancia de autenticación para el módulo de inventario
        autenticacion autenticacionDialog = new autenticacion(null, true, "Modulo transacciones");
        autenticacionDialog.setVisible(true); // Mostrar el diálogo modal y esperar a que se cierre

        // Verificar si la autenticación fue exitosa
        if (autenticacionDialog.isAuthenticated()) {
            ModuloTransacciones transacciones = new ModuloTransacciones();
            transacciones.setVisible(true);

            // Cerrar la ventana de autenticación y la ventana de inicio de sesión
            autenticacionDialog.dispose();

        } else {
            System.out.println("Acceso denegado al Modulo transacciones");
        }
        this.setAlwaysOnTop(false);  // Esto asegura que no esté sobre las demás ventanas
        this.dispose();
    }//GEN-LAST:event_jButton_moduloTransaccionesActionPerformed

    private void jButton_Cuentas_porPagarYCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cuentas_porPagarYCobrarActionPerformed
        // Crear una instancia de autenticación para el módulo de facturación
        autenticacion autenticacionDialog = new autenticacion(null, true, "Modulo Cuentas");
        autenticacionDialog.setVisible(true); // Mostrar el diálogo modal y esperar a que se cierre

        // Verificar si la autenticación fue exitosa
        if (autenticacionDialog.isAuthenticated()) {
            ModuloCuentas moduloCuentas = new ModuloCuentas();
            moduloCuentas.setVisible(true);

            // Cerrar la ventana de autenticación y la ventana de inicio de sesión
            autenticacionDialog.dispose();
            this.dispose();
        } else {
            System.out.println("Acceso denegado a la Modulo Cuentas");
        }
        this.dispose();
    }//GEN-LAST:event_jButton_Cuentas_porPagarYCobrarActionPerformed

    private void jButton_PagoImpuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PagoImpuestosActionPerformed
        // Crear una instancia de autenticación para el módulo de facturación
        autenticacion autenticacionDialog = new autenticacion(null, true, "Modulo Cuentas");
        autenticacionDialog.setVisible(true); // Mostrar el diálogo modal y esperar a que se cierre

        // Verificar si la autenticación fue exitosa
        if (autenticacionDialog.isAuthenticated()) {
            ModuloPagoImpuestos pagoImpuestos = new ModuloPagoImpuestos();
            pagoImpuestos.setVisible(true);

            // Cerrar la ventana de autenticación y la ventana de inicio de sesión
            autenticacionDialog.dispose();
            this.dispose();
        } else {
            System.out.println("Acceso denegado a la Modulo pago de impuestos");
        }
        this.dispose();
    }//GEN-LAST:event_jButton_PagoImpuestosActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label1;
    private javax.swing.JButton jButton_Cuentas_porPagarYCobrar;
    private javax.swing.JButton jButton_Facturacion;
    private javax.swing.JButton jButton_Inventario;
    private javax.swing.JButton jButton_Nomina;
    private javax.swing.JButton jButton_PagoImpuestos;
    private javax.swing.JButton jButton_PuntodeVenta;
    private javax.swing.JButton jButton_UsuariosyRoles;
    private javax.swing.JButton jButton_moduloTransacciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
