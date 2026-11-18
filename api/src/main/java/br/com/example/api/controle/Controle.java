package br.com.example.api.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.example.api.modelo.Pessoa;

@RestController
public class Controle {
    
    @GetMapping ("")
    public String mensagem(){
        return "Olá mundo";
    }

    @GetMapping ("boasVindas")
    public String boasVindas(){
        return "Seja bem vindo!";
    }
    
    @GetMapping
    public String boasVindas(@PathVariable String nome){
        return "Seja bem vindo!"+nome;
    }

    @PostMapping ("/Pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }
}
