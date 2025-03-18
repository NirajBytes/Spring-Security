package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll()); 
//		http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
		http.authorizeHttpRequests(
				(requests) -> requests.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards")
						.authenticated().requestMatchers("/notices", "/contact", "/error").permitAll());
		http.formLogin(Customizer.withDefaults()); // Enable
//		http.formLogin(flc -> flc.disable()); // Disables formlogin
		http.httpBasic(Customizer.withDefaults());
//		http.httpBasic(hbc -> hbc.disable()); // Disables basic authentication

		return http.build();
	}

	//inMemory User
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("user").password("{noop}12345").roles("USER").build();

		UserDetails admin = User.withUsername("admin").password("{noop}54321").roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	
}
