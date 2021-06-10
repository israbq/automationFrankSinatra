package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(css = "p")
    WebElement welcomeTxt;
    @FindBy(css = "[alt='Frank Sinatra']")
    WebElement sinatraImage;
    @FindBy( css = "[href='/login']" )
    WebElement loginLink;
    @FindBy (css = ".flash.notice")
    WebElement messageLogOut;
    // //section/div/div[contains(text(),'You have')]

    public HomePage(WebDriver driver){
        super(driver);
    }
    public void navigateToUrl(String url){
        driver.get(url);
    }
    public void verifyElements(){
        try{
           waitForElementVisible(welcomeTxt);
           waitForElementVisible(sinatraImage);
           waitForElementVisible(loginLink);
        }catch (NullPointerException e){
            System.out.println("Los elementos no pudieron ser localizados en HomePage");
        }
    }
    public void validateMessageLogOut(){
        waitForElementVisible(messageLogOut);
    }

    public void clickLinkLogin() {
        loginLink.click();
    }
}
