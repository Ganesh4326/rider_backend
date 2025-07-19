//package com.rider.rider.users.controller;
//
//import com.rider.rider.auth.util.JwtUtil;
//import com.rider.rider.users.dto.requests.UserSigninRequest;
//import com.rider.rider.users.dto.responses.UserSigninResponse;
//import com.rider.rider.users.dto.requests.UserSignupRequest;
//import com.rider.rider.users.dto.responses.UserSignupResponse;
//import com.rider.rider.users.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @GetMapping("/profile")
//    public String profile() {
//        return "Welcome to your profile!";
//    }
//
//    @GetMapping("/details")
//    public UserDetails getUserByUserEmail(@RequestParam String email) {
//        UserDetails userDetails = userService.loadUserByUsername(email);
//        return userDetails;
//    }
//
//    @PostMapping(value = "/signup", produces = "application/json")
//    public UserSignupResponse register(@RequestBody UserSignupRequest userRegisterRequest) {
//        UserSignupResponse userSignupResponse = userService.registerUser(userRegisterRequest);
//        return userSignupResponse;
//    }
//
//    @PostMapping("/signin")
//    public UserSigninResponse login(@RequestBody UserSigninRequest userSigninRequest) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userSigninRequest.getEmail(), userSigninRequest.getPassword()));
//        String token = jwtUtil.generateToken(userSigninRequest.getEmail());
//        System.out.print("Token: " + token);
//        return new UserSigninResponse(token);
//    }
//}
