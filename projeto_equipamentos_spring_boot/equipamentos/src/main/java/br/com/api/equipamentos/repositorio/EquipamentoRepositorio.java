package br.com.api.equipamentos.repositorio;

import br.com.api.equipamentos.modelo.EquipamentoModelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepositorio extends JpaRepository<EquipamentoModelo, Long> {
}
