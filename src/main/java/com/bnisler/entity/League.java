package com.bnisler.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "league")
@Getter
@Setter
@NoArgsConstructor
public class League {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "league", fetch = FetchType.LAZY)
    @JsonManagedReference
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
