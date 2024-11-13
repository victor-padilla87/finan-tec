package Vistas;

import controlador.Ctr_Cuentas;
import modelo.Cuentas;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Date;
import java.awt.Dimension;

public class ModuloCuentas extends JFrame {

    private JTextField txtDescripcion, txtMonto, txtFiltro;
    private JComboBox<String> comboTipo, comboEstado, comboFiltro;
    private JTable tableCuentas;
    private JDateChooser dateChooserFechaVencimiento;
    private Ctr_Cuentas controladorCuentas;

    public ModuloCuentas() {
        controladorCuentas = new Ctr_Cuentas();
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        cargarCuentas();
        limpiarCampos();
    }

    private void initComponents() {
        setTitle("Cuentas por Cobrar/Pagar");

        Font labelFont = new Font("Arial Black", Font.BOLD, 14);

        // Componentes
        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setFont(labelFont);
        txtDescripcion = new JTextField(20);

        JLabel lblMonto = new JLabel("Monto:");
        lblMonto.setFont(labelFont);
        txtMonto = new JTextField(10);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(labelFont);
        comboTipo = new JComboBox<>(new String[]{"Seleccione tipo:", "Cobrar", "Pagar"});
        comboTipo.setSelectedIndex(0);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setFont(labelFont);
        comboEstado = new JComboBox<>(new String[]{"Seleccione estado:", "Pendiente", "Pagada"});
        comboEstado.setSelectedIndex(0);

        JLabel lblFechaVencimiento = new JLabel("Fecha Vencimiento:");
        lblFechaVencimiento.setFont(labelFont);
        dateChooserFechaVencimiento = new JDateChooser();
        dateChooserFechaVencimiento.setDateFormatString("yyyy-MM-dd");

        JButton btnRegistrar = new JButton("Registrar Transacción");
        btnRegistrar.setFont(new Font("Arial Black", Font.BOLD, 14));
        btnRegistrar.setBackground(Color.GREEN);
        btnRegistrar.addActionListener(e -> registrarCuenta());

        JButton btnGestionar = new JButton("Gestionar Transacciones");
        btnGestionar.setFont(new Font("Arial Black", Font.BOLD, 14));
        btnGestionar.setBackground(Color.ORANGE);
        btnGestionar.addActionListener(e -> abrirDialogoGestionar());

        // Botón para regresar al menú principal
        JButton btnRegresarMenu = new JButton("Regresar al Menú Principal");
        btnRegresarMenu.setFont(labelFont);
        btnRegresarMenu.setBackground(Color.BLUE);
        btnRegresarMenu.setForeground(Color.BLACK);
        btnRegresarMenu.addActionListener(e -> regresarAlMenuPrincipal());

        // Filtros
        JLabel lblFiltro = new JLabel("Filtrar por:");
        lblFiltro.setFont(labelFont);
        comboFiltro = new JComboBox<>(new String[]{"Seleccione filtro:", "ID", "Estado", "Fecha Vencimiento", "Descripción"});
        txtFiltro = new JTextField(15);
        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setFont(new Font("Arial Black", Font.BOLD, 14));
        btnFiltrar.setBackground(Color.CYAN);
        btnFiltrar.addActionListener(e -> filtrarCuentas());

        JPanel filtroPanel = new JPanel(new FlowLayout());
        filtroPanel.add(lblFiltro);
        filtroPanel.add(comboFiltro);
        filtroPanel.add(txtFiltro);
        filtroPanel.add(btnFiltrar);

        // Configuración de la tabla
        tableCuentas = new JTable(new DefaultTableModel(
                new Object[]{"ID", "Tipo", "Descripción", "Monto", "Fecha Vencimiento", "Estado"}, 0
        ));

        tableCuentas.getTableHeader().setFont(new Font("Arial Black", Font.BOLD, 12));
        JScrollPane scrollPane = new JScrollPane(tableCuentas);

        // Diseño del formulario
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10)); // Espacio entre componentes
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Márgenes de 10 píxeles en cada lado
        panel.add(lblDescripcion);
        panel.add(txtDescripcion);
        panel.add(lblMonto);
        panel.add(txtMonto);
        panel.add(lblTipo);
        panel.add(comboTipo);
        panel.add(lblEstado);
        panel.add(comboEstado);
        panel.add(lblFechaVencimiento);
        panel.add(dateChooserFechaVencimiento);
        panel.add(btnRegistrar);
        panel.add(btnGestionar);
        panel.add(btnRegresarMenu);

        // Diseño de la ventana principal
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(filtroPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void registrarCuenta() {
        String descripcion = txtDescripcion.getText();
        double monto = Double.parseDouble(txtMonto.getText());
        String tipo = (String) comboTipo.getSelectedItem();
        String estado = (String) comboEstado.getSelectedItem();
        Date fechaVencimiento = dateChooserFechaVencimiento.getDate();

        if (tipo.equals("Seleccione tipo:") || estado.equals("Seleccione estado:")) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione el tipo y el estado.");
            return;
        }

        if (fechaVencimiento == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una fecha de vencimiento.");
            return;
        }

        Cuentas cuenta = new Cuentas(0, tipo, descripcion, monto, fechaVencimiento, estado);

        if (controladorCuentas.registrarCuenta(cuenta)) {
            JOptionPane.showMessageDialog(this, "Cuenta registrada con éxito.");
            cargarCuentas();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar la cuenta.");
        }
    }

    private void abrirDialogoGestionar() {
        int selectedRow = tableCuentas.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una transacción para gestionar.");
            return;
        }

        int id = (int) tableCuentas.getValueAt(selectedRow, 0);
        Cuentas cuentaSeleccionada = controladorCuentas.obtenerCuentaPorId(id);

        if (cuentaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la transacción.");
            return;
        }

        JDialog dialog = new JDialog(this, "Gestionar Transacciones", true);
        dialog.setSize(600, 400);
        dialog.setLocationRelativeTo(this);

        Font labelFont = new Font("Arial Black", Font.BOLD, 14);

        JTextField txtDescripcion = new JTextField(cuentaSeleccionada.getDescripcion(), 20);
        txtDescripcion.setPreferredSize(new Dimension(170, 30));
        JTextField txtMonto = new JTextField(String.valueOf(cuentaSeleccionada.getMonto()), 10);
        txtMonto.setPreferredSize(new Dimension(170, 30));

        JComboBox<String> comboTipo = new JComboBox<>(new String[]{"Seleccione Tipo:", "Cobrar", "Pagar"});
        comboTipo.setPreferredSize(new Dimension(150, 20));
        comboTipo.setSelectedItem(cuentaSeleccionada.getTipo());

        JComboBox<String> comboEstado = new JComboBox<>(new String[]{"Seleccione Estado:", "Pendiente", "Pagada"});
        comboEstado.setPreferredSize(new Dimension(170, 30));
        comboEstado.setSelectedItem(cuentaSeleccionada.getEstado());

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDate(cuentaSeleccionada.getFechaVencimiento());

        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");

        btnActualizar.setFont(labelFont);
        btnActualizar.setBackground(Color.GREEN);
        btnActualizar.setForeground(Color.WHITE);

        btnEliminar.setFont(labelFont);
        btnEliminar.setBackground(Color.RED);
        btnEliminar.setForeground(Color.WHITE);

        btnActualizar.addActionListener(e -> {
            cuentaSeleccionada.setDescripcion(txtDescripcion.getText());
            cuentaSeleccionada.setMonto(Double.parseDouble(txtMonto.getText()));
            cuentaSeleccionada.setTipo((String) comboTipo.getSelectedItem());
            cuentaSeleccionada.setEstado((String) comboEstado.getSelectedItem());
            cuentaSeleccionada.setFechaVencimiento(dateChooser.getDate());

            if (controladorCuentas.actualizarCuenta(cuentaSeleccionada)) {
                JOptionPane.showMessageDialog(dialog, "Transacción actualizada exitosamente.");
                cargarCuentas();
                limpiarCampos();
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Error al actualizar la transacción.");
            }
        });

        btnEliminar.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(dialog, "¿Estás seguro de que deseas eliminar esta transacción?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (controladorCuentas.eliminarCuenta(id)) {
                    JOptionPane.showMessageDialog(dialog, "Transacción eliminada exitosamente.");
                    cargarCuentas();
                    limpiarCampos();
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Error al eliminar la transacción.");
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // margen de 10 píxeles en cada lado

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setFont(labelFont);
        JLabel lblMonto = new JLabel("Monto:");
        lblMonto.setFont(labelFont);
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(labelFont);
        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setFont(labelFont);
        JLabel lblFecha = new JLabel("Fecha de Vencimiento:");
        lblFecha.setFont(labelFont);

        panel.add(lblDescripcion);
        panel.add(txtDescripcion);
        panel.add(lblMonto);
        panel.add(txtMonto);
        panel.add(lblTipo);
        panel.add(comboTipo);
        panel.add(lblEstado);
        panel.add(comboEstado);
        panel.add(lblFecha);
        panel.add(dateChooser);
        panel.add(btnActualizar);
        panel.add(btnEliminar);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private void actualizarCuenta() {
        int selectedRow = tableCuentas.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una cuenta para actualizar.");
            return;
        }

        try {
            int id = (int) tableCuentas.getValueAt(selectedRow, 0);
            String descripcion = txtDescripcion.getText();
            double monto = Double.parseDouble(txtMonto.getText());
            String tipo = (String) comboTipo.getSelectedItem();
            String estado = (String) comboEstado.getSelectedItem();
            Date fechaVencimiento = dateChooserFechaVencimiento.getDate();

            Cuentas cuentaActualizada = new Cuentas(id, tipo, descripcion, monto, fechaVencimiento, estado);

            if (controladorCuentas.actualizarCuenta(cuentaActualizada)) {
                JOptionPane.showMessageDialog(this, "Cuenta actualizada con éxito.");
                cargarCuentas();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar la cuenta.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un monto válido.");
        }
    }

    private void eliminarCuenta() {
        int selectedRow = tableCuentas.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una cuenta para eliminar.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar esta cuenta?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            int id = (int) tableCuentas.getValueAt(selectedRow, 0);

            if (controladorCuentas.eliminarCuenta(id)) {
                JOptionPane.showMessageDialog(this, "Cuenta eliminada con éxito.");
                cargarCuentas();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar la cuenta.");
            }
        }
    }

    private void filtrarCuentas() {
        String criterio = (String) comboFiltro.getSelectedItem();
        String valor = txtFiltro.getText();

        List<Cuentas> cuentasFiltradas = controladorCuentas.filtrarCuentas(criterio, valor);
        DefaultTableModel model = (DefaultTableModel) tableCuentas.getModel();
        model.setRowCount(0);

        for (Cuentas cuenta : cuentasFiltradas) {
            model.addRow(new Object[]{
                cuenta.getId(), cuenta.getTipo(), cuenta.getDescripcion(), cuenta.getMonto(),
                cuenta.getFechaVencimiento(), cuenta.getEstado()
            });
        }
    }

    private void cargarCuentas() {
        List<Cuentas> cuentas = controladorCuentas.obtenerCuentas();
        DefaultTableModel model = (DefaultTableModel) tableCuentas.getModel();
        model.setRowCount(0);

        for (Cuentas cuenta : cuentas) {
            model.addRow(new Object[]{
                cuenta.getId(), cuenta.getTipo(), cuenta.getDescripcion(), cuenta.getMonto(),
                cuenta.getFechaVencimiento(), cuenta.getEstado()
            });
        }
    }

    private void regresarAlMenuPrincipal() {
        new MenuPrincipal().setVisible(true); // Abre el menú principal
        this.dispose(); // Cierra la ventana actual
    }

    private void limpiarCampos() {
        txtDescripcion.setText("");
        txtMonto.setText("");
        comboTipo.setSelectedIndex(0);
        comboEstado.setSelectedIndex(0);
        dateChooserFechaVencimiento.setDate(null);
    }

}
