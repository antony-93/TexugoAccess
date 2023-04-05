package br.com.TexugoAccess.BackEnd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  //Configuração CORS
  @Bean
  public CharacterEncodingFilter characterEncodingFilter() {
    CharacterEncodingFilter filter = new CharacterEncodingFilter();
    filter.setEncoding("UTF-8");
    filter.setForceEncoding(true);
    return filter;
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {

    //HABILITA TODOS OS ENDPOINTS, ORIGENS, METODOS E CABEÇALHOS!
    /*CASO QUEIRA ADICIONAR UMA SEGURANÇA MAIOR VOCÊ PODE DEFINIR
     ENDPOINT QUE ESTA SENDO ACESSADO, A ORIGEM QUE PODE FAZER A CHAMADA DESSE ENDPOINT,
     OS METODOS DESSES EDNPOINT E OS CABEÇALHOS!!!!!!!!!!!!!
     */
    registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "POST", "PUT")
        .allowedHeaders("*");//
  }
}
