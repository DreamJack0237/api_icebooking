package com.example.icebooking.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authorize ->
                                authorize
                                        .requestMatchers(HttpMethod.POST,"/connexion").permitAll()
                                      .requestMatchers(HttpMethod.POST,"/inscription").permitAll()
                                        .requestMatchers(HttpMethod.POST,"/activation").permitAll()
                                        .anyRequest().authenticated()
                ).build();

    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


        @Bean
        public JavaMailSender javaMailSender() {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            // Configurer le serveur de messagerie, le port, le nom d'utilisateur, le mot de passe, etc.
            mailSender.setHost("smtp.gmail.com");
            mailSender.setPort(587);
            mailSender.setUsername("ngouoleonel3@gmail.com");
            mailSender.setPassword("wlax zthp fymp nfoi");

            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "true");

            return mailSender;
        }


        // gestion des utilisateur authentifier
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

@Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService){
    DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(this.bCryptPasswordEncoder());
    return daoAuthenticationProvider;
}

}
//.httpBasic();
//
//        return httpSecurity.build();