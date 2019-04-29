package com.marianofernandez;

public class App
{
    public static void main(String[] args) throws InterruptedException
    {
        Game game = new Game();

        Jugador jugador1 = new Jugador("German", game);
        Jugador jugador2 = new Jugador("Pablo", game);
        jugador1.start();
        jugador2.start();

        while (jugador1.isAlive() || jugador2.isAlive()){
        }

        game.evaluarEmpate(jugador1,jugador2);
    }
}
