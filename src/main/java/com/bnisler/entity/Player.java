package com.bnisler.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "player")
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private Date birthday;

    @Column(name = "is_active")
    private boolean active;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Team team;

    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
    private List<Commit> commits;

    public List<Commit> getCommits() {
        if (commits == null) {
            commits = new ArrayList<>();
        }
        return commits;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", active=" + active +
                ", email='" + email +
                '}';
    }
}
