package com.rider.rider.users.dto.responses;

public class UserSignupResponse {
    private String userId;

    public UserSignupResponse(String id) {
        this.userId = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
