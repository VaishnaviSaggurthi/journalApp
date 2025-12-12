package net.engineeringdigest.journalApp.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

// Swagger configuration class -- used to create our own custom swagger documentation
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI myCustomConfig(){
        return new OpenAPI()
                .info(
                new Info().title("Journal App APIs")
                          .description("By Vaishnavi Saggurthi")
                )
                .servers(Arrays.asList(new Server().url("http://localhost:8081/").description("Local Dev Server"),
                        new Server().url("https://journalapp-stff.onrender.com/").description("Production Server")
                ))
                .tags(Arrays.asList(
                        new Tag().name("Public APIs").description("APIs for public access like signup and login"),
                        new Tag().name("User APIs").description("APIs for user operations"),
                        new Tag().name("Journal Entry APIs").description("APIs for journal entry operations with authentication"),
                        new Tag().name("Admin APIs").description("APIs for admin operations"),
                        new Tag().name("Health Check API").description("API to check the health status of the application")
                ))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components().addSecuritySchemes(
                        "bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .in(SecurityScheme.In.HEADER)
                                .name("Authorization")
                ));
    }
}
