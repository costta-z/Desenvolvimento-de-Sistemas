import java.util.Scanner;

public class NumerosPositivos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Digite um número positivo (ou um negativo para sair): ");
            numero = scanner.nextInt();
        } while (numero >= 0);

        System.out.println("Número negativo detectado. Programa encerrado!");

        scanner.close();
    }
}