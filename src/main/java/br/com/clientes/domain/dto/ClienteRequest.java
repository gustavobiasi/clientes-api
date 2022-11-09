package br.com.clientes.domain.dto;

import static br.com.clientes.messages.Descriptions.CLIENTE_CPF;
import static br.com.clientes.messages.Descriptions.CLIENTE_NOME;
import static br.com.clientes.messages.Errors.CPF_INVALIDO;
import static br.com.clientes.messages.Errors.REQUIRED_CPF;
import static br.com.clientes.messages.Errors.REQUIRED_NOME;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class ClienteRequest {

    @Schema(description = CLIENTE_NOME)
    @NotBlank(message = REQUIRED_NOME)
    private String nome;
    @Schema(description = CLIENTE_CPF)
    @NotNull(message = REQUIRED_CPF)
    @CPF(message = CPF_INVALIDO)
    private String cpf;
    private String endereco;
}
