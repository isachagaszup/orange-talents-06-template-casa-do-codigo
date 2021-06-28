package br.com.zupacademy.isadora.casadocodigo.config.validacao;

public class ErroDeFormulario {

    private String campo;
    private String erro;

    public ErroDeFormulario(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }

}
