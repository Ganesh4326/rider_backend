package com.rider.rider.users.utils.mapper;


import com.rider.rider.users.dto.normals.UserNormal;
import com.rider.rider.users.entity.User;

import java.util.UUID;

public class UserMapper {

    public static UserNormal toNormal(User user) {
        if (user == null) return null;

        UserNormal normal = new UserNormal();
        normal.setUserId(user.getId().toString());
        normal.setEmail(user.getEmail());
        normal.setName(user.getName());
        normal.setPhone(user.getPhone());
        normal.setPassword(user.getPassword());
        normal.setRole(user.getRole());
        normal.setGender(user.getGender());
        normal.setDateOfBirth(user.getDateOfBirth());

        return normal;
    }

    public static User toEntity(UserNormal normal) {
        if (normal == null) return null;

        User user = new User();
        if (normal.getUserId() != null) {
            user.setId(UUID.fromString(normal.getUserId()));
        }
        user.setEmail(normal.getEmail());
        user.setName(normal.getName());
        user.setPhone(normal.getPhone());
        user.setPassword(normal.getPassword());
        user.setRole(normal.getRole());
        user.setGender(normal.getGender());
        user.setDateOfBirth(normal.getDateOfBirth());

        return user;
    }
}
