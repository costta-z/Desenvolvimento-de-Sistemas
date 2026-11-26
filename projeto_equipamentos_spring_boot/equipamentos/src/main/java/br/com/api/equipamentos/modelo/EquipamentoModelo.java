package br.com.api.equipamentos.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "equipamentos")
public class EquipamentoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank(message = "O nome é obrigatório.")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "A marca é obrigatória.")
    @Column(nullable = false, length = 100)
    private String marca;

    @NotBlank(message = "O modelo é obrigatório.")
    @Column(nullable = false, length = 100)
    private String modelo;

    @NotBlank(message = "O status é obrigatório.")
    @Pattern(
        regexp = "Aguardando manutenção|Em manutenção|Manutenção concluída|Entregue ao cliente",
        message = "Selecione um status permitido."
    )
    @Column(nullable = false, length = 40)
    private String status;

    public EquipamentoModelo() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
