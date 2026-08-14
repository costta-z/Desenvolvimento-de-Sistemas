import java.util.Scanner;

public class Desafio1Produto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Digite o nome do produto: ");
        String produto = scanner.nextLine();

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o preço unitário: ");
        double precoUnitario = scanner.nextDouble();

        // Saída formatada usando printf
        System.out.println();
        System.out.printf("Produto: %s%n", produto);
        System.out.printf("Quantidade: %d%n", quantidade);
        System.out.printf("Preço unitário: R$ %.2f%n", precoUnitario);

        scanner.close();
    }
}