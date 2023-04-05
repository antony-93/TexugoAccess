$(document).ready(function () {

  var codigoAutenticacao = Math.floor(Math.random() * 100000).toString().substring(0, 5);

  var email = localStorage.getItem('email');
  var lastPage = localStorage.getItem('lastPage');

  //Envia um email de confirmação utilizando Ajax
  $.ajax({
    type: "POST",
    url: "http://localhost:8080/enviar-email",
    contentType: "application/json",
    dataType: "json",
    data: JSON.stringify({
      to: email,
      subject: "Código de Verificação - Texugo Access",
      text: codigoAutenticacao
    }),
    success: function (response) {
      console.log("Email enviado com sucesso!");
    },
    error: function (xhr, status, error) {
      console.log(xhr.responseText);
      console.log(email);
      console.error("Erro ao enviar email: " + error);
    }
  });

  $('.codigo input').on('input', function () {
    this.value = this.value.replace(/[^\d]/, '');
  });

  // Mudar o foco para o próximo input ao digitar um número
  $('.codigo input').on('keyup', function (event) {
    var index = $('.codigo input').index(this);
    if (event.keyCode == 8) { // verificar se a tecla pressionada é "backspace"
      var prevInput = $('.codigo input').eq(index - 1);
      if (prevInput.length > 0) {
        prevInput.focus();
      }
    } else {
      var nextInput = $('.codigo input').eq(index + 1);
      if (this.value.length == 1 && nextInput.length > 0) {
        nextInput.focus();
      }
    }
  });

  $('#btn-enviar').on('click', function () {

    console.log("lastPage: ", lastPage);
    var inputs = $('.codigo input');
    var codigo = '';

    inputs.each(function () {
      codigo += $(this).val();
    });

    if (codigo === codigoAutenticacao) {

      //Realiza chamda ajax para alterar a variavel verificado do Banco!
      if (lastPage === "Cadastro.html" || lastPage === "Login.html") {
        $.ajax({
          url: 'http://localhost:8080/usuarios/email/' + email,
          type: 'PUT',
          contentType: 'application/json',
          data: JSON.stringify({
            verificado: true
          }),
          success: function (result) {
            console.log(lastPage);
            window.location.href = "CadastroSucesso.html";
          },
          error: function (jqXHR, textStatus, errorThrown) {
            console.log("Erro ao alterar a variável verificado: " + textStatus);
          }
        });
      } else if (lastPage === "EsqueceuSenha.html") { // Redireciona para a pagina Alterar Senha
        window.location.href = "AlterarSenha.html"
      }
    } else {
      console.log("Código incorreto!");
      alert("Código incorreto!");
    }

  });

});
