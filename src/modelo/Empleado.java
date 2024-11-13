package modelo;

public class Empleado {

    private int idempleado;
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String telefono;
    private String cargo;
    private Double salario;
    private Double deducciones;
    private String fondo_pensiones;
    private String eps;
    private String fechaIngreso;

    public Empleado(String cedula, String nombre, String apellido, String direccion, String telefono, String cargo, double salario, double deducciones, String fondoPensiones, String eps, String fechaIngreso) {

        this.idempleado = 0; // Asumimos que el ID se asignará más tarde, o puede ser autoincremental en la base de datos.
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cargo = cargo;
        this.salario = salario;
        this.deducciones = deducciones;
        this.fondo_pensiones = fondoPensiones;
        this.eps = eps;
        this.fechaIngreso = fechaIngreso;
    }
    // contructo supercargado

    public Empleado(int idempleado, String nombre, String apellido, String cedula, String direccion, String telefono, String cargo, Double salario, Double deducciones, String fondo_pensiones, String eps, String fechaIngreso) {
        this.idempleado = idempleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cargo = cargo;
        this.salario = salario;
        this.deducciones = deducciones;
        this.fondo_pensiones = fondo_pensiones;
        this.eps = eps;
        this.fechaIngreso = fechaIngreso;
    }

    public Empleado() {
        // Constructor vacío para crear un objeto Empleado sin parámetros
    }

    // getter and setter

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getDeducciones() {
        return deducciones;
    }

    public void setDeducciones(Double deducciones) {
        this.deducciones = deducciones;
    }

    public String getFondo_pensiones() {
        return fondo_pensiones;
    }

    public void setFondo_pensiones(String fondo_pensiones) {
        this.fondo_pensiones = fondo_pensiones;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    // toString

    @Override
    public String toString() {
        return "Empleado{" + "idempleado=" + idempleado + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", direccion=" + direccion + ", telefono=" + telefono + ", cargo=" + cargo + ", salario=" + salario + ", deducciones=" + deducciones + ", fondo_pensiones=" + fondo_pensiones + ", eps=" + eps + ", fechaIngreso=" + fechaIngreso + '}';
    }
    
}
