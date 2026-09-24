package Atividade;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("        CADASTRO INICIAL");
        System.out.println("======================================");

        System.out.print("Número da agência: ");
        int numeroAgencia = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome da agência: ");
        String nomeAgencia = scanner.nextLine();

        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do titular: ");
        String titular = scanner.nextLine();

        System.out.print("Saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        Agencia agencia = new Agencia(numeroAgencia, nomeAgencia);

        ContaCorrente conta = new ContaCorrente(
                numeroConta,
                titular,
                saldoInicial,
                agencia
        );

        int opcao;

        do {
            System.out.println();
            System.out.println("======================================");
            System.out.println("              MENU");
            System.out.println("======================================");
            System.out.println("1 - Mostrar dados da conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Pagar com PIX");
            System.out.println("5 - Pagar com cartão");
            System.out.println("6 - Pagar em dinheiro");
            System.out.println("0 - Sair");
            System.out.println("======================================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println();
                    System.out.println("========== DADOS DA CONTA ==========");
                    conta.mostrarDados();
                    break;

                case 2:
                    System.out.println();
                    conta.consultarSaldo();
                    break;

                case 3:
                    System.out.print("Digite o valor do depósito: ");
                    double deposito = scanner.nextDouble();

                    conta.depositar(deposito);
                    break;

                case 4:
                    System.out.print("Digite o valor do pagamento PIX: ");
                    double valorPix = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Digite a chave PIX: ");
                    String chavePix = scanner.nextLine();

                    conta.pagar(valorPix, chavePix);
                    break;

                case 5:
                    System.out.print("Digite o valor da compra: ");
                    double valorCartao = scanner.nextDouble();

                    System.out.print("Digite a quantidade de parcelas: ");
                    int parcelas = scanner.nextInt();

                    conta.pagar(valorCartao, parcelas);
                    break;

                case 6:
                    System.out.print("Digite o valor do pagamento: ");
                    double valorDinheiro = scanner.nextDouble();

                    conta.pagar(valorDinheiro);
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}