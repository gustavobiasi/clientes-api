package br.com.clientes.domain.model;

import static br.com.clientes.messages.Descriptions.CLIENTE_CPF;
import static br.com.clientes.messages.Descriptions.CLIENTE_DATA_CADASTRO;
import static br.com.clientes.messages.Descriptions.CLIENTE_ID;
import static br.com.clientes.messages.Descriptions.CLIENTE_NOME;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Schema(description = CLIENTE_ID)
    private Integer id;
    @Schema(description = CLIENTE_NOME)
    private String nome;
    @Schema(description = CLIENTE_CPF)
    private String cpf;
    @Schema(description = CLIENTE_DATA_CADASTRO, example = "01/01/2022")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;
}
