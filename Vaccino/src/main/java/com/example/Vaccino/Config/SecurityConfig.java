package com.example.Vaccino.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    UserDetailsService UserDS;

    @Autowired
    JwtFilter jwtFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config ) throws Exception{
      return config.getAuthenticationManager();

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       http
               .csrf(customizer -> customizer.disable())
               .authorizeHttpRequests(request-> request.
                       requestMatchers("register","login").permitAll()
                       .anyRequest().authenticated())
               .httpBasic(Customizer.withDefaults())
               .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
       http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
               return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider DAP =  new DaoAuthenticationProvider();
        DAP.setPasswordEncoder(new BCryptPasswordEncoder(10));
        DAP.setUserDetailsService(UserDS);
        return DAP;
    }


}
