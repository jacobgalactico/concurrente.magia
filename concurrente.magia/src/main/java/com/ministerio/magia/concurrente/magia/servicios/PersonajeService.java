package com.ministerio.magia.concurrente.magia.servicios;

import org.springframework.stereotype.Service;

@Service
public class PersonajeService {

    private int vidaJugador1 = 100;
    private int vidaJugador2 = 100;
    private int nivelJugador1 = 1;
    private int nivelJugador2 = 1;
    private int enemigosDerrotadosJugador1 = 0;
    private int enemigosDerrotadosJugador2 = 0;

    public int getVida(int jugador) {
        return jugador == 1 ? vidaJugador1 : vidaJugador2;
    }

    public int getNivel(int jugador) {
        return jugador == 1 ? nivelJugador1 : nivelJugador2;
    }

    public void reducirVida(int jugador, int cantidad) {
        if (jugador == 1) {
            vidaJugador1 -= cantidad;
            if (vidaJugador1 < 0) vidaJugador1 = 0;
        } else {
            vidaJugador2 -= cantidad;
            if (vidaJugador2 < 0) vidaJugador2 = 0;
        }
    }

    public boolean estaVivo(int jugador) {
        return jugador == 1 ? vidaJugador1 > 0 : vidaJugador2 > 0;
    }

    public void restaurarVida(int jugador, int cantidad) {
        if (jugador == 1) {
            vidaJugador1 += cantidad;
            if (vidaJugador1 > 100) vidaJugador1 = 100;
        } else {
            vidaJugador2 += cantidad;
            if (vidaJugador2 > 100) vidaJugador2 = 100;
        }
    }

    public void incrementarNivel(int jugador) {
        if (jugador == 1) {
            enemigosDerrotadosJugador1++;
            if (enemigosDerrotadosJugador1 % 3 == 0) {
                nivelJugador1++;
            }
        } else {
            enemigosDerrotadosJugador2++;
            if (enemigosDerrotadosJugador2 % 3 == 0) {
                nivelJugador2++;
            }
        }
    }
}
