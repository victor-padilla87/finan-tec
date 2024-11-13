package Vistas;

import Conexion.Conexionmysql;
import com.toedter.calendar.JDateChooser;
import controlador.Ctr_Empleado;
import modelo.Empleado;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class MenuNomina extends JFrame {

    private Ctr_Empleado controlador;
    private JTextField txtNombre, txtApellido, txtCedula, txtDireccion, txtTelefono, txtCargo, txtSalario, txtDeducciones, txtFondoPensiones, txtEps;
    private JDesktopPane desktopPane;
    private JDateChooser dateChooserFechaIngreso;

    public MenuNomina() {
        controlador = new Ctr_Empleado();
        this.setExtendedState(MAXIMIZED_BOTH);
        setTitle("Sistema de Nómina");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(ancho, alto);

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(0, 0, 139));
        desktopPane.setBounds(0, 0, ancho, alto - 110);
        this.add(desktopPane);

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setLayout(new BoxLayout(toolBar, BoxLayout.X_AXIS));
        toolBar.setPreferredSize(new Dimension(ancho, 50));
        toolBar.setBackground(Color.WHITE);
        toolBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        toolBar.add(crearBotonEstilizado("Registrar Empleado", e -> mostrarRegistroEmpleadoDialog()));
        toolBar.add(crearBotonEstilizado("Gestionar Empleado", e -> abrirInterGestionarEmpleado()));
        toolBar.add(crearBotonEstilizado("Calcular Salario", e -> mostrarCalculoSalarioDialog()));
        toolBar.add(crearBotonEstilizado("Generar Reporte", e -> mostrarGenerarReporteDialog()));
        toolBar.add(crearBotonEstilizado("Volver a Página Principal", e -> volverAPaginaPrincipal()));

        add(toolBar, BorderLayout.NORTH);
    }

    private JButton crearBotonEstilizado(String texto, ActionListener action) {
        JButton boton = new JButton(texto);
        boton.setMaximumSize(new Dimension(300, 50));
        boton.setFocusPainted(false);
        boton.setBackground(new Color(255, 255, 255));
        boton.setForeground(Color.BLACK);
        boton.setFont(new Font("Arial Black", Font.BOLD, 14));
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.addActionListener(action);
        return boton;
    }

    private void abrirInterGestionarEmpleado() {
        InterGestionarEmpleado gestionarEmpleado = new InterGestionarEmpleado();
        desktopPane.add(gestionarEmpleado);
        gestionarEmpleado.setVisible(true);
    }

    private void mostrarRegistroEmpleadoDialog() {
        JInternalFrame frame = new JInternalFrame("Registrar Empleado", true, true, true, true);
        frame.setSize(800, 500);
        frame.setLocation(50, 50);

        ImageIcon fondoImagen = new ImageIcon("src/imagenes/fondo3.jpg");
        Image imagenEscalada = fondoImagen.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        JLabel fondoLabel = new JLabel(new ImageIcon(imagenEscalada));
        fondoLabel.setLayout(new BorderLayout());
        frame.setContentPane(fondoLabel);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        txtNombre = new JTextField(20);
        txtApellido = new JTextField(20);
        txtCedula = new JTextField(20);
        txtDireccion = new JTextField(20);
        txtTelefono = new JTextField(20);
        txtCargo = new JTextField(20);
        txtSalario = new JTextField(20);
        txtDeducciones = new JTextField(20);
        txtFondoPensiones = new JTextField(20);
        txtEps = new JTextField(20);
        dateChooserFechaIngreso = new JDateChooser();

        agregarCampo(panel, "Nombre:", txtNombre, gbc, 0);
        agregarCampo(panel, "Apellido:", txtApellido, gbc, 1);
        agregarCampo(panel, "Cédula:", txtCedula, gbc, 2);
        agregarCampo(panel, "Dirección:", txtDireccion, gbc, 3);
        agregarCampo(panel, "Teléfono:", txtTelefono, gbc, 4);
        agregarCampo(panel, "Cargo:", txtCargo, gbc, 5);
        agregarCampo(panel, "Salario:", txtSalario, gbc, 6);
        agregarCampo(panel, "Deducciones:", txtDeducciones, gbc, 7);
        agregarCampo(panel, "Fondo de Pensiones:", txtFondoPensiones, gbc, 8);
        agregarCampo(panel, "EPS:", txtEps, gbc, 9);

        gbc.gridx = 0;
        gbc.gridy = 10;
        JLabel fechaIngresoLabel = new JLabel("Fecha de Ingreso:");
        fechaIngresoLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
        fechaIngresoLabel.setForeground(Color.WHITE);
        panel.add(fechaIngresoLabel, gbc);

        gbc.gridx = 1;
        panel.add(dateChooserFechaIngreso, gbc);

        gbc.gridy = 11;
        JButton btnGuardar = new JButton("Guardar Empleado");
        btnGuardar.setBackground(Color.GREEN);
        btnGuardar.setFont(new Font("Arial Black", Font.BOLD, 14));
        btnGuardar.addActionListener(e -> guardarEmpleado());
        panel.add(btnGuardar, gbc);

        fondoLabel.add(panel, BorderLayout.CENTER);
        desktopPane.add(frame);
        frame.setVisible(true);
    }

    private void agregarCampo(JPanel panel, String textoEtiqueta, JTextField campoTexto, GridBagConstraints gbc, int yPos) {
        JLabel label = new JLabel(textoEtiqueta);
        label.setFont(new Font("Arial Black", Font.BOLD, 14));
        label.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(campoTexto, gbc);
    }

    private void guardarEmpleado() {
        try {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String cedula = txtCedula.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            String cargo = txtCargo.getText();
            double salario = Double.parseDouble(txtSalario.getText());
            double deducciones = Double.parseDouble(txtDeducciones.getText());
            String fondoPensiones = txtFondoPensiones.getText();
            String eps = txtEps.getText();

            if (cedula == null || cedula.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: La cédula no puede estar vacía.");
                return;
            }

            Date fechaIngresoDate = dateChooserFechaIngreso.getDate();
            if (fechaIngresoDate == null) {
                JOptionPane.showMessageDialog(this, "Error: Debes seleccionar una fecha de ingreso.");
                return;
            }
            java.sql.Date fechaIngresoSQL = new java.sql.Date(fechaIngresoDate.getTime());

            Empleado empleado = new Empleado(cedula, nombre, apellido, direccion, telefono, cargo, salario, deducciones, fondoPensiones, eps, fechaIngresoSQL.toString());
            boolean resultado = controlador.guardarEmpleado(empleado, fechaIngresoSQL.toString());

            JOptionPane.showMessageDialog(this, resultado ? "Empleado registrado exitosamente." : "Error al registrar el empleado. Verifica los datos.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Salario debe ser un número válido.");
        }
    }

    private void mostrarCalculoSalarioDialog() {

        JInternalFrame frame = new JInternalFrame("Calcular Salario", true, true, true, true);
        frame.setSize(500, 400);
        frame.setLocation(50, 50);

        ImageIcon fondoImagen = new ImageIcon("src/imagenes/fondo3.jpg");
        Image imagenEscalada = fondoImagen.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        JLabel fondoLabel = new JLabel(new ImageIcon(imagenEscalada));
        fondoLabel.setLayout(new BorderLayout());
        frame.setContentPane(fondoLabel);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JComboBox<String> comboEmpleados = new JComboBox<>();
        comboEmpleados.setBackground(Color.GREEN);
        comboEmpleados.setFont(new Font("Arial Black", Font.BOLD, 14));
        cargarEmpleados(comboEmpleados);

        JTextField txtSalarioBase = new JTextField(20);
        txtSalarioBase.setEditable(false);
        JTextField txtDeducciones = new JTextField(20);
        txtDeducciones.setEditable(false);
        JTextField txtBonificaciones = new JTextField(20);
        txtBonificaciones.setEditable(false);
        JLabel lblSalarioNeto = new JLabel("Salario Neto: $0.0");
        lblSalarioNeto.setForeground(Color.WHITE);
        lblSalarioNeto.setFont(new Font("Arial Black", Font.BOLD, 14));

        agregarCampo(panel, "Empleado:", comboEmpleados, gbc, 0);
        agregarCampo(panel, "Salario Base:", txtSalarioBase, gbc, 1);
        agregarCampo(panel, "Deducciones:", txtDeducciones, gbc, 2);
        agregarCampo(panel, "Bonificaciones:", txtBonificaciones, gbc, 3);

        comboEmpleados.addActionListener(e -> {
            String nombreEmpleadoSeleccionado = (String) comboEmpleados.getSelectedItem();
            Integer idEmpleadoSeleccionado = empleadosMap.get(nombreEmpleadoSeleccionado);

            if (idEmpleadoSeleccionado != null) {
                cargarDatosEmpleado(idEmpleadoSeleccionado, txtSalarioBase, txtDeducciones, txtBonificaciones, lblSalarioNeto);
            }
        });

        JButton btnCalcular = new JButton("Calcular Salario");
        btnCalcular.setBackground(Color.GREEN);
        btnCalcular.setFont(new Font("Arial Black", Font.BOLD, 14));
        btnCalcular.addActionListener(e -> {
            try {
                double salarioBase = Double.parseDouble(txtSalarioBase.getText());
                double deducciones = Double.parseDouble(txtDeducciones.getText());
                double bonificaciones = Double.parseDouble(txtBonificaciones.getText());

                // Calcular el salarioneto
                double salarioNeto = calcularSalarioNeto(salarioBase, deducciones, bonificaciones);
                lblSalarioNeto.setText("Salario Neto: $" + salarioNeto);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor ingresa valores numéricos válidos.");
            }
        });

        gbc.gridy = 4;
        panel.add(btnCalcular, gbc);

        gbc.gridy = 5;
        panel.add(lblSalarioNeto, gbc);

        fondoLabel.add(panel, BorderLayout.CENTER);
        desktopPane.add(frame);
        frame.setVisible(true);
    }

// metodo para cargar empleados
    private HashMap<String, Integer> empleadosMap = new HashMap<>();

    private void cargarEmpleados(JComboBox<String> comboEmpleados) {
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            String query = "SELECT idempleado, nombre FROM Empleados";
            PreparedStatement stmt = cn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            comboEmpleados.addItem("Selecciona un empleado");
            while (rs.next()) {
                int id = rs.getInt("idempleado");
                String nombre = rs.getString("nombre");

                empleadosMap.put(nombre, id);
                comboEmpleados.addItem(nombre);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar empleados: " + e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

// calcular el salario neto
    private double calcularSalarioNeto(double salarioBase, double deducciones, double bonificaciones) {
        return salarioBase - deducciones + bonificaciones;
    }

    private void cargarDatosEmpleado(int idEmpleadoSeleccionado, JTextField txtSalarioBase, JTextField txtDeducciones, JTextField txtBonificaciones, JLabel lblSalarioNeto) {
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            String query = "SELECT salario, deducciones, bonificaciones FROM Empleados WHERE idempleado = ?";
            PreparedStatement stmt = cn.prepareStatement(query);
            stmt.setInt(1, idEmpleadoSeleccionado);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                double salarioBase = rs.getDouble("salario");
                double deducciones = rs.getDouble("deducciones");
                double bonificaciones = rs.getDouble("bonificaciones");

                txtSalarioBase.setText(String.valueOf(salarioBase));
                txtDeducciones.setText(String.valueOf(deducciones));
                txtBonificaciones.setText(String.valueOf(bonificaciones));

                double salarioNeto = calcularSalarioNeto(salarioBase, deducciones, bonificaciones);
                lblSalarioNeto.setText("Salario Neto: $" + salarioNeto);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos para el empleado seleccionado.");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos del empleado: " + e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void agregarCampo(JPanel panel, String labelText, JComponent field, GridBagConstraints gbc, int row) {
        
        JLabel label = new JLabel(labelText);

        // Establecer restricciones de la bolsa de rejilla para la etiqueta
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(label, gbc);

        // Establecer restricciones de bolsas de cuadrícula para el campo (ComboBox, TextField, etc.)
        gbc.gridx = 1;
        gbc.gridy = row;
        panel.add(field, gbc);
    }

    private void mostrarGenerarReporteDialog() {
        JInternalFrame frame = new JInternalFrame("Generar Reporte de Nómina", true, true, true, true);
        frame.setSize(600, 400);
        frame.setLocation(50, 50);

        // Agregar la imagen de fondo
        ImageIcon fondoImagen = new ImageIcon("src/imagenes/fondo3.jpg");
        Image imagenEscalada = fondoImagen.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        JLabel fondoLabel = new JLabel(new ImageIcon(imagenEscalada));
        fondoLabel.setLayout(new BorderLayout());
        frame.setContentPane(fondoLabel);

        // Crear el panel principal y hacerlo transparente
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);  // Esto permite ver el fondo a través del panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(30, 30, 30, 30); // Incrementar los márgenes para mayor separación

        // Etiqueta de título
        JLabel lblTitulo = new JLabel("Generar Reporte de Nómina");
        lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblTitulo, gbc);

        // Etiqueta y selector de fecha de inicio
        gbc.gridwidth = 1;
        gbc.gridy++;
        JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
        lblFechaInicio.setForeground(Color.WHITE);
        lblFechaInicio.setFont(new Font("Arial Black", Font.BOLD, 14));
        panel.add(lblFechaInicio, gbc);

        gbc.gridx = 1;
        JDateChooser dateChooserInicio = new JDateChooser();
        panel.add(dateChooserInicio, gbc);

        // Etiqueta y selector de fecha de fin
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblFechaFin = new JLabel("Fecha Fin:");
        lblFechaFin.setForeground(Color.WHITE);
        lblFechaFin.setFont(new Font("Arial Black", Font.BOLD, 14));
        panel.add(lblFechaFin, gbc);

        gbc.gridx = 1;
        JDateChooser dateChooserFin = new JDateChooser();
        panel.add(dateChooserFin, gbc);

        // Botón de generar reporte
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton btnGenerar = new JButton("Generar Reporte");
        btnGenerar.setBackground(Color.GREEN);
        btnGenerar.setFont(new Font("Arial Black", Font.BOLD, 14));
        btnGenerar.addActionListener(e -> generarReporteNomina(dateChooserInicio, dateChooserFin));
        panel.add(btnGenerar, gbc);

        // Añadir el panel al fondoLabel
        fondoLabel.add(panel, BorderLayout.CENTER);

        // Agregar el frame al desktopPane y hacerlo visible
        desktopPane.add(frame);
        frame.setVisible(true);
    }

    private void generarReporteNomina(JDateChooser dateChooserInicio, JDateChooser dateChooserFin) {
        Date fechaInicio = dateChooserInicio.getDate();
        Date fechaFin = dateChooserFin.getDate();

        if (fechaInicio != null && fechaFin != null) {
            // Implementa la lógica para generar el reporte aquí
            JOptionPane.showMessageDialog(null, "Reporte generado de " + fechaInicio + " a " + fechaFin);
            // Aquí puedes implementar la exportación a un archivo o mostrar el reporte en pantalla
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona ambas fechas para el reporte.");
        }
    }

    private void volverAPaginaPrincipal() {
        // Crear e inicializar una instancia de Paginaprincipal
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);  // Mostrar la ventana de la página principal

        // Cerrar la ventana actual (MenuNomina) una vez que se muestre la página principal
        this.setVisible(false);  
        this.dispose();           
    }

}
