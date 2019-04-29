package com.marianofernandez;

public class Palabra {

    String palabra;
    int longitud;

    public Palabra(String palabra, int longitud) {
        this.palabra = palabra;
        this.longitud = longitud;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
}
