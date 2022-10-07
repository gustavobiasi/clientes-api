package br.com.clientes.controller;

import br.com.clientes.domain.dto.ClienteDTO;
import br.com.clientes.domain.model.Cliente;
import br.com.clientes.service.ClienteService;
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
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@Valid @RequestBody ClienteDTO clienteDTO) {
        var resultado = clienteService.salvar(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscarId(@PathVariable(name = "clienteId") Integer clienteId) {
        var resultado = clienteService.buscarId(clienteId);
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Cliente> deletarId(@PathVariable(name = "clienteId") Integer clienteId) {
        clienteService.deletarId(clienteId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizarId(@Valid @RequestBody ClienteDTO clienteDTO,
                                               @PathVariable(name = "clienteId") Integer clienteId) {
        clienteService.atualizarId(clienteDTO, clienteId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarClientes() {
        var lista = clienteService.listarClientes();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
}
