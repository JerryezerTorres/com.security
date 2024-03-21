/*package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
            	.antMatchers(resources).permitAll()
            	.antMatchers("/public/**").permitAll()
            	.antMatchers("/").permitAll()
            	.antMatchers("/views/user/create").permitAll()
            	.antMatchers("/views/pet/create").permitAll()
            	.antMatchers("/views/service/aboutUs").permitAll()
            	.antMatchers("/views/user/login").permitAll()
            	
            	
            	.antMatchers("/views/admin/admin").permitAll()
            	.antMatchers("/views/user/userList").permitAll()
            	
                .antMatchers("/views/service/bookAppointment").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/views/user/login")
                .defaultSuccessUrl("/") 
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}

*/