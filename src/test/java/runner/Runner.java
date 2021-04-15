package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"},
        glue = {"steps", "hooks"},
        features = {"src/test/resources/features/login.feature"},
        dryRun = false,
        stepNotifications = true
)


public class Runner {

}
