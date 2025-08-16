package com.learning.spring.boot.jdbc.tennis_player.spring.data.jpa;

import com.learning.spring.boot.jdbc.tennis_player.jpa.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerJpaRepository extends JpaRepository<Player,Integer> {

  public List<Player> findByNationalityContaining(String input);

  @Modifying
  @Query("update Player p set p.titles = :titles where p.id = :id")
  void updateTitles(@Param("id") int id, @Param("titles") int titles);
}
