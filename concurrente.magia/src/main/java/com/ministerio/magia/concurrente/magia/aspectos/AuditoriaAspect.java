package com.ministerio.magia.concurrente.magia.aspectos;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditoriaAspect {

    @After("execution(* com.ministerio.magia.concurrente.magia.servicios.*.*(..))")
    public void registrarAuditoria() {
        System.out.println("Evento de auditoría registrado: Se ha realizado una operación en el servicio.");
    }
}
