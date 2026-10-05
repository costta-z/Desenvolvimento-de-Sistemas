import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Atividade {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Criar arquivo");
            System.out.println("2 - Escrever no arquivo");
            System.out.println("3 - Ler arquivo");
            System.out.println("4 - Alterar arquivo");
            System.out.println("5 - Remover arquivo");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    try {
                        File arquivo = new File("arquivo.txt");

                        if (arquivo.createNewFile()) {
                            System.out.println("Arquivo criado com sucesso!");
                        } else {
                            System.out.println("O arquivo já existe.");
                        }

                    } catch (IOException e) {
                        System.out.println("Erro ao criar o arquivo: "
                                + e.getMessage());
                    }
                    break;

                    case 2:
                    try {
                        File arquivo = new File("arquivo.txt");

                        if (!arquivo.exists()) {
                            System.out.println("O arquivo não existe. "
                                    + "Crie o arquivo primeiro.");
                            break;
                        }

                        System.out.print("Digite o conteúdo que deseja escrever: ");
                        String texto = sc.nextLine();

                        FileWriter escritor = new FileWriter("arquivo.txt", true);
                        escritor.write(texto + "\n");
                        escritor.close();

                        System.out.println("Conteúdo escrito com sucesso!");

                    } catch (IOException e) {
                        System.out.println("Erro ao escrever: "
                                + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        File arquivo = new File("arquivo.txt");

                        if (!arquivo.exists()) {
                            System.out.println("O arquivo não existe.");
                            break;
                        }

                        BufferedReader leitor = new BufferedReader(
                                new FileReader("arquivo.txt"));

                        String linha;

                        System.out.println("\n===== CONTEÚDO DO ARQUIVO =====");

                        while ((linha = leitor.readLine()) != null) {
                            System.out.println(linha);
                        }

                        leitor.close();

                    } catch (IOException e) {
                        System.out.println("Erro ao ler: "
                                + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        File arquivo = new File("arquivo.txt");

                        if (!arquivo.exists()) {
                            System.out.println("O arquivo não existe.");
                            break;
                        }

                        System.out.print("Digite o novo conteúdo do arquivo: ");
                        String novoTexto = sc.nextLine();

                        FileWriter escritor = new FileWriter("arquivo.txt");
                        escritor.write(novoTexto + "\n");
                        escritor.close();

                        System.out.println("Arquivo alterado com sucesso!");

                    } catch (IOException e) {
                        System.out.println("Erro ao alterar: "
                                + e.getMessage());
                    }
                    break;

                case 5:
                    File arquivo = new File("arquivo.txt");

                    if (arquivo.exists()) {
                        if (arquivo.delete()) {
                            System.out.println("Arquivo removido com sucesso!");
                        } else {
                            System.out.println("Erro ao remover o arquivo.");
                        }
                    } else {
                        System.out.println("O arquivo não existe.");
                    }
                    break;

                case 6:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha uma opção de 1 a 6.");
            }

        } while (opcao != 6);

        sc.close();
    }
}
