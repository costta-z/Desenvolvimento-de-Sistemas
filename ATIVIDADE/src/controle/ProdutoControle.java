package controle;

import java.util.ArrayList;
import dao.ProdutoDao;
import modelo.Produto;

public class ProdutoControle {

    private ProdutoDao dao;

    public ProdutoControle() {

        dao = new ProdutoDao();
    }

    public boolean cadastrar(int codigo, String nome,
                            String categoria, double preco,
                            int quantidade) {

        if (codigo <= 0 || nome.trim().isEmpty()
                || categoria.trim().isEmpty()
                || preco < 0 || quantidade < 0) {

            return false;
        }

        Produto produto = new Produto(
                codigo, nome, categoria, preco, quantidade
        );

        return dao.cadastrar(produto);
    }

    public ArrayList<Produto> listar() {

        return dao.listar();
    }

    public Produto buscar(int codigo) {

        return dao.buscar(codigo);
    }

    public ArrayList<Produto> pesquisar(String nome) {

        return dao.pesquisar(nome);
    }

    public boolean alterar(int codigo, String nome,
                        String categoria, double preco,
                        int quantidade) {

        if (nome.trim().isEmpty() || categoria.trim().isEmpty()
                || preco < 0 || quantidade < 0) {

            return false;
        }

        return dao.alterar(
                codigo, nome, categoria, preco, quantidade
        );
    }

    public boolean remover(int codigo) {

        return dao.remover(codigo);
    }
}