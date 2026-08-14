import java.util.Scanner;

public class Desafio2Boletim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();

        // Cálculo da média
        double media = (nota1 + nota2) / 2.0;

        // Saída formatada com duas casas decimais (%.2f)
        System.out.println();
        System.out.printf("Aluno: %s%n", nome);
        System.out.printf("Nota 1: %.2f%n", nota1);
        System.out.printf("Nota 2: %.2f%n", nota2);
        System.out.printf("Média: %.2f%n", media);

        scanner.close();
    }
}