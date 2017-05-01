package com.bnisler.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "split")
@NoArgsConstructor
public class Split {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "split", fetch = FetchType.LAZY)
    private List<Session> sessions;

    public List<Session> getSessions() {
        if (sessions == null) {
            sessions = new ArrayList<>();
        }
        return sessions;
    }

    @Override
    public String toString() {
        return "Split{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
