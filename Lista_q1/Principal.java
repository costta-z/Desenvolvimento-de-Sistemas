package Lista_q1;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Funcionario funcionario = null;

        while (true) {

            System.out.println("\n===== SISTEMA DE FUNCIONÁRIOS =====");
            System.out.println("1. Cadastrar funcionário");
            System.out.println("2. Escolher tipo de funcionário");
            System.out.println("3. Mostrar dados cadastrados");
            System.out.println("4. Calcular pagamento");
            System.out.println("5. Calcular pagamento com bônus");
            System.out.println("6. Consultar dados do funcionário");
            System.out.println("7. Encerrar");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Salário: ");
                    double salario = scanner.nextDouble();

                    System.out.println("1. CLT");
                    System.out.println("2. Freelancer");
                    System.out.print("Tipo: ");

                    int tipo = scanner.nextInt();

                    if (tipo == 1) {

                        funcionario = new FuncionarioCLT(
                                nome,
                                cpf,
                                salario
                        );

                    } else if (tipo == 2) {

                        System.out.print("Horas trabalhadas: ");
                        double horas = scanner.nextDouble();

                        System.out.print("Valor por hora: ");
                        double valorHora = scanner.nextDouble();

                        funcionario = new FuncionarioFreelancer(
                                nome,
                                cpf,
                                salario,
                                horas,
                                valorHora
                        );

                    } else {

                        System.out.println("Tipo inválido.");
                    }

                    break;

                case 2:

                    if (funcionario == null) {
                        System.out.println("Cadastre um funcionário primeiro.");
                    } else {
                        System.out.println(
                                "Tipo atual: "
                                + funcionario.getClass().getSimpleName()
                        );
                    }

                    break;

                case 3:

                    if (funcionario == null) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {
                        funcionario.mostrarDados();
                    }

                    break;

                case 4:

                    if (funcionario == null) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {

                        Pagamento pagamento = (Pagamento) funcionario;

                        System.out.printf(
                                "Pagamento: R$ %.2f%n",
                                pagamento.calcularPagamento()
                        );
                    }

                    break;

                case 5:

                    if (funcionario == null) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {

                        System.out.print("Bônus: ");
                        double bonus = scanner.nextDouble();

                        Pagamento pagamento = (Pagamento) funcionario;

                        System.out.printf(
                                "Pagamento com bônus: R$ %.2f%n",
                                pagamento.calcularPagamento(bonus)
                        );
                    }

                    break;

                case 6:

                    if (funcionario == null) {

                        System.out.println(
                                "Nenhum funcionário cadastrado."
                        );

                    } else {

                        System.out.println(
                                "Nome: " + funcionario.getNome()
                        );

                        System.out.println(
                                "CPF: " + funcionario.getCpf()
                        );

                        System.out.println(
                                "Tipo: "
                                + funcionario.getClass().getSimpleName()
                        );
                    }

                    break;

                case 7:

                    System.out.println("Programa encerrado.");
                    scanner.close();
                    return;

                default:

                    System.out.println("Opção inválida.");
            }
        }
    }
}