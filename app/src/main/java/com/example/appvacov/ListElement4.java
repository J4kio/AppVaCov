package com.example.appvacov;

public class ListElement4 {


    private String id_lote;
    private String fecha_vencimiento;
    private String marca;
    private String fecha_recepcion;
    private String cantidad;

    public ListElement4(String id_lote, String fecha_vencimiento, String marca, String fecha_recepcion, String cantidad) {
        this.id_lote = id_lote;
        this.fecha_vencimiento = fecha_vencimiento;
        this.marca = marca;
        this.fecha_recepcion = fecha_recepcion;
        this.cantidad = cantidad;
    }

    public String getId_lote() {
        return id_lote;
    }

    public void setId_lote(String id_lote) {
        this.id_lote = id_lote;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(String fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
