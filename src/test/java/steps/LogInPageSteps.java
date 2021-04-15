package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.LogInPage;
import utils.Driver;

public class LogInPageSteps {
    LogInPage logInPage = new LogInPage();
    @Given("Login page should be displayed")
    public void navigateToLogInPage(){
        Assert.assertEquals(Driver.getDriver().getTitle(), "Home Page");
    }

    @Then("I verify that logo is displayed")
    public void iVerifyThatLogoIsDisplayed() {
        WebElement logo = Driver.getDriver().findElement(By.xpath("//img[@class='avatar']"));
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)Driver.getDriver())
                .executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth " +
                        "!= \"undefined\" && arguments[0].naturalWidth > 0", logo);
        if(!ImagePresent){
            try {
                throw new Exception("Logo is not displayed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Then("I verify that {string} input box is enabled")
    public void iVerifyThatInputBoxIsEnabled(String input) {
        Assert.assertTrue(logInPage.username.isEnabled());
        Assert.assertTrue(logInPage.password.isEnabled());
    }
}
