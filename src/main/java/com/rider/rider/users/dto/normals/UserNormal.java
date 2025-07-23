package com.rider.rider.users.dto.normals;

import com.rider.rider.users.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserNormal {
    private String userId;
    private String email;
    private String name;
    private String phone;
    private String password;
    private String role;
    private Gender gender;
    private LocalDateTime dateOfBirth;
}
