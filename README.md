# TexugoAccess

![Preview-Screens](https://github.com/antony-93/img-TexugoAccess/blob/main/Captura%20de%20Tela%20(9).png)

<table>
  <tr>
    <td>
      <img src="https://github.com/antony-93/img-TexugoAccess/blob/main/Captura%20de%20Tela%20(1).png">
    </td>
    <td>
      <img src="https://github.com/antony-93/img-TexugoAccess/blob/main/Captura%20de%20Tela%20(2).png">
    </td>
    <td>
      <img src="https://github.com/antony-93/img-TexugoAccess/blob/main/Captura%20de%20Tela%20(3).png">
    </td>
    <td>
      <img src="https://github.com/antony-93/img-TexugoAccess/blob/main/Captura%20de%20Tela%20(4).png">
    </td>
    <td>
      <img src="https://github.com/antony-93/img-TexugoAccess/blob/main/Captura%20de%20Tela%20(5).png">
    </td>
    <td>
      <img src="https://github.com/antony-93/img-TexugoAccess/blob/main/Captura%20de%20Tela%20(6).png">
    </td>
    <td>
      <img src="https://github.com/antony-93/img-TexugoAccess/blob/main/Captura%20de%20Tela%20(8).png">
    </td>
  </tr>
</table>

## Sobre este projeto

A ideia do site é:

_"Realizar de forma simples e rápida o cadastro e login de um Usuário"._

**PS:** Cadastro e Login foi um tema escolhido por mim, mas todo código dentro desse repositório pode ser utilizado da maneira que você quiser seja escola, faculdade ou até mesmo trabalho!

## Porquê?

Este projeto faz parte do meu portfólio pessoal, então, ficarei feliz se você puder me fornecer algum feedback sobre o projeto, código, estrutura ou qualquer coisa que você possa relatar que possa me tornar um desenvolvedor melhor!

Meu Email: user.antony.cechinel@gmail.com

Conecte-se comigo no [LinkedIn](https://www.linkedin.com/in/antony-luiz-cechinel-789082222/).

Além disso, você pode usar este Projeto como quiser, seja para estudar, seja para fazer melhorias ou ganhar dinheiro com isso!

É grátis!

## Funcionalidades

- Cadastre-se de forma simples e rápida, basta preencher alguns campos com suas informações pessoais, como nome, e-mail e senha. É importante lembrar de escolher uma senha segura e fácil de lembrar. Após concluir o cadastro, você terá acesso imediato às funcionalidades exclusivas do nosso site.

- A página de login é igualmente simples. Basta inserir seu e-mail e senha para acessar sua conta. Se desejar, você pode selecionar a opção "lembrar minha senha" para que não precise inseri-la novamente em visitas futuras.

- Esqueceu sua Senha? Não tem problema! Basta clicar em esqueceu senha na página de login, inserir o código de autenticação e alterar sua senha!

### Pré-requisitos

Para executar este projeto no modo de desenvolvimento, você precisará ter em sua máquina instalado Apache Maven, Visual Studio Code, [MySQL](https://www.mysql.com/) e as extensões do extension pack for java e Spring Boot Extension Pack, que pode ser encontrado [aqui](https://code.visualstudio.com/).

Além disso, você precisará do servidor em execução localmente em sua máquina com os dados fictícios. Você pode encontrar o servidor e todas as instruções para iniciar o servidor [aqui](https://github.com/antony-93/cadastro-login).

### Instalando

**Clonando Repositório**

```
$ git clone https://github.com/antony-93/TexugoAccess
$ cd TexugoAccess
```

**Ou**

Faça o download do repositório [aqui](https://github.com/antony-93/cadastro-login).

### Conectando BackEnd com Banco de dados e Gmail

1- Crie um schema com nome usuarios e copie e cole o código a seguir em sua SQL tab:

```
CREATE TABLE usuario (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(250) NOT NULL UNIQUE,
  nome VARCHAR(250) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  genero VARCHAR(20) NOT NULL,
  data_cadastro DATE NOT NULL,
  senha VARCHAR(200) NOT NULL,
  verificado TINYINT NOT NULL DEFAULT 0
);

```
2- Em seguida copie e cole esse código na SQL tab:

```
DELIMITER $$
CREATE TRIGGER `insert_data_cadastro`
BEFORE INSERT ON `usuario`
FOR EACH ROW
BEGIN
    IF NEW.data_cadastro IS NULL THEN
        SET NEW.data_cadastro = NOW();
    END IF;
END$$
DELIMITER ;

```
3 - Abra o arquivo application.properties localizado [aqui](Cadastro-Login/BackEnd/src/main/resources/application.properties)

4 - Edite as informações conforme descrito no ARQUIVO!!

SERVER_URL=http://localhost:8080/ "Aqui são as rotas"

### Rodar

Após o maven e as extensões estarem instaladas basta rodar a aplicação utilizando a extensão Spring Initializr Java Support!

## Construído com

- [Photoshop](https://www.adobe.com/br/products/photoshop) - Editor de fotos e imagens
- [Spring Boot](https://start.spring.io/) - FrameWork utilizado
- [Maven](https://maven.apache.org/) - Ferramenta de Automação
- [Visual Studio Code](https://code.visualstudio.com/) - Editor de Código Fonte
- [jQuery](https://jquery.com/) - Biblioteca JavaScript
- [MySQL](https://www.mysql.com/) - Banco de Dados

## Linguagens

- JavaScript
- Java
- HTML
- CSS

## Contribuindo

Você pode enviar quantos PR's quiser, terei prazer em analisá-los e aceitá-los! E se você tiver alguma dúvida sobre o projeto...

Meu Email: user.antony.cechinel@gmail.com

Conecte-se comigo no [LinkedIn](https://www.linkedin.com/in/antony-luiz-cechinel-789082222/)

Obrigado!

## Licença

Este projeto está licenciado sob a licença MIT - consulte o arquivo [LICENSE.md](https://github.com/antony-93/TexugoAccess/blob/master/LICENSE.md) para mais detalhes!
