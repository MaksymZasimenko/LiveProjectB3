package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;
import utils.MiscUtils;
import utils.ScreenShotUtils;

import java.util.ArrayList;
import java.util.List;

public class HomeworkSteps {

    @Then("I verify Homework page is displayed containing:")
    public void iVerifyHomeworkPageIsDisplayedContaining(List<String> exp) {
        List<WebElement> al=Driver.getDriver().findElements(By.xpath("//li[@class='list-group-item']"));
        List<String> actual=new ArrayList<>();
        for(WebElement element:al){
            String str= element.getText();
            actual.add(str);
        }
        Assert.assertEquals(exp,actual);
        ScreenShotUtils.logPass("Homework page is displayed", true);
    }

    @Then("I click {string}")
    public void iClick(String arg0) {
        WebElement element=Driver.getDriver().findElement(By.xpath("//li[contains(text(),'CSS Selector task 1')]"));
        MiscUtils.highlightElement(element).click();
    }

    @Then("I verify homework {string} on the page")
    public void iVerifyHomeworkNameOnThePage(String arg0) {
        String str=Driver.getDriver().findElement(By.id("title")).getText();
        Assert.assertEquals(arg0,str);
    }

    @And("I verify that followed List is displayed:")
    public void iVerifyThatFollowedListIsDisplayed(List<String> expected) {
        List<WebElement> al=Driver.getDriver().findElements(By.xpath("//div[@id='status-table']/ul/li[@class='list-group-item']"));
        List<String> actual=new ArrayList<>();
        for(WebElement element:al){
            String str=element.getText();
            int i2=str.indexOf(':');
            str=str.substring(0,i2+1);
            actual.add(str);
        }
        Assert.assertEquals(expected,actual);
    }


    @Then("I verify comment section is displayed")
    public void iVerifyCommentSectionIsDisplayed() {
        Driver.getDriver().findElement(By.xpath("//textarea[@placeholder='Enter your comment']")).isEnabled();
    }


    @And("I enter comment in comment area")
    public void iEnterCommentInCommentArea() {
        WebElement element=Driver.getDriver().findElement(By.xpath("//textarea[@placeholder='Enter your comment']"));
        MiscUtils.highlightElement(element).sendKeys("Lorem ipsum dolor");
    }

    @And("I click Add comment button")
    public void iClickAddCommentButton() {
        WebElement element=Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Add comment')]"));
        MiscUtils.highlightElement(element).click();
    }

    @Then("I check that added {string} is displayed with timestamp and name")
    public void iCheckThatAddedCommentIsDisplayedWithTimestampAndName(String arg0) {
        WebElement element=Driver.getDriver().findElement(By.xpath("//div[contains(text(),'"+arg0+"')]"));
        WebElement name=Driver.getDriver().findElement(By.xpath("//div[contains(text(),'"+arg0+"')]/../div/div[1]"));
        WebElement el=Driver.getDriver().findElement(By.xpath("//div[contains(text(),'"+arg0+"')]/../div/div[2]"));
        String timeStamp=el.getText();
        int i=timeStamp.indexOf(",");
        timeStamp=timeStamp.substring(0,i);
        Assert.assertEquals(element.getText(),arg0);
        Assert.assertEquals(name.getText(),"John");
        Assert.assertEquals(timeStamp, "April 19th 2021");
    }

    @Then("I verify homework section is displayed")
    public void iVerifyHomeworkSectionIsDisplayed() {
        WebElement element=Driver.getDriver().findElement(By.xpath("//textarea[@id='inputArea']"));
        Assert.assertTrue(element.isEnabled());
    }

    @And("I enter {string} in homework section")
    public void iEnterCommentInHomeworkSection(String arg0) {
        WebElement element=Driver.getDriver().findElement(By.xpath("//textarea[@id='inputArea']"));
        MiscUtils.highlightElement(element).sendKeys(arg0);
    }

    @And("I click Save homework button")
    public void iClickSaveHomeworkButton() {
        WebElement element=Driver.getDriver().findElement(By.xpath("//div[@class='answer-section']//button[contains(text(),'Save')]"));
        MiscUtils.highlightElement(element).click();
    }

    @Then("I check that added {string} is displayed")
    public void iCheckThatAddedIsDisplayed(String arg0) {
        WebElement element=Driver.getDriver().findElement(By.xpath("//div[@id='submitted_homework']"));
        Assert.assertEquals(arg0,element.getText());
    }

    @And("I check that status of homework changed to Saved")
    public void iCheckThatStatusOfHomeworkChangedToSaved() {
        WebElement element=Driver.getDriver().findElement(By.xpath("//div[@id='status-table']/ul/li[@class='list-group-item'][1]"));
        Assert.assertEquals("Status:Saved",element.getText());
    }

    @Then("I clear homework section")
    public void iClearHomeworkSection() {
        WebElement element=Driver.getDriver().findElement(By.xpath("//div[@class='answer-section']//button[contains(text(),'Edit')]"));
        element.click();
        WebElement element2=Driver.getDriver().findElement(By.xpath("//textarea[@id='inputArea']"));
        element2.clear();
    }
}
