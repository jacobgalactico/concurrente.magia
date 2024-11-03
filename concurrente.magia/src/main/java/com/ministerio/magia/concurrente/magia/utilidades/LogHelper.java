package com.ministerio.magia.concurrente.magia.utilidades;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelper {

    private static final Logger logger = LoggerFactory.getLogger(LogHelper.class);

    public static void registrarInfo(String mensaje) {
        logger.info(mensaje);
    }

    public static void registrarError(String mensaje, Throwable error) {
        logger.error(mensaje, error);
    }

    public static void registrarAdvertencia(String mensaje) {
        logger.warn(mensaje);
    }
}
