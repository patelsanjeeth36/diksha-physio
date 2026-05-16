package com.diksha.physio.service;

import com.diksha.physio.entity.CallbackRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class EmailNotificationService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${resend.api.key:}")
    private String resendApiKey;

    @Value("${notification.email:diksha.physio.care@gmail.com}")
    private String notificationEmail;

    public void sendCallbackNotification(CallbackRequest request) {
        if (resendApiKey == null || resendApiKey.isBlank()) {
            System.out.println("RESEND_API_KEY not set — skipping email notification.");
            return;
        }

        try {
            String body =
                "Hello Dr. Diksha,\n\n" +
                "You have a new callback request from your website!\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━\n" +
                "Name      : " + request.getName() + "\n" +
                "Phone/WA  : " + request.getPhone() + "\n" +
                "Preferred : " + (request.getPreferredTime() != null ? request.getPreferredTime() : "Any time") + "\n" +
                "Message   : " + (request.getMessage() != null && !request.getMessage().isBlank() ? request.getMessage() : "—") + "\n" +
                "━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "Please call them back as soon as possible.\n\n" +
                "— Diksha Physio Website";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(resendApiKey);

            Map<String, Object> payload = Map.of(
                "from",    "Diksha Physio <onboarding@resend.dev>",
                "to",      List.of(notificationEmail),
                "subject", "New Callback Request — " + request.getName(),
                "text",    body
            );

            restTemplate.postForObject(
                "https://api.resend.com/emails",
                new HttpEntity<>(payload, headers),
                String.class
            );

            System.out.println("Callback notification sent to " + notificationEmail);
        } catch (Exception e) {
            System.err.println("Email notification failed: " + e.getMessage());
        }
    }
}
