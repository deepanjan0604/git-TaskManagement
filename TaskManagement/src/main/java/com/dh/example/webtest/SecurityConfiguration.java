
package com.dh.example.webtest;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource datasource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().and().authorizeRequests().antMatchers("/public/**").permitAll().antMatchers("/admin/**")
				.access("hasRole('ADMIN')").antMatchers("/public/**").access("hasRole('USER')").and().logout()
				.and().csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		

	auth.jdbcAuthentication()
				.dataSource(datasource)
				.usersByUsernameQuery("select username, password, enabled from user_details where username=?")
				.authoritiesByUsernameQuery("select username, authority from authority where username=?");
//				.rolePrefix("");

		
		/*auth.inMemoryAuthentication().withUser("admin").password("admin")
		.roles("ADMIN", "USER");*/
	}
}
