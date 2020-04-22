package fr.pops.gbfRando.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().
        withUser("pops").password("{noop}0000").roles("USER");   
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/charaForm").hasRole("USER")
			.and()
			.authorizeRequests().antMatchers("/logout").anonymous().and()
			.formLogin().loginPage("/login").defaultSuccessUrl("/charaForm").failureUrl("/login")
			.and().logout().invalidateHttpSession(true).logoutUrl("/logout").logoutSuccessUrl("/").permitAll()
			.and().csrf().disable();
	}
}
