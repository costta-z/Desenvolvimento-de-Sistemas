package Ex6;
public class Cachorro extends Animal {
    
    private String raca;

    public Cachorro(String nome, int idade, String raca) {
        super(nome, idade);
        this.raca = raca;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public String exibirInfo() {
        String racaExibida = (raca != null) ? raca : "";
        return String.format("Cachorro | Nome: %s | Idade: %d | Raça: %s", getNome(), getIdade(), racaExibida);
    }
}