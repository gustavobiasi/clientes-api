package br.com.clientes.controller;

import br.com.clientes.domain.dto.ClienteDTO;
import br.com.clientes.domain.model.Cliente;
import br.com.clientes.repository.ClienteRepository;
import br.com.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

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
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizarId(@Valid @RequestBody ClienteDTO clienteDTO,
                                               @PathVariable(name = "clienteId") Integer clienteId) {
        clienteService.atualizarId(clienteDTO, clienteId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
