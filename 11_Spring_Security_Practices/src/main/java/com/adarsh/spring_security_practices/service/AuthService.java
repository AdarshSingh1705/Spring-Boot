package com.adarsh.spring_security_practices.service;

import com.adarsh.spring_security_practices.dto.UserRegisterRequestDTO;
import com.adarsh.spring_security_practices.dto.UserRegisterResponseDTO;
import com.adarsh.spring_security_practices.entity.Role;
import com.adarsh.spring_security_practices.entity.User;
import com.adarsh.spring_security_practices.repository.RoleRepository;
import com.adarsh.spring_security_practices.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegisterResponseDTO register(
            UserRegisterRequestDTO registerRequestDTO) {
        User user = new User();

        user.setUsername(registerRequestDTO.getUsername());

        String encodedPassword =
                passwordEncoder.encode(registerRequestDTO.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);

        Role role = roleRepository.findByName("ROLE_USER").get();
        user.getRoles().add(role);

        userRepository.save(user);

        UserRegisterResponseDTO responseDTO
                = new UserRegisterResponseDTO();

        responseDTO.setUsername(user.getUsername());
        responseDTO.setMessage("User Saved Successfully");

        return responseDTO;
    }

    public Boolean login(UserRegisterRequestDTO registerRequestDTO) {

        Optional<User> userOptional = userRepository.findByUsername(
                registerRequestDTO.getUsername());
        User user = userOptional.get();

        String encodedPassword = user.getPassword();

        return passwordEncoder.matches(
                registerRequestDTO.getPassword(),
                encodedPassword
        );
    }
}
