package org.example;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> jugadores = new ArrayList<>();
        Random random = new Random();

        int numeroJugadores;
        do {
            System.out.print("Ingrese el numero de jugadores (maximo 6): ");
            numeroJugadores = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
        } while (numeroJugadores < 1 || numeroJugadores > 6);

        for (int i = 0; i < numeroJugadores; i++) {

            System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
            jugadores.add(scanner.nextLine());
        }

        Ruleta juego = new Ruleta(jugadores);
        int turno = random.nextInt(numeroJugadores);
        int ronda = 1;

        while (true) {
            System.out.println(" RONDA " + ronda + " ");
            String jugadorActual = jugadores.get(turno);

            if (juego.disparar(jugadorActual)) {
                break;
            }

            turno = (turno + 1) % numeroJugadores;
            ronda++;
        }

        System.out.println(" Juego terminado en la ronda " + ronda);
        scanner.close();
    }

    }
