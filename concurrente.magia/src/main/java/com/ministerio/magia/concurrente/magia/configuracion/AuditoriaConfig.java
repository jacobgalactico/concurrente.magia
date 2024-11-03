package com.ministerio.magia.concurrente.magia.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class AuditoriaConfig {

    private static final Logger logger = LoggerFactory.getLogger(AuditoriaConfig.class);

    @Bean
    public void configurarAuditoria() {
        logger.info("Sistema de auditoría inicializado y configurado.");
    }
}
