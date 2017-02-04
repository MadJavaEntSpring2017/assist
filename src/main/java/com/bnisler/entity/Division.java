package com.bnisler.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Ben on 2/4/2017.
 */
@Entity
@Table(name = "division")
@Getter
@Setter
@NoArgsConstructor
public class Division {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id", nullable = false)
    private League league;

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
