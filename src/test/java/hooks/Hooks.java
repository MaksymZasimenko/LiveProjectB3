package hooks;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;
import utils.Driver;
import utils.ScreenShotUtils;

public class Hooks {
    @Before
    public void setUp(Scenario scenario){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ScreenShotUtils.initScenario(scenario);
    }

    @After
    public void tearDown(){
        Driver.endDriver();
    }
}
