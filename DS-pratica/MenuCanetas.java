import java.util.Scanner;

public class MenuCanetas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU DE CANETAS ---");
            System.out.println("1. Caneta Esferográfica");
            System.out.println("2. Caneta Gel");
            System.out.println("3. Caneta Tinteiro");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Caneta Esferográfica: Econômica e de longa duração.");
                    break;
                case 2:
                    System.out.println("Caneta Gel: Tinta mais pigmentada e escrita suave.");
                    break;
                case 3:
                    System.out.println("Caneta Tinteiro: Clássica e elegante, usada para caligrafia.");
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