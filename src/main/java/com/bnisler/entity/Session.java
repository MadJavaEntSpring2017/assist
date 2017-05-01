package com.bnisler.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "session")
@NoArgsConstructor
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Split split;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Season season;

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", year=" + year +
                ", split=" + split +
                ", season=" + season +
                '}';
    }
}
