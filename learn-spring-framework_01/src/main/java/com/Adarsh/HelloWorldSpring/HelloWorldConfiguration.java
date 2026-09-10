package com.Adarsh.HelloWorldSpring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address){};
record Address (String firstLine, String city){};
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "Adarsh";
    }

    @Bean
    public int age(){
        return 21;
    }

    @Bean
    public Person person(){
         return new Person("Ravi", 20, new Address("Main Street", "Utrecht"));
    }

    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address()); //name , age
    }

    @Bean
    public Person person3Parameter(String name, int age, Address address3 ){ // name, age, address2
        return new Person(name, age, address3); //name , age
    }
    @Bean
    @Primary
    public Person person4Parameter(String name, int age, Address address){ // name, age, address2
        return new Person(name, age, address); //name , age
    }
    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3Qualifier") Address address){ // name,
        //name, age, address2
        return new Person(name, age, address); //name , age
    }
    @Bean(name = "address2")
    @Primary
    public Address address(){
        return new Address("Baker Street", "London");
    }

    @Bean(name = "address3")
    @Qualifier("address3Qualifier")
    public Address address3(){
        return new Address("Motinagar", "Hyderabad");
    }

}
