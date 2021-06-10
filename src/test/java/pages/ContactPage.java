package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage{
    public ContactPage(WebDriver driver){
        super(driver);
    }
    @FindBy (xpath = "//section/p[contains(text(),'You can contact me')]")
    WebElement contactText;
    @FindBy (xpath = "//form/label[contains(text(),'Name')]")
    WebElement nameText;
    @FindBy (xpath = "//form/input[contains(@name,'name')]")
    WebElement nameTextInput;
    @FindBy (xpath = "//form/label[contains(text(),'Email')]")
    WebElement emailText;
    @FindBy (xpath = "//form/input[contains(@name,'email')]")
    WebElement emailTextInput;
    @FindBy (xpath = "//form/label[contains(text(),'Your Message')]")
    WebElement yourMessageText;
    @FindBy (xpath = "//form/textarea[contains(@name,'message')]")
    WebElement yourMessageTextInput;
    @FindBy (xpath = "//form/input[contains(@type,'submit')]")
    WebElement sendMessageButton;
    @FindBy (xpath = "//footer/a[contains(text(),'log out')]")
    WebElement logOutButton;
    @FindBy (xpath = "//body/h1[contains(text(),'Internal')]")
    WebElement messageSent;


    public void validateElements(){
        try{
            waitForElementVisible(contactText);
            waitForElementVisible(nameText);
            waitForElementVisible(nameTextInput);
            waitForElementVisible(emailText);
            waitForElementVisible(emailTextInput);
            waitForElementVisible(yourMessageText);
            waitForElementVisible(yourMessageTextInput);
            waitForElementVisible(sendMessageButton);
            waitForElementVisible(logOutButton);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void filledFields(String name, String email, String message){
        nameTextInput.sendKeys(name);
        emailTextInput.sendKeys(email);
        yourMessageTextInput.sendKeys(message);

    }
    public void clicSendMessage(){
        sendMessageButton.click();
    }
    public void validateSuccessMessageSent(){
        try{
            waitForElementVisible(messageSent);
        }catch(Exception e){
            throw new TimeoutException("El elemento no pude ser encontrado");
        }
    }
    public void clicLogOutButton(){
        try{
            logOutButton.click();
        }catch (Exception e){
            throw new TimeoutException("No se pudo dar clic al botón");
        }
    }


}
