package com.ministerio.magia.concurrente.magia.configuracion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuditoriaConfig {

    @Bean
    public Logger auditoriaLogger() {
        Logger logger = LoggerFactory.getLogger("AuditoriaLogger");
        logger.info("Sistema de auditoría inicializado y configurado.");
        return logger;
    }
}
