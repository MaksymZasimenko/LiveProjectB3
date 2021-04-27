package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/LoginPage.html", "json:target/LoginPage.json"},
        glue = {"steps", "hooks"},
        features = {"src/test/resources/features/login.feature"},
        dryRun = false,
        stepNotifications = true
)


public class LoginRunner {

}
