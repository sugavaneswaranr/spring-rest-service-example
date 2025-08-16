package com.learning.spring.boot.jdbc.tennis_player;

import com.learning.spring.boot.jdbc.tennis_player.jpa.Player;
import com.learning.spring.boot.jdbc.tennis_player.jpa.PlayerRepository;
import com.learning.spring.boot.jdbc.tennis_player.spring.data.jpa.PlayerJpaRepository;
import com.learning.spring.boot.jdbc.tennis_player.spring.jdbc.PlayerDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(TennisPlayerApplication.class);

//	@Autowired
//	PlayerDAO playerDAO;
//
//	@Autowired
//	PlayerRepository playerRepository;
//
//	@Autowired
//	PlayerJpaRepository playerJpaRepository;

	public static void main(String[] args) {

		SpringApplication.run(TennisPlayerApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {

		/*
			Spring JDBC Methods

		 */

//		logger.info("Inserting Player 4: {}", playerDAO.insertPlayer(new Player(4, "Thiem", "Austria", LocalDate.now(),17)));
//
//		logger.info("Updating Player with Id 4: {}",  playerDAO.updatePlayer(
//				new Player(4, "Thiem", "Austria",
//						LocalDate.of(1993,12,31), 17)));
//
//		logger.info("Result of getAllPlayers {}", playerDAO.getAllPlayers());
//
//		logger.info("Deleting Player with Id 2: {}", playerDAO.deletePlayerById(2));
//
//		logger.info("Result of getAllPlayers {}", playerDAO.getAllPlayers());
//
//		logger.info("Result of getPlayerById {}", playerDAO.getPlayerById(3));
//
//		logger.info("USA Players: {}", playerDAO.getPlayerByNationality("USA"));
//
//		playerDAO.createTournamentTable();


		/*
		   Java/Jakarta EE JPA Methods
		 */

		// insert players
//		logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
//				new com.learning.spring.boot.jdbc.tennis_player.jpa.Player("Djokovic", "Serbia", LocalDate.parse("1987-05-22"), 81)));
//		logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
//				new com.learning.spring.boot.jdbc.tennis_player.jpa.Player("Monfils", "France", LocalDate.parse("1986-09-01"), 10)));
//		logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(new com.learning.spring.boot.jdbc.tennis_player.jpa.Player("Thiem", "Austria", LocalDate.now(), 17)));
//
//		// select player
//		logger.info("\n\n>> Player with id 2: {}\n", playerRepository.getPlayerById(2));
//
//		//update player
//		logger.info("\n\n>> Updating Player with Id 3: {}\n", playerRepository.updatePlayer(new com.learning.spring.boot.jdbc.tennis_player.jpa.Player(3, "Thiem", "Austria", LocalDate.parse("1993-09-03"), 17)));
//
//		//get player
//		logger.info("\n\n>> Player with id 3: {}\n", playerRepository.getPlayerById(3));
//
//		//delete player
//		playerRepository.deletePlayerById(2);




		/*
			Spring Data JPA
		 */

//		playerJpaRepository.save(new com.learning.spring.boot.jdbc.tennis_player.jpa.Player("Djokovic", "Serbia", LocalDate.parse("1987-05-22"), 81));
//		playerJpaRepository.save(new com.learning.spring.boot.jdbc.tennis_player.jpa.Player("Monfils", "France", LocalDate.parse("1986-09-01"), 10));
//		playerJpaRepository.save(new com.learning.spring.boot.jdbc.tennis_player.jpa.Player("Thiem", "Austria", LocalDate.now(), 17));
//
//		logger.info("\n\n>> Player with id 2: {}\n", playerJpaRepository.findAll());
//
//		List<Player> players = playerJpaRepository.findByNationalityContaining("Au");
//
//		System.out.println(players.size());
	}
}
