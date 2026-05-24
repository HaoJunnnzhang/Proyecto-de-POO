package com.gamerent.model;

public class VideojuegoNovedad extends Videojuego implements Visualizable    {
    private static  final  double Recargo=2.5; // Recargo fijo para videojuegos de novedad
    private double precioAlquiler = 0;

    public VideojuegoNovedad(String id, String titulo, double precioBase) {
        super(id, titulo, precioBase);
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        precioAlquiler = (getPrecioBase() + Recargo) * dias;
        return precioAlquiler;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Videojuego de Novedad:");
        System.out.println("Título: " + getTitulo());
        System.out.println("ID: " + getId());
        System.out.println("Precio Base: " + getPrecioBase());
        System.out.println("Recargo por Novedad: " + Recargo);
        System.out.println("Disponible: " + (isAlquilado() ? "No" : "Sí"));

    }
}
