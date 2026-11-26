package br.com.api.equipamentos.controle;

import br.com.api.equipamentos.modelo.RespostaModelo;
import br.com.api.equipamentos.modelo.UsuarioModelo;
import br.com.api.equipamentos.servico.UsuarioServico;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Map;

@RestController
public class UsuarioControle {

    private final UsuarioServico servico;

    public UsuarioControle(UsuarioServico servico) {
        this.servico = servico;
    }

    @GetMapping("/")
    public void inicio(HttpServletResponse response) throws IOException {
        response.sendRedirect("/login.html");
    }

    @GetMapping("/csrf")
    public Map<String, String> csrf(CsrfToken token) {
        return Map.of("token", token.getToken());
    }

    @PostMapping("/usuarios/cadastrar")
    public ResponseEntity<RespostaModelo> cadastrar(@Valid @RequestBody UsuarioModelo usuario) {
        try {
            servico.cadastrar(usuario);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new RespostaModelo("Usuário cadastrado com sucesso!", true));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(new RespostaModelo(e.getMessage(), false));
        }
    }
}
