package view;

import controle.ProdutoControle;
import modelo.Produto;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProdutoView extends JFrame {

    private JTextField campoCodigo;
    private JTextField campoNome;
    private JTextField campoCategoria;
    private JTextField campoPreco;
    private JTextField campoQuantidade;
    private JTextField campoPesquisa;

    private JTable tabela;

    private DefaultTableModel modeloTabela;

    private ProdutoControle controle;

    public ProdutoView() {

        controle = new ProdutoControle();

        setTitle("Sistema de Cadastro de Produtos");

        setSize(850, 550);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        criarInterface();

        carregarTabela(controle.listar());
    }

    private void criarInterface() {

        campoCodigo = new JTextField();
        campoNome = new JTextField();
        campoCategoria = new JTextField();
        campoPreco = new JTextField();
        campoQuantidade = new JTextField();
        campoPesquisa = new JTextField();

        JPanel painelCampos = new JPanel(
                new GridLayout(5, 2, 8, 8)
        );

        painelCampos.setBorder(
                BorderFactory.createTitledBorder("Dados do Produto")
        );

        painelCampos.add(new JLabel("Código:"));
        painelCampos.add(campoCodigo);

        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(campoNome);

        painelCampos.add(new JLabel("Categoria:"));
        painelCampos.add(campoCategoria);

        painelCampos.add(new JLabel("Preço:"));
        painelCampos.add(campoPreco);

        painelCampos.add(new JLabel("Quantidade em estoque:"));
        painelCampos.add(campoQuantidade);

        JButton botaoCadastrar = new JButton("Cadastrar");

        JButton botaoAlterar = new JButton("Alterar");

        JButton botaoRemover = new JButton("Remover");

        JButton botaoLimpar = new JButton("Limpar");

        JPanel painelBotoes = new JPanel();

        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoAlterar);
        painelBotoes.add(botaoRemover);
        painelBotoes.add(botaoLimpar);

        JPanel painelSuperior = new JPanel(
                new BorderLayout(8, 8)
        );

        painelSuperior.add(
                painelCampos,
                BorderLayout.CENTER
        );

        painelSuperior.add(
                painelBotoes,
                BorderLayout.SOUTH
        );

        modeloTabela = new DefaultTableModel(
                new Object[]{
                    "Código",
                    "Nome",
                    "Categoria",
                    "Preço",
                    "Quantidade"
                },
                0
        ) {

            @Override
            public boolean isCellEditable(int linha, int coluna) {

                return false;
            }
        };

        tabela = new JTable(modeloTabela);

        tabela.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        JScrollPane rolagem = new JScrollPane(tabela);

        JPanel painelPesquisa = new JPanel(
                new BorderLayout(8, 8)
        );

        painelPesquisa.setBorder(
                BorderFactory.createTitledBorder(
                        "Pesquisar produto por código ou nome"
                )
        );

        JButton botaoPesquisar = new JButton("Pesquisar");

        JButton botaoListar = new JButton("Listar todos");

        JPanel botoesPesquisa = new JPanel();

        botoesPesquisa.add(botaoPesquisar);
        botoesPesquisa.add(botaoListar);

        painelPesquisa.add(
                campoPesquisa,
                BorderLayout.CENTER
        );

        painelPesquisa.add(
                botoesPesquisa,
                BorderLayout.EAST
        );

        setLayout(new BorderLayout(10, 10));

        add(painelSuperior, BorderLayout.NORTH);

        add(rolagem, BorderLayout.CENTER);

        add(painelPesquisa, BorderLayout.SOUTH);

        // Ação do botão cadastrar

        botaoCadastrar.addActionListener(e -> cadastrar());

        // Ação do botão alterar

        botaoAlterar.addActionListener(e -> alterar());

        // Ação do botão remover

        botaoRemover.addActionListener(e -> remover());

        // Ação do botão limpar

        botaoLimpar.addActionListener(e -> limparCampos());

        // Ação do botão pesquisar

        botaoPesquisar.addActionListener(e -> pesquisar());

        // Ação do botão listar

        botaoListar.addActionListener(e -> {

            campoPesquisa.setText("");

            carregarTabela(controle.listar());
        });

        // Selecionar produto na tabela

        tabela.getSelectionModel().addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting()
                    && tabela.getSelectedRow() != -1) {

                preencherCampos();
            }
        });
    }

    // Cadastrar produto

    private void cadastrar() {

        try {

            int codigo = Integer.parseInt(
                    campoCodigo.getText().trim()
            );

            String nome = campoNome.getText().trim();

            String categoria = campoCategoria.getText().trim();

            double preco = lerPreco();

            int quantidade = Integer.parseInt(
                    campoQuantidade.getText().trim()
            );

            if (controle.cadastrar(
                    codigo, nome, categoria, preco, quantidade
            )) {

                JOptionPane.showMessageDialog(
                        this,
                        "Produto cadastrado com sucesso!"
                );

                carregarTabela(controle.listar());

                limparCampos();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Não foi possível cadastrar o produto. Verifique os dados ou se o código já existe."
                );
            }

        } catch (NumberFormatException e) {

            mostrarErroNumerico();
        }
    }

    // Alterar produto

    private void alterar() {

        try {

            int codigo = Integer.parseInt(
                    campoCodigo.getText().trim()
            );

            String nome = campoNome.getText().trim();

            String categoria = campoCategoria.getText().trim();

            double preco = lerPreco();

            int quantidade = Integer.parseInt(
                    campoQuantidade.getText().trim()
            );

            if (controle.alterar(
                    codigo, nome, categoria, preco, quantidade
            )) {

                JOptionPane.showMessageDialog(
                        this,
                        "Produto alterado com sucesso!"
                );

                carregarTabela(controle.listar());

                limparCampos();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Produto não encontrado ou dados inválidos!"
                );
            }

        } catch (NumberFormatException e) {

            mostrarErroNumerico();
        }
    }

    // Remover produto

    private void remover() {

        try {

            int codigo = Integer.parseInt(
                    campoCodigo.getText().trim()
            );

            int opcao = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja realmente remover este produto?",
                    "Confirmar remoção",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcao == JOptionPane.YES_OPTION) {

                if (controle.remover(codigo)) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Produto removido com sucesso!"
                    );

                    carregarTabela(controle.listar());

                    limparCampos();

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Produto não encontrado!"
                    );
                }
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Informe um código válido!"
            );
        }
    }

    // Pesquisar produto

    private void pesquisar() {

        String nome = campoPesquisa.getText().trim();

        if (nome.isEmpty()) {

            carregarTabela(controle.listar());

        } else {

            ArrayList<Produto> encontrados =
                    controle.pesquisar(nome);

            carregarTabela(encontrados);

            if (encontrados.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Nenhum produto encontrado!"
                );
            }
        }
    }

    // Carregar tabela

    private void carregarTabela(ArrayList<Produto> produtos) {

        modeloTabela.setRowCount(0);

        for (Produto produto : produtos) {

            modeloTabela.addRow(new Object[]{
                produto.getCodigo(),
                produto.getNome(),
                produto.getCategoria(),
                String.format("R$ %.2f", produto.getPreco()),
                produto.getQuantidade()
            });
        }
    }

    // Preencher campos ao selecionar um produto

    private void preencherCampos() {

        int linha = tabela.getSelectedRow();

        if (linha >= 0) {

            campoCodigo.setText(
                    modeloTabela.getValueAt(linha, 0).toString()
            );

            campoNome.setText(
                    modeloTabela.getValueAt(linha, 1).toString()
            );

            campoCategoria.setText(
                    modeloTabela.getValueAt(linha, 2).toString()
            );

            campoPreco.setText(
                    modeloTabela.getValueAt(linha, 3)
                            .toString()
                            .replace("R$", "")
                            .trim()
                            .replace(",", ".")
            );

            campoQuantidade.setText(
                    modeloTabela.getValueAt(linha, 4).toString()
            );
        }
    }

    // Converter preço

    private double lerPreco() {

        return Double.parseDouble(
                campoPreco.getText().trim().replace(",", ".")
        );
    }

    // Limpar campos

    private void limparCampos() {

        campoCodigo.setText("");

        campoNome.setText("");

        campoCategoria.setText("");

        campoPreco.setText("");

        campoQuantidade.setText("");

        tabela.clearSelection();

        campoCodigo.requestFocus();
    }

    // Mensagem de erro numérico

    private void mostrarErroNumerico() {

        JOptionPane.showMessageDialog(
                this,
                "Informe valores numéricos válidos para código, preço e quantidade.",
                "Erro",
                JOptionPane.ERROR_MESSAGE
        );
    }
}