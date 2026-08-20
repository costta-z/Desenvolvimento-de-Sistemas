import java.util.Scanner;

public class Wh05 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        
    int op=0;

    while (op!=5) {
        System.out.println("\n===MENU===");
        System.out.println("1-Cadastro");
        System.out.println("2-Listar");
        System.out.println("3-Alterar");
        System.out.println("4-Remover");
        System.out.println("5-Sair");
        System.out.println("Escolha a opção: ");
        op=sc.nextInt();

        switch (op) {
            case 1:
                System.out.println("cadastrar");
                break;
            case 2:
                System.out.println("cadastrar");
                break;
            case 3:
                System.out.println("cadastrar");
                break;
            case 4:
                System.out.println("cadastrar");
                break;
            case 5:
                System.out.println("Sair");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
            }
        }

        sc.close();
    }
}
