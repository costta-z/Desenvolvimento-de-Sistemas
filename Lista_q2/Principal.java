package Lista_q2;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Veiculo veiculo = null;
        int dias = 0;

        while (true) {

            System.out.println("\n===== SISTEMA DE LOCAÇÃO =====");
            System.out.println("1. Cadastrar veículo");
            System.out.println("2. Escolher tipo");
            System.out.println("3. Mostrar dados");
            System.out.println("4. Informar quantidade de dias");
            System.out.println("5. Calcular aluguel");
            System.out.println("6. Calcular aluguel com desconto");
            System.out.println("7. Encerrar");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();

                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();

                    System.out.print("Valor da diária: ");
                    double diaria = scanner.nextDouble();

                    System.out.println("1. Carro");
                    System.out.println("2. Moto");
                    System.out.print("Tipo: ");

                    int tipo = scanner.nextInt();

                    if (tipo == 1) {

                        veiculo = new Carro(
                                placa,
                                modelo,
                                ano,
                                diaria
                        );

                    } else if (tipo == 2) {

                        veiculo = new Moto(
                                placa,
                                modelo,
                                ano,
                                diaria
                        );

                    } else {

                        System.out.println("Tipo inválido.");
                    }

                    break;

                case 2:

                    if (veiculo == null) {

                        System.out.println(
                                "Cadastre um veículo primeiro."
                        );

                    } else {

                        System.out.println(
                                "Tipo atual: "
                                + veiculo.getClass().getSimpleName()
                        );
                    }

                    break;

                case 3:

                    if (veiculo == null) {

                        System.out.println(
                                "Nenhum veículo cadastrado."
                        );

                    } else {

                        veiculo.mostrarDados();
                    }

                    break;

                case 4:

                    System.out.print(
                            "Quantidade de dias: "
                    );

                    dias = scanner.nextInt();

                    System.out.println(
                            "Dias registrados: " + dias
                    );

                    break;

                case 5:

                    if (veiculo == null || dias <= 0) {

                        System.out.println(
                                "Cadastre um veículo e informe os dias."
                        );

                    } else {

                        Aluguel aluguel =
                                (Aluguel) veiculo;

                        System.out.printf(
                                "Valor do aluguel: R$ %.2f%n",
                                aluguel.calcularAluguel(dias)
                        );
                    }

                    break;

                case 6:

                    if (veiculo == null || dias <= 0) {

                        System.out.println(
                                "Cadastre um veículo e informe os dias."
                        );

                    } else {

                        System.out.print("Desconto: ");
                        double desconto = scanner.nextDouble();

                        Aluguel aluguel =
                                (Aluguel) veiculo;

                        System.out.printf(
                                "Valor final: R$ %.2f%n",
                                aluguel.calcularAluguel(
                                        dias,
                                        desconto
                                )
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