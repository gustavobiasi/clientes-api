package br.com.clientes.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Errors {

  //REQUERIDOS
  public static final String REQUIRED_NOME = "{campo.nome.obrigatorio}";
  public static final String REQUIRED_CPF = "{campo.cpf.obrigatorio}";
  public static final String REQUIRED_CIDADE = "{campo.cidade.obrigatorio}";

  //INVALIDOS
  public static final String CPF_INVALIDO = "{campo.cpf.invalido}";

}
