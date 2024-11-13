package Vistas;

import Conexion.Conexionmysql;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.CabeceraVenta;
import modelo.DetalleVenta;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PuntoDeVenta extends JFrame {

    private final JTextField campoBusqueda;
    private final JTextField campoCantidad;
    private final JTextField txt_cliente_buscar;
    private final JButton botonBuscar;
    private final JButton botonBuscarCliente;
    private final JButton botonAgregar;
    private final JButton botonEliminar;
    private final JButton botonCancelar;
    private final JButton botonConfirmar;
//    private final JButton botonCotizar;  
    private final JButton botonRegresar; 
    private final JTable tablaProductos;
    private final JTable tablaVenta;
    private final JLabel etiquetaSubtotal;
    private final JLabel etiquetaIva;
    private final JLabel etiquetaTotal;
    private final JLabel jLabel_wallpaper;
    private final DefaultTableModel modeloProductos;
    private DefaultTableModel modeloVenta;
    private JComboBox<String> jComboBox_Cliente;
    private double subtotal = 0.0, iva = 0.0, total = 0.0;

    public PuntoDeVenta() {
        // Inicializar modelo de datos y tabla de productos
        modeloProductos = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nombre", "Cantidad", "Precio"});
        tablaProductos = new JTable(modeloProductos);

        setTitle("Punto de Venta");
        setExtendedState(MAXIMIZED_BOTH);
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Conexionmysql conexion = new Conexionmysql();

        // Inicializa el ComboBox para clientes
        jComboBox_Cliente = new JComboBox<>();
        jComboBox_Cliente.addItem("Seleccione cliente:");
        CargarComboClientes();  // Llama al método para cargar los clientes en el comboBox

        // Fondo de pantalla
        ImageIcon wallpaper = new ImageIcon("src/imagenes/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT));
        jLabel_wallpaper = new JLabel(icono);
        jLabel_wallpaper.setBounds(0, 0, 900, 700);
        this.getLayeredPane().add(jLabel_wallpaper, Integer.valueOf(Integer.MIN_VALUE));

        // Panel Superior: Búsqueda y Cantidad
        JPanel panelSuperior = new JPanel(new GridLayout(1, 6, 10, 10));
        panelSuperior.setOpaque(false);

        campoBusqueda = new JTextField();
        botonBuscar = new JButton("Buscar");
        botonBuscar.setBackground(new Color(0, 191, 255));
        botonBuscar.setForeground(Color.WHITE);
        botonBuscar.setFocusPainted(false);
        botonBuscar.setPreferredSize(new Dimension(90, 30));  

        campoCantidad = new JTextField("1");
        botonAgregar = new JButton("Agregar");
        botonAgregar.setBackground(new Color(50, 205, 50));
        botonAgregar.setForeground(Color.WHITE);
        botonAgregar.setFocusPainted(false);
        botonAgregar.setPreferredSize(new Dimension(90, 30)); 

        txt_cliente_buscar = new JTextField();
        botonBuscarCliente = new JButton("Buscar Cliente");
        botonBuscarCliente.setBackground(new Color(0, 191, 255));
        botonBuscarCliente.setForeground(Color.WHITE);
        botonBuscarCliente.setFocusPainted(false);
        botonBuscarCliente.setPreferredSize(new Dimension(90, 30));  

        // Agregar componentes de cliente y producto al panel
        panelSuperior.add(new JLabel("Buscar Cliente (Cédula):", SwingConstants.RIGHT));
        panelSuperior.add(txt_cliente_buscar);
        panelSuperior.add(botonBuscarCliente);
        panelSuperior.add(new JLabel("Seleccione Cliente:", SwingConstants.RIGHT));
        panelSuperior.add(jComboBox_Cliente);
        panelSuperior.add(new JLabel(""));

        panelSuperior.add(new JLabel("Buscar Producto (ID/Nombre/Descripción):", SwingConstants.RIGHT));
        panelSuperior.add(campoBusqueda);
        panelSuperior.add(botonBuscar);
        panelSuperior.add(new JLabel("Cantidad:", SwingConstants.RIGHT));
        panelSuperior.add(campoCantidad);
        panelSuperior.add(botonAgregar);

        add(panelSuperior, BorderLayout.NORTH);

        // Panel Central: Tablas de Productos y Venta
        JPanel panelCentral = new JPanel(new GridLayout(1, 2));
        panelCentral.setOpaque(false);

        // Tabla de Productos (carga inicial de productos)
        cargarProductos(conexion);
        panelCentral.add(new JScrollPane(tablaProductos));

        modeloVenta = new DefaultTableModel(new Object[]{"ID", "Nombre", "Cantidad", "Precio Unitario", "Subtotal"}, 0);
        tablaVenta = new JTable(modeloVenta);
        panelCentral.add(new JScrollPane(tablaVenta));

        add(panelCentral, BorderLayout.CENTER);

        // Panel Inferior: Cálculo de Totales y Botones
        JPanel panelInferior = new JPanel(new GridLayout(3, 4, 10, 10));
        panelInferior.setOpaque(false);

        etiquetaSubtotal = new JLabel("Subtotal: $0.0");
        etiquetaIva = new JLabel("IVA (19%): $0.0");
        etiquetaTotal = new JLabel("Total: $0.0");

        botonEliminar = new JButton("Eliminar Producto");
        botonEliminar.setBackground(new Color(255, 99, 71));
        botonEliminar.setForeground(Color.WHITE);
        botonEliminar.setFocusPainted(false);
        botonEliminar.setPreferredSize(new Dimension(90, 40));  

        botonCancelar = new JButton("Cancelar Venta");
        botonCancelar.setBackground(new Color(255, 69, 0));
        botonCancelar.setForeground(Color.WHITE);
        botonCancelar.setFocusPainted(false);
        botonCancelar.setPreferredSize(new Dimension(90, 40)); 

        botonConfirmar = new JButton("Confirmar Venta");
        botonConfirmar.setBackground(new Color(0, 128, 0));
        botonConfirmar.setForeground(Color.WHITE);
        botonConfirmar.setFocusPainted(false);
        botonConfirmar.setPreferredSize(new Dimension(90, 40));  

//        botonCotizar = new JButton("Cotización");
//        botonCotizar.setBackground(new Color(100, 149, 237));
//        botonCotizar.setForeground(Color.WHITE);
//        botonCotizar.setFocusPainted(false);
//        botonCotizar.setPreferredSize(new Dimension(90, 40));  

        botonRegresar = new JButton("Regresar a Inicio");
        botonRegresar.setBackground(new Color(123, 104, 238));
        botonRegresar.setForeground(Color.WHITE);
        botonRegresar.setFocusPainted(false);
        botonRegresar.setPreferredSize(new Dimension(90, 40));  

        panelInferior.add(etiquetaSubtotal);
        panelInferior.add(etiquetaIva);
        panelInferior.add(etiquetaTotal);
        panelInferior.add(botonEliminar);
//        panelInferior.add(botonCotizar);  
        panelInferior.add(botonCancelar);
        panelInferior.add(botonRegresar);  
        panelInferior.add(botonConfirmar);

        add(panelInferior, BorderLayout.SOUTH);

        // Eventos de Búsqueda y Agregado
        botonBuscar.addActionListener(e -> buscarProducto(conexion));
        botonBuscarCliente.addActionListener(e -> buscarClientePorCedula(conexion));
        botonAgregar.addActionListener(e -> agregarProducto());
        botonEliminar.addActionListener(e -> eliminarProducto());
        botonCancelar.addActionListener(e -> cancelarVenta());
        botonConfirmar.addActionListener(e -> confirmarVenta(conexion));

        // Acción para cotizar
        //botonCotizar.addActionListener(e -> cotizarVenta());
        // Acción para regresar a la página principal
        botonRegresar.addActionListener(e -> regresarInicio());
        setVisible(true);
    }

    // Método para cotizar (ejemplo básico)
    private void cotizarVenta() {
        JOptionPane.showMessageDialog(this, "Generando cotización...\nTotal: $" + total);
    }

    // Método para regresar al inicio
    private void regresarInicio() {
        dispose();  // Cierra la ventana actual
         MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
    }

// buscar cliente por cedula
    private void buscarClientePorCedula(Conexionmysql conexion) {
        String clienteBuscar = txt_cliente_buscar.getText().trim();

        if (clienteBuscar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cédula.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection cn = Conexionmysql.getConexion()) {
            String sql = "SELECT nombre, apellido FROM clientes WHERE cedula = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, clienteBuscar);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String cliente = rs.getString("nombre") + " " + rs.getString("apellido");
                jComboBox_Cliente.setSelectedItem(cliente);  // Cambia la selección en el ComboBox
            } else {
                JOptionPane.showMessageDialog(this, "¡Cédula incorrecta o no existe!", "Error", JOptionPane.ERROR_MESSAGE);
                jComboBox_Cliente.setSelectedItem("Seleccione cliente:");
            }

            txt_cliente_buscar.setText("");  // Limpia el campo de texto

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // metodo para cargar clientes en el jComboBox_Cliente
    private void CargarComboClientes() {
        try (Connection cn = Conexionmysql.getConexion()) {
            String sql = "SELECT nombre, apellido FROM clientes";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            jComboBox_Cliente.removeAllItems();
            jComboBox_Cliente.addItem("Seleccione Cliente:");

            while (rs.next()) {
                jComboBox_Cliente.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        } catch (SQLException e) {
            System.out.println("No se pudieron cargar los clientes: " + e);
        }
    }
// meto para cargar productos

    private void cargarProductos(Conexionmysql conexion) {
        try (Connection cn = Conexionmysql.getConexion(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM productos")) {
            while (rs.next()) {
                modeloProductos.addRow(new Object[]{rs.getInt("idProducto"), rs.getString("nombre"), rs.getString("descripcion"), rs.getDouble("precio_unitario")});
            }
        } catch (SQLException e) {
        }
    }

    private void buscarProducto(Conexionmysql conexion) {
        String busqueda = campoBusqueda.getText();
        modeloProductos.setRowCount(0);

        String query = "SELECT * FROM productos WHERE idProducto LIKE ? OR nombre LIKE ? OR descripcion LIKE ?";
        try (Connection cn = Conexionmysql.getConexion(); PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, "%" + busqueda + "%");
            ps.setString(2, "%" + busqueda + "%");
            ps.setString(3, "%" + busqueda + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                modeloProductos.addRow(new Object[]{rs.getInt("idProducto"), rs.getString("nombre"), rs.getString("descripcion"), rs.getDouble("precio_unitario")});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en la búsqueda de productos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarProducto() {
        int selectedRow = tablaProductos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto primero.");
            return;
        }

        try {
            // Verificar y convertir datos
            int id = Integer.parseInt(modeloProductos.getValueAt(selectedRow, 0).toString());
            String nombre = modeloProductos.getValueAt(selectedRow, 1).toString();
            double precio = Double.parseDouble(modeloProductos.getValueAt(selectedRow, 3).toString());

            System.out.println("Datos del producto seleccionados: ID=" + id + ", Nombre=" + nombre + ", Precio=" + precio);

            // Verificar cantidad
            int cantidad = Integer.parseInt(campoCantidad.getText());
            if (cantidad <= 0) {
                throw new NumberFormatException();
            }

            // Agregar producto a la tabla de ventas
            double subtotalProducto = precio * cantidad;
            modeloVenta.addRow(new Object[]{id, nombre, cantidad, precio, subtotalProducto});

            System.out.println("Producto agregado correctamente: " + nombre + " con cantidad " + cantidad);

            // Actualizar totales
            subtotal += subtotalProducto;
            iva = subtotal * 0.19;
            total = subtotal + iva;
            actualizarTotales();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.");
        }
    }

    private void eliminarProducto() {
        int selectedRow = tablaVenta.getSelectedRow();
        if (selectedRow != -1) {
            double subtotalProducto = (double) modeloVenta.getValueAt(selectedRow, 4);
            subtotal -= subtotalProducto;
            iva = subtotal * 0.19;
            total = subtotal + iva;
            modeloVenta.removeRow(selectedRow);
            actualizarTotales();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar.");
        }
    }

    private void cancelarVenta() {
        modeloVenta.setRowCount(0);
        subtotal = iva = total = 0.0;
        actualizarTotales();
    }

    private void actualizarTotales() {
        etiquetaSubtotal.setText("Subtotal: $" + String.format("%.2f", subtotal));
        etiquetaIva.setText("IVA (19%): $" + String.format("%.2f", iva));
        etiquetaTotal.setText("Total: $" + String.format("%.2f", total));
    }

    private void confirmarVenta(Conexionmysql conexion) {

        // Obtener el nombre del cliente seleccionado en el JComboBox y buscar su ID
        String clienteSeleccionado = (String) jComboBox_Cliente.getSelectedItem();
        int idCliente = obtenerIdClientePorNombre(clienteSeleccionado, conexion);
        if (idCliente == -1) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado. Por favor, seleccione un cliente válido.");
            return;
        }

        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        cabeceraVenta.setIdCliente(idCliente);
        cabeceraVenta.setValorPagar(total);
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        cabeceraVenta.setFechaVenta(fechaActual.format(formatter));
        cabeceraVenta.setEstado(1);

        int idCabecera = guardarCabeceraVenta(cabeceraVenta, conexion);
        if (idCabecera == -1) {
            JOptionPane.showMessageDialog(this, "Error al guardar la cabecera de venta.");
            return;
        }

        // Guardar los detalles de la venta
        try (Connection cn = Conexionmysql.getConexion()) {
            for (int i = 0; i < modeloVenta.getRowCount(); i++) {
                DetalleVenta detalleVenta = new DetalleVenta();
                detalleVenta.setIdCabecerVenta(idCabecera);  // Asignar el ID de la cabecera guardada
                detalleVenta.setIdProducto((int) modeloVenta.getValueAt(i, 0));
                detalleVenta.setNombre((String) modeloVenta.getValueAt(i, 1));
                detalleVenta.setCantidad((int) modeloVenta.getValueAt(i, 2));
                detalleVenta.setPrecioUnitario((double) modeloVenta.getValueAt(i, 3));
                detalleVenta.setSubtotal((double) modeloVenta.getValueAt(i, 4));
                detalleVenta.setDescuento(0.0);
                detalleVenta.setIva(detalleVenta.getSubtotal() * 0.19);
                detalleVenta.setTotalApagar(detalleVenta.getSubtotal() + detalleVenta.getIva() - detalleVenta.getDescuento());
                detalleVenta.setEstado(1);

                // Inserta el detalle de venta
                String query = "INSERT INTO detalle_venta (idCabeceraVenta, idProducto, nombre_producto, cantidad, precio_unitario, subtotal, descuento, iva, total_apagar, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement ps = cn.prepareStatement(query)) {
                    ps.setInt(1, detalleVenta.getIdCabecerVenta());
                    ps.setInt(2, detalleVenta.getIdProducto());
                    ps.setString(3, detalleVenta.getNombre_Producto());
                    ps.setInt(4, detalleVenta.getCantidad());
                    ps.setDouble(5, detalleVenta.getPrecioUnitario());
                    ps.setDouble(6, detalleVenta.getSubtotal());
                    ps.setDouble(7, detalleVenta.getDescuento());
                    ps.setDouble(8, detalleVenta.getIva());
                    ps.setDouble(9, detalleVenta.getTotalApagar());
                    ps.setInt(10, detalleVenta.getIdEstado());

                    ps.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(this, "Venta confirmada!");

            // Llamar al método generarFactura y pasar el nombre del cliente
            mostrarFactura(clienteSeleccionado); // <--- Aquí pasamos el nombre del cliente

            // limpiar la venta actual
            cancelarVenta();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarFactura(String cliente) {
        // Verificar la cantidad de productos en el modelo de ventas
        System.out.println("Productos en el modelo de ventas: " + modeloVenta.getRowCount());

        // Si el modelo de ventas está vacío, mostrar el mensaje y terminar
        if (modeloVenta.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay productos en la venta.");
            return;
        }

        int numeroFactura = obtenerNumeroFactura();
        StringBuilder contenidoFactura = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String fechaFactura = sdf.format(new Date());

        // Encabezado de la factura
        contenidoFactura.append("**************************************************\n");
        contenidoFactura.append("                    A&C/TIENDA                   \n");
        contenidoFactura.append("NIT: 1045493668-9\n");
        contenidoFactura.append("Teléfono: 3238122690\n");
        contenidoFactura.append("Dirección: Carrera 14A BARRIO BALTAZAR\n");
        contenidoFactura.append("Correo: a&ctienda@gmail.com\n");
        contenidoFactura.append("**************************************************\n\n");

        // Información de la factura y cliente
        contenidoFactura.append("Factura N°: " + String.format("%03d", numeroFactura) + "\n");
        contenidoFactura.append("Fecha: " + LocalDate.now().toString() + "\n");
        contenidoFactura.append("Cliente: " + cliente + "\n\n");

        // Encabezado de productos
        contenidoFactura.append(String.format("%-10s %-20s %-10s %-10s %-10s\n", "ID", "Nombre", "Cantidad", "Precio", "Subtotal"));
        contenidoFactura.append("--------------------------------------------------------------------------------------------\n");

        double subtotalFactura = 0.0;
        double ivaFactura = 0.0;
        double totalFactura = 0.0;

// Modelo de venta y agregar productos a la factura
        for (int i = 0; i < modeloVenta.getRowCount(); i++) {
            int id = (int) modeloVenta.getValueAt(i, 0);
            String nombre = (String) modeloVenta.getValueAt(i, 1);
            int cantidad = (int) modeloVenta.getValueAt(i, 2);
            double precio = (double) modeloVenta.getValueAt(i, 3);
            double subtotalProducto = (double) modeloVenta.getValueAt(i, 4);

            // Añadir datos del producto a la factura y centrarlos en cada columna
            contenidoFactura.append(String.format("%-10d %-20s %-10d %-10.2f %-10.2f\n",
                    id, nombre, cantidad, precio, subtotalProducto));

            // Sumar subtotal del producto al subtotal general
            subtotalFactura += subtotalProducto;
        }

// Redibuja la tabla de ventas para actualizar la presentación en la interfaz
        tablaVenta.revalidate();
        tablaVenta.repaint();
        // Calcular IVA y total de la factura
        ivaFactura = subtotalFactura * 0.19;
        totalFactura = subtotalFactura + ivaFactura;

        // Totales generales de la factura
        contenidoFactura.append("\n");
        contenidoFactura.append("Subtotal: $" + String.format("%.2f", subtotalFactura) + "\n");
        contenidoFactura.append("IVA (19%): $" + String.format("%.2f", ivaFactura) + "\n");
        contenidoFactura.append("Total: $" + String.format("%.2f", totalFactura) + "\n");

        // Pie de página
        contenidoFactura.append("\n**************************************************\n");
        contenidoFactura.append("¡A&CTienda le da las Gracias por su preferencia! Esperamos su pronta visita.\n");
        contenidoFactura.append("**************************************************\n");

        // Mostrar la factura en un cuadro de diálogo
        JTextArea textArea = new JTextArea(contenidoFactura.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        JDialog dialogoFactura = new JDialog();
        dialogoFactura.setTitle("Factura - A&C/TIENDA");
        dialogoFactura.setModal(true);
        dialogoFactura.setLayout(new BorderLayout());
        dialogoFactura.add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton btnImprimir = new JButton("Imprimir");
        JButton btnDescargar = new JButton("Descargar");

        btnImprimir.addActionListener(e -> {
            try {
                textArea.print();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialogoFactura, "Error al imprimir: " + ex.getMessage());
            }
        });

        btnDescargar.addActionListener(e -> {
            try {
                String nombreArchivo = "Factura_" + fechaFactura + ".txt";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
                    writer.write(contenidoFactura.toString());
                }
                JOptionPane.showMessageDialog(dialogoFactura, "Factura guardada como " + nombreArchivo);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(dialogoFactura, "Error al guardar la factura: " + ex.getMessage());
            }
        });

        panelBotones.add(btnImprimir);
        panelBotones.add(btnDescargar);
        dialogoFactura.add(panelBotones, BorderLayout.SOUTH);
        dialogoFactura.pack();
        dialogoFactura.setLocationRelativeTo(null);
        dialogoFactura.setVisible(true);

        incrementarNumeroFactura();
    }

// Método para obtener el número de factura
    private int obtenerNumeroFactura() {
        try (BufferedReader reader = new BufferedReader(new FileReader("factura_numero.txt"))) {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            return 1; // Inicia con 001 si no existe el archivo
        }
    }

// Método para incrementar el número de factura
    private void incrementarNumeroFactura() {
        int numeroActual = obtenerNumeroFactura();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("factura_numero.txt"))) {
            writer.write(String.valueOf(numeroActual + 1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

// Método para obtener el ID del cliente por nombre
    private int obtenerIdClientePorNombre(String nombreCliente, Conexionmysql conexion) {
        int idCliente = -1;
        String query = "SELECT idCliente FROM clientes WHERE CONCAT(nombre, ' ', apellido) = ?";
        try (Connection cn = Conexionmysql.getConexion(); PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, nombreCliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idCliente;
    }

// Modificar el método guardar para devolver el ID de la cabecera de venta
    private int guardarCabeceraVenta(CabeceraVenta cabeceraVenta, Conexionmysql conexion) {
        String query = "INSERT INTO cabecera_venta (idCliente, valor_pagar, fecha_venta, estado) VALUES (?, ?, ?, ?)";
        try (Connection cn = Conexionmysql.getConexion(); PreparedStatement ps = cn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, cabeceraVenta.getIdCliente(WIDTH));
            ps.setDouble(2, cabeceraVenta.getValorPagar());
            ps.setString(3, cabeceraVenta.getFechaVenta());
            ps.setInt(4, cabeceraVenta.getEstado());
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Retornar el ID generado
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
