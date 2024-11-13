package modelo;

public class CabeceraVenta {

    private int idCabeceraVengta;
    private int idCliente;
    private double ValorPagar;
    private String fechaVenta;
    private int estado;

    // Constructor sin parámetros
    public CabeceraVenta() {
        this.idCabeceraVengta = 0;
        this.idCliente = 0;
        this.ValorPagar = 0;
        this.fechaVenta = "";
        this.estado = 0;
    }

    // Constructor con parámetros
    public CabeceraVenta(int idCabeceraVengta, int idCliente, double ValorPagar, String fechaVenta, int estado) {
        this.idCabeceraVengta = idCabeceraVengta;
        this.idCliente = idCliente;
        this.ValorPagar = ValorPagar;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }
    // getter and setter

    public int getIdCabeceraVengta() {
        return idCabeceraVengta;
    }

    public void setIdCabeceraVengta(int idCabeceraVengta) {
        this.idCabeceraVengta = idCabeceraVengta;
    }

    public int getIdCliente(int idcliente) {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorPagar() {
        return ValorPagar;
    }

    public void setValorPagar(double ValorPagar) {
        this.ValorPagar = ValorPagar;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdCabeceraVenta() {
        return idCabeceraVengta;
    }

    public void setId(int idCabeceraVenta) {
        this.idCabeceraVengta = idCabeceraVenta;
    }
    // metodo toString

    @Override
    public String toString() {
        return "CabeceraVenta{" + "idCabeceraVengta=" + idCabeceraVengta + ", idCliente=" + idCliente + ", ValorPagar=" + ValorPagar + ", fechaVenta=" + fechaVenta + ", estado=" + estado + '}';
    }

   
}
