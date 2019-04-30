package com.marianofernandez;

import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;

public class Jugador extends Thread {

    public static  final int totalVidas = 8;
    private static boolean ganador = false;

    String nombre;
    int vidas;
    static char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    Random letra;
    Game game;

    public Jugador(String nombre, Game game) {
        this.nombre = nombre;
        this.vidas = totalVidas;
        this.game = game;
        this.letra = new Random();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public static boolean isGanador() {
        return ganador;
    }

    public static void setGanador(boolean ganador) {
        Jugador.ganador = ganador;
    }

    public void run() {

        while (this.vidas > 0 && !ganador)
        {
                game.jugar(this);
        }
        if (this.vidas == 0 || ganador)
        {
            this.interrupt();
        }
    }

    public char letraRandom(){
        return abc[letra.nextInt(abc.length)];
    }

    public void eliminarLetra(char letra){
        abc = ArrayUtils.removeElement(abc, letra);
    }
}
