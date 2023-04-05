package br.com.TexugoAccess.BackEnd.email.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.TexugoAccess.BackEnd.email.model.Email;
import br.com.TexugoAccess.BackEnd.email.service.EmailService;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    //DEFINE O ENDPOINT PARA ENVIAR EMAILS
    @PostMapping("/enviar-email")
    public ResponseEntity<?> enviarEmail(@RequestBody Email email) {
        try {
            emailService.enviar(email);
            return ResponseEntity.ok().build();
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}



