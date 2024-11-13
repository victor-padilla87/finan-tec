package controlador;

import Conexion.Conexionmysql;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Font;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Ctr_ReportesClientes {

    // Método para crear reportes de los clientes
    public void ReportesClientes() throws DocumentException, FileNotFoundException {
        Document documento = new Document(PageSize.A4, 50, 50, 50, 50); // Tamaño de página A4 con márgenes
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Clientes.pdf"));

            // Abrir el documento
            documento.open();

            // Agregar imagen de encabezado
            try {
                Image header = Image.getInstance("src/imagenes/header1.jpg");
                header.scaleToFit(650, 100);
                header.setAlignment(Chunk.ALIGN_CENTER);
                documento.add(header);
            } catch (IOException e) {
                System.out.println("Error al cargar la imagen: " + e.getMessage());
            }

            // Agregar título estilizado
            Paragraph titulo = new Paragraph("Reporte de Clientes\n\n",
                    FontFactory.getFont("Arial", 26, Font.BOLD, BaseColor.BLUE));
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            // Subtítulo con creador y fecha
            Paragraph subtitulo = new Paragraph("Reporte generado por Victor Andres Padilla\nFecha: " + java.time.LocalDate.now() + "\n\n",
                    FontFactory.getFont("Arial", 12, Font.ITALIC, BaseColor.DARK_GRAY));
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(subtitulo);

            // Espacio antes de la tabla
            documento.add(new Paragraph("\n"));

            // Crear tabla con los datos de los clientes
            PdfPTable tabla = new PdfPTable(7); // 7 columnas: Código, Cédula, Nombre, Apellido, Dirección, Teléfono, Correo
            tabla.setWidthPercentage(100); // Ancho de la tabla en relación a la página
            tabla.setSpacingBefore(10f);
            tabla.setSpacingAfter(10f);
            tabla.setWidths(new float[]{2f, 3f, 3f, 3f, 4f, 3f, 4f}); // Ajusta el ancho de las columnas

            // Estilo de encabezado de la tabla
            com.itextpdf.text.Font fontHeader = FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.WHITE);
            PdfPCell cell;

            // Encabezados de la tabla
            String[] cabeceras = {"Código", "Cédula", "Nombre", "Apellido", "Dirección", "Teléfono", "Correo"};
            for (String cabecera : cabeceras) {
                cell = new PdfPCell(new Phrase(cabecera, fontHeader));
                cell.setBackgroundColor(BaseColor.BLUE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPadding(8f);
                tabla.addCell(cell);
            }

            // Obtener los datos de la base de datos
            try {
                Conexionmysql conexion = new Conexionmysql();
                Connection cn = conexion.getConnection();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT idCliente, cedula, nombre, apellido, direccion, telefono, email FROM clientes");

                ResultSet rs = pst.executeQuery();

                // Estilo de las celdas de datos
                com.itextpdf.text.Font fontData = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD);

                while (rs.next()) {
                    // Agregar los datos de cada cliente a las celdas de la tabla
                    PdfPCell cellCodigo = new PdfPCell(new Phrase(rs.getString("idCliente"), fontData));
                    cellCodigo.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(cellCodigo);

                    PdfPCell cellCedula = new PdfPCell(new Phrase(rs.getString("cedula"), fontData));
                    cellCedula.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(cellCedula);

                    PdfPCell cellNombre = new PdfPCell(new Phrase(rs.getString("nombre"), fontData));
                    cellNombre.setHorizontalAlignment(Element.ALIGN_LEFT);
                    tabla.addCell(cellNombre);

                    PdfPCell cellApellido = new PdfPCell(new Phrase(rs.getString("apellido"), fontData));
                    cellApellido.setHorizontalAlignment(Element.ALIGN_LEFT);
                    tabla.addCell(cellApellido);

                    PdfPCell cellDireccion = new PdfPCell(new Phrase(rs.getString("direccion"), fontData));
                    cellDireccion.setHorizontalAlignment(Element.ALIGN_LEFT);
                    tabla.addCell(cellDireccion);

                    PdfPCell cellTelefono = new PdfPCell(new Phrase(rs.getString("telefono"), fontData));
                    cellTelefono.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(cellTelefono);

                    PdfPCell cellCorreo = new PdfPCell(new Phrase(rs.getString("email"), fontData));
                    cellCorreo.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(cellCorreo);
                }

            } catch (SQLException e) {
                System.out.println("Error al obtener los datos: " + e.getMessage());
            }

            // Agregar la tabla completa al documento después de agregar los datos
            documento.add(tabla);

            // Mensaje de éxito
            JOptionPane.showMessageDialog(null, "¡Reporte de Clientes creado correctamente!");

        } catch (DocumentException | IOException e) {
            System.out.println("Error al generar el documento: " + e.getMessage());
        } finally {
            // Cerrar el documento
            documento.close();
        }
    }

}
