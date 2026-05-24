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

        String opcion;
        int opcionInt = -1; 

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
            
    
            opcion = sc.nextLine(); 
            
            try {
                opcionInt = Integer.parseInt(opcion);
            } catch (NumberFormatException e) {
                System.out.println("------------------------------");
                System.out.println("Error: Opción no válida. introduce un número.");
            
                continue; 
            }
            
            System.out.println("------------------------------");

            if (opcionInt == 1) {
                for (Videojuego juego : tienda.getListaJuegos()) {
                    if (juego instanceof VideojuegoNovedad ) {
                        ((VideojuegoNovedad) juego).mostrarDetalles();
                    }
                    if (juego instanceof VideojuegoRetro) {
                        ((VideojuegoRetro) juego).mostrarDetalles();
                    }
                }

            } else if (opcionInt == 2) {
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

            } else if (opcionInt == 3) {
                System.out.print("Ingresa el ID del juego a devolver: ");
                tienda.devolverJuego(sc.nextLine());

            } else if (opcionInt == 4) {
                System.out.print("Tipo de juego (novedad/retro): ");
                String tipo = sc.nextLine();
                System.out.print("ID del juego: ");
                String id = sc.nextLine();
                System.out.print("Titulo del juego: ");
                String titulo = sc.nextLine();
                
                double precio = 0.0;
                boolean precioValido = false;
                while (!precioValido) {
                    System.out.print("Precio base: ");
                    try {
                        precio = sc.nextDouble();
                        precioValido = true; 
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Error: Formato inválido. Por favor, introduce un número.");
                        sc.nextLine(); 
                    }
                }
                sc.nextLine(); 

                try {
                    Videojuego nuevoJuego = VideojuegosFactry.crearVideojuego(tipo, id, titulo, precio);
                    tienda.agregarJuego(nuevoJuego);
                    System.out.println("Juego añadido correctamente.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            } else if (opcionInt == 5) {
                System.out.print("Ingresa el ID del juego a eliminar: ");
                tienda.eliminarJuego(sc.nextLine());

            } else if (opcionInt == 0) {
                System.out.println("Gracias por usar Gamerent. " + "Total: " + tienda.getprecio());
                System.out.println("Hasta pronto!");

            } else {
                System.out.println("Opcion no valida.");
            }

        } while (opcionInt != 0);

        sc.close();
    }
}

