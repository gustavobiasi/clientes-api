package br.com.clientes.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import static br.com.clientes.messages.Errors.REQUIRED_CIDADE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CidadeDTO {

    @NotBlank(message = REQUIRED_CIDADE)
    private String cidade;

}
