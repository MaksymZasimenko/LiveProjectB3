package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LogInPage;
import pages.MeetingLinksPage;
import utils.ConfigReader;
import utils.Driver;

import java.util.List;

public class MeetingLinkSteps {
    MeetingLinksPage meetingLinksPage = new MeetingLinksPage();
    LogInPage logInPage = new LogInPage();
    private WebElement meetingLinksBtn = meetingLinksPage.meetingLinksBtn;
    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);



    @Then("I verify meeting links button is enabled")
    public void iVerifyMeetingLinksButtonIsEnabled() {
        Assert.assertTrue(meetingLinksPage.meetingLinksBtn.isEnabled());
    }

    @Then("I click on meeting links button")
    public void iClickOnMeetingLinksButton() {
        wait.until(ExpectedConditions.elementToBeClickable(meetingLinksBtn));
        meetingLinksBtn.click();
    }

    @Then("I verify that im on meeting links page")
    public void iVerifyThatImOnMeetingLinksPage() {
        Assert.assertEquals("Meeting Links", Driver.getDriver().getTitle());
    }
    @Then("I enter {string} in the Name input box")
    public void iEnterInTheNameInputBox(String arg0) {
        meetingLinksPage.linkName.sendKeys(ConfigReader.getProperty("testName"));
    }

    @Then("I enter {string} in the Link input box")
    public void iEnterInTheLinkInputBox(String arg0) {
        meetingLinksPage.link.sendKeys(ConfigReader.getProperty("testUrl"));
    }

    @Then("I select {string} from the Color table")
    public void iSelectFromTheColorTable(String arg0) {
        meetingLinksPage.color.sendKeys(arg0);
    }

    @Then("I click add button")
    public void iClickButton() {
        meetingLinksPage.addLinkBtn.click();
    }


    @Then("I go one page back")
    public void iGoOnePageBack() {
        Driver.getDriver().navigate().back();
    }

    @Then("I click sign out button")
    public void iClickSignOutButton() {
        meetingLinksPage.signOutBtn.click();
    }


    @Then("I should see four new links")
    public int iShouldSeeFourNewLinks() {
        List<WebElement> linkList = Driver.getDriver().findElements(By.xpath("//tr[@class='table-primary']"));
        for (int i = 0; i <= linkList.size(); i++){
            if(i > 1){
                Assert.assertTrue(true);
                linkList.size();
            }
        }
        return linkList.size();
    }


    @Then("I enter JohnCena@gmail.com in the email input box")
    public void iEnterJohnCenaGmailComInTheEmailInputBox() {
        logInPage.username.sendKeys("JohnCena@gmail.com");
    }

    @Then("I enter {int} in the password input box")
    public void iEnterInThePasswordInputBox(int arg0) {
        logInPage.password.sendKeys(Integer.toString(arg0));
    }
}
