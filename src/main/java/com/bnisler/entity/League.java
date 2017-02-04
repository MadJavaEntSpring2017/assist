package com.bnisler.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Ben on 2/4/2017.
 */
@Entity
@Table(name = "league")
@Data
@NoArgsConstructor
public class League {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    private String name;
}
