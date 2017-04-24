package com.bnisler.service.player;

import com.bnisler.entity.Player;
import com.bnisler.entity.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PlayerDetail {
    private String firstname;
    private String lastname;
    private Date birthday;
    private boolean active;
    private String email;
    private Team team;
    //TODO: roster


    @Override
    public String toString() {
        return "PlayerDetail{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", active=" + active +
                ", email='" + email + '\'' +
                ", team=" + team +
                '}';
    }
}
