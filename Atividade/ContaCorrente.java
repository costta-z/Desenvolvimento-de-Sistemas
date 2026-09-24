package Atividade;

public class ContaCorrente extends Conta implements Pagamento {

    public ContaCorrente(int numero, String titular, double saldo, Agencia agencia) {
        super(numero, titular, saldo, agencia);
    }

    @Override
    public void pagar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: o valor do pagamento deve ser maior que zero.");
            return;
        }

        if (realizarPagamento(valor)) {
            System.out.println("Pagamento realizado em dinheiro.");
            System.out.printf("Saldo atualizado: R$ %.2f%n", getSaldo());
        }
    }

    public void pagar(double valor, String chavePix) {
        if (valor <= 0) {
            System.out.println("Erro: o valor do pagamento deve ser maior que zero.");
            return;
        }

        if (realizarPagamento(valor)) {
            System.out.println("Pagamento realizado com PIX.");
            System.out.println("Chave PIX utilizada: " + chavePix);
            System.out.printf("Saldo atualizado: R$ %.2f%n", getSaldo());
        }
    }

    public void pagar(double valor, int parcelas) {
        if (valor <= 0) {
            System.out.println("Erro: o valor do pagamento deve ser maior que zero.");
            return;
        }

        if (parcelas <= 0) {
            System.out.println("Erro: a quantidade de parcelas deve ser maior que zero.");
            return;
        }

        if (realizarPagamento(valor)) {
            double valorParcela = valor / parcelas;

            System.out.println("Pagamento realizado com cartão.");
            System.out.println("Quantidade de parcelas: " + parcelas);
            System.out.printf("Valor de cada parcela: R$ %.2f%n", valorParcela);
            System.out.printf("Saldo atualizado: R$ %.2f%n", getSaldo());
        }
    }
}

