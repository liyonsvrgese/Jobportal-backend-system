package com.liyons.jobportal.controller;

import com.liyons.jobportal.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtils jwtUtils;

    @Autowired
    public AuthController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Simulate authentication (you should replace this with actual authentication logic)
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        // Example: Use actual user service to verify email and password
        if (isValidUser(email, password)) {
            // Generate JWT token
            String token = jwtUtils.generateToken(email);
            return ResponseEntity.ok(new JwtResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // Dummy authentication logic (replace this with real logic, such as checking against the database)
    private boolean isValidUser(String email, String password) {
        return "test@example.com".equals(email) && "password".equals(password);  // Example logic
    }

    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class JwtResponse {
        private String token;

        public JwtResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
