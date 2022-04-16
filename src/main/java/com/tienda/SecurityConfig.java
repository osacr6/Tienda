/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author INFORMATECH
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin")
                .password("{noop}123")
                .roles("ADMIN", "VENDOR", "USER")
            .and()
            .withUser("vendor")
                .password("{noop}123")
                .roles("VENDOR", "USER")
            .and()
            .withUser("user")
                .password("{noop}123")
                .roles("USER");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(
                "/articulo/nuevo",
                "/persona/guardar"
            ).hasRole("ADMIN")
            .antMatchers(
                "/articulo/nuevo",
                "/persona/guardar"
            ).hasAnyRole("ADMIN", "VENDOR")
            .antMatchers(
                "/"
            ).hasAnyRole("ADMIN", "VENDOR", "USER")
            .and()
                .formLogin()
                .loginPage("/login")
            .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
