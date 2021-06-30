package br.com.zupacademy.isadora.casadocodigo.config.validacao;

import java.util.ArrayList;
import java.util.List;

public class ErroDeValidacaoDTO {
    private List<String> globalErrorMessages = new ArrayList<>();
    private List<ErroDeFormularioDTO> fieldErrors = new ArrayList<>();

    public void addError(String message){
        globalErrorMessages.add(message);
    }

    public void addFieldError(String field, String message){
        ErroDeFormularioDTO fieldError = new ErroDeFormularioDTO(field, message);
        fieldErrors.add(fieldError);
    }

    public List<String> getGlobalErrorMessages() {
        return globalErrorMessages;
    }

    public List<ErroDeFormularioDTO> getFieldErrors() {
        return fieldErrors;
    }
}
