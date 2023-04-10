package br.com.TexugoAccess.api.email.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.TexugoAccess.api.email.model.EmailRequest;
import br.com.TexugoAccess.api.email.service.EmailService;
import static br.com.TexugoAccess.api.ApiConstants.POST_ENVIAR_EMAIL;

@RestController
@Service
public class EmailController {

    @Autowired
    private EmailService emailService;

    // DEFINE O ENDPOINT PARA ENVIAR EMAILS
    @PostMapping(POST_ENVIAR_EMAIL)
    public ResponseEntity<?> enviarEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.enviar(emailRequest);
            return ResponseEntity.ok().build();
        } catch (MessagingException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}



