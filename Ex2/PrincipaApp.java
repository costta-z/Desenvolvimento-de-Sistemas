package Ex2;
import java.util.Scanner;

public class PrincipaApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digitre o valor do pagamento: R$ ");
        double valor = sc.nextDouble();

        Pix pix = new Pix();
        pix.pagar(valor);


        sc.close();
    }
}
