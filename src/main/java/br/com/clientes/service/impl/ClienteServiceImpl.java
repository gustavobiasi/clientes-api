package br.com.clientes.service.impl;

import br.com.clientes.domain.dto.ClienteDTO;
import br.com.clientes.domain.dto.ClienteRequest;
import br.com.clientes.domain.entity.ClienteEntity;
import br.com.clientes.domain.model.ClienteResponse;
import br.com.clientes.handler.exceptions.ClientesApiNotFoundException;
import br.com.clientes.mapper.ClienteMapper;
import br.com.clientes.repository.ClienteRepository;
import br.com.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;
  @Autowired
  private ClienteMapper clienteMapper;

  @Override
  public ClienteResponse salvar(ClienteDTO clienteDTO) {

    if (clienteDTO == null)
      throw new RuntimeException("Cliente é nulo");

    var mapper = clienteMapper.toClienteEntity(clienteDTO);
    var clienteSalvo = clienteRepository.save(mapper);

    return ClienteResponse.builder()
              .id(clienteSalvo.getId())
              .nome(clienteSalvo.getNome())
              .cpf(clienteSalvo.getCpf())
              .dataCadastro(clienteSalvo.getDataCadastro())
              .build();
  }

  @Override
  public ClienteResponse buscarId(Integer clienteId) {
    var cliente = clienteRepository.findById(clienteId)
              .orElseThrow(() -> new ClientesApiNotFoundException("Cliente não encontrado."));

    return ClienteResponse.builder()
              .id(cliente.getId())
              .nome(cliente.getNome())
              .cpf(cliente.getCpf())
              .dataCadastro(cliente.getDataCadastro())
              .build();
  }

  @Override
  public void deletarId(Integer clienteId) {
    var cliente = clienteRepository.findById(clienteId);
    if (!cliente.isPresent())
      throw new ClientesApiNotFoundException("Cliente não encontrado");
    clienteRepository.deleteById(clienteId);
  }

  @Override
  public void atualizarId(ClienteRequest clienteRequest, Integer clienteId) {
//      var cliente = clienteRepository.findById(clienteId);
//
//      if (!cliente.isPresent())
//        throw new ClientesApiNotFoundException("Cliente não encontrado");
//
//      var clienteAtualizado = mapperClienteDTOToClienteEntity(clienteRequest);
//      clienteAtualizado.setId(cliente.get().getId());
//      clienteRepository.save(clienteAtualizado);
  }

  @Override
  public List<ClienteResponse> listarClientes() {
    var listaClientes =
              clienteRepository.findAll()
                        .stream()
                        .map(pessoa -> {
                          System.out.println("teste");
                          return this.mapperClienteEntityToCliente(pessoa);
                        })
                        .collect(Collectors.toList());

    if (listaClientes.isEmpty())
      throw new ClientesApiNotFoundException("Nenhum cliente encontrado");

    return listaClientes;
  }

  private ClienteResponse mapperClienteEntityToCliente(ClienteEntity clienteEntity) {
    return ClienteResponse.builder()
              .id(clienteEntity.getId())
              .nome(clienteEntity.getNome())
              .cpf(clienteEntity.getCpf())
              .dataCadastro(clienteEntity.getDataCadastro())
              .build();
  }
}
