package Lista_q5;

public interface Pagamento {

void pagar(double valor);

void pagar(
        double valor,
        String chavePix);

void pagar(
        double valor,
        int parcelas);
}