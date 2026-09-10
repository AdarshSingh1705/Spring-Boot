package adarsh.com.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 1) Allow CORS preflight + your React app through
        http.cors(withDefaults());

        // 2) All requests should be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        // 3) If a request is not authenticated, a web page is shown
        http.httpBasic(withDefaults());

        // 4) CSRF -> POST, PUT
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}