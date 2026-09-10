package adarsh.com.learnjpaandhibernate.course;

import adarsh.com.learnjpaandhibernate.course.SpringDataJPA.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) {

        System.out.println("Runner is executing");
        repository.save(new Course(1, "Learn AWS JPA!", "in28minutes"));
        repository.save(new Course(2, "Learn Azure JPA!", "in28minutes"));
        repository.save(new Course(3, "Learn DevOps JPA!", "in28minutes"));

        repository.deleteById(3l);

        // Build in method in DataJPA
        System.out.println(repository.findById(1l));
        System.out.println(repository.findById(2l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        // custom build using Data JPA
        System.out.println(repository.findByAuthor("in28minutes"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("Learn AWS JPA!"));
    }
}
