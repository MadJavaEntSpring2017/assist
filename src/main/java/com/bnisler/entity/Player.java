package com.bnisler.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "player")
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    private String firstname;
    private String lastname;
    private Date birthday;
    private boolean is_active;
    private String email;

    @ManyToOne
    private Team team;
}
