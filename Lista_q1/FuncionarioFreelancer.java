package Lista_q1;

public class FuncionarioFreelancer extends Funcionario implements Pagamento {

    private double horasTrabalhadas;
    private double valorPorHora;

    public FuncionarioFreelancer(String nome, String cpf, double salario,
                                double horasTrabalhadas, double valorPorHora) {
        super(nome, cpf, salario);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    @Override
    public double calcularPagamento() {
        return horasTrabalhadas * valorPorHora;
    }

    @Override
    public double calcularPagamento(double bonus) {
        return calcularPagamento() + bonus;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Horas trabalhadas: " + horasTrabalhadas);
        System.out.printf("Valor por hora: R$ %.2f%n", valorPorHora);
    }
}