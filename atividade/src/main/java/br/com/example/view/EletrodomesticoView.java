package br.com.example.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.example.controle.EletrodomesticoControle;
import br.com.example.modelo.Eletrodomestico;

public class EletrodomesticoView {

    private EletrodomesticoControle controle;

    public EletrodomesticoView() {
        controle = new EletrodomesticoControle();
    }

    public void menu() {
        int opcao;

        do {
            String menu = """
                    ===== CADASTRO DE ELETRODOMÉSTICOS =====

                    1. Cadastrar eletrodoméstico
                    2. Listar eletrodomésticos
                    3. Alterar eletrodoméstico
                    4. Remover eletrodoméstico
                    5. Sair

                    Escolha uma opção:
                    """;

            String entrada = JOptionPane.showInputDialog(menu);

            if (entrada == null) {
                break;
            }

            try {
                opcao = Integer.parseInt(entrada);

                switch (opcao) {

                    case 1:
                        cadastrar();
                        break;

                    case 2:
                        listar();
                        break;

                    case 3:
                        alterar();
                        break;

                    case 4:
                        remover();
                        break;

                    case 5:
                        JOptionPane.showMessageDialog(null, "Sistema encerrado!");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite uma opção válida!");
                opcao = 0;
            }

        } while (opcao != 5);
    }

    public void cadastrar() {

        String nome = JOptionPane.showInputDialog("Digite o nome do eletrodoméstico:");

        if (nome == null) return;

        String marca = JOptionPane.showInputDialog("Digite a marca:");

        if (marca == null) return;

        String voltagem = JOptionPane.showInputDialog("Digite a voltagem:");

        if (voltagem == null) return;

        String entradaPreco = JOptionPane.showInputDialog("Digite o preço (exemplo: 1599.90):");

        if (entradaPreco == null) return;

        try {
            nome = nome.trim();
            marca = marca.trim();
            voltagem = voltagem.trim();

            if (nome.isEmpty() || marca.isEmpty() || voltagem.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
                return;
            }

            double preco = Double.parseDouble(entradaPreco.trim());

            if (preco <= 0) {
                JOptionPane.showMessageDialog(null, "O preço deve ser maior que zero!");
                return;
            }

            if (controle.cadastrar(nome, marca, voltagem, preco)) {
                JOptionPane.showMessageDialog(null, "Eletrodoméstico cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar eletrodoméstico!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um preço numérico válido!");
        }
    }

    public void listar() {

        ArrayList<Eletrodomestico> eletrodomesticos = controle.listar();

        if (eletrodomesticos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum eletrodoméstico cadastrado!");
            return;
        }

        StringBuilder mensagem = new StringBuilder();

        mensagem.append("===== ELETRODOMÉSTICOS CADASTRADOS =====\n\n");

        for (Eletrodomestico eletrodomestico : eletrodomesticos) {

            mensagem.append("ID: ").append(eletrodomestico.getId()).append("\n");
            mensagem.append("Nome: ").append(eletrodomestico.getNome()).append("\n");
            mensagem.append("Marca: ").append(eletrodomestico.getMarca()).append("\n");
            mensagem.append("Voltagem: ").append(eletrodomestico.getVoltagem()).append("\n");
            mensagem.append("Preço: R$ ").append(String.format("%.2f", eletrodomestico.getPreco())).append("\n");

            mensagem.append("------------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

    public void alterar() {

        String entradaId = JOptionPane.showInputDialog("Digite o ID do eletrodoméstico que deseja alterar:");

        if (entradaId == null) return;

        try {
            int id = Integer.parseInt(entradaId.trim());

            if (id <= 0) {
                JOptionPane.showMessageDialog(null, "O ID deve ser um número inteiro positivo!");
                return;
            }

            Eletrodomestico eletrodomestico = controle.buscar(id);

            if (eletrodomestico == null) {
                JOptionPane.showMessageDialog(null, "Eletrodoméstico não encontrado!");
                return;
            }

            String nome = JOptionPane.showInputDialog(null, "Digite o novo nome:", eletrodomestico.getNome());

            if (nome == null) return;

            String marca = JOptionPane.showInputDialog(null, "Digite a nova marca:", eletrodomestico.getMarca());

            if (marca == null) return;

            String voltagem = JOptionPane.showInputDialog(null, "Digite a nova voltagem:", eletrodomestico.getVoltagem());

            if (voltagem == null) return;

            String entradaPreco = JOptionPane.showInputDialog(null, "Digite o novo preço:", eletrodomestico.getPreco());

            if (entradaPreco == null) return;

            nome = nome.trim();
            marca = marca.trim();
            voltagem = voltagem.trim();

            if (nome.isEmpty() || marca.isEmpty() || voltagem.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
                return;
            }

            double preco = Double.parseDouble(entradaPreco.trim());

            if (preco <= 0) {
                JOptionPane.showMessageDialog(null, "O preço deve ser maior que zero!");
                return;
            }

            if (controle.alterar(id, nome, marca, voltagem, preco)) {
                JOptionPane.showMessageDialog(null, "Eletrodoméstico alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao alterar eletrodoméstico!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite valores numéricos válidos!");
        }
    }

    public void remover() {

        String entradaId = JOptionPane.showInputDialog("Digite o ID do eletrodoméstico que deseja remover:");

        if (entradaId == null) return;

        try {
            int id = Integer.parseInt(entradaId.trim());

            if (id <= 0) {
                JOptionPane.showMessageDialog(null, "O ID deve ser um número inteiro positivo!");
                return;
            }

            Eletrodomestico eletrodomestico = controle.buscar(id);

            if (eletrodomestico == null) {
                JOptionPane.showMessageDialog(null, "Eletrodoméstico não encontrado!");
                return;
            }

            String mensagem = "Deseja realmente remover este eletrodoméstico?\n\n"
                    + "ID: " + eletrodomestico.getId() + "\n"
                    + "Nome: " + eletrodomestico.getNome() + "\n"
                    + "Marca: " + eletrodomestico.getMarca() + "\n"
                    + "Voltagem: " + eletrodomestico.getVoltagem() + "\n"
                    + "Preço: R$ " + eletrodomestico.getPreco();

            int confirmacao = JOptionPane.showConfirmDialog(
                    null,
                    mensagem,
                    "Confirmar exclusão",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacao == JOptionPane.YES_OPTION) {

                if (controle.remover(id)) {
                    JOptionPane.showMessageDialog(null, "Eletrodoméstico removido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao remover eletrodoméstico!");
                }

            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um ID numérico válido!");
        }
    }
}
