import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int tam = 5;
        final int maxReservas = 25;

        int[] quartos = new int[tam];
        int[] camas = new int[tam];

        String[] hospedes = new String[maxReservas];
        int[] quartosReservados = new int[maxReservas];

        int qtd = 0;
        int qtdReservas = 0;
        int op;

        System.out.println("=== SUNSTAY - CADASTRO DE HOTEL ===");

        System.out.println("Informe a quantidade de quartos: ");
        int quantidadeQuartos = sc.nextInt();
        sc.nextLine();

        if (quantidadeQuartos > tam) {
            quantidadeQuartos = tam;
            System.out.println("O hotel pode ter no máximo 5 quartos.");
        }

        do {
            System.out.println("\n=== MENU DO HOTEL ===");
            System.out.println("1 - Registrar número dos quartos");
            System.out.println("2 - Registrar quantidade de camas");
            System.out.println("3 - Reservar quarto");
            System.out.println("4 - Consultar reservas por quarto");
            System.out.println("5 - Consultar reservas por hóspede");
            System.out.println("6 - Encerrar sistema");
            System.out.println("Escolha a opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    if (qtd == quantidadeQuartos) {
                        System.out.println("Todos os quartos já foram cadastrados.");
                        break;
                    }

                    System.out.println("\n--- REGISTRAR QUARTOS ---");

                    while (qtd < quantidadeQuartos) {
                        System.out.println("Informe o número do quarto: ");
                        int numeroQuarto = sc.nextInt();
                        sc.nextLine();

                        quartos[qtd] = numeroQuarto;
                        qtd++;

                        System.out.println("Quarto cadastrado com sucesso!");
                    }

                    break;

                case 2:
                    if (qtd == 0) {
                        System.out.println("Nenhum quarto cadastrado.");
                        break;
                    }

                    System.out.println("\n--- REGISTRAR CAMAS ---");

                    for (int i = 0; i < qtd; i++) {
                        System.out.println(
                            "Quantidade de camas do quarto " +
                            quartos[i] + ":"
                        );

                        camas[i] = sc.nextInt();
                        sc.nextLine();
                    }

                    System.out.println("Camas cadastradas com sucesso!");

                    break;

                case 3:
                    if (qtdReservas == maxReservas) {
                        System.out.println("Limite de 25 reservas atingido.");
                        break;
                    }

                    System.out.println("\n--- RESERVAR QUARTO ---");

                    System.out.println("Informe o número do quarto: ");
                    int quartoReserva = sc.nextInt();
                    sc.nextLine();

                    int posQuarto = -1;

                    for (int i = 0; i < qtd; i++) {
                        if (quartos[i] == quartoReserva) {
                            posQuarto = i;
                            break;
                        }
                    }

                    if (posQuarto == -1) {
                        System.out.println("Este quarto não existe!");

                    } else if (camas[posQuarto] == 0) {
                        System.out.println(
                            "Não há camas disponíveis neste quarto!"
                        );

                    } else {
                        System.out.println("Nome do hóspede: ");
                        hospedes[qtdReservas] = sc.nextLine();

                        quartosReservados[qtdReservas] = quartoReserva;

                        camas[posQuarto]--;

                        qtdReservas++;

                        System.out.println(
                            "Reserva realizada com sucesso!"
                        );
                    }

                    break;

                case 4:
                    System.out.println(
                        "\n--- CONSULTAR RESERVAS POR QUARTO ---"
                    );

                    System.out.println("Informe o número do quarto: ");
                    int quartoBusca = sc.nextInt();
                    sc.nextLine();

                    int posBusca = -1;

                    for (int i = 0; i < qtd; i++) {
                        if (quartos[i] == quartoBusca) {
                            posBusca = i;
                            break;
                        }
                    }

                    int encontrou = 0;

                    if (posBusca == -1) {
                        System.out.println("Este quarto não existe!");

                    } else {

                        for (int i = 0; i < qtdReservas; i++) {

                            if (quartosReservados[i] == quartoBusca) {
                                System.out.println(
                                    "Hóspede: " + hospedes[i]
                                );

                                encontrou++;
                            }
                        }

                        if (encontrou == 0) {
                            System.out.println(
                                "Não há reservas para este quarto!"
                            );
                        }
                    }

                    break;

                case 5:
                    System.out.println(
                        "\n--- CONSULTAR RESERVAS POR HÓSPEDE ---"
                    );

                    System.out.println("Informe o nome do hóspede: ");
                    String hospedeBusca = sc.nextLine();

                    int encontrouHospede = 0;

                    for (int i = 0; i < qtdReservas; i++) {

                        if (hospedes[i].equalsIgnoreCase(hospedeBusca)) {

                            System.out.println(
                                "Quarto reservado: " +
                                quartosReservados[i]
                            );

                            encontrouHospede++;
                        }
                    }

                    if (encontrouHospede == 0) {
                        System.out.println(
                            "Não há reservas para este hóspede!"
                        );
                    }

                    break;

                case 6:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (op != 6);

        sc.close();
    }
}
