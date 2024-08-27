package com.example.ss_2022_c7_e1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
// @PreAuthorize @PostAuthorize @PreFilter @PostFilter
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.httpBasic()
        .and()
        .authorizeRequests().anyRequest().authenticated()
        .and().build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails u1 = User.withUsername("john")
        .password(passwordEncoder().encode("12345"))
        .authorities("read")
        .build();

    UserDetails u2 = User.withUsername("bill")
        .password(passwordEncoder().encode("12345"))
        .authorities("write")
        .build();

    return new InMemoryUserDetailsManager(List.of(u1, u2));
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();  // NoOpPasswordEncoder ---> marked as deprecated because you can ONLY use it in demos.
  }
}
