$(document).ready(function () {

    localStorage.setItem('isAuthenticated', false);

    //Realiza uma chamada Ajax para validar o Login do Usuario
    $("#form-login").submit(function (event) {
        event.preventDefault();
        var email = $("#input-email").val();
        var senha = $("#input-senha").val();
        console.log(email, senha); 

        $.ajax({
            url: "http://localhost:8080/usuarios/email/" + email,
            method: "GET",
            dataType: "json"
        }).done(function (usuario) {
            if (usuario.senha === senha && usuario.verificado === true) {
                localStorage.setItem('isAuthenticated', true);
                window.location.href = "Hub.html";
            } else if (usuario.senha === senha && usuario.verificado === false) {
                window.location.href = "Autenticacao.html";
            } else {
                alert("Email ou senha incorretos");
            }
        }).fail(function () {
            console.log("Erro ao fazer a chamada AJAX");
        });

        localStorage.setItem('email', email);
        localStorage.setItem('lastPage', "Login.html");

    });

});
