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

    // Crear un nuevo hechizo
    public Hechizo crearHechizo(Hechizo hechizo) {
        return hechizoRepository.save(hechizo);
    }

    // Obtener un hechizo por ID
    public Optional<Hechizo> obtenerHechizoPorId(Long id) {
        return hechizoRepository.findById(id);
    }

    // Ejecutar un hechizo
    public Hechizo ejecutarHechizo(Long id, String ejecutadoPor) {
        Optional<Hechizo> hechizoOpt = hechizoRepository.findById(id);
        if (hechizoOpt.isPresent()) {
            Hechizo hechizo = hechizoOpt.get();
            hechizo.setEjecutadoPor(ejecutadoPor);
            hechizo.setExitoso(Math.random() > 0.3); // Ejemplo de éxito aleatorio (70% de éxito)
            return hechizoRepository.save(hechizo);
        } else {
            throw new RuntimeException("Hechizo no encontrado con ID: " + id);
        }
    }

    // Obtener todos los hechizos
    public List<Hechizo> obtenerTodosHechizos() {
        return hechizoRepository.findAll();
    }
}
