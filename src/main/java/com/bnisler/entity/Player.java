package com.bnisler.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "player")
@NoArgsConstructor
public class Player {

//    @Id
//    @GeneratedValue(generator = "increment")
//    @GenericGenerator(name = "increment", strategy = "increment")
//    private int id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstname;
    private String lastname;
    private Date birthday;

    @Column(name = "is_active")
    private boolean isActive;
    private String email;

    @ManyToOne
    private Team team;

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", isActive=" + isActive +
                ", email='" + email + '\'' +
                ", team=" + team +
                '}';
    }
}