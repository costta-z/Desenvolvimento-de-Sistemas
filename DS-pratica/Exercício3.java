import java.util.Scanner;

public class Exercício3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();

        if (idade >= 0 && idade <= 12) {
            System.out.println("CRIANÇA");
        } else if (idade >= 13 && idade <= 17) {
            System.out.println("ADOLESCENTE");
        } else if (idade >= 18 && idade <= 59) {
            System.out.println("ADULTO");
        } else if (idade >= 60) {
            System.out.println("IDOSO");
        } else {
            System.out.println("Idade inválida!");
        }

        scanner.close();
    }
}