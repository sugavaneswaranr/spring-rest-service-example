package com.learning.spring.boot.jdbc.tennis_player.jpa;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
//@Table(name="jpa_player")
@NamedQuery(name="get_all_players",query = "select p from Player p")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nationality;
    private LocalDate birthDate;
    private int titles;

    public Player(String name,String nationality, LocalDate birthDate, int titles)
    {
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;
    }
}
