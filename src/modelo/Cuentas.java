package modelo;

import java.util.Date;

public class Cuentas {
    private int id;
    private String tipo; // Puede ser "Cobrar" o "Pagar"
    private String descripcion;
    private double monto;
    private Date fechaVencimiento;
    private String estado; // Ejemplo: "Pendiente", "Pagada"

    public Cuentas(int id, String tipo, String descripcion, double monto, Date fechaVencimiento, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cuentas{" + "id=" + id + ", tipo=" + tipo + ", descripcion=" + descripcion + ", monto=" + monto + ", fechaVencimiento=" + fechaVencimiento + ", estado=" + estado + '}';
    }
    
    
}
