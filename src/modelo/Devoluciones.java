package modelo;

import java.util.Date;

public class Devoluciones {

    private int id_devolucion;
    private int id_factura;
    private int idProducto;
    private String nombre_producto;
    private int cantidad_devuelta;
    private String motivo;
    private Date fecha_devolucion;

    // Constructor sin parámetros
    public Devoluciones() {
    }

    // Constructor con parámetros
    public Devoluciones(int id_devolucion, int id_factura, int idProducto, int cantidad_devuelta, String nombre_producto, String motivo, Date fecha_devolucion) {
        this.id_devolucion = id_devolucion;
        this.id_factura = id_factura;
        this.idProducto = idProducto;
        this.nombre_producto = nombre_producto;
        this.cantidad_devuelta = cantidad_devuelta;
        this.motivo = motivo;
        this.fecha_devolucion = fecha_devolucion;
    }

    // getter and setter
    public int getId_devolucion() {
        return id_devolucion;
    }

    public void setId_devolucion(int id_devolucion) {
        this.id_devolucion = id_devolucion;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String Nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad_devuelta() {
        return cantidad_devuelta;
    }

    public void setCantidad_devuelta(int cantidad_devuelta) {
        this.cantidad_devuelta = cantidad_devuelta;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    @Override
    public String toString() {
        return "Devoluciones{" + "id_devolucion=" + id_devolucion + ", id_factura=" + id_factura + ", idProducto=" + idProducto + ", nombre_producto=" + nombre_producto + ", cantidad_devuelta=" + cantidad_devuelta + ", motivo=" + motivo + ", fecha_devolucion=" + fecha_devolucion + '}';
    }

}
