import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeBank {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Digite o saldo disponível: ");
            double saldo = sc.nextDouble();

            System.out.println("Digite o valor do pagamento: ");
            double valor =sc.nextDouble();

            if (valor <= 0) {
                throw new IllegalArgumentException("O valor deve ser maior que zero.");
            }

            if (valor > saldo) {
                throw new IllegalArgumentException("Saldo insuficiente.");
            }

            double saldoRestante = saldo - valor;

            System.out.println("Pagamentp realizado com sucesso!");
            System.out.printf("Saldo restante: R$ %.2f%n", saldoRestante);
        } catch (InputMismatchException e) {
            System.out.println("Erro: digite apenas números.");
        } catch(IllegalArgumentException e){
            System.out.println("Erro: "+ e.getMessage());
        } finally {
            System.out.println("Operação encerrada.");
            sc.close();
        }
    }
}
