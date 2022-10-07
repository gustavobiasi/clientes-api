package br.com.clientes.handler;

import br.com.clientes.handler.exceptions.ClientesApiNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        final ApiErrors msg = new ApiErrors();
        msg.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        msg.setDetails(List.of(ex.getMessage()));
        return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ClientesApiNotFoundException.class)
    public ResponseEntity<?> handleClientesApiNotFoundException(ClientesApiNotFoundException ex) {
        final ApiErrors msg = new ApiErrors();
        msg.setCode(HttpStatus.NOT_FOUND.value());
        msg.setDetails(List.of(ex.getMessage()));
        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleFieldValidationException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> messages = bindingResult.getAllErrors().stream()
                  .map(erro -> erro.getDefaultMessage())
                  .collect(Collectors.toList());

        final ApiErrors msg = new ApiErrors();
        msg.setCode(HttpStatus.BAD_REQUEST.value());
        msg.setDetails(messages);
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }
}
