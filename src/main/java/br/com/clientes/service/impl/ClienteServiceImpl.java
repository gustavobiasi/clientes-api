package br.com.clientes.service.impl;

import br.com.clientes.domain.dto.ClienteDTO;
import br.com.clientes.domain.entity.ClienteEntity;
import br.com.clientes.domain.model.Cliente;
import br.com.clientes.repository.ClienteRepository;
import br.com.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente salvar(ClienteDTO clienteDTO) {

        if (clienteDTO == null)
            throw new RuntimeException("Cliente é nulo");

        var clienteEntity = mapperClienteDtoToClienteEntity(clienteDTO);
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
                  .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        return Cliente.builder()
                  .id(cliente.getId())
                  .nome(cliente.getNome())
                  .cpf(cliente.getCpf())
                  .dataCadastro(cliente.getDataCadastro())
                  .build();
    }

    @Override
    public void deletarId(Integer clienteId) {
        clienteRepository.findById(clienteId)
                  .map(cliente -> {
                      clienteRepository.delete(cliente);
                      return Void.TYPE;
                  })
                  .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @Override
    public void atualizarId(ClienteDTO clienteDTO, Integer clienteId) {
        clienteRepository.findById(clienteId)
                  .map(cliente -> {
                      var clienteAtualizado = mapperClienteDtoToClienteEntity(clienteDTO);
                      clienteAtualizado.setId(clienteId);
                      return clienteRepository.save(clienteAtualizado);
                  })
                  .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    private ClienteEntity mapperClienteDtoToClienteEntity(ClienteDTO clienteDTO) {
        return ClienteEntity.builder()
                  .nome(clienteDTO.getNome())
                  .cpf(clienteDTO.getCpf())
                  .build();
    }
}
