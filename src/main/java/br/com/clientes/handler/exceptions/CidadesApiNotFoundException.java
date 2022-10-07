package br.com.clientes.handler.exceptions;

public class CidadesApiNotFoundException extends  RuntimeException{

    public CidadesApiNotFoundException(){
    }

    public CidadesApiNotFoundException(String message) {
        super(message);
    }

    public CidadesApiNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CidadesApiNotFoundException(Throwable cause) {
        super(cause);
    }

    public CidadesApiNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
