package Vistas;

import Conexion.Conexionmysql;
import controlador.Ctr_RegistroVenta;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.CabeceraVenta;

public class InterGestionarFactura extends javax.swing.JInternalFrame {

    private int idCliente = 0;
    private int idVenta;

    public InterGestionarFactura() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar Facturas");

        // cargar tabla
        this.CargarComboClientes();
        this.CargarTablaFacturas();

        // metodo para insertar imagen por medio de codigo
        ImageIcon wallpaper = new ImageIcon("src/imagenes/fondo3.jpg");
        Icon Icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
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

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Facturas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_Actulizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_TotalApagar = new javax.swing.JTextField();
        txt_Fecha = new javax.swing.JTextField();
        jComboBox_Cliente = new javax.swing.JComboBox<>();
        jComboBox_Estado = new javax.swing.JComboBox<>();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("Administrar Facturas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Facturas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable_Facturas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 670, 210));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 690, 230));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Actulizar.setBackground(new java.awt.Color(0, 255, 255));
        jButton_Actulizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_Actulizar.setForeground(new java.awt.Color(0, 0, 0));
        jButton_Actulizar.setText("Actualizar");
        jButton_Actulizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActulizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Actulizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 160, 230));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Total Apagar:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 110, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 110, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cliente:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 110, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Estado:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 110, -1));

        txt_TotalApagar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_TotalApagar.setEnabled(false);
        jPanel3.add(txt_TotalApagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 150, -1));

        txt_Fecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_Fecha.setEnabled(false);
        jPanel3.add(txt_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 150, -1));

        jComboBox_Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        jComboBox_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ClienteActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 170, -1));

        jComboBox_Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jComboBox_Estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_EstadoActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox_Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 860, 130));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_ClienteActionPerformed

    private void jComboBox_EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_EstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_EstadoActionPerformed

    private void jButton_ActulizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActulizarActionPerformed
        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        Ctr_RegistroVenta controlRegistroVenta = new Ctr_RegistroVenta();
        String cliente, estado;
        cliente = jComboBox_Cliente.getSelectedItem().toString().trim();
        estado = jComboBox_Estado.getSelectedItem().toString().trim();

        // verificar si se ha seleccionado un cliente
        if (cliente.equalsIgnoreCase("Seleccione cliente:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente válido");
            return;  // salir del método si no se selecciona un cliente válido
        }

        // obtener el id del cliente
        Conexionmysql conexion = new Conexionmysql();
        try (Connection cn = conexion.getConnection(); PreparedStatement pst = cn.prepareStatement("SELECT idCliente, CONCAT(nombre, ' ', apellido) AS cliente "
                + "FROM clientes WHERE CONCAT(nombre, ' ', apellido) = ?")) {

            pst.setString(1, cliente);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int idCliente = rs.getInt("idCliente");
                    cabeceraVenta.setIdCliente(idCliente);
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                    return;  // salir del método si no se encuentra el cliente
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el id del cliente: " + e.getMessage());
            return;
        }

        // verificar el valor de idVenta (asegúrate de que esta variable esté correctamente inicializada)
        if (idVenta == 0) {
            JOptionPane.showMessageDialog(null, "Error: idVenta no está definido");
            return;
        }

        // actualizar los datos del registro de venta
        if (estado.equalsIgnoreCase("Activo")) {
            cabeceraVenta.setEstado(1);  // estado activo
        } else if (estado.equalsIgnoreCase("Inactivo")) {
            cabeceraVenta.setEstado(0);  // estado inactivo
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un estado válido");
            return;
        }

        // actualizar el registro en la base de datos
        if (controlRegistroVenta.actualizar(cabeceraVenta, idVenta)) {
            JOptionPane.showMessageDialog(null, "¡Registro actualizado correctamente!");
            this.CargarTablaFacturas();  // recargar la tabla
            this.Limpiar();  // limpiar los campos del formulario
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el registro");
        }
    }//GEN-LAST:event_jButton_ActulizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actulizar;
    private javax.swing.JComboBox<String> jComboBox_Cliente;
    private javax.swing.JComboBox<String> jComboBox_Estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_wallpaper;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable_Facturas;
    private javax.swing.JTextField txt_Fecha;
    private javax.swing.JTextField txt_TotalApagar;
    // End of variables declaration//GEN-END:variables

    private void Limpiar() {
        this.txt_TotalApagar.setText("");
        this.txt_Fecha.setText("");
        this.jComboBox_Cliente.setSelectedItem("Seleccione cliente:");
        this.jComboBox_Estado.setSelectedItem("Activo");
        idCliente = 0;

    }

     private void CargarTablaFacturas() {
    Conexionmysql conexion = new Conexionmysql();
    Connection cn = conexion.getConnection();
    DefaultTableModel model = new DefaultTableModel();
    String sql = "SELECT cv.idCabeceraVenta as idCliente, concat(c.nombre, ' ', c.apellido) as clientes, "
               + "cv.valor_pagar as total, cv.fecha_venta as fecha, cv.estado "
               + "FROM cabecera_venta cv "
               + "INNER JOIN clientes c ON cv.idCliente = c.idCliente";  // Relación con INNER JOIN

    Statement st = null;
    ResultSet rs = null;

    try {
        st = cn.createStatement();
        rs = st.executeQuery(sql);

        // Configurar la tabla
        InterGestionarFactura.jScrollPane2.setViewportView(InterGestionarFactura.jTable_Facturas);
        model.addColumn("N");
        model.addColumn("Cliente");
        model.addColumn("Total Apagar");
        model.addColumn("Fecha Venta");
        model.addColumn("Estado");

        while (rs.next()) {
            Object[] fila = new Object[5];
            fila[0] = rs.getInt("idCliente");
            fila[1] = rs.getString("clientes");
            fila[2] = rs.getString("total");
            fila[3] = rs.getString("fecha");
            String estado = rs.getString("estado").equals("1") ? "Activo" : "Inactivo";
            fila[4] = estado;

            model.addRow(fila);
        }

        // Establecer el modelo de tabla
        InterGestionarFactura.jTable_Facturas.setModel(model);
        
        // Agregar el listener para detectar selección de facturas
        agregarListenerSeleccionTabla();

    } catch (SQLException e) {
        System.out.println("Error al cargar los datos: " + e.getMessage());
    } finally {
        // Cerrar recursos correctamente
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

    jTable_Facturas.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int fila_point = jTable_Facturas.rowAtPoint(e.getPoint());
            int columna_point = 0;

            if (fila_point > -1) {
                idVenta = (int) model.getValueAt(fila_point, columna_point);
                try {
                    EnviarDatosFacturaSeleccionada(idVenta);
                } catch (SQLException ex) {
                    Logger.getLogger(InterGestionarFactura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    });
}

    private void EnviarDatosFacturaSeleccionada(int idVenta) throws SQLException {
        // Instancia de la conexión
        Conexionmysql conexion = new Conexionmysql();
        try (Connection cn = conexion.getConnection()) {
            // Consulta SQL para obtener los datos de la factura y el cliente
            PreparedStatement pst = cn.prepareStatement("SELECT cv.idCabeceraVenta, concat(c.nombre, ' ', "
                    + "c.apellido) as clientes, cv.valor_pagar, cv.fecha_venta, cv.estado "
                    + "FROM cabecera_venta cv "
                    + "INNER JOIN clientes c ON cv.idCliente = c.idCliente  "
                    + "WHERE cv.idCabeceraVenta = ?");
            pst.setInt(1, idVenta); // Se usa un PreparedStatement para evitar inyecciones SQL

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                // Seleccionar el cliente en el ComboBox
                String cliente = rs.getString("clientes");
                jComboBox_Cliente.setSelectedItem(cliente);

                // Mostrar los datos de la factura en los campos de texto
                txt_TotalApagar.setText(rs.getString("valor_pagar"));
                txt_Fecha.setText(rs.getString("fecha_venta"));
                int estado = rs.getInt("estado");
                if (estado == 1) {
                    jComboBox_Estado.setSelectedItem("Activo");
                } else {
                    jComboBox_Estado.setSelectedItem("Inactivo");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar la factura: " + e);
        }
    }

    private void CargarComboClientes() {
        // Instancia de la conexión
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();
        // Consulta SQL
        String sql = "SELECT nombre, apellido FROM clientes";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            jComboBox_Cliente.removeAllItems();
            jComboBox_Cliente.addItem("Seleccione Cliente:");

            // Llenado del ComboBox con los clientes
            while (rs.next()) {
                jComboBox_Cliente.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        } catch (SQLException e) {
            System.out.println("No se pudieron cargar los clientes: " + e);
        } finally {
            try {
                if (cn != null && !cn.isClosed()) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex);
            }
        }
    }

    private void agregarListenerSeleccionTabla() {
        InterGestionarFactura.jTable_Facturas.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { // Solo actúa cuando la selección se ha completado
                int selectedRow = InterGestionarFactura.jTable_Facturas.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener el id de la factura seleccionada (columna 0)
                    int idVenta = (int) InterGestionarFactura.jTable_Facturas.getValueAt(selectedRow, 0);

                    // Enviar el idVenta al método que carga los datos de la factura
                    try {
                        EnviarDatosFacturaSeleccionada(idVenta);
                    } catch (SQLException ex) {
                        System.out.println("Error al cargar los datos de la factura seleccionada: " + ex);
                    }
                }
            }
        });
    }

    public boolean actualizar(CabeceraVenta objeto, int idCabecaraVenta, int idcliente) {
        boolean respuesta = false;
        // Instancia de la conexión
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "UPDATE cabecera_venta SET idCliente = ?, estado = ? WHERE idCabeceraVenta = ?");
            consulta.setInt(1, objeto.getIdCliente(idcliente));
            consulta.setInt(2, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cabecera venta" + e);

        }
        return respuesta;
    }

}
