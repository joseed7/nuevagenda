package com.agenda.app.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Agenda de Contactos")
                        .version("1.0")
                        .description("API RESTful para gestión de contactos personales")
                        .contact(new Contact()
                                .name("Soporte")
                                .email("soporte@agenda.com")));
    }
}