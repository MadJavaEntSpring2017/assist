package com.bnisler.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
@Getter
@Setter
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    private String name;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    private Division division;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Player> players;

    public List<Player> getPlayers() {
        if (players == null) {
            players = new ArrayList<>();
        }
        return players;
    }

    // TODO: uncomment this when security implemented
//    @OneToOne(fetch = FetchType.LAZY)
//    private Manager manager;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", division=" + division +
//                ", manager=" + manager +
                '}';
    }
}
