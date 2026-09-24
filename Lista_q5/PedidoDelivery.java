package Lista_q5;

public class PedidoDelivery
        extends Pedido
        implements Pagamento {

private String endereco;
private double taxaEntrega;

public PedidoDelivery(
        int numeroPedido,
        String nomeCliente,
        double valorPedido,
        String endereco,
        double taxaEntrega) {

        super(
                numeroPedido,
                nomeCliente,
                valorPedido
        );

        this.endereco = endereco;
        this.taxaEntrega = taxaEntrega;
}

public String getEndereco() {
        return endereco;
}

public void setEndereco(
        String endereco) {

        this.endereco = endereco;
}

public double getTaxaEntrega() {
        return taxaEntrega;
}

public void setTaxaEntrega(
        double taxaEntrega) {

        this.taxaEntrega = taxaEntrega;
}

public double getValorTotal() {

        return getValorPedido()
                + taxaEntrega;
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

@Override
public void mostrarDados() {

        super.mostrarDados();

        System.out.println(
                "Endereço: " + endereco
        );

        System.out.printf(
                "Taxa de entrega: R$ %.2f%n",
                taxaEntrega
        );

        System.out.printf(
                "Valor total: R$ %.2f%n",
                getValorTotal()
        );
}
}