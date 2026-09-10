package Adarsh.com.examples.c1;

import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Component
@Service
public class BusinessCalculationService {

    private DataService dataService;

    public BusinessCalculationService (DataService dataService){
        super();
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retriveData()).max().orElse(0);
    }
}
