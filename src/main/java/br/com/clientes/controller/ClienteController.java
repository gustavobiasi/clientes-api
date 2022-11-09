package br.com.clientes.controller;

import br.com.clientes.domain.dto.ClienteDTO;
import br.com.clientes.domain.dto.ClienteRequest;
import br.com.clientes.domain.model.ClienteResponse;
import br.com.clientes.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static br.com.clientes.messages.Descriptions.CLIENTE_ID;

@RestController
@RequestMapping("/api/cliente")
@Api(tags = "Cliente")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @PostMapping
  @ApiOperation(value = "Salver Cliente", response = ClienteResponse.class)
  @ApiResponse(code = 201, message = "Sucesso", response = ClienteResponse.class)
  public ResponseEntity<ClienteResponse> salvar(@Valid @RequestBody ClienteRequest clienteRequest) {

    var clienteDTO = ClienteDTO.builder()
              .nome(clienteRequest.getNome())
              .cpf(clienteRequest.getCpf())
              .endereco(clienteRequest.getEndereco())
              .build();

    var resultado = clienteService.salvar(clienteDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
  }

  @GetMapping("/{clienteId}")
  @ApiOperation(value = "Obtem Cliente por ID", response = ClienteResponse.class)
  @ApiResponse(code = 200, message = "Sucesso", response = ClienteResponse.class)
  public ResponseEntity<ClienteResponse> buscarId(
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
            @Valid @RequestBody ClienteRequest clienteRequest,
            @Parameter(description = CLIENTE_ID)
            @PathVariable(name = "clienteId") Integer clienteId) {
    clienteService.atualizarId(clienteRequest, clienteId);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/listar")
  @ApiOperation(value = "Listar Clientes")
  @ApiResponse(code = 200, message = "Sucesso", response = ClienteResponse.class)
  public ResponseEntity<List<ClienteResponse>> listarClientes() {
    var lista = clienteService.listarClientes();
    return ResponseEntity.status(HttpStatus.OK).body(lista);
  }
}
