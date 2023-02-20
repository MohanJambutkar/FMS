package com.example.FMS.models;

import javax.validation.constraints.NotNull;

public class CredentialModel {
    @NotNull(message = "UserName is required")
    private String name;
    @NotNull(message = "UserPassword is required")
    private String password;

    private String newPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
