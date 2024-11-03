package com.ministerio.magia.concurrente.magia.controladores;

import com.ministerio.magia.concurrente.magia.modelos.EventoMagico;
import com.ministerio.magia.concurrente.magia.servicios.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping
    public EventoMagico registrarEvento(@RequestBody EventoMagico evento, @RequestParam String reportadoPor) {
        return eventoService.registrarEvento(evento, reportadoPor);
    }

    @GetMapping("/{id}")
    public Optional<EventoMagico> obtenerEvento(@PathVariable Long id) {
        return eventoService.obtenerEventoPorId(id);
    }

    @GetMapping
    public List<EventoMagico> obtenerTodosEventos() {
        return eventoService.obtenerTodosEventos();
    }
}
