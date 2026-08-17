import java.util.Scanner;

public class Exercício1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();

        if (numero > 0) {
            System.out.println("O número é POSITIVO.");
        } else if (numero < 0) {
            System.out.println("O número é NEGATIVO.");
        } else {
            System.out.println("O número é NULO (zero).");
        }

        scanner.close();
    }
}