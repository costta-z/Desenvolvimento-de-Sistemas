package br.com.api.equipamentos.controle;

import br.com.api.equipamentos.modelo.EquipamentoModelo;
import br.com.api.equipamentos.modelo.RespostaModelo;
import br.com.api.equipamentos.servico.EquipamentoServico;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipamentoControle {

    private final EquipamentoServico servico;

    public EquipamentoControle(EquipamentoServico servico) {
        this.servico = servico;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<EquipamentoModelo>> listar() {
        return ResponseEntity.ok(servico.listar());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@Valid @RequestBody EquipamentoModelo equipamento) {
        try {
            EquipamentoModelo salvo = servico.cadastrar(equipamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(new RespostaModelo(e.getMessage(), false));
        }
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@Valid @RequestBody EquipamentoModelo equipamento) {
        try {
            return ResponseEntity.ok(servico.alterar(equipamento));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(new RespostaModelo(e.getMessage(), false));
        }
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable Long codigo) {
        try {
            servico.remover(codigo);
            return ResponseEntity.ok(new RespostaModelo("Equipamento removido com sucesso!", true));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(new RespostaModelo(e.getMessage(), false));
        }
    }
}
