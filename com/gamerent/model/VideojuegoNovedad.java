package com.gamerent.model;

public class VideojuegoNovedad  extends Videojuego implements Visualizable{
        private static  final  double Recargo=2.5; // Recargo fijo para videojuegos de novedad
        private  double precioAlquiler=0;
        public VideojuegoNovedad(String titulo, double precioBase) {
        super(titulo, precioBase); 
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        precioAlquiler = (super.getPrecioBase()  + Recargo)*dias;
        return precioAlquiler;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Videojuego de Novedad:");
        System.out.println("Título: " + getTitulo());
        System.out.println("Precio Base: " + getPrecioBase());
        System.out.println("Recargo por Novedad: " + Recargo);
        System.out.println("Precio de Alquiler: " + precioAlquiler);
    }
    
    
}
