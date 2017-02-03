package com.bnisler.entity;

import com.bnisler.util.LocalDateAttributeConverter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

import static java.time.LocalDate.now;

/**
 * Created by Ben on 2/2/2017.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    public User() {}

    public User(int id, String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dateOfBirth;

    public int calculateAge() {
        if (dateOfBirth != null) {
            return Period.between(dateOfBirth, now()).getYears();
        } else {
            return 0;
        }
    }
}
