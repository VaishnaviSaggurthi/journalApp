package net.engineeringdigest.journalApp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Health Check API", description = "API to check the health status of the application") // Swagger tag -- used to group APIs in Swagger UI under a common name
public class HealthCheck {

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Ok";
    }
}
