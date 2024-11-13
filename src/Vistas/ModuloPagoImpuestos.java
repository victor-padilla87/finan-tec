package Vistas;

import controlador.Ctr_Impuestos;
import modelo.Impuestos;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Date;

public class ModuloPagoImpuestos extends JFrame {

    private JTextField txtDescripcion, txtMonto, txtreferenciaPago, txtFiltro;
    private JComboBox<String> comboTipoImpuesto, comboEstado, comboFiltro;
    private JTable tableImpuestos;
    private JDateChooser dateChooserfecaha_vencimentos;
    private Ctr_Impuestos controladorImpuestos;

    public ModuloPagoImpuestos() {
        controladorImpuestos = new Ctr_Impuestos();
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        cargarImpuestos();
        limpiarCampos();
    }

    private void initComponents() {
        setTitle("Pago de Impuestos");
        Font labelFont = new Font("Arial Black", Font.BOLD, 14);

        // Componentes
        JLabel lblTipoImpuesto = new JLabel("Tipo de Impuesto:");
        lblTipoImpuesto.setFont(labelFont);
        comboTipoImpuesto = new JComboBox<>(new String[]{"Seleccione tipo:", "IVA", "ISR", "ISN", "Predial"});

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setFont(labelFont);
        txtDescripcion = new JTextField(20);

        JLabel lblMonto = new JLabel("Monto:");
        lblMonto.setFont(labelFont);
        txtMonto = new JTextField(10);

        JLabel lblFechaPago = new JLabel("Fecha de Pago:");
        lblFechaPago.setFont(labelFont);
        dateChooserfecaha_vencimentos = new JDateChooser();
        dateChooserfecaha_vencimentos.setDateFormatString("yyyy-MM-dd");

        JLabel lblReferencia = new JLabel("Referencia de Pago:");
        lblReferencia.setFont(labelFont);
        txtreferenciaPago = new JTextField(15);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setFont(labelFont);
        comboEstado = new JComboBox<>(new String[]{"Seleccione estado:", "Pendiente", "Pagado", "Vencido"});

        JButton btnRegistrar = new JButton("Registrar Impuesto");
        btnRegistrar.setFont(labelFont);
        btnRegistrar.setBackground(Color.GREEN);
        btnRegistrar.addActionListener(e -> registrarImpuesto());

        JButton btnGestionarImpuestos = new JButton("Gestionar Impuestos");
        btnGestionarImpuestos.setFont(labelFont);
        btnGestionarImpuestos.setBackground(Color.ORANGE);
        btnGestionarImpuestos.addActionListener(e -> abrirDialogoGestionarImpuestos());

        JButton btnRegresarMenu = new JButton("Regresar al Menú Principal");
        btnRegresarMenu.setFont(labelFont);
        btnRegresarMenu.setBackground(Color.BLUE);
        btnRegresarMenu.setForeground(Color.BLACK);
        btnRegresarMenu.addActionListener(e -> regresarAlMenuPrincipal());

        // Filtros
        JLabel lblFiltro = new JLabel("Filtrar por:");
        lblFiltro.setFont(labelFont);
        comboFiltro = new JComboBox<>(new String[]{"Seleccione filtro:", "Tipo de Impuesto", "Fecha Pago", "Descripción"});
        txtFiltro = new JTextField(15);
        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.addActionListener(e -> filtrarImpuestos());

        JPanel filtroPanel = new JPanel(new FlowLayout());
        filtroPanel.add(lblFiltro);
        filtroPanel.add(comboFiltro);
        filtroPanel.add(txtFiltro);
        filtroPanel.add(btnFiltrar);

        // Configuración de la tabla
        tableImpuestos = new JTable(new DefaultTableModel(
                new Object[]{"ID", "Tipo de Impuesto", "Descripción", "Monto", "Fecha Pago", "Referencia", "Estado"}, 0
        ));
        JScrollPane scrollPane = new JScrollPane(tableImpuestos);

        // Diseño del formulario
        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(lblTipoImpuesto);
        panel.add(comboTipoImpuesto);
        panel.add(lblDescripcion);
        panel.add(txtDescripcion);
        panel.add(lblMonto);
        panel.add(txtMonto);
        panel.add(lblFechaPago);
        panel.add(dateChooserfecaha_vencimentos);
        panel.add(lblReferencia);
        panel.add(txtreferenciaPago);
        panel.add(lblEstado);
        panel.add(comboEstado);
        panel.add(btnRegistrar);
        panel.add(btnGestionarImpuestos);
        panel.add(btnRegresarMenu);

        // Layout principal
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(filtroPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void abrirDialogoGestionarImpuestos() {
        int selectedRow = tableImpuestos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un impuesto para gestionar.");
            return;
        }

        // Obtener el ID del impuesto seleccionado desde la tabla
        int id = Integer.parseInt(tableImpuestos.getValueAt(selectedRow, 0).toString());
        Impuestos impuesto = controladorImpuestos.obtenerImpuestoPorId(id);

        if (impuesto == null) {
            JOptionPane.showMessageDialog(this, "No se pudo encontrar el impuesto seleccionado.");
            return;
        }

        // El ID se recupera correctamente aquí
        System.out.println("ID recuperado: " + impuesto.getId());

        // Crear el JDialog
        JDialog dialog = new JDialog(this, "Gestionar Impuestos", true);
        dialog.setSize(600, 400);
        dialog.setLocationRelativeTo(this);

        Font labelFont = new Font("Arial Black", Font.BOLD, 14);
        JTextField txtId = new JTextField(10);
        JTextField txtTipoImpuesto = new JTextField(20);
        JTextField txtDescripcion = new JTextField(20);
        JTextField txtMonto = new JTextField(10);
        JTextField txtReferencia = new JTextField(20);
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");
        JComboBox<String> comboEstado = new JComboBox<>(new String[]{"Seleccione estado:", "Pagado", "Pendiente", "Vencido"});

        // Cargar los datos del impuesto en los campos del JDialog
        txtId.setText(String.valueOf(impuesto.getId()));
        txtTipoImpuesto.setText(impuesto.getTipoImpuesto());
        txtDescripcion.setText(impuesto.getDescripcion());
        txtMonto.setText(String.valueOf(impuesto.getMonto()));
        txtReferencia.setText(impuesto.getReferenciaPago());
        dateChooser.setDate(impuesto.getFecha_vencimiento());
        comboEstado.setSelectedItem(impuesto.getEstado());

        // Deshabilitar el campo ID
        txtId.setEnabled(false);

        // Botones de acción
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(labelFont);
        btnActualizar.setBackground(Color.GREEN);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(labelFont);
        btnEliminar.setBackground(Color.RED);

        // Acción para actualizar el registro
        btnActualizar.addActionListener(e -> {
            try {
                // Obtener y asignar los valores correctamente
                String tipoImpuesto = txtTipoImpuesto.getText().trim();
                String descripcion = txtDescripcion.getText().trim();
                double monto = Double.parseDouble(txtMonto.getText().trim());
                String referenciaPago = txtReferencia.getText().trim();
                Date fechaVencimiento = dateChooser.getDate();
                String estado = (comboEstado.getSelectedItem() != null) ? comboEstado.getSelectedItem().toString() : "";

                // Verificar que los campos no estén vacíos
                if (tipoImpuesto.isEmpty() || descripcion.isEmpty() || referenciaPago.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Por favor, completa todos los campos.");
                    return;
                }

                // Validación del campo Estado
                if (estado.isEmpty() || estado.equals("Seleccione estado:")) {
                    JOptionPane.showMessageDialog(dialog, "Por favor, selecciona un estado válido para el impuesto.");
                    return;
                }

                // Actualizar los valores en el objeto impuesto
                impuesto.setTipoImpuesto(tipoImpuesto);
                impuesto.setDescripcion(descripcion);
                impuesto.setMonto(monto);
                impuesto.setReferenciaPago(referenciaPago);
                impuesto.setFecha_vencimiento(fechaVencimiento);
                impuesto.setEstado(estado);

                // Llamar al método de actualización del controlador
                if (controladorImpuestos.actualizarImpuesto(impuesto)) {
                    JOptionPane.showMessageDialog(dialog, "Impuesto actualizado correctamente.");
                    cargarImpuestos();
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Error al actualizar el impuesto.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Error en el formato de los datos numéricos: " + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage());
            }
        });

        // Acción para eliminar el registro
        btnEliminar.addActionListener(e -> {
            // Confirmación de eliminación
            int confirmacion = JOptionPane.showConfirmDialog(dialog,
                    "¿Estás seguro de que deseas eliminar este impuesto?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                // Llamar al controlador para eliminar el impuesto de la base de datos
                boolean eliminado = controladorImpuestos.eliminarImpuesto(impuesto.getId());

                if (eliminado) {
                    // Actualizar la tabla si se eliminó correctamente
                    JOptionPane.showMessageDialog(dialog, "Impuesto eliminado exitosamente.");
                    cargarImpuestos(); // Refrescar la tabla en la interfaz principal
                    dialog.dispose(); // Cerrar el diálogo
                } else {
                    JOptionPane.showMessageDialog(dialog, "Error al eliminar el impuesto.");
                }
            }
        });

        // Panel de componentes
        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("ID:"));
        panel.add(txtId);
        panel.add(new JLabel("Tipo de Impuesto:"));
        panel.add(txtTipoImpuesto);
        panel.add(new JLabel("Descripción:"));
        panel.add(txtDescripcion);
        panel.add(new JLabel("Monto:"));
        panel.add(txtMonto);
        panel.add(new JLabel("Fecha de Pago:"));
        panel.add(dateChooser);
        panel.add(new JLabel("Referencia de Pago:"));
        panel.add(txtReferencia);
        panel.add(new JLabel("Estado:"));
        panel.add(comboEstado);
        panel.add(btnActualizar);
        panel.add(btnEliminar);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private void registrarImpuesto() {
        try {
            // Obtener y validar los campos del formulario
            String tipoImpuesto = (comboTipoImpuesto.getSelectedItem() != null) ? comboTipoImpuesto.getSelectedItem().toString() : "";
            String descripcion = txtDescripcion.getText().trim();
            String montoText = txtMonto.getText().trim();
            Date fechaVencimiento = dateChooserfecaha_vencimentos.getDate();
            String referenciaPago = txtreferenciaPago.getText().trim();
            String estado = (comboEstado.getSelectedItem() != null) ? comboEstado.getSelectedItem().toString() : "";

            // Validaciones
            if (tipoImpuesto.isEmpty() || tipoImpuesto.equals("Seleccione tipo:")) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un tipo de impuesto válido.");
                return;
            }

            if (descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa una descripción.");
                return;
            }

            if (montoText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa un monto.");
                return;
            }

            // Validar formato numérico del monto
            double monto;
            try {
                monto = Double.parseDouble(montoText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El monto ingresado no es válido. Por favor, ingresa un número.");
                return;
            }

            if (fechaVencimiento == null) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona una fecha de pago.");
                return;
            }

            if (referenciaPago.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa una referencia de pago.");
                return;
            }

            if (estado.isEmpty() || estado.equals("Seleccione estado:")) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un estado válido.");
                return;
            }
            int id = 0;

            // Crear objeto Impuestos
            Impuestos impuesto = new Impuestos(id, descripcion, tipoImpuesto, monto, fechaVencimiento, referenciaPago, estado);

            // Intentar registrar el impuesto
            if (controladorImpuestos.registrarImpuesto(impuesto)) {
                JOptionPane.showMessageDialog(this, "Impuesto registrado correctamente.");
                cargarImpuestos(); // Actualizar la tabla
                limpiarCampos();   // Limpiar los campos
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el impuesto.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar el impuesto: " + ex.getMessage());
        }
    }

    private void cargarImpuestos() {
        List<Impuestos> impuestos = controladorImpuestos.obtenerImpuesto();
        DefaultTableModel model = (DefaultTableModel) tableImpuestos.getModel();
        model.setRowCount(0);

        for (Impuestos impuesto : impuestos) {
            model.addRow(new Object[]{
                impuesto.getId(),
                impuesto.getTipoImpuesto(),
                impuesto.getDescripcion(),
                impuesto.getMonto(),
                impuesto.getFecha_vencimiento(),
                impuesto.getReferenciaPago(),
                impuesto.getEstado()
            });
        }
    }

    private void filtrarImpuestos() {
        String criterio = (String) comboFiltro.getSelectedItem();
        String valor = txtFiltro.getText().trim();

        List<Impuestos> impuestosFiltrados = controladorImpuestos.obtenerImpuesto().stream()
                .filter(impuesto -> {
                    switch (criterio) {
                        case "Tipo de Impuesto":
                            return impuesto.getTipoImpuesto().equalsIgnoreCase(valor);
                        case "Descripción":
                            return impuesto.getDescripcion().toLowerCase().contains(valor.toLowerCase());
                        case "Estado":
                            return impuesto.getEstado().equalsIgnoreCase(valor);
                        default:
                            return false;
                    }
                }).toList();

        DefaultTableModel model = (DefaultTableModel) tableImpuestos.getModel();
        model.setRowCount(0);

        for (Impuestos impuesto : impuestosFiltrados) {
            model.addRow(new Object[]{
                impuesto.getId(), impuesto.getTipoImpuesto(),
                impuesto.getDescripcion(), impuesto.getMonto(),
                impuesto.getFecha_vencimiento(), impuesto.getReferenciaPago()
            });
        }
    }

    private void limpiarCampos() {
        txtDescripcion.setText("");
        txtMonto.setText("");
        txtreferenciaPago.setText("");
        comboTipoImpuesto.setSelectedIndex(0);
        dateChooserfecaha_vencimentos.setDate(null);
    }

    private void regresarAlMenuPrincipal() {
        new MenuPrincipal().setVisible(true); // Abre el menú principal
        this.dispose(); // Cierra la ventana actual
    }

}
