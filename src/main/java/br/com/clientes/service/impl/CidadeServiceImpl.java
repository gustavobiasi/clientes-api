package br.com.clientes.service.impl;

import br.com.clientes.domain.dto.CidadeDTO;
import br.com.clientes.domain.entity.CidadeEntity;
import br.com.clientes.domain.model.Cidade;
import br.com.clientes.handler.exceptions.CidadesApiNotFoundException;
import br.com.clientes.repository.CidadeRepository;
import br.com.clientes.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public Cidade salvar(cidadeDTO cidadeDTO) {

        if (cidadeDTO == null)
            throw new RuntimeException("Cidade é nulo");

        var cidadeEntity = mapperCidadeDTOToCidadeEntity(cidadeDTO);
        var cidadeSalvo = cidadeRepository.save(cidadeEntity);

        return Cidade.builder()
                .id(cidadeSalvo.getId())
                .cidade(cidadeSalvo.getCidade())
                .dataCadastro(cidadeSalvo.getDataCadastro())
                .build();
    }

    @Override
    public Cidade buscarId(Integer cidadeId) {
        var cidade = cidadeRepository.findById(cidadeId)
                .orElseThrow(() -> new CidadesApiNotFoundException("Cidade não encontrado."));

        return Cidade.builder()
                .id(cidade.getId())
                .nome(cidade.getNome())
                .cpf(cidade.getCpf())
                .dataCadastro(cidade.getDataCadastro())
                .build();
    }

    @Override
    public void deletarId(Integer cidadeId) {
        var cidade = cidadeRepository.findById(cidadeId);
        if (!cidade.isPresent())
            throw new CidadesApiNotFoundException("Cidade não encontrado");
        cidadeRepository.deleteById(cidadeId);
    }

    @Override
    public void atualizarId(CidadeDTO cidadeDTO, Integer cidadeId) {
        var cidade = cidadeRepository.findById(cidadeId);

        if (!cidade.isPresent())
            throw new CidadesApiNotFoundException("Cidade não encontrado");

        var cidadeAtualizado = mapperCidadeDTOToCidadeEntity(cidadeDTO);
        cidadeAtualizado.setId(cidade.get().getId());
        cidadeRepository.save(cidadeAtualizado);
    }

    @Override
    public List<Cidade> listarCidades() {
        var listaCidades =
                cidadeRepository.findAll()
                        .stream()
                        .map(pessoa -> {
                            System.out.println("teste");
                            return this.mapperCidadeEntityToCidade(pessoa);
                        })
                        .collect(Collectors.toList());

        if (listaCidades.isEmpty())
            throw new CidadesApiNotFoundException("Nenhum cidade encontrado");

        return listaCidades;
    }

    private CidadeEntity mapperCidadeDTOToCidadeEntity(CidadeDTO cidadeDTO) {
        return CidadeEntity.builder()
                .cidade(cidadeDTO.getNome())
                .build();
    }

    private Cidade mapperCidadeEntityToCidade(CidadeEntity cidadeEntity) {
        return Cidade.builder()
                .id(cidadeEntity.getId())
                .cidade(cidadeEntity.getCidade())
                .dataCadastro(cidadeEntity.getDataCadastro())
                .build();
    }
}
