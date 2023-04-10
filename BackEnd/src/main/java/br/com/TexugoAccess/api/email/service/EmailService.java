package br.com.TexugoAccess.api.email.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.TexugoAccess.api.email.model.Email;
import br.com.TexugoAccess.api.email.model.EmailRequest;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private EmailBuilder builder = new EmailBuilder();;

    // Coleta as informações necessarias para enviar um email
    public void enviar(EmailRequest emailRequest) throws MessagingException {
        Email email = builder.buildEmail(emailRequest);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getText());
        mailSender.send(message);
    }
}
