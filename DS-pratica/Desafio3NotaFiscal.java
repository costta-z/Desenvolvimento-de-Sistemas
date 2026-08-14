import java.util.Scanner;

public class Desafio3NotaFiscal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Digite o nome do cliente: ");
        String cliente = scanner.nextLine();

        System.out.print("Digite o nome do produto: ");
        String produto = scanner.nextLine();

        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();

        System.out.print("Digite o valor unitário: ");
        double valorUnitario = scanner.nextDouble();

        // Cálculo do valor total
        double total = quantidade * valorUnitario;

        // Saída formatada
        System.out.println("\n--------- NOTA FISCAL ---------");
        System.out.printf("Cliente: %s%n", cliente);
        System.out.printf("Produto: %s%n", produto);
        System.out.printf("Quantidade: %d%n", quantidade);
        System.out.printf("Valor unitário: R$ %.2f%n", valorUnitario);
        System.out.printf("Total: R$ %.2f%n", total);
        System.out.println("-------------------------------");

        scanner.close();
    }
}