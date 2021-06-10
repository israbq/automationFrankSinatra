package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends BasePage{
    public AboutPage(WebDriver driver){
        super(driver);
    }
    @FindBy (css = "section p")
    WebElement messageAbout;
    @FindBy (xpath = "//section/p[contains(text(),'This site')]")
    WebElement containsMessage;
    @FindBy (css="[href='/logout']")
    WebElement logoutButton;

    public void validateElements(){
        try{
            waitForElementVisible(messageAbout);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void validateMessageAbout(){
        waitForElementVisible(containsMessage);
    }
    public void clicLogOut(){
        logoutButton.click();
    }

}
