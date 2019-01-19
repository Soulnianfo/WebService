/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2;

import com.classphoto2.classphoto2.service.MyUserDetailService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author Souleymane
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailService userDetailsService;
    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
    	http.authorizeRequests()
                    .antMatchers(
                            "/",
                            "/picture",
                            "/js/**",
                            "/css/**",
                            "/img/**",
                            "/photograph",
                            "/registration",
                            "/school/accueilSchool",
                            "/api/getAllClass","/api/getClassPhotos",
                            "/webjars/**").permitAll()
                    .antMatchers("/api/**").hasRole("ADMIN")
                    .antMatchers("/school/**").hasRole("ADMIN")
                    .antMatchers("/photograph/**").hasRole("PHOTOG")
                    .antMatchers("/parent/**").hasRole("USER")
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .passwordParameter("password").usernameParameter("username").successHandler(new AuthenticationSuccessHandler() {
	                    @Override
	                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
	                            Authentication authentication) throws IOException, ServletException {
	                        redirectStrategy.sendRedirect(request, response, "/school/accueilSchool");
	                    }
	                })
                    //.failureUrl("/access-denied")
                    .permitAll()
                .and()
                .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
                .and()
                .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler);
                    http.csrf().disable();
        //http.addFilterAfter(new CsrfTokenResponseHeaderBindingFilter(), CsrfFilter.class);
                //"/school/accueilSchool"
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      
        auth.userDetailsService(userDetailsService)
               .passwordEncoder(userDetailsService.encoder)
               ;
                       //auth.inMemoryAuthentication()
                //        .withUser("user").password(passwordEncoder().encode("password")).roles("ADMIN");
           // .and()
            //    .withUser("manager").password("password").roles("MANAGER");
    }
   @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
