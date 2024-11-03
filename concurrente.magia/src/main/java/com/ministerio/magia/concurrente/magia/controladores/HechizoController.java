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

    @PostMapping
    public Hechizo crearHechizo(@RequestBody Hechizo hechizo) {
        return hechizoService.crearHechizo(hechizo);
    }

    @GetMapping("/{id}")
    public Optional<Hechizo> obtenerHechizo(@PathVariable Long id) {
        return hechizoService.obtenerHechizoPorId(id);
    }

    @PostMapping("/{id}/ejecutar")
    public Hechizo ejecutarHechizo(@PathVariable Long id, @RequestParam String ejecutadoPor) {
        return hechizoService.ejecutarHechizo(id, ejecutadoPor);
    }

    @GetMapping
    public List<Hechizo> obtenerTodosHechizos() {
        return hechizoService.obtenerTodosHechizos();
    }
}
