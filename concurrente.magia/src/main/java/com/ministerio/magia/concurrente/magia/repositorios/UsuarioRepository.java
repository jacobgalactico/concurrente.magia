package com.ministerio.magia.concurrente.magia.repositorios;

import com.ministerio.magia.concurrente.magia.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);

}
