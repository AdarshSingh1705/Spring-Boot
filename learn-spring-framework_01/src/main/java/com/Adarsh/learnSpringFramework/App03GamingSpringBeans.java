package com.Adarsh.learnSpringFramework;

import com.Adarsh.Spring_Game.GameRunner;
import com.Adarsh.Spring_Game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext
                (GamingConfiguration.class)) {

            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }

    }
}
