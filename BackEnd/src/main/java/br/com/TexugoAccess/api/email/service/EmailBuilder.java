package br.com.TexugoAccess.api.email.service;

import org.springframework.stereotype.Service;

import br.com.TexugoAccess.api.email.model.Email;
import br.com.TexugoAccess.api.email.model.EmailRequest;

@Service
public class EmailBuilder {

    public Email buildEmail(EmailRequest request) {
        return Email.builder()
                .to(request.getTo())
                .subject(request.getSubject())
                .text(request.getText())
                .build();
    }

}
