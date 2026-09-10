package com.Adarsh.learnSpringFramework;

import com.Adarsh.Spring_Game.GameRunner;
import com.Adarsh.Spring_Game.GamingConsole;
import com.Adarsh.Spring_Game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        var game = new PacmanGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

}
