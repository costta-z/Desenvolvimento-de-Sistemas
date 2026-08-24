package ds_pratica;

public class Exercício3 {
    public static void main(String[] args) {
        System.out.println("--- Números Ímpares de 1 a 51 ---");
        for (int i = 1; i <= 51; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println("\n\n--- Números Pares de 52 a 100 ---");
        for (int i = 52; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}