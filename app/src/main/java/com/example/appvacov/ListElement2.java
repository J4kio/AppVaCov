package com.example.appvacov;

public class ListElement2 {

    private String nombre;
    private String apellido;
    private String cedula;
    private String fecha;
    private String dosis;
    private String fase;
    private String edad;

    public String getFecha() {
        return fecha;
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

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public ListElement2(String nombre, String apellido, String cedula, String fecha, String dosis, String fase, String edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fecha = fecha;
        this.dosis = dosis;
        this.fase = fase;
        this.edad = edad;
    }



}
