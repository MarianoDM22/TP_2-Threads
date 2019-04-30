package com.marianofernandez;

import org.apache.commons.lang3.StringUtils;

public class Game {

    private Jdbc jdbc = new Jdbc();
    private Palabra palabra;
    private boolean disponible = false;
    private boolean turno = false;

    public Game() {
        this.palabra = jdbc.getPalabra();
    }

    public Palabra getPalabra() {
        return palabra;
    }


    public synchronized void jugar (Jugador jugador){
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        disponible = true;
        turno = true;

        while (turno && !jugador.isGanador()){
            turno = jugarLetra(jugador, jugador.letraRandom());

            evaluarWin(jugador);
        }

        evaluarLose(jugador);

        disponible = false;
        notifyAll();
    }

    public boolean jugarLetra(Jugador jugador, char latra){

        System.out.println(jugador.getNombre() + " ha jugado la letra: " + latra);

        boolean retorno = true;

        if (0 <= palabra.getPalabra().indexOf(latra)){
            palabra.setLongitud(palabra.getLongitud()- StringUtils.countMatches(palabra.getPalabra(), latra));
            System.out.println("Acertaste una letra, quedan " + palabra.getLongitud() + " letras.\n");
            jugador.eliminarLetra(latra);
        }else {
            jugador.setVidas(jugador.getVidas() - 1);
            System.out.println("No acertaste, te quedan " + jugador.getVidas() + " vidas.\n");
            jugador.eliminarLetra(latra);
            retorno = false;
        }
        return retorno;
    }

    public void presentarJuego(Jugador jugador1, Jugador jugador2)
    {
        System.out.println(jugador1.getNombre() + " VS " + jugador2.getNombre());
        System.out.println("La palabra sera: " + palabra.getPalabra() + "\n");
    }

    public void evaluarWin(Jugador jugador)
    {
        if (this.palabra.getLongitud() == 0)
        {
            System.out.println(jugador.getNombre() + " GANASTE, la palabra era: " + palabra.getPalabra());
            jdbc.insertarGanador(jugador, palabra);
            jugador.setGanador(true);
        }
    }

    public void evaluarLose(Jugador jugador)
    {
        if (jugador.getVidas() == 0){
            System.out.println(jugador.getNombre() + " PERDISTE\n");
        }
    }

    public void evaluarEmpate(Jugador jugador1, Jugador jugador2) {
        if (jugador1.getVidas() == 0 && jugador2.getVidas() == 0)
        {
            System.out.println("Ambos pierden, la palabra era: " + palabra.getPalabra());
        }
    }
}
