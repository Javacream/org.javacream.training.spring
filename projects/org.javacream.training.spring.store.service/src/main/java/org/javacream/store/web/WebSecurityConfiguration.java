package org.javacream.store.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@SuppressWarnings("deprecation")
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails sawitzki = User.withDefaultPasswordEncoder().username("Sawitzki").password("egal").roles("USER").build();
		UserDetails guest = User.withDefaultPasswordEncoder().username("Mustermann").password("egal").roles("GUEST").build();
		return new InMemoryUserDetailsManager(sawitzki, guest);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api/store/**").authenticated().and().formLogin().permitAll().and().logout().permitAll();
	}


}