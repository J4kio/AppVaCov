package com.example.appvacov;

public class ListElement {

    private String id;
    private String hora;
    private String fecha;
    private String sede;
    private String usuario;
    private String cedulap;

    public String getCedulap() {
        return cedulap;
    }

    public void setCedulap(String cedulap) {
        this.cedulap = cedulap;
    }

    public ListElement(String id, String hora, String fecha, String sede, String usuario, String cedulap) {
        this.id = id;
        this.hora = hora;
        this.fecha = fecha;
        this.sede = sede;
        this.usuario = usuario;
        this.cedulap = cedulap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
    this.sede = sede;
   }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
