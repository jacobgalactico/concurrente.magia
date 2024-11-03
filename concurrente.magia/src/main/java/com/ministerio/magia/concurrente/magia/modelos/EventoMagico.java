package com.ministerio.magia.concurrente.magia.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion; // Descripción del evento mágico
    private LocalDateTime fecha; // Fecha y hora del evento
    private String lugar; // Ubicación donde ocurrió el evento
    private String reportadoPor; // Nombre del mago que reportó el evento
}
