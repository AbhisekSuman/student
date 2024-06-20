package com.abhi.student.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {
        @Bean
        public OpenAPI defineOpenApi() {
            Server server = new Server();
            server.setUrl("http://localhost:8082");
            server.setDescription("Development");

            Contact myContact = new Contact();
            myContact.setName("Abhisek NAyak");
            myContact.setEmail("abhiseknayak2003@gmail.com");

            Info information = new Info()
                    .title("student")
                    .version("1.0")
                    .description("test project for Spring Boot")
                    .contact(myContact);
            return new OpenAPI().info(information).servers(List.of(server));
        }
    }

