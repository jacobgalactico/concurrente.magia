package com.ministerio.magia.concurrente.magia.aspectos;

import com.ministerio.magia.concurrente.magia.servicios.PersonajeService;
import com.ministerio.magia.concurrente.magia.modelos.Hechizo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HechizoAspect {

    @Autowired
    private PersonajeService personajeService;

    @AfterReturning(pointcut = "execution(* com.ministerio.magia.concurrente.magia.servicios.HechizoService.ejecutarHechizo(..))", returning = "hechizo")
    public void reducirVidaDespuesDeHechizo(JoinPoint joinPoint, Hechizo hechizo) {
        // Obtén el jugador desde los argumentos del método ejecutado
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof Integer) {
            int jugador = (Integer) args[0]; // Suponiendo que el primer argumento es el número del jugador
            int daño = hechizo.getNivelDeDificultad() * 5; // Calcula el daño basado en el nivel del hechizo

            personajeService.reducirVida(jugador, daño); // Reduce la vida del jugador especificado
            System.out.println("Vida del Jugador " + jugador + " reducida en " + daño + ". Vida actual: " + personajeService.getVida(jugador));
        }
    }
}
