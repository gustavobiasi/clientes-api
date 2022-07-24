package br.com.clientes.handler.exceptions;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> erros;

    public ApiErrors(List<String> errors) {
        this.erros = errors;
    }

    public ApiErrors(String messages) {
        this.erros = Arrays.asList(messages);
    }
}
