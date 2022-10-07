package br.com.clientes.repository;

import br.com.clientes.domain.entity.CidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository  extends JpaRepository<CidadeEntity, Integer> {
}
