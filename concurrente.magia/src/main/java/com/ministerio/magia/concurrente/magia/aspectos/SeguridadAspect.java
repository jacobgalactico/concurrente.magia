package com.ministerio.magia.concurrente.magia.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SeguridadAspect {

    @Before("execution(* com.ministerio.magia.concurrente.magia.servicios.*.*(..))")
    public void verificarSeguridad() {
        System.out.println("Verificación de seguridad: Autenticación y autorización de usuario.");
    }
}
