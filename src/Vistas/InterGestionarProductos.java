package Vistas;

import Conexion.Conexionmysql;
import controlador.Ctr_Producto;
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
import modelo.Producto;

public class InterGestionarProductos extends javax.swing.JInternalFrame {

    private int idProducto;
    int obtenerIdCategoriaCombo = 0;

    private int idProveedor;

    public InterGestionarProductos() {
        initComponents();
        this.setSize(new Dimension(1200, 500));
        this.setTitle("Gestionar Productos");

        this.CargarTablaProductos();
        this.CargarComboProveedores();

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
        jTable_GestionProductos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_precio_venta = new javax.swing.JTextField();
        txt_precioCompra = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        jComboBox_seleccione_iva = new javax.swing.JComboBox<>();
        jComboBox_seleccione_proveedor = new javax.swing.JComboBox<>();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestionar Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTable_GestionProductos.setBackground(new java.awt.Color(255, 255, 255));
        jTable_GestionProductos.setForeground(new java.awt.Color(0, 0, 0));
        jTable_GestionProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_GestionProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1150, 210));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1170, 230));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 70, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Descripcion:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Precio unitario:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 150, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Precio de Compra:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 150, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Cantidad:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Iva:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 70, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Descuento:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 150, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Proveedor:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 150, -1));

        txt_nombre.setBackground(new java.awt.Color(255, 255, 255));
        txt_nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 190, -1));

        txt_precio_venta.setBackground(new java.awt.Color(255, 255, 255));
        txt_precio_venta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_precio_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 190, -1));

        txt_precioCompra.setBackground(new java.awt.Color(255, 255, 255));
        txt_precioCompra.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_precioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 190, -1));

        txt_cantidad.setEditable(false);
        txt_cantidad.setBackground(new java.awt.Color(255, 255, 255));
        txt_cantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_cantidad.setEnabled(false);
        jPanel3.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 190, -1));

        txt_descuento.setBackground(new java.awt.Color(255, 255, 255));
        txt_descuento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 190, 20));

        txt_descripcion.setBackground(new java.awt.Color(255, 255, 255));
        txt_descripcion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 190, 20));

        jComboBox_seleccione_iva.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_seleccione_iva.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox_seleccione_iva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione iva:", "no tiene iva", "16%", "19%" }));
        jComboBox_seleccione_iva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_seleccione_ivaActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox_seleccione_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 190, -1));

        jComboBox_seleccione_proveedor.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_seleccione_proveedor.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox_seleccione_proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione proveedor:", "item 1", "item 2", "item 3" }));
        jComboBox_seleccione_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_seleccione_proveedorActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox_seleccione_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 190, -1));

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
        jPanel3.add(jButton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, 110, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 1170, 180));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        if (!txt_nombre.getText().isEmpty()) {
            // Crear instancia de Producto y controlador
            Producto producto = new Producto();
            Ctr_Producto controlProducto = new Ctr_Producto();

            // Asignar los valores de los campos a los atributos del objeto Producto
            producto.setNombre(txt_nombre.getText().trim());
            producto.setDescripcion(txt_descripcion.getText().trim());
            producto.setPrecioCompra(Double.valueOf(txt_precioCompra.getText().trim()));
            producto.setPrecioUnitario(Double.valueOf(txt_precio_venta.getText().trim()));
            producto.setCantidad(Integer.parseInt(txt_cantidad.getText().trim()));

            // Validación del IVA seleccionado en el JComboBox
            String ivaSeleccionado = jComboBox_seleccione_iva.getSelectedItem().toString().trim();
            if (!ivaSeleccionado.equalsIgnoreCase("Seleccione IVA")) {
                // Remover el símbolo '%' antes de la conversión y dividir entre 100
                ivaSeleccionado = ivaSeleccionado.replace("%", "").trim();
                try {
                    double iva = Double.parseDouble(ivaSeleccionado) / 100.0;
                    producto.setPorcentajeIva(iva);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Seleccione un porcentaje de IVA válido.");
                    return;  // Salir del método si no se puede convertir el IVA
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un valor de IVA válido.");
                return;  // Salir del método si no se selecciona un valor de IVA válido
            }

            // Validación del proveedor seleccionado en el JComboBox
            String proveedorSeleccionado = jComboBox_seleccione_proveedor.getSelectedItem().toString().trim();
            if (!proveedorSeleccionado.equalsIgnoreCase("Seleccione proveedor:")) {
                producto.setProveedor(proveedorSeleccionado);  
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un proveedor válido.");
                return;  
            }

            // Actualizar el producto (utilizar idProducto en lugar de idProveedor)
            if (controlProducto.Actualizar(producto, idProducto)) {
                JOptionPane.showMessageDialog(null, "Se actualizó el producto correctamente");

                // Recargar la tabla de productos
                this.CargarTablaProductos();
                this.Limpiar();  // Limpiar los campos del formulario
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el producto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto.");
        }

    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed
        if (!txt_nombre.getText().isEmpty()) {
            Producto producto = new Producto();
            Ctr_Producto controlProducto = new Ctr_Producto();

            producto.setNombre(txt_nombre.getText().trim());
            if (controlProducto.Eliminar(idProducto)) {
                JOptionPane.showMessageDialog(null, "Se elimino un producto");
                txt_nombre.setText("");
                this.CargarTablaProductos();

            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        }
        this.Limpiar();
    }//GEN-LAST:event_jButton_EliminarActionPerformed

    private void jComboBox_seleccione_ivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_seleccione_ivaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_seleccione_ivaActionPerformed

    private void jComboBox_seleccione_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_seleccione_proveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_seleccione_proveedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Eliminar;
    private javax.swing.JComboBox<String> jComboBox_seleccione_iva;
    private javax.swing.JComboBox<String> jComboBox_seleccione_proveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_GestionProductos;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precioCompra;
    private javax.swing.JTextField txt_precio_venta;
    // End of variables declaration//GEN-END:variables

    // Limpiar los campos del formulario
    private void Limpiar() {
        txt_nombre.setText("");
        txt_descripcion.setText("");
        txt_precioCompra.setText("");
        txt_precio_venta.setText("");
        txt_cantidad.setText("");
        txt_descuento.setText("");
        jComboBox_seleccione_iva.setSelectedItem("Seleccione iva:");
        jComboBox_seleccione_proveedor.setSelectedItem("Seleccione proveedor:");

    }
// metodo para cargar el combo provvedores

    private void CargarComboProveedores() {

        // Obtener la conexión a la base de datos
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();
        String sql = "Select * from proveedores";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_seleccione_proveedor.removeAllItems();
            jComboBox_seleccione_proveedor.addItem("Seleccione proveedor:");
            while (rs.next()) {
                jComboBox_seleccione_proveedor.addItem(rs.getString("nombre"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar los proveedores" + e);
        }

    }

// metodo para cargar la tabla producto
    String nombreProveedor = "";
    double precio = 0.0;
    double precio_unitario = 0.0;
    int porcentajeIva = 0;
    double iva = 0;

    private void CargarTablaProductos() {
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT idProducto, nombre, descripcion, precio_compra, precio_unitario, cantidad, porcentaje_iva, descuento, proveedor FROM productos";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            // Obtener referencia a la tabla existente
            InterGestionarProductos.jTable_GestionProductos.setModel(model);
            InterGestionarProductos.jScrollPane1.setViewportView(InterGestionarProductos.jTable_GestionProductos);

            // Añadir columnas al modelo
            model.addColumn("N");
            model.addColumn("Nombre");
            model.addColumn("Descripcion");
            model.addColumn("Precio compra");
            model.addColumn("Precio venta");
            model.addColumn("Cantidad");
            model.addColumn("Iva");
            model.addColumn("Descuento");
            model.addColumn("Proveedor");

            // Cargar los datos en el modelo
            while (rs.next()) {
                Object fila[] = new Object[9];
                fila[0] = rs.getInt("idProducto");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("descripcion");
                fila[3] = rs.getDouble("precio_compra");
                fila[4] = rs.getDouble("precio_unitario");
                fila[5] = rs.getInt("cantidad");
                fila[6] = rs.getDouble("porcentaje_iva");
                fila[7] = rs.getDouble("descuento");
                fila[8] = rs.getString("proveedor");
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

        jTable_GestionProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_GestionProductos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idProducto = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosProductoSeleccionado(idProducto);
                }
            }
        });
    }

    // metodo para calcular el iva
    private double calcularIva(double precio_unitario, double iva) {
        // Calcular el porcentaje del IVA
        double porcentajeIva = (precio_unitario * (iva / 100));

        // Redondear el resultado a dos decimales
        porcentajeIva = Math.round(porcentajeIva * 100.0) / 100.0;

        return porcentajeIva;
    }
// metodo para mostrar los datos del producto seleccionadp
    private void EnviarDatosProductoSeleccionado(int idProducto) {

        try {
            // Crear la conexión
            Conexionmysql conexion = new Conexionmysql();
            Connection cn = conexion.getConnection();

            // Preparar la consulta con el parámetro idCategoria
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM productos WHERE idProducto = ?");

            // Asignar el valor del parámetro
            pst.setInt(1, idProducto);

            // Ejecutar la consulta
            ResultSet rs = pst.executeQuery();

            // Si se encuentra el producto, cargar los  datos en el campo de texto
            if (rs.next()) {
                txt_nombre.setText(rs.getString("nombre"));
                txt_descripcion.setText(rs.getString("descripcion"));
                txt_cantidad.setText(rs.getString("cantidad"));
                txt_precioCompra.setText(rs.getString("precio_compra"));
                txt_precio_venta.setText(rs.getString("precio_unitario"));
                txt_descuento.setText(rs.getString("descuento"));
                int iva = rs.getInt("porcentaje_iva");
            }

            // Cerrar la conexión
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al seleccionar la categoría: " + e.getMessage());
        }
    }

}
