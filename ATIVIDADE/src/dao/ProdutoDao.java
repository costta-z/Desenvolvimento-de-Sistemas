package dao;

import java.util.ArrayList;
import modelo.Produto;

public class ProdutoDao {

    private ArrayList<Produto> produtos = new ArrayList<>();

    public boolean cadastrar(Produto produto) {

        if (buscar(produto.getCodigo()) != null) {
            return false;
        }

        produtos.add(produto);

        return true;
    }

    public ArrayList<Produto> listar() {

        return produtos;
    }

    public Produto buscar(int codigo) {

        for (Produto produto : produtos) {

            if (produto.getCodigo() == codigo) {

                return produto;
            }
        }

        return null;
    }

    public ArrayList<Produto> pesquisar(String nome) {

        ArrayList<Produto> encontrados = new ArrayList<>();

        for (Produto produto : produtos) {

            if (produto.getNome().toLowerCase()
                    .contains(nome.toLowerCase())
                    || String.valueOf(produto.getCodigo()).contains(nome)) {

                encontrados.add(produto);
            }
        }

        return encontrados;
    }

    public boolean alterar(int codigo, String nome,
                        String categoria, double preco,
                        int quantidade) {

        Produto produto = buscar(codigo);

        if (produto != null) {

            produto.setNome(nome);
            produto.setCategoria(categoria);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);

            return true;
        }

        return false;
    }

    public boolean remover(int codigo) {

        Produto produto = buscar(codigo);

        if (produto != null) {

            produtos.remove(produto);

            return true;
        }

        return false;
    }
}