package view;

import controle.UsuarioControle;
import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton botaoEntrar;

    private UsuarioControle controle;

    public LoginView() {

        controle = new UsuarioControle();

        setTitle("Sistema de Cadastro de Produtos");
        setSize(350, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel titulo = new JLabel(
                "LOGIN DO SISTEMA",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        campoUsuario = new JTextField();
        campoSenha = new JPasswordField();

        botaoEntrar = new JButton("Entrar");

        JPanel painelCampos = new JPanel(
                new GridLayout(2, 2, 10, 10)
        );

        painelCampos.add(new JLabel("Usuário:"));
        painelCampos.add(campoUsuario);

        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(campoSenha);

        JPanel painel = new JPanel(new BorderLayout(10, 15));

        painel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        painel.add(titulo, BorderLayout.NORTH);
        painel.add(painelCampos, BorderLayout.CENTER);
        painel.add(botaoEntrar, BorderLayout.SOUTH);

        add(painel);

        botaoEntrar.addActionListener(e -> entrar());

        campoSenha.addActionListener(e -> entrar());
    }

    private void entrar() {

        String usuario = campoUsuario.getText();

        String senha = new String(
                campoSenha.getPassword()
        );

        if (controle.validarLogin(usuario, senha)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login realizado com sucesso!"
            );

            dispose();

            ProdutoView tela = new ProdutoView();

            tela.setVisible(true);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Usuário ou senha incorretos!",
                    "Erro de Login",
                    JOptionPane.ERROR_MESSAGE
            );

            campoSenha.setText("");

            campoSenha.requestFocus();
        }
    }
}