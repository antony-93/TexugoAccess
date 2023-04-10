package br.com.TexugoAccess.api.email.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//Define as variaveis necessarias para enviar um email
@Getter
@Setter
@Builder
public class Email {

    private String to;
    private String subject;
    private String text;
    
}




