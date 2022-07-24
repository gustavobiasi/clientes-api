package br.com.clientes.service;

import br.com.clientes.domain.dto.ClienteDTO;
import br.com.clientes.domain.model.Cliente;

public interface ClienteService {

    /**
     * Salvar cliente
     *
     * @param clienteDTO
     * @return
     */
    Cliente salvar(ClienteDTO clienteDTO);

    /**
     * Buscar cliente por ID
     * @param clienteId
     */
    Cliente buscarId(Integer clienteId);

    /**
     * Deletar cliente por ID
     * @param clienteId
     */
    void deletarId(Integer clienteId);

    /**
     * Atualizar cliente por ID
     * @param clienteDTO
     * @param clienteId
     */
    void atualizarId(ClienteDTO clienteDTO, Integer clienteId);
}
