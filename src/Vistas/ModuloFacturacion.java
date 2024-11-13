
package Vistas;

import com.itextpdf.text.DocumentException;
import controlador.Ctr_ReportesClientes;
import controlador.Ctr_ReportesFacturas;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;

public class ModuloFacturacion extends javax.swing.JDialog {

    public static JDesktopPane jDesktopPane_menu;

    public ModuloFacturacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(new Dimension(1300, 700));
        this.setLocationRelativeTo(null);
        this.setTitle("Menu Facturacion");

        this.setLayout(null);
        jDesktopPane_menu = new JDesktopPane();

        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.jDesktopPane_menu.setBounds(0, 0, ancho, (alto - 110));
        this.add(jDesktopPane_menu);

    }

    ModuloFacturacion() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1_Gestionar_facturas = new javax.swing.JMenu();
        jMenuItem1_Nueva_factura = new javax.swing.JMenuItem();
        jMenuItem_Gestionar_facturas = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7Nuevo_cliente = new javax.swing.JMenuItem();
        jMenuItem_Gestionar_clientes = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem_Historial_facturas = new javax.swing.JMenuItem();
        jMenuItem_Historial_reportes = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9Reportes = new javax.swing.JMenuItem();
        jMenuItem_ReporteClientes = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem_Configuracion_factura = new javax.swing.JMenuItem();
        jMenu6Cerrar_sesion = new javax.swing.JMenu();
        jMenuItem_Cerrear_sesion = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_volver_al_menu = new javax.swing.JMenuItem();

        jMenuItem6.setText("jMenuItem6");

        jMenuItem13.setText("jMenuItem13");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MODULO FACTURACION");
        setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        setResizable(false);

        jMenu1_Gestionar_facturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/carrito.png"))); // NOI18N
        jMenu1_Gestionar_facturas.setText(" Facturas");
        jMenu1_Gestionar_facturas.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu1_Gestionar_facturas.setPreferredSize(new java.awt.Dimension(186, 50));

        jMenuItem1_Nueva_factura.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem1_Nueva_factura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anadir.png"))); // NOI18N
        jMenuItem1_Nueva_factura.setText("Nueva factura");
        jMenuItem1_Nueva_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1_Nueva_facturaActionPerformed(evt);
            }
        });
        jMenu1_Gestionar_facturas.add(jMenuItem1_Nueva_factura);

        jMenuItem_Gestionar_facturas.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem_Gestionar_facturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuraciones.png"))); // NOI18N
        jMenuItem_Gestionar_facturas.setText("Gestionar facturas");
        jMenuItem_Gestionar_facturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Gestionar_facturasActionPerformed(evt);
            }
        });
        jMenu1_Gestionar_facturas.add(jMenuItem_Gestionar_facturas);

        jMenuBar1.add(jMenu1_Gestionar_facturas);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N
        jMenu2.setText("Clientes");
        jMenu2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(186, 50));

        jMenuItem7Nuevo_cliente.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem7Nuevo_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo-cliente.png"))); // NOI18N
        jMenuItem7Nuevo_cliente.setText("Nuevo cliente");
        jMenuItem7Nuevo_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7Nuevo_clienteActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7Nuevo_cliente);

        jMenuItem_Gestionar_clientes.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem_Gestionar_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N
        jMenuItem_Gestionar_clientes.setText("Gestionar clientes");
        jMenuItem_Gestionar_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Gestionar_clientesActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_Gestionar_clientes);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/producto.png"))); // NOI18N
        jMenu3.setText("Historial ");
        jMenu3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(186, 50));

        jMenuItem_Historial_facturas.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem_Historial_facturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/producto.png"))); // NOI18N
        jMenuItem_Historial_facturas.setText("Facturas");
        jMenuItem_Historial_facturas.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_Historial_facturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Historial_facturasActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_Historial_facturas);

        jMenuItem_Historial_reportes.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem_Historial_reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jMenuItem_Historial_reportes.setText("Reportes");
        jMenuItem_Historial_reportes.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_Historial_reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Historial_reportesActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_Historial_reportes);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportes.png"))); // NOI18N
        jMenu4.setText(" Reportes");
        jMenu4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(186, 50));

        jMenuItem9Reportes.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem9Reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte1.png"))); // NOI18N
        jMenuItem9Reportes.setText("Reporte facturas");
        jMenuItem9Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ReportesActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9Reportes);

        jMenuItem_ReporteClientes.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem_ReporteClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte1.png"))); // NOI18N
        jMenuItem_ReporteClientes.setText("Reporte Clientes");
        jMenuItem_ReporteClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ReporteClientesActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem_ReporteClientes);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuraciones.png"))); // NOI18N
        jMenu5.setText("Configuracion");
        jMenu5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu5.setPreferredSize(new java.awt.Dimension(186, 50));

        jMenuItem_Configuracion_factura.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem_Configuracion_factura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuraciones.png"))); // NOI18N
        jMenuItem_Configuracion_factura.setText("Configurar factura");
        jMenuItem_Configuracion_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Configuracion_facturaActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_Configuracion_factura);

        jMenuBar1.add(jMenu5);

        jMenu6Cerrar_sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"))); // NOI18N
        jMenu6Cerrar_sesion.setText("Cerrar sesion");
        jMenu6Cerrar_sesion.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu6Cerrar_sesion.setPreferredSize(new java.awt.Dimension(186, 50));

        jMenuItem_Cerrear_sesion.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem_Cerrear_sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"))); // NOI18N
        jMenuItem_Cerrear_sesion.setText("Cerrar sesion");
        jMenuItem_Cerrear_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Cerrear_sesionActionPerformed(evt);
            }
        });
        jMenu6Cerrar_sesion.add(jMenuItem_Cerrear_sesion);

        jMenuBar1.add(jMenu6Cerrar_sesion);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/volver1.png"))); // NOI18N
        jMenu1.setText("Regresar");
        jMenu1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(186, 50));

        jMenuItem_volver_al_menu.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem_volver_al_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/volver1.png"))); // NOI18N
        jMenuItem_volver_al_menu.setText("MenuPrincipal");
        jMenuItem_volver_al_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_volver_al_menuActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_volver_al_menu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_Historial_reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Historial_reportesActionPerformed
        InterHistorialReportes historialReportes = new InterHistorialReportes();
        jDesktopPane_menu.add(historialReportes);
        historialReportes.setVisible(true);
    }//GEN-LAST:event_jMenuItem_Historial_reportesActionPerformed

    private void jMenuItem_Historial_facturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Historial_facturasActionPerformed
        InterHistorialVentas historialVentas = new InterHistorialVentas();
        jDesktopPane_menu.add(historialVentas);
        historialVentas.setVisible(true);
    }//GEN-LAST:event_jMenuItem_Historial_facturasActionPerformed

    private void jMenuItem1_Nueva_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1_Nueva_facturaActionPerformed
        InterFacturacion interfacturacion = new InterFacturacion();
        jDesktopPane_menu.add(interfacturacion);
        interfacturacion.setVisible(true);
    }//GEN-LAST:event_jMenuItem1_Nueva_facturaActionPerformed

    private void jMenuItem7Nuevo_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7Nuevo_clienteActionPerformed
        InterCliente interCliente = new InterCliente();
        jDesktopPane_menu.add(interCliente);
        interCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem7Nuevo_clienteActionPerformed

    private void jMenuItem_Gestionar_facturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Gestionar_facturasActionPerformed
        InterGestionarFactura interGestionarFactura = new InterGestionarFactura();
        jDesktopPane_menu.add(interGestionarFactura);
        interGestionarFactura.setVisible(true);
    }//GEN-LAST:event_jMenuItem_Gestionar_facturasActionPerformed

    private void jMenuItem_Gestionar_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Gestionar_clientesActionPerformed
        InterGestionarClientes interGestionarClientes = new InterGestionarClientes();
        jDesktopPane_menu.add(interGestionarClientes);
        interGestionarClientes.setVisible(true);
    }//GEN-LAST:event_jMenuItem_Gestionar_clientesActionPerformed

    private void jMenuItem_Cerrear_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Cerrear_sesionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem_Cerrear_sesionActionPerformed

    private void jMenuItem_ReporteClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ReporteClientesActionPerformed
        Ctr_ReportesClientes reportes = new Ctr_ReportesClientes();
        try {
            reportes.ReportesClientes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModuloFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ModuloFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem_ReporteClientesActionPerformed

    private void jMenuItem9ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ReportesActionPerformed
        Ctr_ReportesFacturas reportesFacturas = new Ctr_ReportesFacturas();
        try {
            reportesFacturas.ReportesFacturas();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModuloFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ModuloFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem9ReportesActionPerformed

    private void jMenuItem_Configuracion_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Configuracion_facturaActionPerformed
        InterConfiguracionFacturas interConfiguracionFacturas = new InterConfiguracionFacturas();
        jDesktopPane_menu.add(interConfiguracionFacturas);
        interConfiguracionFacturas.setVisible(true);
    }//GEN-LAST:event_jMenuItem_Configuracion_facturaActionPerformed

    private void jMenuItem_volver_al_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_volver_al_menuActionPerformed
// Crear e inicializar una instancia de Paginaprincipal
         MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jMenuItem_volver_al_menuActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ModuloFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ModuloFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ModuloFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ModuloFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ModuloFacturacion dialog = new ModuloFacturacion(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu1_Gestionar_facturas;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6Cerrar_sesion;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem1_Nueva_factura;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7Nuevo_cliente;
    private javax.swing.JMenuItem jMenuItem9Reportes;
    private javax.swing.JMenuItem jMenuItem_Cerrear_sesion;
    private javax.swing.JMenuItem jMenuItem_Configuracion_factura;
    private javax.swing.JMenuItem jMenuItem_Gestionar_clientes;
    private javax.swing.JMenuItem jMenuItem_Gestionar_facturas;
    private javax.swing.JMenuItem jMenuItem_Historial_facturas;
    private javax.swing.JMenuItem jMenuItem_Historial_reportes;
    private javax.swing.JMenuItem jMenuItem_ReporteClientes;
    private javax.swing.JMenuItem jMenuItem_volver_al_menu;
    // End of variables declaration//GEN-END:variables

}
