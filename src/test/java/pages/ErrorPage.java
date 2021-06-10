package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ErrorPage extends BasePage{
    public ErrorPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "flash")
    WebElement userIncorrect;
    @FindBy (xpath = "//body/h1[contains(text(),'Internal')]")
    WebElement errorNullMessage;

    public void verifyElementsLoginEmpty() {
        try{
            waitForElementVisible(userIncorrect);
        }catch (NullPointerException e){
            System.out.println(
                    "Los elementos no pudieron ser localizados " +
                            "en HomePage");
        }
    }
    public void verifyElementsLoginWrong(){
        try{
            waitForElementVisible(userIncorrect);
        }catch (NullPointerException e){
            System.out.println("Los elementos no pudieron ser localizados en HomePage");
        }
    }

    public void validateNullValuesSongsPage(){

    }
    public void validateSendNullMessage(){
        try{
            waitForElementVisible(errorNullMessage);
        }catch(Exception e){
            throw new TimeoutException("El elemento no pude ser encontrado");
        }
    }

}
