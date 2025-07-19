//package com.rider.rider.auth.filter;
//
//import com.rider.rider.auth.util.JwtUtil;
//import com.rider.rider.users.service.UserService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    @Lazy
//    private JwtUtil jwtUtil;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        final String authHeader = request.getHeader("Authorization");
//
//        String username = null;
//
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            String token = authHeader.substring(7);
//            username = jwtUtil.extractUsername(token);
//        }
//
//        //condition checking for valid token and no other user authorized(avoids re-authenticating)
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = userService.loadUserByUsername(username);
//
//            //creating Spring Security Authentication Token
//            //(principal -> who the user is, credentials -> not need as already verified JWT, authorities-> roles and responsibilities)
//            UsernamePasswordAuthenticationToken authToken =
//                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//
//            //tells this request and user is authenticated
//            //you can access authToken anywhere using getAuthentication method(logged-in user details)
//            SecurityContextHolder.getContext().setAuthentication(authToken);
//        }
//        filterChain.doFilter(request, response);
//    }
//}
