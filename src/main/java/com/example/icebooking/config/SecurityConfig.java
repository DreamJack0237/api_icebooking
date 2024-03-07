package com.example.icebooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
        private final BCryptPasswordEncoder bCryptPasswordEncoder;
        private final JwtFilter jwtFilter;
        private final UserDetailsService userDetailsService;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
                        throws Exception {
                return httpSecurity
                                .csrf(AbstractHttpConfigurer::disable)
                                .authorizeHttpRequests(
                                                authorize -> authorize
                                                                .requestMatchers(HttpMethod.POST, "/connexion")
                                                                .permitAll()
                                                                .requestMatchers(HttpMethod.POST, "/inscription")
                                                                .permitAll()
                                                                .requestMatchers(HttpMethod.POST, "/activation")
                                                                .permitAll()
                                                                .requestMatchers(HttpMethod.GET, "/ouvrages/**")
                                                                .permitAll()
                                                                .requestMatchers(HttpMethod.GET, "/categories/**")
                                                                .permitAll()

                                                                .anyRequest().authenticated())
                                .sessionManagement(
                                                httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer
                                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

                                .build();

        }

        // gestion des utilisateur authentifier
        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
                        throws Exception {
                return authenticationConfiguration.getAuthenticationManager();
        }

}