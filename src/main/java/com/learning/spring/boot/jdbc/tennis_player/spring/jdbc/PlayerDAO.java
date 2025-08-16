package com.learning.spring.boot.jdbc.tennis_player.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PlayerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final class PlayerMapper implements RowMapper<Player>
    {

        @Override
        public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player player = new Player();
            player.setId(rs.getInt("id"));
            player.setName(rs.getString("name"));
            player.setNationality(rs.getString("nationality"));
            player.setBirthDate(rs.getDate("birth_date").toLocalDate());
            player.setTitles(rs.getInt("titles"));

            return player;
        }
    }

    public List<Player> getPlayerByNationality(String nationality)
    {
        String sql = "SELECT * FROM PLAYER WHERE NATIONALITY = ?";
        return jdbcTemplate.query(sql,new PlayerMapper(),new Object[] {nationality});
    }


    public List<Player> getAllPlayers()
    {
        String query = "SELECT * FROM PLAYER";
        return jdbcTemplate.query(query,new BeanPropertyRowMapper<Player>(Player.class));
    }

    public Player getPlayerById(int id)
    {
        String query = "SELECT * FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<Player>(Player.class), new Object[] {id});
    }

    public int insertPlayer(Player player)
    {
        String query = "INSERT INTO PLAYER (ID, Name, Nationality,Birth_date, Titles) " +
                                                                            "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query,new Object[] { player.getId(), player.getName(), player.getNationality(), player.getBirthDate(), player.getTitles() });
    }

    public int updatePlayer(Player player)
    {
        String sql = "UPDATE PLAYER " +
                "SET Name = ?, Nationality = ?, Birth_date = ? , Titles = ? " +
                "WHERE ID = ?";

        return jdbcTemplate.update( sql, new Object[] {
                player.getName(),
                player.getNationality(),
                player.getBirthDate(),
                player.getTitles(),
                player.getId() }
        );
    }

    public int deletePlayerById(int id)
    {
        String sql="DELETE FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[] {id});
    }

    public void createTournamentTable() {
        String sql = "CREATE TABLE TOURNAMENT (ID INTEGER, NAME VARCHAR(50), LOCATION VARCHAR(50), PRIMARY KEY (ID))";
        jdbcTemplate.execute(sql);
        System.out.println("Table created");
    }
}

