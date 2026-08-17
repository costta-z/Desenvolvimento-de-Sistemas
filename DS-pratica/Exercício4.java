import java.util.Scanner;

public class Exercício4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();

        if (idade >= 18) {
            System.out.println("É maior de idade.");
        } else {
            System.out.println("NÃO é maior de idade.");
        }

        scanner.close();
    }
}