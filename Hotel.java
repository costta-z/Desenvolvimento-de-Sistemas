import java.util.Scanner;

public class Hotel {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    final int tam = 5;
    final int maxReservas = 25;

    int[] quartos = new int[tam];
    int[] camas = new int[tam];

    String[] hospedes = new String[maxReservas];
    int[] quartosReservados = new int[maxReservas];

    int qtd = 0;
    int qtdReservas = 0;
    int op;

    System.out.println("===SUNSTAY - CADASTRO DE HOTEL ===");

    System.out.println("Informe a quantidade de quartos: ");
    int quantidadeQuartos = sc.nextInt();
    sc.nextLine();

    if (quantidadeQuartos > tam) {
        quantidadeQuartos = tam;
        System.out.println("O hotel pode ter no máximo 5 quartos.");
    }

    do {
        System.out.println("\n=== MENU DO HOTEL ===");
        System.out.println("1 - Registrar número dos quartos");
        System.out.println("2 - Registrar quantidade de camas");
        System.out.println("3 - Reservar quarto");
        System.out.println("4 - Consultar reservas por quarto");
        System.out.println("5 - Consultar reservas por hóspede");
        System.out.println("6 - Encerrar sitema");
        System.out.println("Escolha a opção: ");

        op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                if (qtd == quantidadeQuartos) {
                    System.out.println("Todos os quartos já foram cadastrados.");
                    break;
                }

                System.out.println("\n---");
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
        
            default:
                break;
        }
    } while ();







    sc.close();
}
}
