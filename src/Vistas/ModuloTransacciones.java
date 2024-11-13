package Vistas;

import controlador.Ctr_Transacciones;
import modelo.Transacciones;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.List;
import java.awt.Font;

public class ModuloTransacciones extends javax.swing.JFrame {

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldTipo;
    private javax.swing.JTextField jTextFieldMonto;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonGenerarReporte;
    private javax.swing.JButton jButtonGestionarTransacciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableTransacciones;
    private javax.swing.JButton btnRegresarMenu;

    private Ctr_Transacciones controladorTransacciones;

    public ModuloTransacciones() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Módulo de Transacciones");

        getContentPane().setBackground(Color.lightGray);

        controladorTransacciones = new Ctr_Transacciones();
        cargarTransacciones();
    }

    private void initComponents() {
        Font labelFont = new Font("Arial Black", Font.BOLD, 14);

        jLabel1 = new javax.swing.JLabel("Tipo de Transacción:");
        jLabel1.setFont(labelFont);
        jTextFieldTipo = new javax.swing.JTextField();

        jLabel2 = new javax.swing.JLabel("Monto:");
        jLabel2.setFont(labelFont);
        jTextFieldMonto = new javax.swing.JTextField();

        jLabel3 = new javax.swing.JLabel("Descripción:");
        jLabel3.setFont(labelFont);
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jScrollPane1 = new JScrollPane(jTextAreaDescripcion);

        jButtonRegistrar = new javax.swing.JButton("Registrar Transacción");
        jButtonRegistrar.setFont(new Font("Arial Black", Font.BOLD, 14));
        jButtonRegistrar.setBackground(Color.GREEN);

        jButtonGenerarReporte = new javax.swing.JButton("Generar Reporte");
        jButtonGenerarReporte.setFont(new Font("Arial Black", Font.BOLD, 14));
        jButtonGenerarReporte.setBackground(Color.CYAN);

        jButtonGestionarTransacciones = new javax.swing.JButton("Gestionar Transacciones");
        jButtonGestionarTransacciones.setFont(new Font("Arial Black", Font.BOLD, 14));
        jButtonGestionarTransacciones.setBackground(Color.ORANGE);
        
        // Botón para regresar al menú principal
        btnRegresarMenu = new JButton("Regresar al Menú Principal");
        btnRegresarMenu.setFont(new Font("Arial Black", Font.BOLD, 14));
        btnRegresarMenu.setBackground(Color.BLUE);
        btnRegresarMenu.setForeground(Color.BLACK);

        jTableTransacciones = new JTable();
        jScrollPane2 = new JScrollPane(jTableTransacciones);

        jTableTransacciones.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Tipo", "Monto", "Fecha", "Descripción"}
        ));
        jTableTransacciones.getTableHeader().setFont(new Font("Arial Black", Font.BOLD, 12));

        jButtonRegistrar.addActionListener(evt -> registrarTransaccion());
        jButtonGenerarReporte.addActionListener(evt -> generateReport());
        jButtonGestionarTransacciones.addActionListener(evt -> GestionarTransaciones());
        btnRegresarMenu.addActionListener(e -> regresarAlMenuPrincipal());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jButtonRegistrar)
                                                        .addComponent(jButtonGenerarReporte)
                                                        .addComponent(jButtonGestionarTransacciones)
                                                        .addComponent(btnRegresarMenu))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldTipo)
                                                        .addComponent(jTextFieldMonto)
                                                        .addComponent(jScrollPane1))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextFieldMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButtonRegistrar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonGenerarReporte)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonGestionarTransacciones)
                                .addComponent(btnRegresarMenu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }

    private void registrarTransaccion() {
        String tipoTransaccion = jTextFieldTipo.getText();
        double monto = Double.parseDouble(jTextFieldMonto.getText());
        String descripcion = jTextAreaDescripcion.getText();

        Transacciones transaccion = new Transacciones(0, tipoTransaccion, monto, null, descripcion);

        if (controladorTransacciones.registrarTransaccion(transaccion)) {
            JOptionPane.showMessageDialog(this, "Transacción registrada con éxito.");
            jTextFieldTipo.setText("");
            jTextFieldMonto.setText("");
            jTextAreaDescripcion.setText("");
            cargarTransacciones();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar la transacción.");
        }
    }

    private void cargarTransacciones() {
        List<Transacciones> transacciones = controladorTransacciones.obtenerTransacciones();
        DefaultTableModel model = (DefaultTableModel) jTableTransacciones.getModel();
        model.setRowCount(0);

        for (Transacciones transaccion : transacciones) {
            model.addRow(new Object[]{
                transaccion.getId(),
                transaccion.getTipo_transaccion(),
                transaccion.getMonto(),
                transaccion.getFecha(),
                transaccion.getDescripcion()
            });
        }
    }

    private void GestionarTransaciones() {
        int selectedRow = jTableTransacciones.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una transacción de la tabla.");
            return;
        }

        int id = (int) jTableTransacciones.getValueAt(selectedRow, 0);
        String tipo = (String) jTableTransacciones.getValueAt(selectedRow, 1);
        double monto = (double) jTableTransacciones.getValueAt(selectedRow, 2);
        String descripcion = (String) jTableTransacciones.getValueAt(selectedRow, 4);

        JDialog manageDialog = new JDialog(this, "Gestionar Transacción", true);
        manageDialog.setSize(600, 400);
        manageDialog.setLayout(new GridBagLayout());
        manageDialog.setLocationRelativeTo(this);

        // Configuración del layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        Font labelFont = new Font("Arial Black", Font.BOLD, 14);

        // Campos de texto y etiquetas
        JLabel tipoLabel = new JLabel("Tipo:");
        tipoLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        manageDialog.add(tipoLabel, gbc);

        JTextField tipoField = new JTextField(tipo);
        tipoField.setPreferredSize(new Dimension(170, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        manageDialog.add(tipoField, gbc);

        JLabel montoLabel = new JLabel("Monto:");
        montoLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        manageDialog.add(montoLabel, gbc);

        JTextField montoField = new JTextField(String.valueOf(monto));
        montoField.setPreferredSize(new Dimension(170, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        manageDialog.add(montoField, gbc);

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        manageDialog.add(descripcionLabel, gbc);

        JTextArea descripcionArea = new JTextArea(descripcion);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        JScrollPane descripcionScrollPane = new JScrollPane(descripcionArea);
        descripcionScrollPane.setPreferredSize(new Dimension(170, 60));
        gbc.gridx = 1;
        gbc.gridy = 2;
        manageDialog.add(descripcionScrollPane, gbc);

        // Botones
        JButton updateButton = new JButton("Actualizar");
        updateButton.setFont(new Font("Arial Black", Font.BOLD, 14));
        updateButton.setBackground(Color.GREEN);
        updateButton.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 3;
        manageDialog.add(updateButton, gbc);

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.setFont(new Font("Arial Black", Font.BOLD, 14));
        deleteButton.setBackground(Color.GREEN);
        deleteButton.setForeground(Color.BLACK);
        gbc.gridx = 1;
        gbc.gridy = 3;
        manageDialog.add(deleteButton, gbc);

        // Funcionalidad de botones
        updateButton.addActionListener(e -> {
            String newTipo = tipoField.getText();
            double newMonto = Double.parseDouble(montoField.getText());
            String newDescripcion = descripcionArea.getText();

            Transacciones updatedTransaccion = new Transacciones(id, newTipo, newMonto, null, newDescripcion);
            controladorTransacciones.actualizarTransaccion(updatedTransaccion);

            cargarTransacciones();
            manageDialog.dispose();
            JOptionPane.showMessageDialog(this, "Transacción actualizada con éxito.");
        });

        deleteButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(manageDialog, "¿Está seguro de eliminar esta transacción?");
            if (confirm == JOptionPane.YES_OPTION) {
                controladorTransacciones.eliminarTransaccion(id);
                cargarTransacciones();
                manageDialog.dispose();
                JOptionPane.showMessageDialog(this, "Transacción eliminada con éxito.");
            }
        });

        manageDialog.setVisible(true);
    }

    private void generateReport() {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("ReporteTransacciones.pdf"));
            document.open();
            document.add(new Paragraph("Reporte de Transacciones"));

            for (int i = 0; i < jTableTransacciones.getRowCount(); i++) {
                document.add(new Paragraph("ID: " + jTableTransacciones.getValueAt(i, 0)
                        + ", Tipo: " + jTableTransacciones.getValueAt(i, 1)
                        + ", Monto: " + jTableTransacciones.getValueAt(i, 2)
                        + ", Fecha: " + jTableTransacciones.getValueAt(i, 3)
                        + ", Descripción: " + jTableTransacciones.getValueAt(i, 4)));
            }
            document.close();
            JOptionPane.showMessageDialog(this, "Reporte PDF generado con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateGraphReport() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < jTableTransacciones.getRowCount(); i++) {
            String tipo = (String) jTableTransacciones.getValueAt(i, 1);
            double monto = (double) jTableTransacciones.getValueAt(i, 2);
            dataset.addValue(monto, "Monto", tipo);
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Reporte de Transacciones", "Tipo de Transacción", "Monto",
                dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        JFrame chartFrame = new JFrame("Gráfica de Transacciones");
        chartFrame.add(chartPanel);
        chartFrame.pack();
        chartFrame.setVisible(true);
    }

    private void regresarAlMenuPrincipal() {
        this.dispose(); // Cierra la ventana actual
        new MenuPrincipal().setVisible(true); // Abre el menú principal
    }

}
