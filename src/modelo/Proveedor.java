package modelo;

public class Proveedor {

    private int idProveedor;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String descripcion;
    private String estado;

    // contructor vacion
    public Proveedor() {
        this.idProveedor = 0;
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
        this.email = "";
        this.descripcion = "";
        this.estado = "";

    }

    // contructor con parametros
    public Proveedor(int idProveedor, String nombre, String direccion, String telefono, String email, String descripcion, String estado) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    // getter and setter
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }

}
