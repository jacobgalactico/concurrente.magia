package com.ministerio.magia.concurrente.magia.servicios;

import com.ministerio.magia.concurrente.magia.modelos.Hechizo;
import com.ministerio.magia.concurrente.magia.repositorios.HechizoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HechizoService {

    @Autowired
    private HechizoRepository hechizoRepository;

    @Autowired
    private PersonajeService personajeService;

    // Crear un nuevo hechizo
    public Hechizo crearHechizo(Hechizo hechizo) {
        return hechizoRepository.save(hechizo);
    }

    // Obtener un hechizo por ID
    public Optional<Hechizo> obtenerHechizoPorId(Long id) {
        return hechizoRepository.findById(id);
    }

    // Ejecutar un hechizo por un jugador en contra del oponente
    public Hechizo ejecutarHechizo(Long hechizoId, int jugador, String ejecutadoPor) {
        Optional<Hechizo> hechizoOpt = hechizoRepository.findById(hechizoId);

        if (hechizoOpt.isPresent()) {
            Hechizo hechizo = hechizoOpt.get();
            hechizo.setEjecutadoPor(ejecutadoPor);

            // Determinación del éxito del hechizo (70% de probabilidad de éxito)
            boolean exitoso = Math.random() > 0.3;
            hechizo.setExitoso(exitoso);

            if (exitoso) {
                // Calcular el daño basado en el nivel del hechizo
                int daño = hechizo.getNivelDeDificultad() * 5;

                // Determinar el oponente (jugador contrario)
                int oponente = jugador == 1 ? 2 : 1;

                // Reducir la vida del oponente
                personajeService.reducirVida(oponente, daño);

                // Incrementar el contador de enemigos derrotados y el nivel si el oponente es derrotado
                if (!personajeService.estaVivo(oponente)) {
                    personajeService.incrementarNivel(jugador);
                    System.out.println("¡Jugador " + jugador + " ha derrotado a su oponente!");
                }
            } else {
                System.out.println("El hechizo ha fallado.");
            }

            // Guardar los cambios en el hechizo
            return hechizoRepository.save(hechizo);
        } else {
            throw new RuntimeException("Hechizo no encontrado con ID: " + hechizoId);
        }
    }

    // Obtener todos los hechizos
    public List<Hechizo> obtenerTodosHechizos() {
        return hechizoRepository.findAll();
    }
}
