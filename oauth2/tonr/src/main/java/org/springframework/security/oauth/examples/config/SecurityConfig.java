package org.springframework.security.oauth.examples.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	protected void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("marissa").password("wombat").roles("USER").and().withUser("sam")
				.password("kangaroo").roles("USER");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**","/**/*.css","/**/*.js");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
				.authorizeRequests()
				.anyRequest().hasRole("USER")
				.and()
				.exceptionHandling()
				.accessDeniedPage("/login.jsp?authorization_error=true")
				.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login.jsp")
				.and()
				.formLogin()
				.loginProcessingUrl("/login")
				.loginPage("/login.jsp").permitAll();
    	// @formatter:on
	}

}
