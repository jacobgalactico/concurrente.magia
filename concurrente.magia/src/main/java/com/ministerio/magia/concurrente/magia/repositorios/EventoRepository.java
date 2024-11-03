package com.ministerio.magia.concurrente.magia.repositorios;

import com.ministerio.magia.concurrente.magia.modelos.EventoMagico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<EventoMagico, Long> {
    // Aquí podemos agregar métodos de consulta personalizados si es necesario.
}
