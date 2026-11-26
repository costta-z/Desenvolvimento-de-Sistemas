package br.com.api.equipamentos.servico;

import br.com.api.equipamentos.modelo.EquipamentoModelo;
import br.com.api.equipamentos.repositorio.EquipamentoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquipamentoServico {

    private final EquipamentoRepositorio repositorio;

    private static final List<String> STATUS_PERMITIDOS = List.of(
            "Aguardando manutenção",
            "Em manutenção",
            "Manutenção concluída",
            "Entregue ao cliente"
    );

    public EquipamentoServico(EquipamentoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<EquipamentoModelo> listar() {
        return repositorio.findAll();
    }

    @Transactional
    public EquipamentoModelo cadastrar(EquipamentoModelo equipamento) {
        validar(equipamento);
        equipamento.setCodigo(null);
        return repositorio.save(equipamento);
    }

    @Transactional
    public EquipamentoModelo alterar(EquipamentoModelo equipamento) {
        if (equipamento.getCodigo() == null
                || !repositorio.existsById(equipamento.getCodigo())) {
            throw new IllegalArgumentException("Equipamento não encontrado.");
        }

        validar(equipamento);
        return repositorio.save(equipamento);
    }

    @Transactional
    public void remover(Long codigo) {
        if (!repositorio.existsById(codigo)) {
            throw new IllegalArgumentException("Equipamento não encontrado.");
        }
        repositorio.deleteById(codigo);
    }

    private void validar(EquipamentoModelo equipamento) {
        if (equipamento.getNome() == null || equipamento.getNome().isBlank()
                || equipamento.getMarca() == null || equipamento.getMarca().isBlank()
                || equipamento.getModelo() == null || equipamento.getModelo().isBlank()
                || equipamento.getStatus() == null || equipamento.getStatus().isBlank()) {
            throw new IllegalArgumentException("Preencha todos os campos.");
        }

        if (!STATUS_PERMITIDOS.contains(equipamento.getStatus())) {
            throw new IllegalArgumentException("Status inválido.");
        }
    }
}
