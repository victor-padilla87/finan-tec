package modelo;

public class Transacciones {

    private int id;
    private String tipo_transaccion;
    private Double monto;
    private String fecha;
    private String descripcion;

    public Transacciones() {

        this.id = 0;
        this.tipo_transaccion = "";
        this.monto = 0.0;
        this.fecha = "";
        this.descripcion = "";

    }

    public Transacciones(int id, String tipo_transaccion, Double monto, String fecha, String descripcion) {
        this.id = id;
        this.tipo_transaccion = tipo_transaccion;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
    
    // getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // toString
    @Override
    public String toString() {
        return "Transacciones{" + "id=" + id + ", tipo_transaccion=" + tipo_transaccion + ", monto=" + monto + ", fecha=" + fecha + ", descripcion=" + descripcion + '}';
    }

}
