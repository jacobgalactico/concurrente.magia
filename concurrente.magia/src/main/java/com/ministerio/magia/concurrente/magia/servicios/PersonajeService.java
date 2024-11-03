package com.ministerio.magia.concurrente.magia.servicios;

import org.springframework.stereotype.Service;

@Service
public class PersonajeService {

    private int vida = 100; // Vida inicial del personaje

    public int getVida() {
        return vida;
    }

    public void reducirVida(int cantidad) {
        vida -= cantidad;
        if (vida < 0) {
            vida = 0;
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void restaurarVida() {
        vida = 100; // Restaura la vida al máximo
    }
}
