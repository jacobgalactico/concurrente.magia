package com.ministerio.magia.concurrente.magia.excepciones;

public class TransaccionException extends RuntimeException {

    public TransaccionException(String mensaje) {
        super(mensaje);
    }
}
