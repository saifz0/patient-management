package com.pm.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PatientUpdateRequestDTO {

    @Size(max = 100, message = "Name cannot exceed 100 characters")
    @Pattern(regexp = ".*\\S.*", message = "Name must not be blank")
    private String name;

    @Email(message = "Email should be valid")
    @Pattern(regexp = ".*\\S.*", message = "Email must not be blank")
    private String email;

    @Pattern(regexp = ".*\\S.*", message = "Address must not be blank")
    private String address;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date of birth must be in yyyy-MM-dd format")
    private String dateOfBirth;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
