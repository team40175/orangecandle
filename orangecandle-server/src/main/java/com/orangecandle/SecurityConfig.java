package com.orangecandle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("a").password("a")
				.authorities("USER");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("loginRequest");
	};

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http

		.authorizeRequests().anyRequest().authenticated();
		// .addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class)
		// .antMatchers(HttpMethod.OPTIONS, "*").permitAll()
		// .formLogin().loginProcessingUrl("loginRequest")
		http.httpBasic().and().csrf().disable();
		// http.sessionManagement().sessionCreationPolicy(
		//			SessionCreationPolicy.STATELESS);
	}
}
