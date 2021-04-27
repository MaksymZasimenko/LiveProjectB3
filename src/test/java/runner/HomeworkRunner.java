package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/Homework.html", "json:target/Homework.json"},
        glue = {"steps", "hooks"},
        features = {"src/test/resources/features/homework.feature"},
        dryRun = false,
        tags = {"@BCAMP-6"},
        stepNotifications = true
)


public class HomeworkRunner {

}