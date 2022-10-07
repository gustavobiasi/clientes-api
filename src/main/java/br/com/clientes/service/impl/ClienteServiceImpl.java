package br.com.clientes.service.impl;

import br.com.clientes.domain.dto.ClienteDTO;
import br.com.clientes.domain.entity.ClienteEntity;
import br.com.clientes.domain.model.Cliente;
import br.com.clientes.handler.exceptions.ClientesApiNotFoundException;
import br.com.clientes.repository.ClienteRepository;
import br.com.clientes.service.ClienteService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente salvar(ClienteDTO clienteDTO) {

        if (clienteDTO == null)
            throw new RuntimeException("Cliente é nulo");

        var clienteEntity = mapperClienteDTOToClienteEntity(clienteDTO);
        var clienteSalvo = clienteRepository.save(clienteEntity);

        return Cliente.builder()
                  .id(clienteSalvo.getId())
                  .nome(clienteSalvo.getNome())
                  .cpf(clienteSalvo.getCpf())
                  .dataCadastro(clienteSalvo.getDataCadastro())
                  .build();
    }

    @Override
    public Cliente buscarId(Integer clienteId) {
        var cliente = clienteRepository.findById(clienteId)
                  .orElseThrow(() -> new ClientesApiNotFoundException("Cliente não encontrado."));

        return Cliente.builder()
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
    public void atualizarId(ClienteDTO clienteDTO, Integer clienteId) {
      var cliente = clienteRepository.findById(clienteId);

      if (!cliente.isPresent())
        throw new ClientesApiNotFoundException("Cliente não encontrado");

      var clienteAtualizado = mapperClienteDTOToClienteEntity(clienteDTO);
      clienteAtualizado.setId(cliente.get().getId());
      clienteRepository.save(clienteAtualizado);
    }

  @Override
  public List<Cliente> listarClientes() {
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

  private ClienteEntity mapperClienteDTOToClienteEntity(ClienteDTO clienteDTO) {
        return ClienteEntity.builder()
                  .nome(clienteDTO.getNome())
                  .cpf(clienteDTO.getCpf())
                  .build();
    }

  private Cliente mapperClienteEntityToCliente(ClienteEntity clienteEntity) {
    return Cliente.builder()
        .id(clienteEntity.getId())
        .nome(clienteEntity.getNome())
        .cpf(clienteEntity.getCpf())
        .dataCadastro(clienteEntity.getDataCadastro())
        .build();
  }
}
