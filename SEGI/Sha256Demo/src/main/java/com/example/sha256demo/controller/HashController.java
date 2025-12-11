package com.example.sha256demo.controller;

import com.example.sha256demo.dto.HashRequest;
import com.example.sha256demo.dto.HashResponse;
import com.example.sha256demo.service.HashService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hash")
public class HashController {

    private final HashService hashService;

    public HashController(HashService hashService) {
        this.hashService = hashService;
    }

    @PostMapping("/sha256")
    public ResponseEntity<HashResponse> sha256(@RequestBody HashRequest request) {
        if (request == null || request.getText() == null) {
            return ResponseEntity.badRequest().build();
        }
        String hex = hashService.sha256Hex(request.getText());
        HashResponse response = new HashResponse(hex);
        return ResponseEntity.ok(response);
    }
}
