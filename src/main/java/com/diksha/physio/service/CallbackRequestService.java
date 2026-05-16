package com.diksha.physio.service;

import com.diksha.physio.dto.CallbackRequestDto;
import com.diksha.physio.entity.CallbackRequest;
import com.diksha.physio.repository.CallbackRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallbackRequestService {

    private final CallbackRequestRepository repository;
    private final EmailNotificationService emailService;

    public CallbackRequestService(CallbackRequestRepository repository,
                                  EmailNotificationService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    public CallbackRequest save(CallbackRequestDto dto) {
        CallbackRequest entity = new CallbackRequest();
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setMessage(dto.getMessage());
        entity.setPreferredTime(dto.getPreferredTime());
        CallbackRequest saved = repository.save(entity);
        emailService.sendCallbackNotification(saved);
        return saved;
    }

    public List<CallbackRequest> findAll() {
        return repository.findAll();
    }
}
