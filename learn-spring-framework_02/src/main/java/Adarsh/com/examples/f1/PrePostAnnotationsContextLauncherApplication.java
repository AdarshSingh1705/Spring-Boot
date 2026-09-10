package Adarsh.com.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{

    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency){
        super();
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready");
    }

    // @PostConstruct runs after Spring creates the bean and finishes dependency injection
    // when you need to initialize things that depend on injected fields, like:
    // opening resources
    // loading cache data
    // validating configuration
    @PostConstruct
    public void intialize(){
        someDependency.getReady();
    }

//@PreDestroy runs just before the bean is removed from the container.
// Use @PreDestroy when you need to clean up before shutdown, like:
//    closing connections
//    stopping threads
//    releasing files or sockets
    @PreDestroy
    public void cleanup(){
        System.out.println("Clean-up");
    }
}

@Component
class  SomeDependency{

    public void getReady(){
        System.out.println("Some logic using SomeDependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext
                (PrePostAnnotationsContextLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }

    }
}
