package com.microserviceproject.security.controller;

import com.microserviceproject.security.service.AuthService;
import com.microserviceproject.security.vo.AuthenticationResponse;
import com.microserviceproject.security.vo.RegisterUserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signUp(@RequestBody RegisterUserVo user){
        return ResponseEntity.ok(authService.signUp(user));
    }
    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> signIn(@RequestBody RegisterUserVo user){
        return ResponseEntity.ok(authService.signIn(user));
    }
}
