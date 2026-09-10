package adarsh.com.learnspringboot;

// courses
// Course: id, name, author

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    // /courses
    @RequestMapping("/courses")
    public List<Course> retriveAllCourses(){
        return Arrays.asList(
                new Course(1, "Learn AWS", "in28mintues"),
                new Course(2, "Learn DevOps", "in28minutes"),
                new Course(3, "Learn ML", "in28minutes"),
                new Course(4, "Learn FullStack", "in28minutes"),
                new Course(5, "Learn Docker", "in28minutes"),
                new Course(6, "Learn DataBase", "in28minutes")


        );
    }
}
