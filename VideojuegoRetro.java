package com.gamerent.model;

public class VideojuegoRetro extends Videojuego implements Visualizable {

    private double precioAlquiler = 0;

    public VideojuegoRetro(String id, String titulo, double precioBase) {
        super(id, titulo, precioBase);
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        precioAlquiler = dias * getPrecioBase();
        return precioAlquiler;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Videojuego Retro:");
        System.out.println("Título: " + getTitulo());
        System.out.println("ID: " + getId());
        System.out.println("Precio Base: " + getPrecioBase());
        System.out.println("Precio de Alquiler: $" + precioAlquiler);
    }
}