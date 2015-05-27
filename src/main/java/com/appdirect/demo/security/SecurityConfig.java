package com.appdirect.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .openidLogin()
                .loginPage("/login")
                .permitAll()
                .authenticationUserDetailsService(new CustomUserDetailsService())
                .attributeExchange("https://www.appdirect.com/.*")
                    .attribute("firstname")
                        .type("http://axschema.org/namePerson/first")
                        .required(true);
    }
}
