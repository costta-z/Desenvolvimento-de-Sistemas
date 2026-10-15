
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Laboratorio {

    public static void main(String[] args) {

        File pasta = new File("LABORATORIO");

        if (!pasta.isDirectory()) {
            JOptionPane.showMessageDialog(null, "A pasta LABORATORIO não existe.");
            return;
        }

        int opcao = 0;
        String nome;

        do {

            String menu = """
                    GERENCIADOR DE ARQUIVOS

                    1 - Criar arquivo
                    2 - Escrever no arquivo
                    3 - Ler arquivo
                    4 - Renomear arquivo
                    5 - Excluir arquivo
                    6 - Mostrar informações
                    7 - Somente leitura
                    8 - Sair

                    Escolha uma opção:
                    """;

            String escolha = JOptionPane.showInputDialog(menu);

            if (escolha == null) {
                continue;
            }

            try {
                opcao = Integer.parseInt(escolha);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite uma opção válida.");
                continue;
            }

            switch (opcao) {

                case 1:

                    nome = JOptionPane.showInputDialog("Digite o nome do arquivo:");

                    if (nome == null) {
                        break;
                    }

                    nome = nome.trim();

                    if (nome.isEmpty() || nome.contains("/") || nome.contains("\\")
                            || nome.equals(".") || nome.equals("..")) {
                        JOptionPane.showMessageDialog(null, "Nome inválido.");
                        break;
                    }

                    try {
                        File arquivo = new File(pasta, nome);

                        if (arquivo.createNewFile()) {
                            JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Arquivo já existe.");
                        }

                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao criar arquivo.");
                    }

                    break;

                case 2:

                    nome = JOptionPane.showInputDialog("Digite o nome do arquivo:");

                    if (nome == null) {
                        break;
                    }

                    nome = nome.trim();

                    if (nome.isEmpty() || nome.contains("/") || nome.contains("\\")
                            || nome.equals(".") || nome.equals("..")) {
                        JOptionPane.showMessageDialog(null, "Nome inválido.");
                        break;
                    }

                    File arquivoEscrever = new File(pasta, nome);

                    if (!arquivoEscrever.isFile()) {
                        JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
                        break;
                    }

                    if (!arquivoEscrever.canWrite()) {
                        JOptionPane.showMessageDialog(null, "Arquivo sem permissão de gravação.");
                        break;
                    }

                    String texto = JOptionPane.showInputDialog("Digite o conteúdo:");

                    if (texto == null) {
                        break;
                    }

                    try (FileWriter writer = new FileWriter(arquivoEscrever)) {
                        writer.write(texto);

                        JOptionPane.showMessageDialog(null, "Conteúdo escrito com sucesso!");

                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo.");
                    }

                    break;

                case 3:

                    nome = JOptionPane.showInputDialog("Digite o nome do arquivo:");

                    if (nome == null) {
                        break;
                    }

                    nome = nome.trim();

                    if (nome.isEmpty() || nome.contains("/") || nome.contains("\\")
                            || nome.equals(".") || nome.equals("..")) {
                        JOptionPane.showMessageDialog(null, "Nome inválido.");
                        break;
                    }

                    File arquivoLer = new File(pasta, nome);

                    if (!arquivoLer.isFile()) {
                        JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
                        break;
                    }

                    try (BufferedReader reader = new BufferedReader(new FileReader(arquivoLer))) {

                        String linha;
                        StringBuilder conteudo = new StringBuilder();

                        while ((linha = reader.readLine()) != null) {
                            conteudo.append(linha).append("\n");
                        }

                        JOptionPane.showMessageDialog(null,
                                conteudo.isEmpty() ? "Arquivo vazio." : conteudo.toString());

                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao ler arquivo.");
                    }

                    break;

                case 4:

                    nome = JOptionPane.showInputDialog("Digite o nome atual do arquivo:");

                    if (nome == null) {
                        break;
                    }

                    nome = nome.trim();

                    if (nome.isEmpty() || nome.contains("/") || nome.contains("\\")
                            || nome.equals(".") || nome.equals("..")) {
                        JOptionPane.showMessageDialog(null, "Nome inválido.");
                        break;
                    }

                    File arquivoAtual = new File(pasta, nome);

                    if (!arquivoAtual.isFile()) {
                        JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
                        break;
                    }

                    String novoNome = JOptionPane.showInputDialog("Digite o novo nome:");

                    if (novoNome == null) {
                        break;
                    }

                    novoNome = novoNome.trim();

                    if (novoNome.isEmpty() || novoNome.contains("/") || novoNome.contains("\\")
                            || novoNome.equals(".") || novoNome.equals("..")) {
                        JOptionPane.showMessageDialog(null, "Nome inválido.");
                        break;
                    }

                    File arquivoNovo = new File(pasta, novoNome);

                    if (arquivoNovo.exists()) {
                        JOptionPane.showMessageDialog(null, "Esse nome já existe.");
                    } else if (arquivoAtual.renameTo(arquivoNovo)) {
                        JOptionPane.showMessageDialog(null, "Arquivo renomeado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao renomear arquivo.");
                    }

                    break;

                case 5:

                    nome = JOptionPane.showInputDialog("Digite o nome do arquivo:");

                    if (nome == null) {
                        break;
                    }

                    nome = nome.trim();

                    if (nome.isEmpty() || nome.contains("/") || nome.contains("\\")
                            || nome.equals(".") || nome.equals("..")) {
                        JOptionPane.showMessageDialog(null, "Nome inválido.");
                        break;
                    }

                    File arquivoExcluir = new File(pasta, nome);

                    if (!arquivoExcluir.isFile()) {
                        JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
                        break;
                    }

                    int confirmar = JOptionPane.showConfirmDialog(
                            null,
                            "Deseja excluir o arquivo?",
                            "Confirmação",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (confirmar == JOptionPane.YES_OPTION) {

                        if (arquivoExcluir.delete()) {
                            JOptionPane.showMessageDialog(null, "Arquivo excluído com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao excluir arquivo.");
                        }
                    }

                    break;

                case 6:

                    nome = JOptionPane.showInputDialog("Digite o nome do arquivo:");

                    if (nome == null) {
                        break;
                    }

                    nome = nome.trim();

                    if (nome.isEmpty() || nome.contains("/") || nome.contains("\\")
                            || nome.equals(".") || nome.equals("..")) {
                        JOptionPane.showMessageDialog(null, "Nome inválido.");
                        break;
                    }

                    File arquivoInfo = new File(pasta, nome);

                    if (!arquivoInfo.isFile()) {
                        JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
                        break;
                    }

                    String extensao = "";

                    int ponto = nome.lastIndexOf(".");

                    if (ponto > 0) {
                        extensao = nome.substring(ponto + 1);
                    }

                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                    String data = formato.format(new Date(arquivoInfo.lastModified()));

                    String informacoes = "Nome: " + arquivoInfo.getName()
                            + "\nExtensão: " + extensao
                            + "\nTamanho: " + arquivoInfo.length() + " bytes"
                            + "\nCaminho: " + arquivoInfo.getAbsolutePath()
                            + "\nLeitura: " + arquivoInfo.canRead()
                            + "\nGravação: " + arquivoInfo.canWrite()
                            + "\nExecução: " + arquivoInfo.canExecute()
                            + "\nÚltima modificação: " + data;

                    JOptionPane.showMessageDialog(null, informacoes);

                    break;

                case 7:

                    nome = JOptionPane.showInputDialog("Digite o nome do arquivo:");

                    if (nome == null) {
                        break;
                    }

                    nome = nome.trim();

                    if (nome.isEmpty() || nome.contains("/") || nome.contains("\\")
                            || nome.equals(".") || nome.equals("..")) {
                        JOptionPane.showMessageDialog(null, "Nome inválido.");
                        break;
                    }

                    File arquivoProtegido = new File(pasta, nome);

                    if (!arquivoProtegido.isFile()) {
                        JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
                        break;
                    }

                    if (arquivoProtegido.setReadOnly()) {
                        JOptionPane.showMessageDialog(null, "Arquivo definido como somente leitura!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível proteger o arquivo.");
                    }

                    break;

                case 8:

                    JOptionPane.showMessageDialog(null, "Sistema encerrado!");

                    break;

                default:

                    JOptionPane.showMessageDialog(null, "Opção inválida.");

            }

        } while (opcao != 8);

    }
}
