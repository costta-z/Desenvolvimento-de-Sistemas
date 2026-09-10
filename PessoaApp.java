public class PessoaApp {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(1, "Carlos");
        Pessoa p2 = new Pessoa(2, "Marta");

        // Acessador
        System.out.println("Pessoa: " + p1.getCodigo() + " Nome: " + p1.getNome());

        // Modificador
        p1.setNome("Vanessa");

        System.out.println("Pessoa: " + p1.getCodigo() + " Nome: " + p1.getNome());
    }
}