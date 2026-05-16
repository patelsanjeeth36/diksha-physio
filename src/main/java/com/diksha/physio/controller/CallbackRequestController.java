package com.diksha.physio.controller;

import com.diksha.physio.dto.CallbackRequestDto;
import com.diksha.physio.entity.CallbackRequest;
import com.diksha.physio.service.CallbackRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/callback")
public class CallbackRequestController {

    private final CallbackRequestService service;

    public CallbackRequestController(CallbackRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody CallbackRequestDto dto) {
        CallbackRequest saved = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of(
                        "id", saved.getId(),
                        "message", "Callback request received. We will contact you shortly!"
                ));
    }

    @GetMapping
    public ResponseEntity<List<CallbackRequest>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleValidation(org.springframework.web.bind.MethodArgumentNotValidException ex) {
        Map<String, String> errors = new java.util.LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(fe -> errors.put(fe.getField(), fe.getDefaultMessage()));
        return Map.of("errors", errors);
    }
}
