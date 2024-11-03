package com.ministerio.magia.concurrente.magia.controladores;

import com.ministerio.magia.concurrente.magia.modelos.EventoMagico;
import com.ministerio.magia.concurrente.magia.servicios.EventoService;
import com.ministerio.magia.concurrente.magia.servicios.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private PersonajeService personajeService;

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

    @GetMapping("/derrotas/{jugador}")
    public int obtenerDerrotas(@PathVariable int jugador) {
        return personajeService.getDerrotas(jugador);
    }
}