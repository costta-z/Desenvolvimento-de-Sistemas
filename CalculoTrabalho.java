import java.util.Scanner;

public class CalculoTrabalho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a força aplicada (F) em Newtons: ");
        double forca = scanner.nextDouble();

        System.out.print("Digite a distância percorrida (D) em metros: ");
        double distancia = scanner.nextDouble();

        // Fórmula: T = F * D
        double trabalho = forca * distancia;

        System.out.println("O trabalho realizado (T) é: " + trabalho + " Joules (J)");

        scanner.close();
    }
}