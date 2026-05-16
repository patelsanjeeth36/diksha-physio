package com.diksha.physio.service;

import com.diksha.physio.entity.CallbackRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    private final JavaMailSender mailSender;

    @Value("${notification.email:}")
    private String notificationEmail;

    public EmailNotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendCallbackNotification(CallbackRequest request) {
        if (notificationEmail == null || notificationEmail.isBlank()) return;

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(notificationEmail);
            message.setSubject("New Callback Request — " + request.getName());
            message.setText(
                "Hello Dr. Diksha,\n\n" +
                "You have a new callback request from your website!\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━\n" +
                "Name        : " + request.getName() + "\n" +
                "Phone/WA    : " + request.getPhone() + "\n" +
                "Preferred   : " + (request.getPreferredTime() != null ? request.getPreferredTime() : "Any time") + "\n" +
                "Message     : " + (request.getMessage() != null ? request.getMessage() : "—") + "\n" +
                "━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "Please call them back as soon as possible.\n\n" +
                "— Dr. Diksha Physio Website"
            );
            mailSender.send(message);
        } catch (Exception e) {
            // Log but don't fail the request if email fails
            System.err.println("Email notification failed: " + e.getMessage());
        }
    }
}
