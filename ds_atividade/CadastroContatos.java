package ds_atividade;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroContatos {

    static ArrayList<Contato> contatos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarContatoPessoal();
                    break;

                case 2:
                    cadastrarContatoProfissional();
                    break;

                case 3:
                    listarContatos();
                    break;

                case 4:
                    pesquisarContato();
                    break;

                case 5:
                    alterarContato();
                    break;

                case 6:
                    excluirContato();
                    break;

                case 7:
                    System.out.println("\nPrograma encerrado.");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }

        } while (opcao != 7);

        sc.close();
    }

    public static void exibirMenu() {
        System.out.println();
        System.out.println("===================================");
        System.out.println("        AGENDA DE CONTATOS");
        System.out.println("===================================");
        System.out.println("1 - Cadastrar contato pessoal");
        System.out.println("2 - Cadastrar contato profissional");
        System.out.println("3 - Listar todos os contatos");
        System.out.println("4 - Pesquisar contato");
        System.out.println("5 - Alterar contato");
        System.out.println("6 - Excluir contato");
        System.out.println("7 - Sair");
        System.out.println("===================================");
    }

    public static void cadastrarContatoPessoal() {
        System.out.println("\n--- CADASTRAR CONTATO PESSOAL ---");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Parentesco: ");
        String parentesco = sc.nextLine();

        ContatoPessoal contato = new ContatoPessoal(
                nome,
                telefone,
                parentesco
        );

        contatos.add(contato);

        System.out.println("\nContato pessoal cadastrado com sucesso!");
    }

    public static void cadastrarContatoProfissional() {
        System.out.println("\n--- CADASTRAR CONTATO PROFISSIONAL ---");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Empresa: ");
        String empresa = sc.nextLine();

        System.out.print("Cargo: ");
        String cargo = sc.nextLine();

        ContatoProfissional contato = new ContatoProfissional(
                nome,
                telefone,
                empresa,
                cargo
        );

        contatos.add(contato);

        System.out.println("\nContato profissional cadastrado com sucesso!");
    }

    public static void listarContatos() {
        System.out.println("\n--- LISTA DE CONTATOS ---");

        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }

        for (int i = 0; i < contatos.size(); i++) {
            System.out.println("\n" + (i + 1) + " -");
            System.out.println(contatos.get(i).exibirDados());
            System.out.println("-----------------------------------");
        }
    }

    public static void pesquisarContato() {
        System.out.println("\n--- PESQUISAR CONTATO ---");

        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }

        System.out.print("Digite o nome para pesquisar: ");
        String nomePesquisa = sc.nextLine();

        boolean encontrado = false;

        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nomePesquisa)) {
                System.out.println("\nContato encontrado!");
                System.out.println(contato.exibirDados());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\nContato não encontrado.");
        }
    }

    public static void alterarContato() {
        System.out.println("\n--- ALTERAR CONTATO ---");

        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }

        for (int i = 0; i < contatos.size(); i++) {
            System.out.println((i + 1) + " - " + contatos.get(i).getNome());
        }

        int posicao = lerInteiro(
                "Informe o número do contato que deseja alterar: "
        );

        if (posicao < 1 || posicao > contatos.size()) {
            System.out.println("Contato inválido!");
            return;
        }

        int indice = posicao - 1;

        Contato contato = contatos.get(indice);

        System.out.println("\nContato atual:");
        System.out.println(contato.exibirDados());

        System.out.print("\nNovo nome: ");
        String novoNome = sc.nextLine();

        System.out.print("Novo telefone: ");
        String novoTelefone = sc.nextLine();

        contato.setNome(novoNome);
        contato.setNumero(novoTelefone);

        System.out.println("\nContato alterado com sucesso!");
    }

    public static void excluirContato() {
        System.out.println("\n--- EXCLUIR CONTATO ---");

        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }

        for (int i = 0; i < contatos.size(); i++) {
            System.out.println(
                    (i + 1) + " - " + contatos.get(i).getNome()
            );
        }

        int posicao = lerInteiro(
                "Informe o número do contato que deseja excluir: "
        );

        if (posicao < 1 || posicao > contatos.size()) {
            System.out.println("Contato inválido!");
            return;
        }

        contatos.remove(posicao - 1);

        System.out.println("Contato excluído com sucesso!");
    }

    public static int lerInteiro(String mensagem) {

        while (true) {
            System.out.print(mensagem);

            try {
                return Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Erro: digite apenas números!");
            }
        }
    }
}

