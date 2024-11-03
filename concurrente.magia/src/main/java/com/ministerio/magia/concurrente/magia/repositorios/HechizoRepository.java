package com.ministerio.magia.concurrente.magia.repositorios;

import com.ministerio.magia.concurrente.magia.modelos.Hechizo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HechizoRepository extends JpaRepository<Hechizo, Long> {
    // Aquí podemos agregar métodos de consulta personalizados si es necesario.
}
