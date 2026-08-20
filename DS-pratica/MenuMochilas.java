import java.util.Scanner;

public class MenuMochilas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU DE MOCHILAS ---");
            System.out.println("1. Mochila Escolar");
            System.out.println("2. Mochila de Viagem");
            System.out.println("3. Mochila Esportiva");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Mochila Escolar: Compacta e ideal para estudantes.");
                    break;
                case 2:
                    System.out.println("Mochila de Viagem: Espaçosa, ideal para longas jornadas.");
                    break;
                case 3:
                    System.out.println("Mochila Esportiva: Leve, resistente e ergonômica.");
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}