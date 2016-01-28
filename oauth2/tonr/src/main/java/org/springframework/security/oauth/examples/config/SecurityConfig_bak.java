package org.springframework.security.oauth.examples.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
//@EnableOAuth2Sso
public class SecurityConfig_bak extends WebSecurityConfigurerAdapter {

//	@Autowired
//	protected void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("marissa").password("wombat").roles("USER").and().withUser("sam")
//				.password("kangaroo").roles("USER");
//	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**","/**/*.css","/**/*.js");
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
				.authorizeRequests()
				.anyRequest().authenticated().and().csrf().disable();
    	// @formatter:on
	}

}
