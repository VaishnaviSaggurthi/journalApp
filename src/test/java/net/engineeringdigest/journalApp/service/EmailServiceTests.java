package net.engineeringdigest.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    public void testSendEmail() {
        // Test sending an email
        emailService.sendEmail("saggurthivaishnavi@gmail.com", "Testing Java mail Sender", "Hi, How are you?");
        emailService.sendEmail("srinivas.saggurthi@gmail.com", "Testing Java mail Sender", "Hi, I'm Practicing Spring Boot Email Service.");
    }
}
