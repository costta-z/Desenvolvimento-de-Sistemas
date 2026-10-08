package Atividade;

public class Carro extends Veiculo{

    public Carro(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }
    
    @Override
    public String mostrarDados(){
        return "Marca: " + getMarca()
                +"\nModelo: " + getModelo()
                +"\nAno: " + getAno();
    }

}
