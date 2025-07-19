package com.rider.rider.users.dto.responses;

public class UserSigninResponse {
    private final String token;

    public UserSigninResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
