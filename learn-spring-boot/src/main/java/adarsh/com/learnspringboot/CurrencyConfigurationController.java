package adarsh.com.learnspringboot;

// courses
// Course: id, name, author

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguration configuration;
    // /courses
    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration retriveAllCourses(){
        return configuration;
    }
}
