package com.microserviceproject.security.service;

import com.microserviceproject.security.user.User;
import com.microserviceproject.security.user.UserRepository;
import com.microserviceproject.security.vo.AuthenticationResponse;
import com.microserviceproject.security.vo.RegisterUserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse signUp(RegisterUserVo userReq) {
        User user = User.builder()
                .firstName(userReq.getFirstName())
                .lastName(userReq.getLastName())
                .email(userReq.getEmail())
                .password(passwordEncoder.encode(userReq.getPassword()))
                .build();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse signIn(RegisterUserVo userReq) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userReq.getEmail(),
                        userReq.getPassword()
                )
        );
        User user = userRepository.findByEmail(userReq.getEmail())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
