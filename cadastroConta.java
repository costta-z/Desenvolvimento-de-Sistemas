import java.util.ArrayList;

public class cadastroConta {

    private ArrayList<Conta> contas;
    private static final int LIMITE_MAXIMO = 100;

    public cadastroConta() {
        contas = new ArrayList<>();
    }

    public void inserir(Conta conta)
            throws ExcecaoElementoJaExistente, ExcecaoRepositorio {

        if (contas.size() >= LIMITE_MAXIMO) {
            throw new ExcecaoRepositorio(
                    "Limite máximo de 100 contas atingido."
            );
        }

        if (buscarContaInternamente(conta.getNumeroConta()) != null) {
            throw new ExcecaoElementoJaExistente(
                    "Já existe uma conta com esse número."
            );
        }

        contas.add(conta);
    }

    public Conta buscar(String numeroConta)
            throws ExcecaoElementoInexistente {

        Conta conta = buscarContaInternamente(numeroConta);

        if (conta == null) {
            throw new ExcecaoElementoInexistente(
                    "Conta não encontrada."
            );
        }

        return conta;
    }

    public void remover(String numeroConta)
            throws ExcecaoElementoInexistente {

        Conta conta = buscarContaInternamente(numeroConta);

        if (conta == null) {
            throw new ExcecaoElementoInexistente(
                    "Conta não encontrada."
            );
        }

        contas.remove(conta);
    }

    private Conta buscarContaInternamente(String numeroConta) {

        for (Conta conta : contas) {

            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }

        return null;
    }
}