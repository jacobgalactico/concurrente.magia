package com.ministerio.magia.concurrente.magia.aspectos;

import com.ministerio.magia.concurrente.magia.servicios.PersonajeService;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditoriaAspect {

    @Autowired
    private PersonajeService personajeService;

    @AfterReturning("execution(* com.ministerio.magia.concurrente.magia.servicios.PersonajeService.reducirVida(..))")
    public void auditarUsoHechizo() {
        System.out.println("Hechizo lanzado, auditar evento en los logs.");
    }

    @AfterReturning("execution(* com.ministerio.magia.concurrente.magia.servicios.PersonajeService.incrementarNivel(..))")
    public void auditarSubidaDeNivel() {
        System.out.println("Subida de nivel registrada, auditar en los logs.");
    }
}
