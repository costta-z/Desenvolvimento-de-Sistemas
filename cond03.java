import java.util.Scanner;

public class cond03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informar a idade: ");
        int idade = sc.nextInt();

        System.out.println("É estudante? Digite 1 para sim ou 0 para não: ");
        int estudante = sc.nextInt();

        if (idade >= 60 || estudante == 1) {
            System.out.println("Você tem direito ao desconto");
        } else {
            System.out.println("Você não tem direito ao desconto");
        }

        sc.close();
    }
}