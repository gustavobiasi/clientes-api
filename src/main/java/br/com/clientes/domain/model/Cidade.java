package br.com.clientes.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cidade {

    private Integer id;
    private String cidade;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;
}
