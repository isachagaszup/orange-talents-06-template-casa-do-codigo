package br.com.zupacademy.isadora.casadocodigo.cliente;

import br.com.zupacademy.isadora.casadocodigo.localizacao.estado.Estado;
import br.com.zupacademy.isadora.casadocodigo.localizacao.estado.EstadoRepository;
import br.com.zupacademy.isadora.casadocodigo.localizacao.pais.Pais;
import br.com.zupacademy.isadora.casadocodigo.localizacao.pais.PaisRepository;
import br.com.zupacademy.isadora.casadocodigo.validador.anotacao.CpfCnpj;
import br.com.zupacademy.isadora.casadocodigo.validador.anotacao.ExistsId;
import br.com.zupacademy.isadora.casadocodigo.validador.anotacao.ValidState;
import br.com.zupacademy.isadora.casadocodigo.validador.anotacao.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ValidState(
        field = "paisId",
        joinField = "estadoId"
)
public class ClienteRequest {

    @NotBlank @Email @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @CpfCnpj
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;
    private Long estadoId;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Pais pais = paisRepository.getById(paisId);

        Estado estado = null;
        if (estadoId != null) {
            estado = estadoRepository.getById(estadoId);
        }

        return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento, this.cidade, pais, estado, this.telefone, this.cep);
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
