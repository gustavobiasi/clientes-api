package br.com.clientes.service;

import br.com.clientes.domain.dto.ClienteDTO;
import br.com.clientes.domain.dto.ClienteRequest;
import br.com.clientes.domain.model.ClienteResponse;
import java.util.List;

public interface ClienteService {

    /**
     * Salvar
     * @param clienteDTO
     * @return
     */
    ClienteResponse salvar(ClienteDTO clienteDTO);

    /**
     * Buscar cliente por ID
     * @param clienteId
     */
    ClienteResponse buscarId(Integer clienteId);

    /**
     * Deletar cliente por ID
     * @param clienteId
     */
    void deletarId(Integer clienteId);

    /**
     * Atualizar cliente por ID
     * @param clienteRequest
     * @param clienteId
     */
    void atualizarId(ClienteRequest clienteRequest, Integer clienteId);

    /**
     * Buscar todos os clientes
     *
     * @return
     */
    List<ClienteResponse> listarClientes();
}
