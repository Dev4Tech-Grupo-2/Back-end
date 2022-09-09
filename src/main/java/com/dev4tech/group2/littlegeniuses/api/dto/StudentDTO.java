package com.dev4tech.group2.littlegeniuses.api.dto;

import com.dev4tech.group2.littlegeniuses.domain.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @NotBlank
    private String email;

    @NotNull
    @Positive
    private BigDecimal fees;

    @NotBlank
    private String street;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String state;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.phone = student.getPhone();
        this.email = student.getEmail();
        this.fees = student.getFees();
        this.street = student.getStreet();
        this.city = student.getCity();
        this.country = student.getCountry();
        this.postalCode = student.getPostalCode();
        this.state = student.getState();
    }

}
