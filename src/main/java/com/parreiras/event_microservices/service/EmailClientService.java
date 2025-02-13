package com.parreiras.event_microservices.service;

import com.parreiras.event_microservices.dto.EmailRequestDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailClientService {

    private final JavaMailSender mailSender;

    public EmailClientService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(EmailRequestDto emailRequest) {
        var message = new SimpleMailMessage();
        message.setFrom("noreply@email.com");
        message.setTo(emailRequest.to());
        message.setSubject(emailRequest.subject());
        message.setText(emailRequest.body());

        mailSender.send(message);
    }
}
