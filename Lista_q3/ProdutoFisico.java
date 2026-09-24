package Lista_q3;

public class ProdutoFisico extends Produto implements Venda {

    private double frete;

    public ProdutoFisico(
            int codigo,
            String nome,
            double preco,
            double frete) {

        super(codigo, nome, preco);
        this.frete = frete;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    @Override
    public double realizarVenda(int quantidade) {

        return getPreco() * quantidade + frete;
    }

    @Override
    public double realizarVenda(
            int quantidade,
            double descontoPercentual) {

        double total =
                getPreco() * quantidade + frete;

        return total -
                (total * descontoPercentual / 100);
    }

    @Override
    public void mostrarDados() {

        super.mostrarDados();

        System.out.printf(
                "Frete: R$ %.2f%n",
                frete
        );
    }
}