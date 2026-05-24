package com.gamerent.model;

public interface GestionCatalogo {
     void agregarJuego(Videojuego juego);
  void eliminarJuego(String id);
  void alquilarJuego(String id,String dias);
  void devolverJuego(String id);
}
