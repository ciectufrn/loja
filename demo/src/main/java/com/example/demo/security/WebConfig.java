package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebConfig  {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .cors(cors -> cors.configure(http))
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorizeConfig ->
                authorizeConfig
                    .requestMatchers(HttpMethod.POST,"/clientes").permitAll()
                    .requestMatchers(HttpMethod.PUT,"/clientes").permitAll()
                    .requestMatchers(HttpMethod.DELETE,"/clientes/{id:[0-9]+}").permitAll()
                    .requestMatchers(HttpMethod.GET, "/compras/{nome:.*}").permitAll()

                
            ).build();
    }
}