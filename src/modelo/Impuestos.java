package modelo;

import java.util.Date;

public class Impuestos {

    private int id;
    private String descripcion;
    private String tipoImpuesto;
    private double monto;
    private Date fecha_vencimiento;
    private String referenciaPago;
    private String estado;

    public Impuestos(int id, String descripcion, String tipoImpuesto, double monto, Date fecha_vencimiento, String referenciaPago, String estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipoImpuesto = tipoImpuesto;
        this.monto = monto;
        this.fecha_vencimiento = fecha_vencimiento;
        this.referenciaPago = referenciaPago;
        this.estado = estado;
    }

    public Impuestos() {

    }

    // getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(String tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getReferenciaPago() {
        return referenciaPago;
    }

    public void setReferenciaPago(String referenciaPago) {
        this.referenciaPago = referenciaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // toString
    @Override
    public String toString() {
        return "Impuestos{" + "id=" + id + ", descripcion=" + descripcion + ", tipoImpuesto=" + tipoImpuesto + ", monto=" + monto + ", fecha_vencimiento=" + fecha_vencimiento + ", referenciaPago=" + referenciaPago + ", estado=" + estado + '}';
    }

}
