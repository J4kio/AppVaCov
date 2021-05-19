package com.example.appvacov;

public class ListElement3 {

    private String cedula;
    private String correo;
    private String nombres;
    private String apellidos;
    private String edad;
    private String genero;
    private String fase;
    private String ocupacion;
    private String comorbilidades;
    private String direccion;

    public ListElement3(String cedula, String correo, String nombres, String apellidos, String edad, String genero, String fase, String ocupacion, String comorbilidades, String direccion) {
        this.cedula = cedula;
        this.correo = correo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.genero = genero;
        this.fase = fase;
        this.ocupacion = ocupacion;
        this.comorbilidades = comorbilidades;
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getComorbilidades() {
        return comorbilidades;
    }

    public void setComorbilidades(String comorbilidades) {
        this.comorbilidades = comorbilidades;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
