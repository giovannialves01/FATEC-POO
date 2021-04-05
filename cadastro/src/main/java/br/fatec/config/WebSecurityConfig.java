package br.fatec.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests()
			.antMatchers("/cadastro").hasAnyRole("AuthCadastro")
			.antMatchers("/listar-clientes").hasAnyRole("AuthCadastro")
			.antMatchers("/").hasAuthority("User")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/entrar").permitAll();
		*/
	}
}
