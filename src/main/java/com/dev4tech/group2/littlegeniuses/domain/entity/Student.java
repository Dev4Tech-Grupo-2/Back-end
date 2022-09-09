package com.dev4tech.group2.littlegeniuses.domain.entity;

import com.dev4tech.group2.littlegeniuses.api.dto.StudentDTO;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "fees", nullable = false)
    private BigDecimal fees;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "state", nullable = false)
    private String state;

    public Student(StudentDTO student) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return id != null && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
