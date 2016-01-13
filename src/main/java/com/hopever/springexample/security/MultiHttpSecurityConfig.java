package com.hopever.springexample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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
                .withUser("admin").password("password").roles("USER", "ADMIN").and()
                .withUser("mrhop1985.blogspot.com").password("password").roles("USER");
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
                    .anyRequest().hasRole("USER").and()
                    .openidLogin().loginPage("/openIdLogin").permitAll().authenticationUserDetailsService(new CustomUserDetailsService())
                    .attributeExchange("https://www.google.com/.*")
                    .attribute("email")
                    .type("http://axschema.org/contact/email")
                    .required(true)
                    .and()
                    .attribute("firstname")
                    .type("http://axschema.org/namePerson/first")
                    .required(true)
                    .and()
                    .attribute("lastname")
                    .type("http://axschema.org/namePerson/last")
                    .required(true)
                    .and()
                    .and()
                    .attributeExchange(".*yahoo.com.*")
                    .attribute("email")
                    .type("http://axschema.org/contact/email")
                    .required(true)
                    .and()
                    .attribute("fullname")
                    .type("http://axschema.org/namePerson")
                    .required(true)
                    .and()
                    .and()
                    .attributeExchange(".*myopenid.com.*")
                    .attribute("email")
                    .type("http://schema.openid.net/contact/email")
                    .required(true)
                    .and()
                    .attribute("fullname")
                    .type("http://schema.openid.net/namePerson")
                    .required(true);
        }
    }

    @Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests().antMatchers("/resources/**", "/css/**", "/js/**", "/v*/js/**", "/v*/css/**","/images/**", "/about", "/login").permitAll()
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
