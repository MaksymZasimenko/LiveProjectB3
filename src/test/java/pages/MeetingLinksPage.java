package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class MeetingLinksPage {

    public MeetingLinksPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Meeting links')]")
    public WebElement meetingLinksBtn;

    @FindBy(id = "name")
    public WebElement linkName;

    @FindBy(id = "link")
    public WebElement link;

    @FindBy(id = "color")
    public WebElement color;


    @FindBy(xpath = "//button[@class='btn btn-light']")
    public WebElement signOutBtn;

    @FindBy(id = "submit-btn")
    public WebElement addLinkBtn;
}
