package net.engineeringdigest.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    
    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendEmail(String to, String subject, String body) {
        // Implementation for sending email
        try{
           SimpleMailMessage mail = new SimpleMailMessage();
           mail.setTo(to);
           mail.setSubject(subject);
           mail.setText(body);
           mail.setFrom(fromEmail);
           javaMailSender.send(mail);
        }catch(Exception e){
            log.error("Error occurred while sending email",e);
        }
    }

}
