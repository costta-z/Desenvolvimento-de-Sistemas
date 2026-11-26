const formLogin = document.getElementById("formLogin");
const mensagemLogin = document.getElementById("mensagem");

async function obterTokenCsrf() {
    const resposta = await fetch("/csrf", { credentials: "same-origin" });
    const dados = await resposta.json();
    return dados.token;
}

formLogin.addEventListener("submit", async (evento) => {
    evento.preventDefault();
    mensagemLogin.textContent = "";
    mensagemLogin.className = "mensagem";

    try {
        const token = await obterTokenCsrf();
        const dados = new URLSearchParams();
        dados.append("email", document.getElementById("email").value.trim());
        dados.append("senha", document.getElementById("senha").value);

        const resposta = await fetch("/login", {
            method: "POST",
            credentials: "same-origin",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
                "X-XSRF-TOKEN": token
            },
            body: dados
        });

        const retorno = await resposta.json();

        if (!resposta.ok) {
            throw new Error(retorno.mensagem || "Não foi possível realizar o login.");
        }

        window.location.href = "/index.html";
    } catch (erro) {
        mensagemLogin.textContent = erro.message;
        mensagemLogin.classList.add("erro");
    }
});
