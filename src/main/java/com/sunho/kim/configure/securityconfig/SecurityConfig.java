package com.sunho.kim.configure.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity // 시큐리티 기능을 활성화한다.
@Configuration
public class SecurityConfig {

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     // 아래의 내용은 모든 요청에 대한 설정
    //     http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
    //             // .formLogin(Customizer.withDefaults());
    //             .formLogin(form -> form
    //                     // .loginPage("/loginPage")
    //                     .loginProcessingUrl("/loginProc")
    //                     .defaultSuccessUrl("/", true) //true면 /, false면 사용자가 요청보낸 곳으로 보낸다.
    //                     .failureUrl("/faild").usernameParameter("user")
    //                     .passwordParameter("pwd")
    //                     //아래 내용의 위의 내용보다 우선 시 된다.
    //                     .successHandler((request, response, authentication) -> {
    //                         System.out.println("authentication : " + authentication);
    //                         response.sendRedirect("/home");
    //                     }).failureHandler((request, response, exception) -> {
    //                         System.out.println("exception : " + exception);
    //                         response.sendRedirect("/faild");
    //                     }).permitAll());
    //     return http.build();
    // }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//
//        return http.authorizeHttpRequests(a -> a.anyRequest().authenticated())
//        // .httpBasic(Customizer.withDefaults()).build();
//        .httpBasic(basic -> basic.authenticationEntryPoint(new CustomAuthenticationEntryPoint())).build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(User.withUsername("user").password("{noop}1111").roles("USER").build()
//        // User.withUsername("sunho").password("{noop}2222").roles("USER").build());
//        );
//    }
}
