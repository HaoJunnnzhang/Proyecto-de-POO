package com.gamerent.model;

import java.util.ArrayList;
import java.util.HashMap;

public class TiendaAlquiler implements GestionCatalogo {
    
    private static TiendaAlquiler instancia=null;
    private HashMap<String, Videojuego> catalogo ;
    private double precios;

    private TiendaAlquiler() {
        catalogo = new HashMap<>();
        precios = 0.0;
    }

    public static TiendaAlquiler getInstancia() {
        if (instancia == null) {
            instancia = new TiendaAlquiler();
        }
        return instancia;
    }
  
    public HashMap<String, Videojuego> getCatalogo() {
        return catalogo;
    }
    

    @Override
    public void agregarJuego(Videojuego juego) {

        if (catalogo.containsKey(juego.getId())) {
            System.out.println("Error: ya existe un juego con el ID " + juego.getId());
            return;
        }
        catalogo.put(juego.getId(), juego);
        System.out.println("Juego añadido: " + juego.getTitulo());
    }
 
    @Override
    public void eliminarJuego(String id) {
        if (!catalogo.containsKey(id)) {
            System.out.println("Error: no existe ningún juego con el ID " + id);
            return;
        }
        System.out.println("Juego eliminado: " + catalogo.get(id).getTitulo());
        catalogo.remove(id);
    }
 
    @Override
    public void alquilarJuego(String id,String dias) {
        Videojuego juego = catalogo.get(id);
        int diasInt;
        double preciototal=0.0;
        try {
            dias = dias.trim();
             diasInt = Integer.parseInt(dias);
        } catch (NumberFormatException e) {
            System.out.println("Error: el número de días no es válido.");
            return;
        }
 
        if (juego == null) {
            System.out.println("Error: no existe ningún juego con el ID " + id);
            return;
        }
 
        if (juego.isAlquilado()) {
            System.out.println("Error: el juego \"" + juego.getTitulo() + "\" ya está alquilado.");
            return;
        }
 
        juego.setAlquilado(true);   
        System.out.println("Precio de alquiler por día: " + juego.getPrecioBase());
        if(juego instanceof VideojuegoNovedad){
            System.out.println("Precio total por " + diasInt + " días: " + juego.calcularPrecioAlquiler(diasInt));
            preciototal = juego.calcularPrecioAlquiler(diasInt);
        }  
         if (juego instanceof VideojuegoRetro) {
            System.out.println("Precio total por " + diasInt + " días: " + juego.calcularPrecioAlquiler(diasInt));
            preciototal = juego.calcularPrecioAlquiler(diasInt);
        }
        System.out.println("Juego alquilado: " + juego.getTitulo());
        precios += preciototal;
    }
 
    @Override
    public void devolverJuego(String id) {
        Videojuego juego = catalogo.get(id);
 
        if (juego == null) {
            System.out.println("Error: no existe ningún juego con el ID " + id);
            return;
        }
 
        if (!juego.isAlquilado()) {
            System.out.println("Error: el juego \"" + juego.getTitulo() + "\" no estaba alquilado.");
            return;
        }
 
        juego.setAlquilado(false);
        System.out.println("Juego devuelto: " + juego.getTitulo());
    }
    
    public void buscarJuego(String id) {
        if (!catalogo.containsKey(id)) {
            System.out.println("Error: no existe ningun juego con el ID " + id);
            return;
        }
        ((Visualizable) catalogo.get(id)).mostrarDetalles();
    }
 
    // Método para que el menú pueda mostrar el catálogo
    public ArrayList<Videojuego> getListaJuegos() {
        return new ArrayList<>(catalogo.values());
    }
    public double getprecio(){
        return precios;
    }
}
