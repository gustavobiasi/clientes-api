package br.com.clientes.controller;

import static br.com.clientes.messages.Descriptions.CLIENTE_ID;

import br.com.clientes.domain.dto.ClienteDTO;
import br.com.clientes.domain.model.Cliente;
import br.com.clientes.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Parameter;
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
@Api(tags = "Cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ApiOperation(value = "Salver Cliente", response = Cliente.class)
    @ApiResponse(code = 201, message = "Sucesso", response = Cliente.class)
    public ResponseEntity<Cliente> salvar(@Valid @RequestBody ClienteDTO clienteDTO) {
        var resultado = clienteService.salvar(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @GetMapping("/{clienteId}")
    @ApiOperation(value = "Obtem Cliente por ID", response = Cliente.class)
    @ApiResponse(code = 200, message = "Sucesso", response = Cliente.class)
    public ResponseEntity<Cliente> buscarId(
        @Parameter(description = CLIENTE_ID)
        @PathVariable(name = "clienteId") Integer clienteId) {
        var resultado = clienteService.buscarId(clienteId);
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

    @DeleteMapping("/{clienteId}")
    @ApiOperation(value = "Deletar Cliente")
    @ApiResponse(code = 200, message = "Sucesso")
    public ResponseEntity<?> deletarId(
        @Parameter(description = CLIENTE_ID)
        @PathVariable(name = "clienteId") Integer clienteId) {
        clienteService.deletarId(clienteId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{clienteId}")
    @ApiOperation(value = "Atualizar Cliente")
    @ApiResponse(code = 204, message = "Sucesso")
    public ResponseEntity<?> atualizarId(
        @Valid @RequestBody ClienteDTO clienteDTO,
        @Parameter(description = CLIENTE_ID)
        @PathVariable(name = "clienteId") Integer clienteId) {
        clienteService.atualizarId(clienteDTO, clienteId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/listar")
    @ApiOperation(value = "Listar Clientes")
    @ApiResponse(code = 200, message = "Sucesso", response = Cliente.class)
    public ResponseEntity<List<Cliente>> listarClientes() {
        var lista = clienteService.listarClientes();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
}
