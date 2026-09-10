import java.util.Scanner;

public class ClienteApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op;

        do {
            System.out.println("\n=== SISTEMA DE CADASTRO DE CLIENTES ===");
            System.out.println("1 - Pessoa Física");
            System.out.println("2 - Pessoa Jurídica");
            System.out.println("0 - Sair");
            System.out.print("Escolha a opção: ");

            while (!sc.hasNextInt()) {
                System.out.println("Opção inválida. Digite 0, 1 ou 2.");
                sc.next();
            }

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1: {
                    System.out.print("Informe o nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Informe o endereço: ");
                    String endereco = sc.nextLine();

                    System.out.print("Informe o CPF: ");
                    String cpf = sc.nextLine();

                    ClientePF pf = new ClientePF(nome, endereco, cpf);

                    System.out.println("\n-- Dados do cliente PF --");
                    pf.exibirDados();

                    break;
                }

                case 2: {
                    System.out.print("Informe o nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Informe o endereço: ");
                    String endereco = sc.nextLine();

                    System.out.print("Informe o CNPJ: ");
                    String cnpj = sc.nextLine();

                    ClientePJ pj = new ClientePJ(nome, endereco, cnpj);

                    System.out.println("\n-- Dados do cliente PJ --");
                    pj.exibirDados();

                    break;
                }

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Digite 0, 1 ou 2.");
                    break;
            }

        } while (op != 0);

        sc.close();
    }
}