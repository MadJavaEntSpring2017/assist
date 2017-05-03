package com.bnisler.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "roster")
@NoArgsConstructor
public class Roster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Team team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Session session;

    @OneToMany(mappedBy = "roster", fetch = FetchType.LAZY)
    private List<Commit> commits;

    public List<Commit> getCommits() {
        if (commits == null) {
            commits = new ArrayList<>();
        }
        return commits;
    }

    public void removeCommits(List<Commit> commits) {
        if (this.commits != null && this.commits.size() > 0) {
            this.commits.removeAll(commits);
        }
    }

    public void addCommit(Commit commit) {
        if (this.commits == null) {
            this.commits = new ArrayList<>();
        }
        this.commits.add(commit);
    }

    @Override
    public String toString() {
        return "Roster{" +
                "id=" + id +
                ", team=" + team +
                ", session=" + session +
                '}';
    }
}
