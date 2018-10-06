package com.valencia.sopra.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	/** INYECTAMOS NUESTRO 'UserService' EL CUAL YA TIENE INYECTADO NUESTRO 'UserRepository' */
	@Autowired
	@Qualifier("userService")
	private UserDetailsService userService;
	
	/** 
	 *  PREPARAMOS NUESTRA CLASE SECURIZADA PARA QUE USE 'BCryptPasswordEncoder' Y CONVIERTA
	 * 	EL PASSWORD INTRODUCIDO POR EL USUARIO EN EL FRONT A CIFRADO Y DE ESE MODO COINCIDA CON
	 * 	EL QUE HEMOS INTRODUCIDO EN BASE DE DATOS ENCRIPTADO POR NOSOTROS DESDE LA CLASE 'TestCrypt'
	 * 
	 * 	@param auth
	 * 
	 * 	@throws Exception
	 * 
	 */
	@Autowired
	public void ConfigureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	/** SECURIZAMOS NUESTRO LOGIN */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/*", "/imgs/*").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").loginProcessingUrl("/loginCheck")
		.usernameParameter("username").passwordParameter("password")
		.defaultSuccessUrl("/loginsucces").permitAll()
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
		.permitAll();
	}
	
	
	
	

}
