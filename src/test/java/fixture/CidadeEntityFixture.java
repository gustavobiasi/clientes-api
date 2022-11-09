package fixture;

import br.com.clientes.domain.entity.CidadeEntity;

import java.time.LocalDate;

public class CidadeEntityFixture {

  public static CidadeEntity buildCidadeEntity() {
    return CidadeEntity.builder()
              .id(1)
              .cidade("Uberlandia")
              .dataCadastro(LocalDate.now())
              .build();
  }
}
