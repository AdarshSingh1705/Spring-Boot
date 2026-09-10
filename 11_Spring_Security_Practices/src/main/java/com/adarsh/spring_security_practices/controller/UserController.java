package com.adarsh.spring_security_practices.controller;


import com.adarsh.spring_security_practices.dto.UserRegisterRequestDTO;
import com.adarsh.spring_security_practices.dto.UserRegisterResponseDTO;
import com.adarsh.spring_security_practices.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private AuthService authService;
    public UserController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String sayHello(Authentication authentication){
        return "Hello, you are logged in as : " + authentication.getName();
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDTO> register(
            @RequestBody UserRegisterRequestDTO registerRequestDTO){
           UserRegisterResponseDTO userRegisterResponseDTO
                   = authService.register(registerRequestDTO);

           return ResponseEntity.ok(userRegisterResponseDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(
            @RequestBody UserRegisterRequestDTO registerRequestDTO){
        Boolean loggedIn = authService.login(registerRequestDTO);

        return ResponseEntity.ok(loggedIn);
    }

}
