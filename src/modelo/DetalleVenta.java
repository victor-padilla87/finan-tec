package modelo;

public class DetalleVenta {

    // atributos
    private int idDetalleVenta;
    private int idCabecerVenta;
    private int idProducto;
    // adicional
    private String nombre_producto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    private double descuento;
    private double iva;
    private double totalApagar;
    private int estado;

    // contructor vacio
    public DetalleVenta(int auxIdDetalle, int par, int idproducto, String nombre1_producto, int cantidad1, double precioUnitario1, double subtotal1, double descuento1, double iva1, double totalApagar1, int par1) {
        this.idDetalleVenta = 0;
        this.idCabecerVenta = 0;
        this.idProducto = 0;
        this.nombre_producto = "";
        this.cantidad = 0;
        this.precioUnitario = 0.0;
        this.subtotal = 0.0;
        this.descuento = 0.0;
        this.iva = 0.0;
        this.totalApagar = 0.0;
        this.estado = 0;
    }
    
    // contructor con parametros
    public DetalleVenta(int idDetalleVenta, int idCabecerVenta, int idProducto, String nombre_producto, int cantidad, double precioUnitario, double subtotal, double descuento, double iva, double totalApagar) {
        this.idDetalleVenta = idDetalleVenta;
        this.idCabecerVenta = idCabecerVenta;
        this.idProducto = idProducto;
        this.nombre_producto = nombre_producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.iva = iva;
        this.totalApagar = totalApagar;
        this.estado = 1;
        
    }
    //getter and setter
    
    public DetalleVenta() {
        
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdCabecerVenta() {
        return idCabecerVenta;
    }

    public void setIdCabecerVenta(int idCabecerVenta) {
        this.idCabecerVenta = idCabecerVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre_Producto() {
        return nombre_producto;
    }

    public void setNombre(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotalApagar() {
        return totalApagar;
    }

    public void setTotalApagar(double totalApagar) {
        this.totalApagar = totalApagar;
    }
    
    public int getIdEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    // metodo toString

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", idCabecerVenta=" + idCabecerVenta + ", idProducto=" + idProducto + ", nombre=" + nombre_producto + ", cantidad=" + cantidad + ", precio_unitario=" + precioUnitario + ", subtotal=" + subtotal + ", descuento=" + descuento + ", iva=" + iva + ", totalApagar=" + totalApagar + "estado=" + estado + '}';
    }
    
}
