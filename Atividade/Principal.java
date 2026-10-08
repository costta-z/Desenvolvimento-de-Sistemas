package Atividade;

import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        ArrayList<Carro> carros = new ArrayList<>();

        int opcao;

        do {

            String menu = """
                    ===== SISTEMA DE CADASTRO DE CARROS =====
                    
                    1 - Cadastrar Carro
                    2 - Listar Carros
                    3 - Detalhar Carro
                    4 - Alterar Carro
                    5 - Remover Carro
                    6 - Gravar Informações em Arquivo
                    7 - Sair
                    
                    Escolha uma opção:
                    """;

            try {
                opcao = Integer.parseInt(
                        JOptionPane.showInputDialog(null, menu)
                );
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Digite uma opção válida."
                );
                opcao = 0;
            }

            switch (opcao) {

                case 1:

                    String marca = JOptionPane.showInputDialog(
                            null,
                            "Digite a marca do carro:"
                    );

                    if (marca == null) {
                        break;
                    }

                    String modelo = JOptionPane.showInputDialog(
                            null,
                            "Digite o modelo do carro:"
                    );

                    if (modelo == null) {
                        break;
                    }

                    int ano;

                    try {
                        ano = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        null,
                                        "Digite o ano do carro:"
                                )
                        );
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Ano inválido."
                        );
                        break;
                    }

                    Carro novoCarro = new Carro(marca, modelo, ano);

                    carros.add(novoCarro);

                    JOptionPane.showMessageDialog(
                            null,
                            "Carro cadastrado com sucesso!"
                    );

                    break;

                case 2:

                    if (carros.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Nenhum carro cadastrado."
                        );

                    } else {

                        String lista = "===== CARROS CADASTRADOS =====\n\n";

                        for (int i = 0; i < carros.size(); i++) {

                            Carro carro = carros.get(i);

                            lista += "Número: " + (i + 1) + "\n";
                            lista += "Marca: " + carro.getMarca() + "\n";
                            lista += "Modelo: " + carro.getModelo() + "\n";
                            lista += "-----------------------------\n";
                        }

                        JOptionPane.showMessageDialog(
                                null,
                                lista
                        );
                    }

                    break;

                case 3:

                    if (carros.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Nenhum carro cadastrado."
                        );

                        break;
                    }

                    try {

                        int numero = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        null,
                                        "Digite o número do carro:"
                                )
                        );

                        if (numero < 1 || numero > carros.size()) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Número de carro inválido."
                            );

                            break;
                        }

                        Carro carro = carros.get(numero - 1);

                        JOptionPane.showMessageDialog(
                                null,
                                "===== DETALHES DO CARRO =====\n\n"
                                + carro.mostrarDados()
                        );

                    } catch (NumberFormatException e) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Digite um número válido."
                        );
                    }

                    break;

                case 4:

                    if (carros.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Nenhum carro cadastrado."
                        );

                        break;
                    }

                    try {

                        int numero = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        null,
                                        "Digite o número do carro que deseja alterar:"
                                )
                        );

                        if (numero < 1 || numero > carros.size()) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Número de carro inválido."
                            );

                            break;
                        }

                        String novaMarca = JOptionPane.showInputDialog(
                                null,
                                "Digite a nova marca:"
                        );

                        if (novaMarca == null) {
                            break;
                        }

                        String novoModelo = JOptionPane.showInputDialog(
                                null,
                                "Digite o novo modelo:"
                        );

                        if (novoModelo == null) {
                            break;
                        }

                        int novoAno = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        null,
                                        "Digite o novo ano:"
                                )
                        );

                        Carro carroAtualizado = new Carro(
                                novaMarca,
                                novoModelo,
                                novoAno
                        );

                        carros.set(numero - 1, carroAtualizado);

                        JOptionPane.showMessageDialog(
                                null,
                                "Carro alterado com sucesso!"
                        );

                    } catch (NumberFormatException e) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Digite valores válidos."
                        );
                    }

                    break;

                case 5:

                    if (carros.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Nenhum carro cadastrado."
                        );

                        break;
                    }

                    try {

                        int numero = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        null,
                                        "Digite o número do carro que deseja remover:"
                                )
                        );

                        if (numero < 1 || numero > carros.size()) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Número de carro inválido."
                            );

                            break;
                        }

                        carros.remove(numero - 1);

                        JOptionPane.showMessageDialog(
                                null,
                                "Carro removido com sucesso!"
                        );

                    } catch (NumberFormatException e) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Digite um número válido."
                        );
                    }

                    break;

                case 6:

                    if (carros.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Nenhum carro cadastrado para gravar."
                        );

                        break;
                    }

                    try {

                        FileWriter arquivo = new FileWriter("carros.txt");

                        for (Carro carro : carros) {

                            arquivo.write("Marca: " + carro.getMarca() + "\n");
                            arquivo.write("Modelo: " + carro.getModelo() + "\n");
                            arquivo.write("Ano: " + carro.getAno() + "\n");
                            arquivo.write("-----------------------------\n");
                        }

                        arquivo.close();

                        JOptionPane.showMessageDialog(
                                null,
                                "Informações gravadas com sucesso no arquivo carros.txt!"
                        );

                    } catch (IOException e) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Erro ao gravar o arquivo."
                        );
                    }

                    break;

                case 7:

                    JOptionPane.showMessageDialog(
                            null,
                            "Sistema encerrado."
                    );

                    break;

                default:

                    JOptionPane.showMessageDialog(
                            null,
                            "Opção inválida!"
                    );
            }

        } while (opcao != 7);
    }
}