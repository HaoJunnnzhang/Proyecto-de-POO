package com.gamerent.model;

import java.util.Scanner;

public class Menu {
     public static void main(String[] args) {
        TiendaAlquiler tienda = TiendaAlquiler.getInstancia();
        Scanner sc = new Scanner(System.in);
        Videojuego juego1 = new VideojuegoNovedad("J001", "Elden Ring", 3.00);
        Videojuego juego2 = new VideojuegoNovedad("J002", "GTA VI", 4.00);
        Videojuego juego3 = new VideojuegoRetro("J003", "Super Mario Bros", 2.00);
        tienda.agregarJuego(juego1);
        tienda.agregarJuego(juego2);
        tienda.agregarJuego(juego3);

        int opcion;

        do {
            System.out.println("\n==============================");
            System.out.println("   GAMERENT - VIDEOJUEGOS");
            System.out.println("==============================");
            System.out.println("0. Salir");
            System.out.println("1. Ver catalogo");
            System.out.println("2. Alquilar juego");
            System.out.println("3. Devolver juego");
            System.out.println("4. Añadir juego");
            System.out.println("5. Eliminar juego");
            System.out.print("Elige opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
             System.out.println("------------------------------");

        

            if (opcion == 1) {
                for (Videojuego juego : tienda.getListaJuegos()) {
                    if (juego instanceof VideojuegoNovedad ) {
                        ((VideojuegoNovedad) juego).mostrarDetalles();
                    }
                    if (juego instanceof VideojuegoRetro) {
                        ((VideojuegoRetro) juego).mostrarDetalles();
                    }
                }

            } else if (opcion == 2) {
                for (Videojuego juego : tienda.getListaJuegos()) {
                    if (juego instanceof VideojuegoNovedad ) {
                        ((VideojuegoNovedad) juego).mostrarDetalles();
                    }
                    if (juego instanceof VideojuegoRetro) {
                        ((VideojuegoRetro) juego).mostrarDetalles();
                    }
                }
                System.out.print("Ingresa el ID del juego a alquilar: ");
                String idAlquiler = sc.nextLine();
                System.out.print("Ingresa los dias de alquiler: ");
                String diasAlquiler = sc.nextLine();
                tienda.alquilarJuego(idAlquiler, diasAlquiler);

            } else if (opcion == 3) {
            	System.out.print("Ingresa el ID del juego a devolver: ");
                tienda.devolverJuego(sc.nextLine());

            } else if (opcion == 4) {
                System.out.print("Tipo de juego (novedad/retro): ");
                String tipo = sc.nextLine();
                System.out.print("ID del juego: ");
                String id = sc.nextLine();
                System.out.print("Titulo del juego: ");
                String titulo = sc.nextLine();
                System.out.print("Precio base: ");
                double precio = sc.nextDouble();
                sc.nextLine(); 

                try {
                    Videojuego nuevoJuego = VideojuegosFactry.crearVideojuego(tipo, id, titulo, precio);
                    tienda.agregarJuego(nuevoJuego);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            } else if (opcion == 5) {
            	System.out.print("Ingresa el ID del juego a eliminar: ");
                tienda.eliminarJuego(sc.nextLine());

            } else if (opcion == 0) {
                System.out.println("Gracias por usar Gamerent. " + "Total: " + tienda.getprecio());
                System.out.println("Hasta pronto!");

            } else {
                System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}