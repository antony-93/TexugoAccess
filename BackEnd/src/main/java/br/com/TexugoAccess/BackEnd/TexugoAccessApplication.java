package br.com.TexugoAccess.BackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebConfig.class)
public class TexugoAccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(TexugoAccessApplication.class, args);
	}

}
