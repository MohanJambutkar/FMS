package com.example.FMS.models;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserModel {
    @NotNull(message = "User Id is required")
    private long UserId;
    @NotNull(message = "Name Id is required")
    private String name;
    @NotNull(message = "Email Id is required")
    private String UserEmail;
    @NotNull(message = "Phone Number Id is required")
    private String UserPhone;
    @NotNull(message = "Password Id is required")
    private String password;
    @NotNull(message = "Age Id is required")
    private String UserAge;

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserAge() {
        return UserAge;
    }

    public void setUserAge(String userAge) {
        UserAge = userAge;
    }

}
