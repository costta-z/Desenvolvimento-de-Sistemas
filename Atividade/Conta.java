package Atividade;
public class Conta {

    private int numero;
    private String titular;
    private double saldo;
    private Agencia agencia;

    public Conta(int numero, String titular, double saldo, Agencia agencia) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito realizado com sucesso!%n");
            System.out.printf("Novo saldo: R$ %.2f%n", saldo);
        } else {
            System.out.println("Erro: o valor do depósito deve ser maior que zero.");
        }
    }

    public void consultarSaldo() {
        System.out.printf("Saldo disponível: R$ %.2f%n", saldo);
    }

    public void mostrarDados() {
        agencia.mostrarDados();
        System.out.println("Número da conta: " + numero);
        System.out.println("Nome do titular: " + titular);
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
    }

    protected boolean realizarPagamento(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: o valor do pagamento deve ser maior que zero.");
            return false;
        }

        if (valor > saldo) {
            System.out.println("Erro: saldo insuficiente.");
            return false;
        }

        saldo -= valor;
        return true;
    }
}