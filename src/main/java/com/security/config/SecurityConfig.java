package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;	 
	
	String[] resources = new String[]{ "/include/**","/css/**","/icons/**","/images/**","/js/**" };
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            .antMatchers("/").permitAll()
	            .antMatchers(resources).permitAll()
	            .antMatchers("/views/user/create").permitAll()
	            .antMatchers("/views/user/creater").permitAll()
	            .antMatchers("/views/service/aboutUs").permitAll()
	            .antMatchers("/views/service/bookAppointment").permitAll()
	            .anyRequest().authenticated()
	         .and()
	        .formLogin() .permitAll()
	            .loginPage("/views/user/login")
	            .defaultSuccessUrl("/")
	            .permitAll()
	            .and()
	        .logout()
	            .logoutUrl("/logout")
	          //  .logoutSuccessUrl("/")
	            .logoutSuccessUrl("/login?logout")
	            .permitAll();
	}
   
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }


    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
}

