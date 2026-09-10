package com.Adarsh.learnSpringFramework;

import com.Adarsh.Spring_Game.GameRunner;
import com.Adarsh.Spring_Game.PacmanGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {

//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PacmanGame(); // 1: Object Creation

        var gameRunner = new GameRunner(game);
        //2: object creation + wiring of Dependencies
        // Game is a Dependency of GameRunner

        gameRunner.run();
    }
}
