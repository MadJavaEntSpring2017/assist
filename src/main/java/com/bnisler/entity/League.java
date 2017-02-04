package com.bnisler.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 2/4/2017.
 */
@Entity
@Table(name = "league")
@Getter
@Setter
@NoArgsConstructor
public class League {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "league")
    private List<Division> divisions;

    public List<Division> getDivisions() {
        if (divisions == null) {
            divisions = new ArrayList<>();
        }
        return divisions;
    }

    @Override
    public String toString() {
        return "League{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
