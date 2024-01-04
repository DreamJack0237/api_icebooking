package com.example.icebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
public class IcebookingApplication {
	@Configuration
	public class MailConfig {

		@Bean
		public JavaMailSender javaMailSender() {
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost("smtp.gmail.com");
			mailSender.setPort(587);
			mailSender.setUsername("ngouoleonel3@gmail.com");
			mailSender.setPassword("wlax zthp fymp nfoi");

			Properties props = mailSender.getJavaMailProperties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");

			return mailSender;
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(IcebookingApplication.class, args);
	}

}
