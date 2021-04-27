package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/MeetingLinks.html", "json:target/MeetingLinks.json"},
        glue = {"steps", "hooks"},
        features = {"src/test/resources/features/meetingLinks.feature"},
        dryRun = false,
        stepNotifications = true
)


public class MeetingLinksRunner {

}
