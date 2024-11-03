package com.ministerio.magia.concurrente.magia.controladores;

import com.ministerio.magia.concurrente.magia.modelos.Hechizo;
import com.ministerio.magia.concurrente.magia.servicios.HechizoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hechizos")
public class HechizoController {

    @Autowired
    private HechizoService hechizoService;

    // Endpoint para crear un nuevo hechizo
    @PostMapping
    public Hechizo crearHechizo(@RequestBody Hechizo hechizo) {
        return hechizoService.crearHechizo(hechizo);
    }

    // Endpoint para obtener un hechizo por ID
    @GetMapping("/{id}")
    public Optional<Hechizo> obtenerHechizoPorId(@PathVariable Long id) {
        return hechizoService.obtenerHechizoPorId(id);
    }

    // Endpoint para ejecutar un hechizo por un jugador
    @PostMapping("/ejecutar/{id}")
    public Hechizo ejecutarHechizo(
            @PathVariable Long id,
            @RequestParam int jugador,
            @RequestParam String ejecutadoPor
    ) {
        return hechizoService.ejecutarHechizo(id, jugador, ejecutadoPor);
    }

    // Endpoint para obtener todos los hechizos
    @GetMapping
    public List<Hechizo> obtenerTodosHechizos() {
        return hechizoService.obtenerTodosHechizos();
    }
}
