package com.learning.spring.boot.jdbc.tennis_player.controllers;

import com.learning.spring.boot.jdbc.tennis_player.jpa.Player;
import com.learning.spring.boot.jdbc.tennis_player.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

@RestController
public class PlayerController {

    @Autowired
    PlayerService service;

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id)
    {
       return service.getPlayer(id);
    }

    @PostMapping("/players")
    public Player createPlayer(@RequestBody Player player)
    {
        return service.createPlayer(player);
    }

    @GetMapping("/players")
    public List<Player> getPlayers()
    {
        return service.getAllPlayers();
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable int id, @RequestBody Player player)
    {
        return service.updatePlayer(id,player);
    }

    @PatchMapping("/players/{id}")
    public Player patchPlayer(@PathVariable int id, @RequestBody Map<String,Object> values)
    {
       return service.patchPlayer(id,values);
    }

    @PatchMapping("/players/{id}/titles")
    public void updateTitles(@PathVariable int id, @RequestBody int titles) {
        service.updateTitles(id, titles);
    }

    @DeleteMapping("/players/{id}")
    public String deletePlayer(@PathVariable int id)
    {
        return service.deletePlayer(id);
    }

}
