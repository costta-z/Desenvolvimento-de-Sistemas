package ds_pratica;

import java.util.Scanner;

public class Exercício6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Calcular Tabuada");
            System.out.println("2 - Realizar Contagem Regressiva");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o número para a tabuada: ");
                    int num = scanner.nextInt();
                    System.out.println("--- Tabuada do " + num + " ---");
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(num + " x " + i + " = " + (num * i));
                    }
                }
                case 2 -> {
                    System.out.print("Digite o número inicial da contagem regressiva: ");
                    int inicio = scanner.nextInt();
                    System.out.println("--- Contagem Regressiva ---");
                    for (int i = inicio; i >= 0; i--) {
                        System.out.println(i);
                    }
                }
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
