
package br.com.example.controle;

import java.util.ArrayList;

import br.com.example.dao.EletrodomesticoDao;
import br.com.example.modelo.Eletrodomestico;

public class EletrodomesticoControle {

    private EletrodomesticoDao dao;

    public EletrodomesticoControle() {
        dao = new EletrodomesticoDao();
    }

    public boolean cadastrar(String nome, String marca, String voltagem, double preco) {
        Eletrodomestico eletrodomestico = new Eletrodomestico(0, nome, marca, voltagem, preco);
        return dao.cadastrar(eletrodomestico);
    }

    public ArrayList<Eletrodomestico> listar() {
        return dao.listar();
    }

    public Eletrodomestico buscar(int id) {
        return dao.buscar(id);
    }

    public boolean alterar(int id, String nome, String marca, String voltagem, double preco) {
        return dao.alterar(id, nome, marca, voltagem, preco);
    }

    public boolean remover(int id) {
        return dao.remover(id);
    }
}
