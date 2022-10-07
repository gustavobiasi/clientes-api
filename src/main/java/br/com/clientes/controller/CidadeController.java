package br.com.clientes.controller;

import br.com.clientes.domain.dto.CidadeDTO;
import br.com.clientes.domain.model.Cidade;
import br.com.clientes.service.CidadeService;
import io.swagger.annotations.Api;
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
@Api(tags = "Cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidade> salvar(@Valid @RequestBody CidadeDTO cidadeDTO) {
        var resultado = cidadeService.salvar(cidadeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscarId(@PathVariable(name = "cidadeId") Integer cidadeId) {
        var resultado = cidadeService.buscarId(cidadeId);
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

    @DeleteMapping("/{cidadeId}")
    public ResponseEntity<Cidade> deletarId(@PathVariable(name = "cidadeId") Integer cidadeId) {
        cidadeService.deletarId(cidadeId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{cidadeId}")
    public ResponseEntity<Cidade> atualizarId(@Valid @RequestBody CidadeDTO cidadeDTO,
                                               @PathVariable(name = "cidadeId") Integer cidadeId) {
        cidadeService.atualizarId(cidadeDTO, cidadeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cidade>> listarCidades() {
        var lista = cidadeService.listarCidades();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

}
