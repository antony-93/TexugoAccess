package br.com.TexugoAccess.BackEnd.email.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.TexugoAccess.BackEnd.email.model.Email;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    //Coleta as informações necessarias para enviar um email
    public void enviar(Email email) throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getText());
        mailSender.send(message);
    }
}
