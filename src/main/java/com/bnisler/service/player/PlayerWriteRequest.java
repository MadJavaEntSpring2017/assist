package com.bnisler.service.player;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PlayerWriteRequest {
    private String firstname;
    private String lastname;
    private Date birthday;
    private boolean isActive;
    private String email;
    private int teamId;
}
