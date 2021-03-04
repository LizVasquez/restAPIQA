package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class Runner {
    //hooks --> similar a before y after de junit

    @Before
    public void beforeCucumber(){
        System.out.println("******* Before Cucumber");
    }

    @After
    public void afterCucumber(){
        System.out.println("******* After Cucumber");
    }


}
