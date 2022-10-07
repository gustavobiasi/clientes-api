package br.com.clientes.controller;

import br.com.clientes.domain.dto.CidadeDTO;
import br.com.clientes.domain.model.Cidade;
import br.com.clientes.service.CidadeService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidade> salvar(@Valid @RequestBody CidadeDTO cidadeDTO) {
        var resultado = cidadeService.salvar(cidadeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }


}
