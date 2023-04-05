$(document).ready(function () {
    var email = localStorage.getItem('email');

    //Altera a variavel senha do Banco
    $("#form-alterarSenha").submit(function (event) {
        event.preventDefault();
        var senha = $("#senha").val();
        var confirmeSenha = $("#confirmeSenha").val();

        if (senha !== confirmeSenha) {
            alert("As senhas não coincidem. Por favor, tente novamente.");
        } else {
            $.ajax({
                url: 'http://localhost:8080/usuarios/email/' + email,
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify({
                    senha: senha
                }),
                success: function (result) {
                    console.log(result);
                    alert("Senha alterada com Sucesso")
                    window.location.href = "CadastroSucesso.html";
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("Erro ao alterar a variável verificado: " + textStatus);
                }
            });
        }
    });
});