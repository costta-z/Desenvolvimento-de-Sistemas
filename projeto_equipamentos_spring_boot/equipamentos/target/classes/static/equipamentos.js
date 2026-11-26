const formEquipamento = document.getElementById("formEquipamento");
const tabelaEquipamentos = document.getElementById("tabelaEquipamentos");
const mensagemEquipamento = document.getElementById("mensagem");
const btnSalvar = document.getElementById("btnSalvar");
const btnCancelar = document.getElementById("btnCancelar");
const tituloFormulario = document.getElementById("tituloFormulario");

document.addEventListener("DOMContentLoaded", listarEquipamentos);

async function obterTokenCsrf() {
    const resposta = await fetch("/csrf", { credentials: "same-origin" });
    if (!resposta.ok) {
        throw new Error("Não foi possível obter o token de segurança.");
    }
    const dados = await resposta.json();
    return dados.token;
}

async function requisicaoProtegida(url, metodo, corpo) {
    const token = await obterTokenCsrf();
    const opcoes = {
        method: metodo,
        credentials: "same-origin",
        headers: { "X-XSRF-TOKEN": token }
    };

    if (corpo !== undefined) {
        opcoes.headers["Content-Type"] = "application/json";
        opcoes.body = JSON.stringify(corpo);
    }

    const resposta = await fetch(url, opcoes);

    if (resposta.status === 401 || resposta.status === 403) {
        window.location.href = "/login.html";
        throw new Error("Sessão encerrada. Faça login novamente.");
    }

    const texto = await resposta.text();
    let dados = {};
    if (texto) {
        try {
            dados = JSON.parse(texto);
        } catch {
            dados = { mensagem: texto };
        }
    }

    if (!resposta.ok) {
        throw new Error(dados.mensagem || "Ocorreu um erro na operação.");
    }

    return dados;
}

async function listarEquipamentos() {
    try {
        const resposta = await fetch("/listar", { credentials: "same-origin" });

        if (resposta.status === 401 || resposta.status === 403) {
            window.location.href = "/login.html";
            return;
        }

        if (!resposta.ok) {
            throw new Error("Não foi possível carregar os equipamentos.");
        }

        const equipamentos = await resposta.json();
        tabelaEquipamentos.innerHTML = "";

        if (equipamentos.length === 0) {
            tabelaEquipamentos.innerHTML =
                '<tr><td colspan="6" class="vazio">Nenhum equipamento cadastrado.</td></tr>';
            return;
        }

        equipamentos.forEach((equipamento) => {
            const linha = document.createElement("tr");
            adicionarCelula(linha, equipamento.codigo);
            adicionarCelula(linha, equipamento.nome);
            adicionarCelula(linha, equipamento.marca);
            adicionarCelula(linha, equipamento.modelo);
            adicionarCelula(linha, equipamento.status);

            const celulaAcoes = document.createElement("td");

            const selecionar = document.createElement("button");
            selecionar.textContent = "Selecionar";
            selecionar.className = "botao-selecionar";
            selecionar.addEventListener("click", () => selecionarEquipamento(equipamento));

            const remover = document.createElement("button");
            remover.textContent = "Remover";
            remover.className = "botao-remover";
            remover.addEventListener("click", () => removerEquipamento(equipamento.codigo));

            celulaAcoes.append(selecionar, remover);
            linha.appendChild(celulaAcoes);
            tabelaEquipamentos.appendChild(linha);
        });
    } catch (erro) {
        mostrarMensagem(erro.message, "erro");
    }
}

function adicionarCelula(linha, valor) {
    const celula = document.createElement("td");
    celula.textContent = valor ?? "";
    linha.appendChild(celula);
}

function selecionarEquipamento(equipamento) {
    document.getElementById("codigo").value = equipamento.codigo;
    document.getElementById("nome").value = equipamento.nome;
    document.getElementById("marca").value = equipamento.marca;
    document.getElementById("modelo").value = equipamento.modelo;
    document.getElementById("status").value = equipamento.status;

    tituloFormulario.textContent = "Alterar equipamento";
    btnSalvar.textContent = "Alterar";
    btnCancelar.hidden = false;
    window.scrollTo({ top: 0, behavior: "smooth" });
}

formEquipamento.addEventListener("submit", async (evento) => {
    evento.preventDefault();

    const codigo = document.getElementById("codigo").value;
    const equipamento = {
        nome: document.getElementById("nome").value.trim(),
        marca: document.getElementById("marca").value.trim(),
        modelo: document.getElementById("modelo").value.trim(),
        status: document.getElementById("status").value
    };

    if (!equipamento.nome || !equipamento.marca || !equipamento.modelo || !equipamento.status) {
        mostrarMensagem("Preencha todos os campos.", "erro");
        return;
    }

    try {
        if (codigo) {
            equipamento.codigo = Number(codigo);
            await requisicaoProtegida("/alterar", "PUT", equipamento);
            mostrarMensagem("Equipamento alterado com sucesso!", "sucesso");
        } else {
            await requisicaoProtegida("/cadastrar", "POST", equipamento);
            mostrarMensagem("Equipamento cadastrado com sucesso!", "sucesso");
        }

        limparFormulario();
        await listarEquipamentos();
    } catch (erro) {
        mostrarMensagem(erro.message, "erro");
    }
});

async function removerEquipamento(codigo) {
    if (!confirm("Tem certeza de que deseja remover este equipamento?")) {
        return;
    }

    try {
        const retorno = await requisicaoProtegida("/remover/" + codigo, "DELETE");
        mostrarMensagem(retorno.mensagem || "Equipamento removido com sucesso!", "sucesso");
        limparFormulario();
        await listarEquipamentos();
    } catch (erro) {
        mostrarMensagem(erro.message, "erro");
    }
}

function limparFormulario() {
    formEquipamento.reset();
    document.getElementById("codigo").value = "";
    tituloFormulario.textContent = "Cadastrar equipamento";
    btnSalvar.textContent = "Cadastrar";
    btnCancelar.hidden = true;
}

btnCancelar.addEventListener("click", () => {
    limparFormulario();
    mostrarMensagem("", "");
});

document.getElementById("btnAtualizar").addEventListener("click", listarEquipamentos);

document.getElementById("btnSair").addEventListener("click", async () => {
    try {
        const retorno = await requisicaoProtegida("/logout", "POST");
        mostrarMensagem(retorno.mensagem || "Logout realizado.", "sucesso");
        window.location.href = "/login.html";
    } catch (erro) {
        window.location.href = "/login.html";
    }
});

function mostrarMensagem(texto, tipo) {
    mensagemEquipamento.textContent = texto;
    mensagemEquipamento.className = "mensagem";
    if (tipo) {
        mensagemEquipamento.classList.add(tipo);
    }
}
