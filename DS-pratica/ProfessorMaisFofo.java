import java.util.Scanner;

public class ProfessorMaisFofo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome = "";

        while (!nome.equalsIgnoreCase("Anderson")) {
            System.out.print("Digite o nome do professor mais fofo do SENAI: ");
            nome = scanner.nextLine();

            if (!nome.equalsIgnoreCase("Anderson")) {
                System.out.println("Incorreto! Tente novamente.");
            }
        }

        System.out.println("Acertou! O programa foi encerrado.");

        scanner.close();
    }
}