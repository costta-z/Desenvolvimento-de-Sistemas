import java.util.ArrayList;

public class Ex02 {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> numeros = new ArrayList<>();

        // ADICIONAR
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Listar
        System.out.println("Lista");
        for (Integer  numero : numeros) {
            System.out.println(numero);
        }

        // ALTERAR
        numeros.set(1, 15);
        
        System.out.println("Lista após alterar");
        for (Integer  numero : numeros) {
            System.out.println(numero);
        }

        // REMOVER
        numeros.remove(0);

        System.out.println("Lista após remover");
        for (Integer  numero : numeros) {
            System.out.println(numero);
        }
        
    }
}

