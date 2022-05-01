package com.visoth.businesslogin.Validate;

import javax.validation.constraints.NotEmpty;


@CustomPasswordAnnotation.List({
        @CustomPasswordAnnotation(first="password",second = "confirmPassword",message = "The password fields must match")
})
public class ValidateUser {

    @NotEmpty()
    private String firstName;

    @NotEmpty()
    private String lastName;

    @ValidateEmailAnnotation
    @NotEmpty()
    private String email;

    @ValidPasswordStrength
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
