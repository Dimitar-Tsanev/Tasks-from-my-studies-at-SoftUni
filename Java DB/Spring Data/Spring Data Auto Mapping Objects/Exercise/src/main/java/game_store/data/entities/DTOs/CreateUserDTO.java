package game_store.data.entities.DTOs;

import game_store.data.entities.annotations.Password;
import jakarta.validation.constraints.Email;

public class CreateUserDTO {

    @Email(message = "Incorrect email.",
            regexp = "[A-Za-z0-9-_.]+@[A-Za-z0-9-_.]+.[A-Za-z]+$")
    private String email;

    @Password(minLength = 6,
            constraintDigit = true,
            constraintLowercase = true,
            constraintUppercase = true
    )
    private String password;

    private String confirmPassword;

    private String fullName;

    private boolean isAdmin;

    public boolean isAdmin () {
        return isAdmin;
    }

    public void setAdmin ( boolean admin ) {
        this.isAdmin = admin;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getPassword () {
        return password;
    }

    public CreateUserDTO ( String email, String password, String confirmPassword, String fullName ) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getConfirmPassword () {
        return confirmPassword;
    }

    public void setConfirmPassword ( String confirmPassword ) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName () {
        return fullName;
    }

    public void setFullName ( String fullName ) {
        this.fullName = fullName;
    }
}
