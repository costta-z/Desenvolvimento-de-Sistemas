const formCadastro = document.getElementById("formCadastro");
const mensagemCadastro = document.getElementById("mensagem");

async function obterTokenCsrf() {
    const resposta = await fetch("/csrf", { credentials: "same-origin" });
    const dados = await resposta.json();
    return dados.token;
}

formCadastro.addEventListener("submit", async (evento) => {
    evento.preventDefault();
    mensagemCadastro.textContent = "";
    mensagemCadastro.className = "mensagem";

    const senha = document.getElementById("senha").value;
    const confirmarSenha = document.getElementById("confirmarSenha").value;

    if (senha.length < 8) {
        mostrarMensagem("A senha deve ter pelo menos 8 caracteres.", "erro");
        return;
    }

    if (senha !== confirmarSenha) {
        mostrarMensagem("As senhas não conferem.", "erro");
        return;
    }

    try {
        const token = await obterTokenCsrf();
        const usuario = {
            nome: document.getElementById("nome").value.trim(),
            email: document.getElementById("email").value.trim(),
            senha: senha
        };

        const resposta = await fetch("/usuarios/cadastrar", {
            method: "POST",
            credentials: "same-origin",
            headers: {
                "Content-Type": "application/json",
                "X-XSRF-TOKEN": token
            },
            body: JSON.stringify(usuario)
        });

        const retorno = await resposta.json();

        if (!resposta.ok) {
            throw new Error(retorno.mensagem || "Erro ao cadastrar usuário.");
        }

        mostrarMensagem(retorno.mensagem + " Redirecionando para o login...", "sucesso");
        formCadastro.reset();
        setTimeout(() => window.location.href = "/login.html", 1400);
    } catch (erro) {
        mostrarMensagem(erro.message, "erro");
    }
});

function mostrarMensagem(texto, tipo) {
    mensagemCadastro.textContent = texto;
    mensagemCadastro.className = "mensagem " + tipo;
}
