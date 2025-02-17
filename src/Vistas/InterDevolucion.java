package Vistas;

import controlador.Ctr_Devoluciones;
import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import modelo.Devoluciones;

public class InterDevolucion extends javax.swing.JInternalFrame {

    private Ctr_Devoluciones controlador;

    public InterDevolucion() {

        controlador = new Ctr_Devoluciones();

        initComponents();

        // Crear el modelo de la tabla y añadir las columnas para que se vean inicialmente
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("IdProducto");
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        jTable_detalle_venta.setModel(model);

        this.setSize(new Dimension(650, 500));
        this.setTitle("Registro Devolucion");

        // metodo para insertar imagen por medio de codigo
        ImageIcon wallpaper = new ImageIcon("src/imagenes/fondo3.jpg");
        Icon Icono = new ImageIcon(wallpaper.getImage().getScaledInstance(800, 600, WIDTH));
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
        jLabel3 = new javax.swing.JLabel();
        txt_idfactura = new javax.swing.JTextField();
        jButto_buscar_venta = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_detalle_venta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_cantidad_devolucion = new javax.swing.JTextField();
        txt_motivo = new javax.swing.JTextField();
        jDateChooser_fecha_devolucion = new com.toedter.calendar.JDateChooser();
        jButton_registrar_devolucion = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro Devolucion");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 5, 250, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Id Factura:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 30));

        txt_idfactura.setBackground(new java.awt.Color(255, 255, 255));
        txt_idfactura.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txt_idfactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 170, 30));

        jButto_buscar_venta.setBackground(new java.awt.Color(17, 232, 229));
        jButto_buscar_venta.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButto_buscar_venta.setForeground(new java.awt.Color(0, 0, 0));
        jButto_buscar_venta.setText("Buscar Venta");
        jButto_buscar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButto_buscar_ventaActionPerformed(evt);
            }
        });
        getContentPane().add(jButto_buscar_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 150, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 91, 640, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_detalle_venta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_detalle_venta);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 290));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 310));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cantidad Para Devolucion:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 250, 30));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Motivo de la devolucion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 250, 30));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fecha:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 250, 30));

        txt_cantidad_devolucion.setBackground(new java.awt.Color(255, 255, 255));
        txt_cantidad_devolucion.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        txt_cantidad_devolucion.setForeground(new java.awt.Color(0, 0, 0));
        txt_cantidad_devolucion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txt_cantidad_devolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 200, 40));

        txt_motivo.setBackground(new java.awt.Color(255, 255, 255));
        txt_motivo.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        txt_motivo.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txt_motivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 200, 40));

        jDateChooser_fecha_devolucion.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser_fecha_devolucion.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jDateChooser_fecha_devolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 200, 40));

        jButton_registrar_devolucion.setBackground(new java.awt.Color(0, 204, 204));
        jButton_registrar_devolucion.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton_registrar_devolucion.setForeground(new java.awt.Color(0, 0, 0));
        jButton_registrar_devolucion.setText("Registrar Devolucion");
        jButton_registrar_devolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrar_devolucionActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_registrar_devolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 620, 330));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButto_buscar_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButto_buscar_ventaActionPerformed
        try {
            // Obtener el ID de factura desde el campo de texto
            int idVenta = Integer.parseInt(txt_idfactura.getText());

            // Llamar al método del controlador para buscar los productos de la venta
            ArrayList<Devoluciones> productos = controlador.buscarVenta(idVenta);

            // Crear un modelo de tabla y añadir las columnas
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("IdProducto");
            model.addColumn("Nombre");
            model.addColumn("Cantidad");

            // Cargar los datos en el modelo
            for (Devoluciones producto : productos) {
                Object[] fila = new Object[3];
                fila[0] = producto.getIdProducto();
                fila[1] = producto.getNombre_producto();
                fila[2] = producto.getCantidad_devuelta();
                model.addRow(fila);
            }

            // Asignar el modelo actualizado a la tabla
            jTable_detalle_venta.setModel(model);

            // Verificar si no se encontraron productos y mostrar mensaje si es el caso
            if (productos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron productos para la venta con ID: " + idVenta);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de factura válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButto_buscar_ventaActionPerformed

    private void jButton_registrar_devolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrar_devolucionActionPerformed
        try {
            // Obtener el ID de la factura desde el campo de texto
            int idFactura = Integer.parseInt(txt_idfactura.getText());

            // Obtener el ID del producto seleccionado en la tabla
            int selectedRow = jTable_detalle_venta.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un producto de la lista para registrar la devolución.");
                return;
            }

            int idProducto = (int) jTable_detalle_venta.getValueAt(selectedRow, 0);
            String nombreProducto = (String) jTable_detalle_venta.getValueAt(selectedRow, 1);

            // Obtener la cantidad devuelta desde el campo de texto
            int cantidadDevuelta = Integer.parseInt(txt_cantidad_devolucion.getText());

            // Obtener el motivo desde el campo de texto
            String motivo = txt_motivo.getText();

            // Obtener la fecha de devolución desde el selector de fecha
            Date fechaDevolucion = jDateChooser_fecha_devolucion.getDate();
            if (fechaDevolucion == null) {
                JOptionPane.showMessageDialog(this, "Seleccione una fecha de devolución.");
                return;
            }

            // Crear una instancia de Devoluciones
            Devoluciones devolucion = new Devoluciones(0, idFactura, idProducto, cantidadDevuelta, nombreProducto, motivo, fechaDevolucion);

            // Llamar al método del controlador para registrar la devolución
            boolean registroExitoso = controlador.registrarDevolucion(devolucion);

            if (registroExitoso) {
                // Actualizar la cantidad en la tabla producto y en el detalle de venta
                boolean actualizacionProductoExitosa = controlador.actualizarCantidadProducto(idProducto, cantidadDevuelta);
                boolean actualizacionDetalleVentaExitosa = controlador.actualizarCantidadYSubtotal(idFactura, idProducto, cantidadDevuelta);

                if (actualizacionProductoExitosa && actualizacionDetalleVentaExitosa) {
                    JOptionPane.showMessageDialog(this, "Devolución registrada y cantidades actualizadas con éxito.");

                    // Limpiar los campos después del registro
                    txt_idfactura.setText("");
                    txt_cantidad_devolucion.setText("");
                    txt_motivo.setText("");
                    jDateChooser_fecha_devolucion.setDate(null);

                    // Actualizar la tabla de detalle de venta después de la modificación
                    jButto_buscar_ventaActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar las cantidades en producto o detalle de venta.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar la devolución. Intente nuevamente.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos para la cantidad de devolución y el ID de factura.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_registrar_devolucionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButto_buscar_venta;
    private javax.swing.JButton jButton_registrar_devolucion;
    private com.toedter.calendar.JDateChooser jDateChooser_fecha_devolucion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTable jTable_detalle_venta;
    private javax.swing.JTextField txt_cantidad_devolucion;
    private javax.swing.JTextField txt_idfactura;
    private javax.swing.JTextField txt_motivo;
    // End of variables declaration//GEN-END:variables

    // Método para buscar una venta y mostrar los productos en la tabla
    private void buscarVenta() {
        try {
            int idVenta = Integer.parseInt(txt_idfactura.getText());
            ArrayList<Devoluciones> productos = controlador.buscarVenta(idVenta);

            DefaultTableModel model = (DefaultTableModel) jTable_detalle_venta.getModel();
            model.setRowCount(0); // Limpiar la tabla antes de mostrar los resultados

            for (Devoluciones producto : productos) {
                model.addRow(new Object[]{producto.getIdProducto(), producto.getNombre_producto(), producto.getCantidad_devuelta()});
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID de factura válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para actualizar la cantidad devuelta en el detalle de la venta
    private void actualizarCantidadDevuelta(int id_factura, int idProducto, int nuevaCantidadDevuelta) {
        if (controlador.actualizarCantidadYSubtotal(id_factura, idProducto, nuevaCantidadDevuelta)) {
            JOptionPane.showMessageDialog(this, "Cantidad devuelta actualizada en la base de datos.");
            buscarVenta(); // Actualiza la tabla con los datos modificados
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar la cantidad devuelta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
