package modelo;

public class ConfiguracionFacturas {

    private int id_configuracion;
    private String nombre_empresa;
    private String direccion;
    private String telefono;
    private byte[] logo;
    private String pie_pagina;
    private String prefijo;
    private int numero_inicial;
    private Double porcentaje_impuesto;
    private Double porcentaje_descuento;

    // contructor sin parametros
    public ConfiguracionFacturas() {

        this.id_configuracion = 0;
        this.nombre_empresa = "";
        this.direccion = "";
        this.telefono = "";
        this.logo = new byte[0];
        this.pie_pagina = "";
        this.prefijo = "";
        this.numero_inicial = 0;
        this.porcentaje_impuesto = 0.0;
        this.porcentaje_descuento = 0.0;

    }

    // constructor con parametros
    public ConfiguracionFacturas(int id_configuracion, String nombre_empresa, String direccion, String telefono, byte[] logo, String pie_pagina, String prefijo, int numero_inicial, Double porcentaje_impuesto, Double porcentaje_descuento) {
        this.id_configuracion = id_configuracion;
        this.nombre_empresa = nombre_empresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.logo = logo;
        this.pie_pagina = pie_pagina;
        this.prefijo = prefijo;
        this.numero_inicial = numero_inicial;
        this.porcentaje_impuesto = porcentaje_impuesto;
        this.porcentaje_descuento = porcentaje_descuento;
    }

    // getter and setter
    public int getId_configuracion() {
        return id_configuracion;
    }

    public void setId_configuracion(int id_configuracion) {
        this.id_configuracion = id_configuracion;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
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

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getPie_pagina() {
        return pie_pagina;
    }

    public void setPie_pagina(String pie_pagina) {
        this.pie_pagina = pie_pagina;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public int getNumero_inicial() {
        return numero_inicial;
    }

    public void setNumero_inicial(int numero_inicial) {
        this.numero_inicial = numero_inicial;
    }

    public Double getPorcentaje_impuesto() {
        return porcentaje_impuesto;
    }

    public void setPorcentaje_impuesto(Double porcentaje_impuesto) {
        this.porcentaje_impuesto = porcentaje_impuesto;
    }

    public Double getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(Double porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }

    @Override
    public String toString() {
        return "ConfiguracionFacturas{" + "id_configuracion=" + id_configuracion + ", nombre_empresa=" + nombre_empresa + ", direccion=" + direccion + ", telefono=" + telefono + ", logo=" + logo + ", pie_pagina=" + pie_pagina + ", prefijo=" + prefijo + ", numero_inicial=" + numero_inicial + ", porcentaje_impuesto=" + porcentaje_impuesto + ", porcentaje_descuento=" + porcentaje_descuento + '}';
    }

}
