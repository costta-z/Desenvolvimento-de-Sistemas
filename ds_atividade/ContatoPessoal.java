package ds_atividade;

public class ContatoPessoal extends Contato {

    private String parentesco;

    public ContatoPessoal(String nome, String numero, String parentesco) {
        super(nome, numero);
        this.parentesco = parentesco;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    @Override
    public String exibirDados() {
        return "Nome: " + getNome()
                + "\nTelefone: " + getNumero()
                + "\nTipo: Pessoal"
                + "\nParentesco: " + parentesco;
    }
}

