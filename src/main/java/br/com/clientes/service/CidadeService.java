package br.com.clientes.service;

import br.com.clientes.domain.dto.CidadeDTO;
import br.com.clientes.domain.model.Cidade;
import java.util.List;

public interface CidadeService {

    /**
     * Salvar cidade
     *
     * @param cidadeDTO
     * @return
     */

    Cidade salvar(CidadeDTO cidadeDTO);

    /**
     * Buscar cidade por ID
     * @param cidadeId
     */
    Cidade buscarId(Integer cidadeId);

    /**
     * Deletar cidade por ID
     * @param cidadeId
     */
    void deletarId(Integer clienteId);

    /**
     * Atualizar cidade por ID
     * @param cidadeDTO
     * @param cidadeID
     */
    void atualizarId(CidadeDTO cidadeDTO, Integer cidadeID);

    /**
     * Buscar todas as cidades
     *
     * @return
     */

    List<Cidade> listarCidades();
}
