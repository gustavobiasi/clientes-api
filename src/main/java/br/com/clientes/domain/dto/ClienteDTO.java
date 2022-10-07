package br.com.clientes.domain.dto;

import static br.com.clientes.messages.Errors.CPF_INVALIDO;
import static br.com.clientes.messages.Errors.REQUIRED_CPF;
import static br.com.clientes.messages.Errors.REQUIRED_NOME;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    @NotBlank(message = REQUIRED_NOME)
    private String nome;

    @NotNull(message = REQUIRED_CPF)
    @CPF(message = CPF_INVALIDO)
    private String cpf;
}
