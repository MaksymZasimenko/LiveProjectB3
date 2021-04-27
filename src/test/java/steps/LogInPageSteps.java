package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.LogInPage;
import utils.Driver;
import utils.MiscUtils;

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

    @Then("I enter {string} in the email input box")
    public void iEnterInTheInputBox(String arg0) {
        WebElement element = logInPage.username;
        MiscUtils.highlightElement(element).sendKeys(arg0);
    }

    @And("I enter {string} in the password input box")
    public void iEnterInThePasswordInputBox(String arg0) {
        WebElement element = logInPage.password;
        MiscUtils.highlightElement(element).sendKeys(arg0);
    }

    @And("I click Login button")
    public void iClickButton() {
        WebElement element = logInPage.logInButton;
        MiscUtils.highlightElement(element).click();
    }

    @Then("I should see {string}")
    public void iShouldSee(String arg0) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[contains(text(),'"+arg0+"')]"));
        Assert.assertTrue(element.isDisplayed());
    }

    @Then("I click Homework button")
    public void iClickHomeworkButton() {
        WebElement element=Driver.getDriver().findElement(By.xpath("//*[contains(text(),'Homeworks')]"));
        MiscUtils.highlightElement(element).click();
    }
}
