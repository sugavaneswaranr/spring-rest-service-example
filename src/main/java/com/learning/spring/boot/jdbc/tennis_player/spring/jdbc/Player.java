package com.learning.spring.boot.jdbc.tennis_player.spring.jdbc;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Player {
    private int id;
    private String name;
    private String nationality;
    private LocalDate birthDate;
    private int titles;
}
