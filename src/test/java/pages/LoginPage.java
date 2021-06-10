package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Time;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(css=  "[value='Log In']")
    WebElement loginButton;
    @FindBy(css="[href='/login']")
    WebElement loginLink;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void verifyElements(){
        try{
            waitForElementVisible(usernameField);
            waitForElementVisible(passwordField);
            waitForElementVisible(loginButton);
            waitForElementVisible(loginLink);
        }catch(TimeoutException e){
            throw new TimeoutException("El elemento no se pudo localizar");
        }
    }
    public void enterCredentials(String user, String password){
        usernameField.sendKeys(user);
        passwordField.sendKeys(password);
        loginButton.click();
    }

}
