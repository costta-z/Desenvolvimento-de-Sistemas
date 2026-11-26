package br.com.api.equipamentos.repositorio;

import br.com.api.equipamentos.modelo.UsuarioModelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<UsuarioModelo, Long> {

    Optional<UsuarioModelo> findByEmail(String email);

    boolean existsByEmail(String email);
}
