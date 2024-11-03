package com.ministerio.magia.concurrente.magia.aspectos;

import com.ministerio.magia.concurrente.magia.servicios.PersonajeService;
import com.ministerio.magia.concurrente.magia.modelos.Hechizo;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HechizoAspect {

    @Autowired
    private PersonajeService personajeService;

    // Intercepta el uso del hechizo y reduce la vida del personaje
    @AfterReturning(pointcut = "execution(* com.ministerio.magia.concurrente.magia.servicios.HechizoService.ejecutarHechizo(..))", returning = "hechizo")
    public void reducirVidaDespuesDeHechizo(Hechizo hechizo) {
        int daño = hechizo.getNivelDeDificultad() * 5; // Ejemplo: cada nivel reduce 5 puntos de vida
        personajeService.reducirVida(daño);
        System.out.println("Vida del personaje reducida en " + daño + ". Vida actual: " + personajeService.getVida());
    }
}
