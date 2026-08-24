package ds_pratica;

public class Exercício4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("\n--- Tabuada do " + i + " ---");
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }
        }
    }
}
