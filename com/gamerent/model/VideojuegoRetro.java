package com.gamerent.model;

public class VideojuegoRetro  extends  Videojuego implements Visualizable{
    private double precioAlquiler=0;
    public VideojuegoRetro(String tiutlo,double preciobase) {
        super(tiutlo, preciobase);
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        this.precioAlquiler = dias*super.getPrecioBase();
        return dias*super.getPrecioBase();
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Videojuego Retro:");
        System.out.println("Título: " + getTitulo());
        System.out.println("Precio Base: " + getPrecioBase());
        System.out.println("Precio de Alquiler: $" + precioAlquiler);
    }

}