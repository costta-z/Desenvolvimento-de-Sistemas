import java.util.Scanner;

public class ValidacaoSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int senha;

        do {
            System.out.print("Digite a senha de 4 dígitos: ");
            senha = scanner.nextInt();

            if (senha != 2024) {
                System.out.println("Senha incorreta. Tente novamente.");
            }
        } while (senha != 2024);

        System.out.println("Acesso Permitido");

        scanner.close();
    }
}