package com.rider.rider.users.dto.requests;

import com.rider.rider.users.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignupRequest {
    private String email;
    private String name;
    private String phone;
    private String password;
}
