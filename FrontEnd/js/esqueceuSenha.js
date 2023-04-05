$(document).ready(function () {

    //Realiza uma chamda Ajax para ver se existe este email cadastrado no Banco!
    $("#form-esqueceuSenha").submit(function (event) {
        event.preventDefault();
        var email = $("#input-email").val();

        $.ajax({
            url: "http://localhost:8080/usuarios/email/" + email,
            method: "GET",
            dataType: "json"
        }).done(function (usuario) {
           window.location.href = "Autenticacao.html";
        }).fail(function () {
            console.log("Erro ao fazer a chamada AJAX");
        });

        localStorage.setItem('email', email);
        localStorage.setItem('lastPage', "EsqueceuSenha.html");
        
    });

});

