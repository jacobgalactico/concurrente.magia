package com.ministerio.magia.concurrente.magia.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SeguridadConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/hechizos/**").hasRole("AUROR")
                        .requestMatchers("/api/eventos/**").hasRole("MINISTRO")
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults -> {}); // Usa la configuración básica HTTP con el nuevo formato

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails auror = User.withUsername("auror")
                .password("{noop}password") // "{noop}" indica que no se usará un codificador de contraseñas
                .roles("AUROR")
                .build();

        UserDetails ministro = User.withUsername("ministro")
                .password("{noop}password")
                .roles("MINISTRO")
                .build();

        return new InMemoryUserDetailsManager(auror, ministro);
    }
}