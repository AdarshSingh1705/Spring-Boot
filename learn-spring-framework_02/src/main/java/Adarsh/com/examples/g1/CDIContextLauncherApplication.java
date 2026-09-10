package Adarsh.com.examples.g1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//@Component
@Named // replacement of Componenet
class BusinessService{
    private DataService dataService;

//    @Autowired
    @Inject  // same as Autowired or replacement of Autowired
    public void setDataService(DataService dataService){
        this.dataService = dataService;
    }

    public DataService getDataService(){
        System.out.println("Setter Injection");
        return dataService;
    }


}

//@Component
@Named
class DataService{

}

@Configuration
@ComponentScan
public class CDIContextLauncherApplication {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext
                (CDIContextLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataService());
        }

    }
}
