package Vistas;

import Conexion.Conexionmysql;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.plot.PlotOrientation;

public class InterStockbajo extends javax.swing.JInternalFrame {

    int umbral = 10; // Umbral para considerar stock bajo (puedes hacerlo dinámico)

    public InterStockbajo() {
        initComponents();
        this.setSize(new Dimension(700, 500));
        this.setTitle("Reporte Stock Bajo");

        this.CargarTablaStockBajo(umbral);

        // metodo para insertar imagen por medio de codigo
        ImageIcon wallpaper = new ImageIcon("src/imagenes/fondo3.jpg");
        Icon Icono = new ImageIcon(wallpaper.getImage().getScaledInstance(700, 500, WIDTH));
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
        jTable_StockBajo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_Graficar = new javax.swing.JButton();
        jButton_GeneralPdf = new javax.swing.JButton();
        jButton_DescargarGraficar = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reporte Stock Bajo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 5, 210, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_StockBajo.setBackground(new java.awt.Color(255, 255, 255));
        jTable_StockBajo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_StockBajo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, 280));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 670, 300));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Graficar.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        jButton_Graficar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton_Graficar.setForeground(new java.awt.Color(0, 70, 211));
        jButton_Graficar.setText("General Grafica");
        jButton_Graficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GraficarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Graficar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 160, 50));

        jButton_GeneralPdf.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        jButton_GeneralPdf.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton_GeneralPdf.setForeground(new java.awt.Color(0, 132, 118));
        jButton_GeneralPdf.setText("General Pdf");
        jButton_GeneralPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GeneralPdfActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_GeneralPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 160, 50));

        jButton_DescargarGraficar.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        jButton_DescargarGraficar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton_DescargarGraficar.setForeground(new java.awt.Color(0, 229, 202));
        jButton_DescargarGraficar.setText("Descargar Grafica");
        jButton_DescargarGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DescargarGraficarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_DescargarGraficar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 160, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 670, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GeneralPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GeneralPdfActionPerformed
        // Verificar que la tabla no esté vacía
        if (jTable_StockBajo == null || jTable_StockBajo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos con stock bajo para exportar.");
            return;
        }

        // Crear un formato de fecha adecuado para nombres de archivos
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaActualStr = dateFormat.format(new Date());

        // Ruta donde se guardará el archivo PDF
        String ruta = "reporte_stock_bajo_" + fechaActualStr + ".pdf";

        // Generar el PDF usando iText
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            // Título del reporte
            Paragraph titulo = new Paragraph("Reporte de Productos con Stock Bajo",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, Font.BOLD, BaseColor.BLACK));
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            documento.add(new Paragraph("Fecha de generación: " + fechaActualStr));
            documento.add(new Paragraph(" "));  // Espacio en blanco

            // Crear tabla con 5 columnas (ID Producto, Nombre, Descripción, Cantidad, Proveedor)
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // Configurar los anchos de las columnas
            float[] columnWidths = {1f, 2f, 3f, 2f, 2f};
            table.setWidths(columnWidths);

            // Agregar encabezados a la tabla
            PdfPCell cell;

            cell = new PdfPCell(new Phrase("ID Producto",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE)));
            cell.setBackgroundColor(BaseColor.BLUE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(10f);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Nombre",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE)));
            cell.setBackgroundColor(BaseColor.BLUE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(10f);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Descripción",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE)));
            cell.setBackgroundColor(BaseColor.BLUE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(10f);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Cantidad",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE)));
            cell.setBackgroundColor(BaseColor.BLUE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(10f);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Proveedor",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE)));
            cell.setBackgroundColor(BaseColor.BLUE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(10f);
            table.addCell(cell);

            // Agregar los datos de productos con stock bajo desde la tabla
            for (int i = 0; i < jTable_StockBajo.getRowCount(); i++) {
                // ID Producto
                String idProducto = jTable_StockBajo.getValueAt(i, 0).toString();
                cell = new PdfPCell(new Phrase(idProducto,
                        FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK)));
                cell.setPadding(8f);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                // Nombre
                String nombre = jTable_StockBajo.getValueAt(i, 1).toString();
                cell = new PdfPCell(new Phrase(nombre,
                        FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK)));
                cell.setPadding(8f);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                // Descripción
                String descripcion = jTable_StockBajo.getValueAt(i, 2).toString();
                cell = new PdfPCell(new Phrase(descripcion,
                        FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK)));
                cell.setPadding(8f);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                // Cantidad
                String cantidad = jTable_StockBajo.getValueAt(i, 3).toString();
                cell = new PdfPCell(new Phrase(cantidad,
                        FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK)));
                cell.setPadding(8f);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                // Proveedor
                String proveedor = jTable_StockBajo.getValueAt(i, 4).toString();
                cell = new PdfPCell(new Phrase(proveedor,
                        FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK)));
                cell.setPadding(8f);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            // Agregar la tabla al documento
            documento.add(table);

            // Cerrar el documento
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte guardado en: " + ruta);

        } catch (Exception e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton_GeneralPdfActionPerformed

    private void jButton_GraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GraficarActionPerformed
        // Crear el dataset para el gráfico
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

// Definir el umbral de stock bajo 
        int umbralStockBajo = 10;

// Conectar a la base de datos y obtener los productos con stock bajo
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        String sql = "SELECT idProducto, nombre, descripcion, cantidad, proveedor FROM productos WHERE cantidad < ?";

        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, umbralStockBajo);
            rs = pst.executeQuery();

            // Recorrer los resultados y añadir al dataset
            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int cantidad = rs.getInt("cantidad");
                String proveedor = rs.getString("proveedor");

                // Construir un nombre descriptivo para el producto con id y proveedor
                String labelProducto = nombre + " (ID: " + idProducto + ", Prov: " + proveedor + ")";

                // Añadir la cantidad al dataset usando el nombre como etiqueta
                dataset.addValue(cantidad, "Cantidad", labelProducto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

// Crear el gráfico de barras con el dataset cargado
        JFreeChart chart = ChartFactory.createBarChart(
                "Reporte de Productos con Stock Bajo", // Título del gráfico
                "Productos", // Etiqueta del eje X
                "Cantidad en Stock", // Etiqueta del eje Y
                dataset // Datos para el gráfico
        );

// Crear un panel para mostrar el gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

// Crear una ventana para mostrar el gráfico
        JFrame ventanaGrafico = new JFrame("Gráfico de Productos con Stock Bajo");
        ventanaGrafico.setContentPane(chartPanel);
        ventanaGrafico.pack();
        ventanaGrafico.setVisible(true);

// Establecer la operación de cierre correcta
        ventanaGrafico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_jButton_GraficarActionPerformed

    private void jButton_DescargarGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DescargarGraficarActionPerformed
        // Crear el dataset para el gráfico
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Definir el umbral de stock bajo 
        int umbralStockBajo = 10;

        // Conectar a la base de datos y obtener los productos con stock bajo
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        String sql = "SELECT idProducto, nombre, descripcion, cantidad, proveedor FROM productos WHERE cantidad < ?";

        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, umbralStockBajo);
            rs = pst.executeQuery();

            // Recorrer los resultados y añadir al dataset
            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int cantidad = rs.getInt("cantidad");
                String proveedor = rs.getString("proveedor");

                // Construir un nombre descriptivo para el producto con id y proveedor
                String labelProducto = nombre + " (ID: " + idProducto + ", Prov: " + proveedor + ")";

                // Añadir la cantidad al dataset usando el nombre como etiqueta
                dataset.addValue(cantidad, "Cantidad", labelProducto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        // Crear el gráfico de barras con los datos obtenidos
        JFreeChart chart = ChartFactory.createBarChart(
                "Stock Bajo de Productos", // Título del gráfico
                "Producto", // Etiqueta del eje X
                "Cantidad", // Etiqueta del eje Y
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Orientación del gráfico
                true, // Incluir leyenda
                true, // Incluir tooltips
                false // No incluir URLs
        );

        // Guardar el gráfico en un archivo PNG
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar gráfico como");

        // Filtro para archivos PNG
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".png") || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Imagen PNG (*.png)";
            }
        });

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            // Asegúrate de que el archivo tenga la extensión .png
            if (!fileToSave.getName().toLowerCase().endsWith(".png")) {
                fileToSave = new File(fileToSave + ".png");
            }

            try {
                // Guardar el gráfico en el archivo seleccionado
                ChartUtils.saveChartAsPNG(fileToSave, chart, 800, 600);
                JOptionPane.showMessageDialog(null, "Gráfico guardado exitosamente en: " + fileToSave.getAbsolutePath());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar el gráfico: " + e.getMessage());
            }
        }


    }//GEN-LAST:event_jButton_DescargarGraficarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_DescargarGraficar;
    private javax.swing.JButton jButton_GeneralPdf;
    private javax.swing.JButton jButton_Graficar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_wallpaper;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_StockBajo;
    // End of variables declaration//GEN-END:variables

    // Método para cargar la tabla con los productos con Stock bajo
    private void CargarTablaStockBajo(int umbral) {
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();
        DefaultTableModel model = new DefaultTableModel();

        // Consulta para seleccionar productos con stock bajo según el umbral
        String sql = "SELECT * FROM productos WHERE cantidad < " + umbral;
        Statement st = null;
        java.sql.ResultSet rs = null;

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            // Establecer el modelo de la tabla
            jTable_StockBajo.setModel(model);
            jScrollPane1.setViewportView(jTable_StockBajo);

            // Añadir columnas al modelo
            model.addColumn("Codigo");
            model.addColumn("Nombre");
            model.addColumn("Descripcion");
            model.addColumn("Cantidad");
            model.addColumn("Proveedor");

            // Cargar los datos en el modelo
            while (rs.next()) {
                Object fila[] = new Object[5];
                fila[0] = rs.getInt("idProducto");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("descripcion");
                fila[3] = rs.getInt("cantidad");
                fila[4] = rs.getString("proveedor");
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

    }

    public void descargarGrafico(JFreeChart chart) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar gráfico como");

        // Filtro para guardar solo imágenes PNG
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".png") || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Imagen PNG (*.png)";
            }
        });

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getName().toLowerCase().endsWith(".png")) {
                fileToSave = new File(fileToSave + ".png"); // Asegurarse de que el archivo tenga extensión .png
            }

            try {
                ChartUtils.saveChartAsPNG(fileToSave, chart, 800, 600);
                JOptionPane.showMessageDialog(null, "Gráfico guardado exitosamente en: " + fileToSave.getAbsolutePath());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar el gráfico: " + e.getMessage());
            }
        }
    }

}
