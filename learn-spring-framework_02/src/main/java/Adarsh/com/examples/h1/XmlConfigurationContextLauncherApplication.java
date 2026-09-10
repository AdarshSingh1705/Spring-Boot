package Adarsh.com.examples.h1;

import Adarsh.com.Spring_Game.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

// whatever we do with java configuration we can do with xml configuration, but it rarely used
public class XmlConfigurationContextLauncherApplication {

    public static void main(String[] args) {

        try(var context =
                    new ClassPathXmlApplicationContext("contextConfiguration.xml")) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));

            context.getBean(GameRunner.class).run();

        }

    }
}
