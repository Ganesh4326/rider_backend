package com.rider.rider.users.service;

import com.rider.rider.users.entity.User;
import com.rider.rider.users.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UUID saveUser() {
        User user = new User();
        User savedUser = this.userRepository.save(user);
        return savedUser.getId();
    }

    public Optional<User> getUserById(UUID userId) {
        return this.userRepository.findById(userId);
    }

//    @Autowired
//    @Lazy
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByName(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(), user.getPassword(),
//                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
//        );
//    }
//
//    public UserSignupResponse registerUser(UserSignupRequest userRegisterRequest) {
//        User user = new User();
//        user.setName(userRegisterRequest.getUsername());
//        user.setEmail(userRegisterRequest.getEmail());
//        user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));
//        User savedUser = userRepository.save(user);
//        return new UserSignupResponse(savedUser.getId().toString());
//    }
}
