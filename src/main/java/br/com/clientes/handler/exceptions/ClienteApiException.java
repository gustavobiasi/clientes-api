package br.com.clientes.handler.exceptions;

public class ClienteApiException extends  RuntimeException{

    public ClienteApiException(){
    }

    public ClienteApiException(String message) {
        super(message);
    }

    public ClienteApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClienteApiException(Throwable cause) {
        super(cause);
    }

    public ClienteApiException(String message, Throwable cause, boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
