package com.ministerio.magia.concurrente.magia.servicios;

import com.ministerio.magia.concurrente.magia.modelos.EventoMagico;
import com.ministerio.magia.concurrente.magia.repositorios.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    // Registrar un nuevo evento
    public EventoMagico registrarEvento(EventoMagico evento, String reportadoPor) {
        evento.setFecha(LocalDateTime.now());
        evento.setReportadoPor(reportadoPor);
        return eventoRepository.save(evento);
    }

    // Obtener un evento por ID
    public Optional<EventoMagico> obtenerEventoPorId(Long id) {
        return eventoRepository.findById(id);
    }

    // Obtener todos los eventos
    public List<EventoMagico> obtenerTodosEventos() {
        return eventoRepository.findAll();
    }
}
