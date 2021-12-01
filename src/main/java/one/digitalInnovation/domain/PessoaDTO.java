package one.digitalInnovation.domain;

import javax.validation.constraints.NotNull;

public class PessoaDTO {

    private Long id;

    @NotNull(message = "Um nome deve ser informado")
    private String nome;

    @NotNull(message = "Um endereÃ§o deve ser informado")
    private String endereco;

    @NotNull(message = "Um hobbie deve ser informado")
    private String hobbies;

    public PessoaDTO() {}

    public PessoaDTO(String nome, String endereco, String hobbies) {
        this.nome = nome;
        this.endereco = endereco;
        this.hobbies = hobbies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}

