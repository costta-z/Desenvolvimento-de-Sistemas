import java.util.Scanner;

public class Exercício6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sem mensagens de entrada, conforme especificado no enunciado
        double operando1 = scanner.nextDouble();
        double operando2 = scanner.nextDouble();
        char operador = scanner.next().charAt(0);

        double resultado = 0;

        switch (operador) {
            case '+':
                resultado = operando1 + operando2;
                break;
            case '-':
                resultado = operando1 - operando2;
                break;
            case '*':
                resultado = operando1 * operando2;
                break;
            case '/':
                if (operando2 != 0) {
                    resultado = operando1 / operando2;
                } else {
                    System.out.println("Erro: Divisão por zero!");
                    scanner.close();
                    return;
                }
                break;
            default:
                System.out.println("Operador inválido!");
                scanner.close();
                return;
        }

        System.out.println(resultado);

        scanner.close();
    }
}