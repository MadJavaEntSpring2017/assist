package com.bnisler.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
    private boolean is_active;

    @ManyToOne
    private Division division;

    // TODO: uncomment this when security implemented
//    @OneToOne(fetch = FetchType.LAZY)
//    private Manager manager;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", is_active=" + is_active +
                ", division=" + division +
//                ", manager=" + manager +
                '}';
    }
}
