package com.diksha.physio.service;

import com.diksha.physio.dto.CallbackRequestDto;
import com.diksha.physio.entity.CallbackRequest;
import com.diksha.physio.repository.CallbackRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallbackRequestService {

    private final CallbackRequestRepository repository;

    public CallbackRequestService(CallbackRequestRepository repository) {
        this.repository = repository;
    }

    public CallbackRequest save(CallbackRequestDto dto) {
        CallbackRequest entity = new CallbackRequest();
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setMessage(dto.getMessage());
        entity.setPreferredTime(dto.getPreferredTime());
        return repository.save(entity);
    }

    public List<CallbackRequest> findAll() {
        return repository.findAll();
    }
}
