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
    private Long id;

    private String name;

    @Column(name = "is_active")
    private boolean active;

    @ManyToOne
    private Division division;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Player> players;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Roster> rosters;

    public List<Player> getPlayers() {
        if (players == null) {
            players = new ArrayList<>();
        }
        return players;
    }

    public List<Roster> getRosters() {
        if (rosters == null) {
            rosters = new ArrayList<>();
        }
        return rosters;
    }

    // TODO: uncomment this when security implemented
//    @OneToOne(fetch = FetchType.LAZY)
//    private Manager manager;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", division=" + division +
//                ", manager=" + manager +
                '}';
    }
}
