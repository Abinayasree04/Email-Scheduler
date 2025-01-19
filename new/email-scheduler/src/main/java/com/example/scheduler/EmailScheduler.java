package com.example.emailscheduler.scheduler;

import com.example.emailscheduler.service.EmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private final EmailService emailService;

    public EmailScheduler(EmailService emailService) {
        this.emailService = emailService;
    }

    // This will send an email every minute (cron expression)
    @Scheduled(cron = "0 35 00 ? * *") // Modify as needed (cron expression)
    public void sendScheduledEmail() {
        String to = "abinayasreej04@gmail.com";
        String subject = "Scheduled Email";
        String text = "This is a scheduled email sent by Spring Boot!";
        emailService.sendSimpleMessage(to, subject, text);
        System.out.println("Email sent at: " + System.currentTimeMillis());
    }
}
