package sg.edu.nus.iss.ibfb4ssfassessment.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class Login {

    @NotNull (message = "Please enter email")
    @NotEmpty (message = "Please enter email")
    @Email(message = "Please enter a valid email :(")
    private String email;

    //format yyyy-mm-dd, cannot be current or future date
    @NotNull (message = "Please enter Date Of Birth")
    @Past (message = "Are you from the future?")
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date birthDate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
}
