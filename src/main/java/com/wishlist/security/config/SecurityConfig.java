package com.wishlist.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/users/**").authenticated()
                .and()
                .formLogin()
                .usernameParameter("mail")
                .defaultSuccessUrl("/users/1")
                .loginPage("/login")
        ;*/
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
                .and()
                .authorizeRequests()
                .antMatchers("/users/**").authenticated()
                //.antMatchers("/api/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .usernameParameter("mail")
                //.successHandler(mySuccessHandler)
                //.failureHandler(myFailureHandler)
          //      .and()
        //        .logout()
        ;

        // http.csrf().disable();

        /* http.authorizeRequests()
                .antMatchers("/users/**").authenticated();
                //.antMatchers("/login").permitAll();
                //.formLogin();
                //.loginPage("/login");*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
