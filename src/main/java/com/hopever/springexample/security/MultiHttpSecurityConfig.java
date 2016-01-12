package com.hopever.springexample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.openid.OpenIDLoginConfigurer;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * Created by huodh on 1/11/16.
 */
@EnableWebSecurity
public class MultiHttpSecurityConfig {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/api/**").antMatcher("/rest/**")
                    .authorizeRequests()
                    .anyRequest().hasRole("USER").and()
                    .httpBasic();
        }
    }

    @Configuration
    @Order(2)
    public static class SimpleTestWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/simple/**")
                    .authorizeRequests()
                    .anyRequest().hasRole("USER").withObjectPostProcessor(new ObjectPostProcessor<OpenIDLoginConfigurer>() {
                public <O extends OpenIDLoginConfigurer> O postProcess(
                        O fsi) {
                    //fsi.
                    //sth need to do
                    return fsi;
                }
            }).and()
                    .openidLogin();
        }
    }

    @Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests().antMatchers("/resources/**", "/css/**", "/js/**", "/v*/js/**", "/v*/css/**", "/about", "/login").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                    .anyRequest().authenticated().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                public <O extends FilterSecurityInterceptor> O postProcess(
                        O fsi) {
                    fsi.setPublishAuthorizationSuccess(true);
                    return fsi;
                }
            }).and()
                    .formLogin()
                    .loginPage("/login");
            http.logout().logoutSuccessUrl("/index").invalidateHttpSession(true);
        }
    }
}
