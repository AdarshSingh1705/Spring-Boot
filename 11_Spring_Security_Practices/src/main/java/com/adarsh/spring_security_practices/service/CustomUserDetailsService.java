package com.adarsh.spring_security_practices.service;

import com.adarsh.spring_security_practices.entity.CustomUserDetails;
import com.adarsh.spring_security_practices.entity.User;
import com.adarsh.spring_security_practices.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow( ()-> new UsernameNotFoundException(
                        "User not Found"
                ));

        return new CustomUserDetails(user);
    }
}
