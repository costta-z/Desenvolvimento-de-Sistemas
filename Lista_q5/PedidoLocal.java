package Lista_q5;

public class PedidoLocal
        extends Pedido
        implements Pagamento {

public PedidoLocal(
        int numeroPedido,
        String nomeCliente,
        double valorPedido) {

        super(
                numeroPedido,
                nomeCliente,
                valorPedido
        );
}

@Override
public void pagar(double valor) {

        System.out.printf(
                "Pagamento em dinheiro: R$ %.2f%n",
                valor
        );
}

@Override
public void pagar(
        double valor,
        String chavePix) {

        System.out.printf(
                "Pagamento via PIX: R$ %.2f | Chave: %s%n",
                valor,
                chavePix
        );
}

@Override
public void pagar(
        double valor,
        int parcelas) {

        double parcela =
                valor / parcelas;

        System.out.printf(
                "Pagamento com cartão: R$ %.2f em %d parcelas de R$ %.2f%n",
                valor,
                parcelas,
                parcela
        );
}
}