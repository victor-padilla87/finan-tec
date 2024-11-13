
package Vistas;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
public class Nomina extends javax.swing.JFrame {

    public static JDesktopPane jDesktopPane_Inventario;
    
    public Nomina() {
        initComponents();
        this.setSize(new Dimension(1200, 700));
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Menu Inventario");
        this.setLayout(null);
        jDesktopPane_Inventario = new JDesktopPane();
        
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.jDesktopPane_Inventario.setBounds(0, 0, ancho, (alto - 110));
        this.add(jDesktopPane_Inventario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_AgregarEmpleado = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/producto.png"))); // NOI18N
        jMenu1.setText("Empleados");
        jMenu1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu1.setMinimumSize(new java.awt.Dimension(172, 50));
        jMenu1.setPreferredSize(new java.awt.Dimension(172, 50));

        jMenuItem_AgregarEmpleado.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem_AgregarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jMenuItem_AgregarEmpleado.setText("Agregar Empleado");
        jMenuItem_AgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AgregarEmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_AgregarEmpleado);

        jMenuItem2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/producto.png"))); // NOI18N
        jMenuItem2.setText("Gestionar Producto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo-producto.png"))); // NOI18N
        jMenuItem3.setText("Actualizar Stock");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categorias.png"))); // NOI18N
        jMenu2.setText("Categoria");
        jMenu2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu2.setMinimumSize(new java.awt.Dimension(172, 50));
        jMenu2.setPreferredSize(new java.awt.Dimension(172, 50));

        jMenuItem4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categorias.png"))); // NOI18N
        jMenuItem4.setText("Agregar Categoria");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categorias.png"))); // NOI18N
        jMenuItem5.setText("Gestionar Categoria");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedores1.png"))); // NOI18N
        jMenu3.setText("Proveedores");
        jMenu3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu3.setMinimumSize(new java.awt.Dimension(172, 50));
        jMenu3.setPreferredSize(new java.awt.Dimension(172, 50));

        jMenuItem6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedores1.png"))); // NOI18N
        jMenuItem6.setText("Agregar Proveedores");
        jMenu3.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedores1.png"))); // NOI18N
        jMenuItem7.setText("Gestionar Proveedores");
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportes.png"))); // NOI18N
        jMenu4.setText("Reportes");
        jMenu4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu4.setMinimumSize(new java.awt.Dimension(172, 50));
        jMenu4.setPreferredSize(new java.awt.Dimension(172, 50));

        jMenuItem8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte1.png"))); // NOI18N
        jMenuItem8.setText("R. Stock Bajo");
        jMenu4.add(jMenuItem8);

        jMenuItem9.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte1.png"))); // NOI18N
        jMenuItem9.setText("R. Ventas Por Producto");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte1.png"))); // NOI18N
        jMenuItem10.setText("R. Inventario Total");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/devoluciones32.png"))); // NOI18N
        jMenu5.setText("Devoluciones");
        jMenu5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu5.setMinimumSize(new java.awt.Dimension(172, 50));
        jMenu5.setPreferredSize(new java.awt.Dimension(172, 50));

        jMenuItem11.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/devoluciones32.png"))); // NOI18N
        jMenuItem11.setText("Registrar De Volucion");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuItem12.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/devoluciones32.png"))); // NOI18N
        jMenuItem12.setText("Gestionar Devolucion");
        jMenu5.add(jMenuItem12);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"))); // NOI18N
        jMenu6.setText("Cerrar Sesion");
        jMenu6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu6.setMinimumSize(new java.awt.Dimension(172, 50));
        jMenu6.setPreferredSize(new java.awt.Dimension(172, 50));

        jMenuItem13.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"))); // NOI18N
        jMenuItem13.setText("Cerrar Sesion");
        jMenu6.add(jMenuItem13);

        jMenuBar1.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/volver1.png"))); // NOI18N
        jMenu7.setText("Regresar");
        jMenu7.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu7.setMinimumSize(new java.awt.Dimension(172, 50));
        jMenu7.setPreferredSize(new java.awt.Dimension(172, 50));

        jMenuItem14.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/volver1.png"))); // NOI18N
        jMenuItem14.setText("Menu Principal");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem14);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem_AgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AgregarEmpleadoActionPerformed
        InterProducto producto = new InterProducto();
        jDesktopPane_Inventario.add(producto);
        producto.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem_AgregarEmpleadoActionPerformed

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
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nomina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItem_AgregarEmpleado;
    // End of variables declaration//GEN-END:variables
}
