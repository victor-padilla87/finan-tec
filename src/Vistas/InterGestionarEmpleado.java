package Vistas;

import Conexion.Conexionmysql;
import controlador.Ctr_Empleado;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;

public class InterGestionarEmpleado extends javax.swing.JInternalFrame {

    private int idempleado;

    private int idProveedor;

    public InterGestionarEmpleado() {
        initComponents();
        this.setSize(new Dimension(1200, 573));
        this.setTitle("Gestionar Empleados");

        this.CargarTablaEmpleados();

        // metodo para insertar imagen por medio de codigo
        ImageIcon wallpaper = new ImageIcon("src/imagenes/fondo3.jpg");
        Icon Icono = new ImageIcon(wallpaper.getImage().getScaledInstance(1200, 600, WIDTH));
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
        jTable_GestionEmpleado = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_cargo = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_salario = new javax.swing.JTextField();
        txt_eps = new javax.swing.JTextField();
        txt_pension = new javax.swing.JTextField();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_Eliminar = new javax.swing.JButton();
        jDateChooser_fechaIngreso = new com.toedter.calendar.JDateChooser();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestionar Empleado");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTable_GestionEmpleado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_GestionEmpleado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1150, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1170, 250));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cedula:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 90, 110, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 110, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Telefono:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 120, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Direccion:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 130, 110, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Apellido:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, 110, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Cargo:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 120, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Salario:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 120, -1));

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Eps:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 120, -1));

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Pensiones:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 120, -1));

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Fecha INgreso:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 120, -1));

        txt_cedula.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 190, 25));

        txt_telefono.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 190, 25));

        txt_direccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 190, 25));

        txt_apellido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 190, 25));

        txt_cargo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 190, 25));

        txt_nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 190, 25));

        txt_salario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 190, 25));

        txt_eps.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_eps, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 190, 25));

        txt_pension.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txt_pension, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 190, 25));

        jButton_Actualizar.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        jButton_Actualizar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(34, 210, 62));
        jButton_Actualizar.setText("Actualizar");
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 110, 40));

        jButton_Eliminar.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        jButton_Eliminar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton_Eliminar.setForeground(new java.awt.Color(221, 11, 10));
        jButton_Eliminar.setText("Elimanar");
        jButton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, 110, 40));
        jPanel3.add(jDateChooser_fechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 190, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 1170, 220));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        if (txt_nombre.getText().isEmpty()
                || txt_apellido.getText().isEmpty()
                || txt_cedula.getText().isEmpty()
                || txt_direccion.getText().isEmpty()
                || txt_telefono.getText().isEmpty()
                || txt_cargo.getText().isEmpty()
                || txt_salario.getText().isEmpty()
                || txt_eps.getText().isEmpty()
                || txt_pension.getText().isEmpty()
                || jDateChooser_fechaIngreso.getDate().after(new Date())) {

            JOptionPane.showMessageDialog(null, "Complete todos los campos.");
        } else {
            Empleado empleado = new Empleado();
            Ctr_Empleado controlEmpleado = new Ctr_Empleado();

            empleado.setNombre(txt_nombre.getText().trim());
            empleado.setApellido(txt_apellido.getText().trim());
            empleado.setCedula(txt_cedula.getText().trim());
            empleado.setDireccion(txt_direccion.getText().trim());
            empleado.setTelefono(txt_telefono.getText().trim());
            empleado.setCargo(txt_cargo.getText().trim());
            empleado.setSalario(Double.parseDouble(txt_salario.getText().trim()));
            empleado.setEps(txt_eps.getText().trim());
            empleado.setFondo_pensiones(txt_pension.getText().trim());

            // Convertir la fecha de ingreso a cadena
            Date fechaIngreso = jDateChooser_fechaIngreso.getDate();
            java.sql.Date fechaIngresoSQL = new java.sql.Date(fechaIngreso.getTime());
            empleado.setFechaIngreso(fechaIngresoSQL.toString());

            empleado.setIdempleado(idempleado);

            if (controlEmpleado.Actualizar(empleado, idempleado)) {
                JOptionPane.showMessageDialog(null, "Empleado actualizado.");
                this.CargarTablaEmpleados();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el Empleado.");
                this.Limpiar();
            }
        }
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarActionPerformed

        Ctr_Empleado controlEmpleado = new Ctr_Empleado();

        if (idempleado == 0) {
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un empleado");
        } else {
            // Cambiamos la lógica para que el mensaje de éxito aparezca cuando controlCliente.Eliminar(idEmpleado) devuelva true
            if (controlEmpleado.eliminarEmpleado(idempleado)) {
                JOptionPane.showMessageDialog(null, "Empleado Eliminado");
                this.CargarTablaEmpleados(); // Actualiza la tabla de empleados
                this.Limpiar(); // Limpia los campos
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar el empleado. Verifique que el empleado exista.");
                this.Limpiar();
            }
        }
    }//GEN-LAST:event_jButton_EliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Eliminar;
    private com.toedter.calendar.JDateChooser jDateChooser_fechaIngreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_GestionEmpleado;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cargo;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_eps;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_pension;
    private javax.swing.JTextField txt_salario;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

    // Limpiar los campos del formulario
    private void Limpiar() {
        txt_nombre.setText("");
        txt_direccion.setText("");
        txt_cedula.setText("");
        txt_telefono.setText("");
        txt_apellido.setText("");
        txt_cargo.setText("");
        txt_salario.setText("");
        txt_eps.setText("");
        txt_pension.setText("");
        jDateChooser_fechaIngreso.setDate(null);
    }

// metodo para cargar la tabla empleados
    private void CargarTablaEmpleados() {
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT * FROM empleados";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            // Obtener referencia a la tabla existente
            InterGestionarEmpleado.jTable_GestionEmpleado.setModel(model);
            InterGestionarEmpleado.jScrollPane1.setViewportView(InterGestionarEmpleado.jTable_GestionEmpleado);

            // Añadir columnas al modelo
            model.addColumn("N");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Cedula");
            model.addColumn("Direccion");
            model.addColumn("Telefono");
            model.addColumn("Cargo");
            model.addColumn("Salario");
            model.addColumn("Eps");
            model.addColumn("Fondo de Pensiones");
            model.addColumn("Fecha Ingreso");

            // Cargar los datos en el modelo
            while (rs.next()) {
                Object fila[] = new Object[11];
                fila[0] = rs.getInt("idempleado");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("apellido");
                fila[3] = rs.getString("cedula");
                fila[4] = rs.getString("direccion");
                fila[5] = rs.getString("telefono");
                fila[6] = rs.getString("cargo");
                fila[7] = rs.getDouble("salario");
                fila[8] = rs.getString("eps");
                fila[9] = rs.getString("fondo_pensiones");
                fila[10] = rs.getString("fechaIngreso");
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
        jTable_GestionEmpleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_GestionEmpleado.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idempleado = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosEmpleadoSeleccionado(idempleado);
                }
            }
        });
    }

    private void EnviarDatosEmpleadoSeleccionado(int idempleado) {

        try {
            // Crear la conexión
            Conexionmysql conexion = new Conexionmysql();
            Connection cn = conexion.getConnection();

            // Preparar la consulta con el parámetro idCategoria
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM empleados WHERE idempleado = ?");

            // Asignar el valor del parámetro
            pst.setInt(1, idempleado);

            // Ejecutar la consulta
            ResultSet rs = pst.executeQuery();

            // Si se encuentra el producto, cargar la descripción en el campo de texto
            if (rs.next()) {
                txt_nombre.setText(rs.getString("nombre"));
                txt_apellido.setText(rs.getString("apellido"));
                txt_cedula.setText(rs.getString("cedula"));
                txt_direccion.setText(rs.getString("direccion"));
                txt_telefono.setText(rs.getString("telefono"));
                txt_cargo.setText(rs.getString("cargo"));
                txt_salario.setText(rs.getString("salario"));
                txt_eps.setText(rs.getString("eps"));
                txt_pension.setText(rs.getString("fondo_pensiones"));
                jDateChooser_fechaIngreso.setDate(rs.getDate("fechaIngreso"));

            }

            // Cerrar la conexión
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al seleccionar el empleado: " + e.getMessage());
        }
    }

}
