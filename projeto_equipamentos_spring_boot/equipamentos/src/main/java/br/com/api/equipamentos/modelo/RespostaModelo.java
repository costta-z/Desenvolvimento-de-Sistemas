package br.com.api.equipamentos.modelo;

public class RespostaModelo {

    private String mensagem;
    private boolean sucesso;

    public RespostaModelo() {
    }

    public RespostaModelo(String mensagem, boolean sucesso) {
        this.mensagem = mensagem;
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }
}
