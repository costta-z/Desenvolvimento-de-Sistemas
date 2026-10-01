import java.util.Scanner;

public class ContaApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        cadastroConta cadastro = new cadastroConta();

        int opcao = 0;

        while (opcao != 4) {

            System.out.println();
            System.out.println("===== SISTEMA DE CONTAS BANCÁRIAS =====");
            System.out.println("1. Cadastrar Conta");
            System.out.println("2. Buscar Conta");
            System.out.println("3. Remover Conta");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            try {

                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {

                    case 1:
                        cadastrarConta(scanner, cadastro);
                        break;

                    case 2:
                        buscarConta(scanner, cadastro);
                        break;

                    case 3:
                        removerConta(scanner, cadastro);
                        break;

                    case 4:
                        System.out.println("Programa encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Erro: digite uma opção numérica."
                );

            } catch (ExcecaoDadoInvalido |
                     ExcecaoElementoJaExistente |
                     ExcecaoElementoInexistente |
                     ExcecaoRepositorio e) {

                System.out.println("Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void cadastrarConta(
            Scanner scanner,
            cadastroConta cadastro)
            throws ExcecaoDadoInvalido,
                   ExcecaoElementoJaExistente,
                   ExcecaoRepositorio {

        System.out.println();
        System.out.println("===== CADASTRO DE CONTA =====");

        System.out.print("Digite o número da conta: ");
        String numero = scanner.nextLine();

        System.out.print("Digite o nome do titular: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o saldo inicial: ");
        double saldo = Double.parseDouble(scanner.nextLine());

        Conta conta = new Conta(numero, nome, saldo);

        cadastro.inserir(conta);

        System.out.println("Conta cadastrada com sucesso!");
    }

    private static void buscarConta(
            Scanner scanner,
            cadastroConta cadastro)
            throws ExcecaoElementoInexistente {

        System.out.println();
        System.out.println("===== BUSCAR CONTA =====");

        System.out.print("Digite o número da conta: ");
        String numero = scanner.nextLine();

        Conta conta = cadastro.buscar(numero);

        System.out.println("Conta encontrada!");
        System.out.println("Titular: " + conta.getNomeTitular());
        System.out.printf("Saldo: R$ %.2f%n", conta.getSaldo());
    }

    private static void removerConta(
            Scanner scanner,
            cadastroConta cadastro)
            throws ExcecaoElementoInexistente {

        System.out.println();
        System.out.println("===== REMOVER CONTA =====");

        System.out.print("Digite o número da conta: ");
        String numero = scanner.nextLine();

        cadastro.remover(numero);

        System.out.println("Conta removida com sucesso!");
    }
}