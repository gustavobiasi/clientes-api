package br.com.clientes.handler.exceptions;

public class ClientesApiNotFoundException extends RuntimeException{

  public ClientesApiNotFoundException() {
  }

  public ClientesApiNotFoundException(String message) {
    super(message);
  }

  public ClientesApiNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public ClientesApiNotFoundException(Throwable cause) {
    super(cause);
  }

  public ClientesApiNotFoundException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
