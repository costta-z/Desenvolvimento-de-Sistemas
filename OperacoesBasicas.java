import java.util.Scanner;

public class OperacoesBasicas {
    public static void main(String[] args) {
        // Criando o objeto Scanner para ler a entrada do teclado
        Scanner scanner = new Scanner(System.in);

        // Solicita o primeiro número
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();

        // Solicita o segundo número
        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        // Realiza os cálculos
        double soma = num1 + num2;
        double subtracao = num1 - num2;
        double multiplicacao = num1 * num2;

        // Exibe os resultados
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Soma: " + soma);
        System.out.println("Subtração: " + subtracao);
        System.out.println("Multiplicação: " + multiplicacao);

        // Validação para evitar a divisão por zero
        if (num2 != 0) {
            double divisao = num1 / num2;
            System.out.println("Divisão: " + divisao);
        } else {
            System.out.println("Divisão: Erro! Não é possível dividir por zero.");
        }

        // Fecha o leitor para liberar recursos
        scanner.close();
    }
}