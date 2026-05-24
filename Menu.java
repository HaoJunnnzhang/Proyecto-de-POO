package com.gamerent.model;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        TiendaAlquiler tienda = new TiendaAlquiler();
        Scanner sc = new Scanner(System.in);

        tienda.agregarJuego(new VideojuegoNovedad("J001", "Elden Ring", 59.99));
        tienda.agregarJuego(new VideojuegoNovedad("J002", "GTA VI", 69.99));
        tienda.agregarJuego(new VideojuegoRetro("J003", "Super Mario Bros", 4.99));

        int opcion;

        do {
            System.out.println("\n==============================");
            System.out.println("   GAMERENT - VIDEOJUEGOS");
            System.out.println("==============================");
            System.out.println("0. Salir");
            System.out.println("1. Ver catalogo");
            System.out.println("2. Alquilar juego");
            System.out.println("3. Devolver juego");
            System.out.println("4. Aniadir juego");
            System.out.println("5. Eliminar juego");
            System.out.print("Elige opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                tienda.getListaJuegos();

            } else if (opcion == 2) {
                tienda.alquilarJuego(sc.nextLine());

            } else if (opcion == 3) {
                tienda.devolverJuego(sc.nextLine());

            } else if (opcion == 4) {
                tienda.agregarJuego(new VideojuegoNovedad(sc.nextLine(), sc.nextLine(), sc.nextDouble()));

            } else if (opcion == 5) {
                tienda.eliminarJuego(sc.nextLine());

            } else if (opcion == 0) {
                System.out.println("Hasta pronto!");

            } else {
                System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}