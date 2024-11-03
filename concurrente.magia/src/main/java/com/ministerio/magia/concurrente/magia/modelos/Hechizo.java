package com.ministerio.magia.concurrente.magia.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hechizo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo; // Ejemplo: "Defensivo", "Ofensivo"
    private int nivelDeDificultad; // Nivel de dificultad del hechizo, de 1 a 10
    private String ejecutadoPor; // Nombre del mago que ejecutó el hechizo
    private boolean exitoso; // Estado de éxito o fracaso del hechizo
}
