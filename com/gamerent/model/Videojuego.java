package com.gamerent.model;

public abstract class Videojuego {

    private String titulo;
    private double precioBase;

    public Videojuego(String titulo, double precioBase) {
        this.titulo = titulo;
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecioAlquiler(int dias);

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
}
