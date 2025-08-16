package com.learning.spring.boot.jdbc.tennis_player.exceptions;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String message)
    {
        super(message);
    }

    public PlayerNotFoundException(String message, Throwable throwable)
    {
        super(message,throwable);
    }

    public PlayerNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
