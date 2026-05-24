package com.gamerent.model;

public class VideojuegosFactry {
    public static Videojuego crearVideojuego(String tipo, String id, String titulo, double precioBase) {
        if (tipo.equalsIgnoreCase("novedad")) {
            return new VideojuegoNovedad(id, titulo, precioBase);
        } else if (tipo.equalsIgnoreCase("retro")) {
            return new VideojuegoRetro(id, titulo, precioBase);
        } else {
            throw new IllegalArgumentException("Tipo de videojuego no válido: " );
        }
    }
}
