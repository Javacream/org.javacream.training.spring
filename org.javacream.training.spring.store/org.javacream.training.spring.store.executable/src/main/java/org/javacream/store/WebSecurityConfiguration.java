package org.javacream.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@SuppressWarnings("deprecation")
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails sawitzki = User.withDefaultPasswordEncoder().username("Sawitzki").password("egal").roles("user").build();
		return new InMemoryUserDetailsManager(sawitzki);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api/store/**").authenticated().and().formLogin().permitAll().and().logout().permitAll();
	}

	
}
