import java.util.Scanner;

public class CalculoIMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o peso (em kg): ");
        double peso = scanner.nextDouble();

        System.out.print("Digite a altura (em metros, ex: 1.75): ");
        double altura = scanner.nextDouble();

        // Fórmula: IMC = peso / (altura * altura)
        double imc = peso / (altura * altura);

        // Exibe o IMC formatado com 2 casas decimais
        System.out.printf("O IMC calculado é: %.2f\n", imc);

        scanner.close();
    }
}