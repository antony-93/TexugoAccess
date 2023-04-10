package br.com.TexugoAccess.api.login.model;

//Define as variaveis necessarias para realizar CRUD no banco
public class UsuarioRequest {

    private String email;
    private String nome;
    private String telefone;
    private String genero;
    private String data_cadastro;
    private String senha;
    private Boolean verificado;

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public String getGenero() {
    return genero;
  }

  public String getData_cadastro() {
    return data_cadastro;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getSenha() {
    return senha;
  }

  public Boolean getVerificado() {
    return verificado;
  }

}
