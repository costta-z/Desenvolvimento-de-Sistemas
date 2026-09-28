package Exemplos;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex05 {
    
    public static void main(String[] args) {
        
        ArrayList<String> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int op= -1;

        while (op!=0) {
            try{
                System.out.println("\n=== MENU ===");
                System.out.println("1-Adicionar");
                System.out.println("2-Listar");
                System.out.println("3-Remover");
                System.out.println("0-Sair");
                System.out.println("Infor a opção: ");
                op=sc.nextInt();
                sc.nextLine();

                switch (op) {
                    case 1:
                        System.out.println("Informe o nome: ");
                        String nome = sc.nextLine();
                        lista.add(nome);
                        System.out.println("Adicionado com sucesso!");
                        break;
                    case 2:
                        if (lista.isEmpty()) {
                            System.out.println("Lista vazia");
                        }else{
                            System.out.println("Lista: "+lista);
                        }
                        break;
                    case 3:
                        System.out.println("Informe o indice para remover: ");
                        int indice=sc.nextInt();
                        sc.nextLine();
                        lista.remove(indice);
                        System.out.println("Removido com sucesso!");
                        break;
                    case 0:
                        System.out.println("Partiu!");
                        break;
                    default:
                        System.out.println("opção inválida!");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Erro: Você deve digitar um número");
                sc.nextLine();
            }catch(IndexOutOfBoundsException e){
                System.out.println("Erro: indice inválido");
            }catch(Exception e){
                System.out.println("Erro inesperado: "+e.getMessage());
            }
            }
        



        sc.close();
    }
}
