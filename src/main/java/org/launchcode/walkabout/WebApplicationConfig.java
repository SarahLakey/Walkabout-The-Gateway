package org.launchcode.walkabout;

import org.launchcode.walkabout.controllers.AuthenticationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class WebApplicationConfig implements WebMvcConfigurer {

    @Autowired
    AuthenticationController authenticationController;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/", "/register", "/login",
                                        "/styles.css", "/images/**", "/index", "/static/**", "/fragments").permitAll()
                                .anyRequest().authenticated())


//                .formLogin(withDefaults())
                .formLogin(form->form
                        .loginPage("/login").permitAll())
//                .oauth2Login(withDefaults())

                .build();
    }

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(
//                        auth -> auth
//                                .requestMatchers("/").permitAll()
//                                .requestMatchers("/static/**").permitAll()
//                                .requestMatchers("/images/**").permitAll()
//                                .requestMatchers("/css/**").permitAll()
//                                .anyRequest().authenticated())
//
//                .formLogin(withDefaults())
////                .formLogin(form->form
////                        .loginPage("/login").permitAll())
//                .oauth2Login(withDefaults())
//
//
//
//                .build();
//    }

    @Bean
    public AuthenticationFilter authenticationFilter() {
        return new AuthenticationFilter();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationFilter());
    }

}
