package com.example.demo.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
				.requestMatchers("/notices", "/contact", "/error").permitAll());
	
		//Enabling Form Login
		http.formLogin(Customizer.withDefaults()); 
		http.httpBasic(Customizer.withDefaults());
		
		//Disabling form login
//		http.formLogin(flc -> flc.disable()); // Disables formlogin 
//		http.httpBasic(hbc -> hbc.disable()); // Disables basic authentication

		
		return http.build();
	}

	// inMemory User
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withUsername("user").password("{noop}User@12345").roles("USER").build();
//
//		UserDetails admin = User.withUsername("admin").password("{bcrypt}$2a$12$D7A.w89SIc8NsOXOcQtOg.fON1/6Q/i0u.L1sxkHFNqyDeB2ocqc6").roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(user, admin);
//	}
	
	//JDBC users
	
	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}//At this moment this method is optional if we removed it the spring security framework will add the it own encoder
	
//	@Bean
//	public CompromisedPasswordChecker compromisedPasswordChecker() {
//		return new HaveIBeenPwnedRestApiPasswordChecker();
//	}

}