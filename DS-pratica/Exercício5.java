import java.util.Scanner;

public class Exercício5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String senhaCorreta = "1234segredo"; // Senha pré-configurada

        System.out.print("Digite a senha: ");
        String senhaDigitada = scanner.nextLine();

        if (senhaDigitada.equals(senhaCorreta)) {
            System.out.println("PORTA ABERTA");
        } else {
            System.out.println("SENHA NAO CONFERE");
        }

        scanner.close();
    }
}