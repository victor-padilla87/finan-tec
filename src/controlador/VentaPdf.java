package controlador;

import Conexion.Conexionmysql;
import Vistas.InterFacturacion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentaPdf {
    
    // variables globales declaradas para los datos del cliente
    private String nombreCliente;
    private String idCliente;
    private String telefonoCliente;
    private String direccionCliente;

    private String fechaActual = "";
    private String nombreArchivoPDFVenta = "";

    public void datosCliente(int id) {
    // Instancia de la conexión
    Conexionmysql conexion = new Conexionmysql();
    Connection cn = conexion.getConnection();

    // Verificar que el id no sea 0 o negativo
    if (id <= 0) {
        System.out.println("ID de cliente no válido.");
        return;
    }

    // Consulta SQL
    String sql = "SELECT * FROM clientes WHERE id = '" + id + "'";
    Statement st;
    try {
        st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        // Validar si la consulta devuelve resultados
        if (!rs.isBeforeFirst()) { // Si no hay resultados
            System.out.println("No se encontró el cliente con ID: " + id);
            return;
        }

        // Procesar los datos del cliente
        while (rs.next()) {
            nombreCliente = rs.getString("nombre") + " " + rs.getString("apellido");
            idCliente = rs.getString("id");
            telefonoCliente = rs.getString("telefono");
            direccionCliente = rs.getString("direccion");
        }
        
        System.out.println("Nombre del cliente cargado: " + nombreCliente);

        // Cerrar la conexión
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al obtener los datos del cliente: " + e);
    }
}

    // metodo para general la factura
    public void generalFacturaPDF() {

        try {
            // cargar la fecha actual
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(date);
            // cambiar el formato de la fecha
            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");

                }

            }

            nombreArchivoPDFVenta = "Venta_" + nombreCliente + "_" + fechaNueva + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image imagenes = Image.getInstance("src/imagenes/ventas.png");
            
            // Paragraph para crear un parrafo
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.GREEN);
            
            fecha.add(Chunk.NEWLINE);
            
            // "\n" para agregar un salto de linea
            fecha.add("""
                      Factura 001:
                      Fecha:""" + fechaActual + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0); // quitar los bordes de la tabla
            
            // tamaño de las celdas
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            // agregar celdas
            Encabezado.addCell(imagenes);

            String nit = "1045493668-9";
            String nombre = "A&C/TIENDA";
            String telefono = "3238122690";
            String direccion = "Carrera 14A BARRIO BALTAZAR";
            String correo = "a&ctienda@gmail.com";

            Encabezado.addCell("");
            Encabezado.addCell(" NIT: " + nit + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nCORREO: " + correo);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            // cuerpo de la factura
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("""
                        Datos del cliente: 
                        
                        """);
            doc.add(cliente);

            PdfPTable tablaClientes = new PdfPTable(4);
            tablaClientes.setWidthPercentage(100);
            tablaClientes.getDefaultCell().setBorder(0);

            // tamaño de las celdas
            float[] ColumnaClientes = new float[]{25f, 35f, 30f, 40f};
            tablaClientes.setWidths(ColumnaClientes);
            tablaClientes.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("cedula/NIT: ", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("NOMBRE: ", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("TELEFONO: ", negrita));
            PdfPCell cliente4 = new PdfPCell(new Phrase("DIRECCION: ", negrita));
            
            // quitar los bordes a las celdas
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);
            
            // se agregan los datos a la tabla
            tablaClientes.addCell(cliente1);
            tablaClientes.addCell(cliente2);
            tablaClientes.addCell(cliente3);
            tablaClientes.addCell(cliente4);
            tablaClientes.addCell(idCliente);
            tablaClientes.addCell(nombreCliente);
            tablaClientes.addCell(telefonoCliente);
            tablaClientes.addCell(direccionCliente);
            
            // se agregan al documento
            doc.add(tablaClientes);
            
            // agregar un espacio en blanco para la separacion
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);
            
            // agregar los productos
            PdfPTable tablaProductos = new PdfPTable(4);
            tablaProductos.setWidthPercentage(100);
            tablaProductos.getDefaultCell().setBorder(0); // quitar los bordes de la tabla
            
            // tamaño de las celdas
            float[] ColumnaProductos = new float[]{15f, 50f, 15f, 20f};
            tablaProductos.setWidths(ColumnaProductos);
            tablaProductos.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Descripcion: ", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio unitario: ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Precio total: ", negrita));
            
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            
            //agregar color a el encabezado
            producto1.setBackgroundColor(BaseColor.MAGENTA);
            producto2.setBackgroundColor(BaseColor.MAGENTA);
            producto3.setBackgroundColor(BaseColor.MAGENTA);
            producto4.setBackgroundColor(BaseColor.MAGENTA);
            
            // se agrega la celda productos a la tabla
            tablaProductos.addCell(producto1);
            tablaProductos.addCell(producto2);
            tablaProductos.addCell(producto3);
            tablaProductos.addCell(producto4);
            
            for(int i = 0; i < InterFacturacion.jTable_productos.getRowCount(); i++){
                String producto = InterFacturacion.jTable_productos.getValueAt(i, 1).toString();
                String cantidad = InterFacturacion.jTable_productos.getValueAt(i, 2).toString();
                String precio = InterFacturacion.jTable_productos.getValueAt(i, 3).toString();
                String total = InterFacturacion.jTable_productos.getValueAt(i, 7).toString();
                
                tablaProductos.addCell(cantidad);
                tablaProductos.addCell(producto);
                tablaProductos.addCell(precio);
                tablaProductos.addCell(total);
            }
            // agregamos a el documento
            doc.add(tablaProductos);
            
            // total apagar
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Toatal Apagar: " + InterFacturacion.txt_total_apagar.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            // firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelacion y firma\n\n");
            firma.add("_______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            
            // mensaje final
            // firma
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("¡Gracias por su Preferencia!");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
            
            // cierre del documento y el archivo
            doc.close();
            archivo.close();
            
            // apertura de la factura al ser generada
            Desktop.getDesktop().open(file);
                    

        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }

}
