package org.example;

import java.util.ArrayList;
import java.util.Random;

class Ruleta {
    private ArrayList<String> jugadores;
    private int posicionActual;
    private int posicionBala;
    private Random random;

    public Ruleta(ArrayList<String> jugadores) {
        this.jugadores = jugadores;
        this.random = new Random();
        nuevoAleatorio();
    }

    public void nuevoAleatorio() {
        posicionBala = random.nextInt(6);
        posicionActual = random.nextInt(6);
    }

    public boolean disparar(String jugador) {
        System.out.println(" Turno de " + jugador);
        System.out.println("Posicion del tambor: " + posicionActual);
        System.out.println("Posicion de la bala: " + posicionBala);

        if (posicionActual == posicionBala) {
            System.out.println(  " ha muerto. Fin del juego"+ jugador );
            return true;
        } else {
            System.out.println(" sobrevive esta ronda."+ jugador );
            posicionActual = (posicionActual + random.nextInt(3) + 1) % 6;
            return false;
        }
    }
}






