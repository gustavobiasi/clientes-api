package br.com.clientes.service.impl;

import br.com.clientes.domain.dto.CidadeDTO;
import br.com.clientes.handler.exceptions.ClienteApiException;
import br.com.clientes.repository.CidadeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static fixture.CidadeEntityFixture.buildCidadeEntity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CidadeServiceImplTest {

  @InjectMocks
  private CidadeServiceImpl cidadeServiceImpl;
  @Mock
  private CidadeRepository cidadeRepository;

  @Test
  public void test_salvar_CidadeDTO_Null_ClienteApiException() {
    assertThrows(ClienteApiException.class, () -> cidadeServiceImpl.salvar(null));
  }

  @Test
  public void test_salvar_Sucesso() {
    when(cidadeRepository.save(any()))
              .thenReturn(buildCidadeEntity());

    var result = cidadeServiceImpl.salvar(CidadeDTO.builder().build());

    assertEquals(Integer.valueOf(1), result.getId());
    assertEquals("Uberlandia", result.getCidade());
    assertEquals(LocalDate.now(), result.getDataCadastro());
  }



}