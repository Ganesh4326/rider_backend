//package com.rider.rider.auth.config;
//
//import com.rider.rider.auth.filter.JwtFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
////spring security configuration class
////url access rules, JWT filter, password encoding, session policy, auth manager
////@Configuration -> spring will access it at startup
//
////Request → SecurityConfig → JwtFilter → JwtUtil → UserService (if needed) → Controller
//
//@Configuration
//public class SecurityConfig {
//
//    private JwtFilter jwtFilter;
//
//    public SecurityConfig(JwtFilter jwtFilter) {
//        this.jwtFilter = jwtFilter;
//    }
//
//    //which urls are secured and which filters are applied
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        //disables CSRF protection(need for browser based apps not for REST apis)
//        //removing filter chain for some end points, other apis need valid JWT token
//        //marks app as stateless(no session will be stored) and every request must carry JWT
//        //Check JWT token, Authenticate user, Set it in the security context before UsernamePasswordAuthenticationFilter.
//        httpSecurity.csrf().disable().authorizeHttpRequests(auth ->
//                        auth.requestMatchers(
//                                        "/user/signup",
//                                        "/user/signin",
//                                        "/swagger-ui/**",
//                                        "/v3/api-docs/**"
//                                ).permitAll()
//                                .anyRequest().authenticated())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//        return httpSecurity.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
//}
