package com.hevlar.graphql.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.Map;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity){
        return httpSecurity.authorizeExchange(authorizeExchangeSpec ->
                authorizeExchangeSpec
                        .anyExchange().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public ReactiveUserDetailsService reactiveUserDetailsService(){
        UserDetails administrator = User
                .builder()
                .username("administrator")
                .password("{bcrypt}$2a$12$MPKhq7X2817XkJETLR4p5.mo4Of3WMeNkoYgcZ5V6UX5u5jN2NQzu")
                .roles("ADMIN")
                .build();
        return new MapReactiveUserDetailsService(administrator);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        Map<String, PasswordEncoder> encoderMap = Map.of(
                "bcrypt", new BCryptPasswordEncoder()
        );
        return new DelegatingPasswordEncoder("bcrypt", encoderMap);
    }
}
