package com.visoth.businesslogin.Validate;

import javax.validation.constraints.NotEmpty;

public class ValidateUser {

    @NotEmpty()
    private String firstName;

    @NotEmpty()
    private String lastName;

    @NotEmpty()
    private String email;

    @NotEmpty()
    private String password;

    @NotEmpty()
    private String confirmPassword;

    public ValidateUser() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
