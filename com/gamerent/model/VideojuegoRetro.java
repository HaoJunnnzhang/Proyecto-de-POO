package com.gamerent.model;

public class VideojuegoRetro extends Videojuego implements Visualizable {
    private static final double Descuento = 0.5; // Descuento fijo para videojuegos retro
    private double precioAlquiler = 0;

    public VideojuegoRetro(String id, String titulo, double precioBase) {
        super(id, titulo, precioBase);
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        precioAlquiler = (getPrecioBase() * Descuento) * dias;
        return precioAlquiler;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Videojuego Retro:");
        System.out.println("Título: " + getTitulo());
        System.out.println("ID: " + getId());
        System.out.println("Precio Base: " + getPrecioBase());
        System.out.println("Descuento por Retro: " + Descuento);
        System.out.println("Disponible: " + (isAlquilado() ? "No" : "Sí"));
        System.out.println("------------------------------");

        
    }
    
}
