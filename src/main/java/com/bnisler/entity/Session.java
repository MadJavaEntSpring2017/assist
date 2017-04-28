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

    @OneToOne(fetch = FetchType.LAZY)
    private Split split;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Season season;

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", split=" + split +
                ", season=" + season +
                '}';
    }
}
