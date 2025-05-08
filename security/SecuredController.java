package com.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredController {

    @GetMapping("/secure")
    public ResponseEntity<String> securePage() {
        return ResponseEntity.ok("This is a secured page!");
    }
}
