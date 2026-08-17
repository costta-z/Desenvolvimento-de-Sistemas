import java.util.Scanner;

public class Exercício7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a cor do CD (VERDE, AZUL, AMARELO, VERMELHO): ");
        String cor = scanner.nextLine().trim().toUpperCase();

        switch (cor) {
            case "VERDE":
                System.out.println("Preço: R$ 10.00");
                break;
            case "AZUL":
                System.out.println("Preço: R$ 20.00");
                break;
            case "AMARELO":
                System.out.println("Preço: R$ 30.00");
                break;
            case "VERMELHO":
                System.out.println("Preço: R$ 40.00");
                break;
            default:
                System.out.println("Cor inválida!");
                break;
        }

        scanner.close();
    }
}