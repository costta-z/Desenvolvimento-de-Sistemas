import java.util.Scanner;

public class MediaDoisNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        // Parênteses garantem que a soma seja feita antes da divisão
        double media = (num1 + num2) / 2.0;

        System.out.println("A média aritmética é: " + media);

        scanner.close();
    }
}