package br.com.clientes.mapper;

import br.com.clientes.domain.dto.ClienteDTO;
import br.com.clientes.domain.entity.ClienteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

  ClienteEntity toClienteEntity(ClienteDTO clienteDTO);

  ClienteDTO toClienteDTO(ClienteEntity clienteEntity);
}
