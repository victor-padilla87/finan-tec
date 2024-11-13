package modelo;

public class Producto {

    // atributos
    private int idProducto;
    private String nombre;
    private String descripcion;
    private Double precioCompra;
    private Double precioUnitario;
    private int cantidad;
    private Double porcentajeIva;
    private Double descuento;
    private String proveedor;
    private int idCategoria;
    private int idFactura;

    // contructor
    public Producto() {

        this.idProducto = 0;
        this.nombre = "";
        this.descripcion = "";
        this.precioCompra = 0.0;
        this.precioUnitario = 0.0;
        this.cantidad = 0;
        this.porcentajeIva = 0.0;
        this.descuento = 0.0;
        this.proveedor = "";
        this.idCategoria = 0;
        this.idFactura = 0;
    }

    // contructor

    public Producto(int idProducto, String nombre, String descripcion, Double precioCompra, Double precioUnitario, int cantidad, Double porcentajeIva, Double descuento, String proveedor, int idCategoria, int idFactura) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.porcentajeIva = porcentajeIva;
        this.descuento = descuento;
        this.proveedor = proveedor;
        this.idCategoria = idCategoria;
        this.idFactura = idFactura;
    }
    
    //getter and setter

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(Double porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    
    
}
