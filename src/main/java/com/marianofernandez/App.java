package com.marianofernandez;

public class App
{
    public static void main(String[] args)
    {
        Game game = new Game();

        Jugador jugador1 = new Jugador("German", game);
        Jugador jugador2 = new Jugador("Pablo", game);

        game.presentarJuego(jugador1, jugador2);

        //jugador1.start();
        //jugador2.start();

        Thread t1 = new Thread(jugador1);
        Thread t2 = new Thread(jugador2);

        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive()){
        }

        game.evaluarEmpate(jugador1,jugador2);
    }
}
