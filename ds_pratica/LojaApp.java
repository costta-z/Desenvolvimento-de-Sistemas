package ds_pratica;

import java.util.Scanner;

public class LojaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Loja a =new Loja(null, 0, 0);

        System.out.println("Informe o Nome: ");
        a.setNome(sc.nextLine());

        System.out.println("Informe o preço: ");
        a.setPreco(sc.nextFloat());

        System.out.println("Informe a quantidade: ");
        a.setQuantidade(sc.nextInt());

        System.out.println("\nO Nome: "+a.getNome());
        System.out.println("\nO Preço: "+a.getPreco());
        System.out.println("\nA Quantidade: "+a.getQuantidade());

        sc.close();
    }
}
