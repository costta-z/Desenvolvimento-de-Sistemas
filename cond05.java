import java.util.Scanner;

public class cond05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informar o nome: ");
        String nome = sc.nextLine();

        System.out.println("Informar a semha: ");
        String senha=sc.nextLine();

        if (nome.equals("raquel") && senha.equals("123")) {
            System.out.println("login realizado com sucesso");
        }else if (nome.equals("maria")&& senha.equals("5678")) {
            System.out.println("login realizado com sucesso");
        }else{
            System.out.println("dados incorretos");
        }

        sc.close();
    }
}
