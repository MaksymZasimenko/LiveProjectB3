package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LogInPage {

    public LogInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//input[@name='email']")
    public WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath ="//*[contains(text(),'Login')]")
    public WebElement logInButton;
}
