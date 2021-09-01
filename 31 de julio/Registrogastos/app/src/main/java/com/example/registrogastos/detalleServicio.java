package com.example.registrogastos;

import java.util.Date;

public class detalleServicio {
    private int servicio;
    private String fecha;
    private int monto;

    public detalleServicio(int servicio, String fecha, int monto) {
        this.servicio = servicio;
        this.fecha = fecha;
        this.monto = monto;
    }

    public detalleServicio() {
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
