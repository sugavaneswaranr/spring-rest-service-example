package com.learning.spring.boot.jdbc.tennis_player.services;

import com.learning.spring.boot.jdbc.tennis_player.jpa.Player;
import com.learning.spring.boot.jdbc.tennis_player.spring.data.jpa.PlayerJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerService {

    PlayerJpaRepository playerJpaRepository;

    public PlayerService(PlayerJpaRepository jpaRepository)
    {
        this.playerJpaRepository = jpaRepository;
    }


    public Player createPlayer(Player player)
    {
        player.setId(0);
        return playerJpaRepository.save(player);
    }
    public Player updatePlayer(int id, Player player)
    {
        Optional<Player> tempPlayer = playerJpaRepository.findById(id);

        if(tempPlayer.isPresent())
        {
            Player p = tempPlayer.get();
            p.setBirthDate(player.getBirthDate());
            p.setName(player.getName());
            p.setNationality(player.getNationality());
            p.setTitles(player.getTitles());

            return playerJpaRepository.save(p);
        }
        else
        {
            throw new RuntimeException("Player id "+ player.getId() +" is not found");
        }



    }
    public Player getPlayer(int id)
    {
        Optional<Player> tempPlayer = playerJpaRepository.findById(id);

        if(tempPlayer.isPresent())
        {
            return tempPlayer.get();
        }
        else
        {
            throw new RuntimeException("Player id "+ id +" is not found");
        }
    }
    public List<Player> getAllPlayers()
    {
      return playerJpaRepository.findAll();
    }
    public Player patchPlayer(int id, Map<String,Object> values)
    {
        Optional<Player> tempPlayer = playerJpaRepository.findById(id);

        if(tempPlayer.isPresent())
        {
            Player p = tempPlayer.get();
            for(Map.Entry<String,Object> entry : values.entrySet())
            {
                Optional<Field> field = Optional.ofNullable(ReflectionUtils.findField(Player.class,entry.getKey()));

                field.ifPresent(f -> {
                    ReflectionUtils.makeAccessible(field.get());
                    ReflectionUtils.setField(f, p, entry.getValue());
                });
            }
           return playerJpaRepository.save(p);
        }
        else
        {
            throw new RuntimeException("Player id "+ id +" is not found");
        }

    }
    @Transactional
    public void updateTitles(int id, int titles)
    {
        playerJpaRepository.updateTitles(id,titles);
    }
    public String deletePlayer(int id)
    {
        Optional<Player> tempPlayer = playerJpaRepository.findById(id);

        if(tempPlayer.isPresent())
        {
            playerJpaRepository.delete(tempPlayer.get());
            return "Player id " + id + " was deleted successfully";
        }
        else
        {
            throw new RuntimeException("Player id "+ id +" is not found");
        }

    }
}
