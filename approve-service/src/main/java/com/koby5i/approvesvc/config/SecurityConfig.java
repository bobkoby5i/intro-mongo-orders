package com.koby5i.approvesvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


//@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true)
//@Order(SecurityProperties.BASIC_AUTH_ORDER)
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableWebSecurity
@ComponentScan
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/**").permitAll()
                .antMatchers("/css/**", "/index").permitAll()
                .antMatchers("/**").permitAll()
                .anyRequest().permitAll()
                //.anyRequest().authenticated()
                .and()
                .formLogin()
                //.loginPage("/login")
                //.permitAll()
                .and()
                .logout();
                //.and().anyRequest().authenticated();
//                .logoutSuccessUrl("/login?logout")
//                .permitAll();
        //.loginPage("/login").failureUrl("/login-error");
    }



    //use=user
    //password=secret123
    //encodedPassword='$2a$10$AIUufK8g6EFhBcumRRV2L.AQNz3Bjp7oDQVFiO5JJMBFZQ6x2/R/2'
    //password='password
    //encodedPassword='$2a$10$Uquje0jeqhm0kzRFv1pqu.6DPS2dijCg2MTOP3ubOBPtXtIopoqrC'

    private static final String USER_ENCODED_PASSWORD = "$2a$10$AIUufK8g6EFhBcumRRV2L.AQNz3Bjp7oDQVFiO5JJMBFZQ6x2/R/2";

    //@Autowired
    //DataSource dataSource;

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        String password = "password";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        System.out.printf("encodedPassword('%s')='%s'%n", password, encodedPassword );

        // users stored in DB
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

//    public PasswordEncoder getPasswordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

