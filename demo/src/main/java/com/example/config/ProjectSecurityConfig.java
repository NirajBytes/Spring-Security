package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());
//		http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
				.requestMatchers("/notices","/contact").permitAll());
		
		http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		 http.csrf(AbstractHttpConfigurer::disable);
//		http.formLogin(login -> login.disable()); // Disables
//		http.httpBasic(basic -> basic.disable()); // Disables basic authentication
		return http.build();
	}
}
