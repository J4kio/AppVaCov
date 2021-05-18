package com.example.appvacov;

public class ListElement2 {

    private String id_reporte;
    private String cedulapa;
    private String cedulap;
    private String fecha;
    private String sede;
    private String dosis;
    private String id_lote;
    private String marca;

    public ListElement2(String id_reporte, String cedulapa, String cedulap, String fecha, String sede, String dosis, String id_lote, String marca) {
        this.id_reporte = id_reporte;
        this.cedulapa = cedulapa;
        this.cedulap = cedulap;
        this.fecha = fecha;
        this.sede = sede;
        this.dosis = dosis;
        this.id_lote = id_lote;
        this.marca = marca;
    }

    public String getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(String id_reporte) {
        this.id_reporte = id_reporte;
    }

    public String getCedulapa() {
        return cedulapa;
    }

    public void setCedulapa(String cedulapa) {
        this.cedulapa = cedulapa;
    }

    public String getCedulap() {
        return cedulap;
    }

    public void setCedulap(String cedulap) {
        this.cedulap = cedulap;
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

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getId_lote() {
        return id_lote;
    }

    public void setId_lote(String id_lote) {
        this.id_lote = id_lote;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
