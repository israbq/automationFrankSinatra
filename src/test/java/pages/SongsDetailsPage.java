package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SongsDetailsPage extends BasePage{
    public SongsDetailsPage(WebDriver driver){
        super(driver);
    }
    @FindBy (xpath = "//section/h1")
    WebElement titleSong;
    @FindBy (xpath = "//form/input[@name='song[title]']")
    WebElement titleSongValue;
    @FindBy (xpath = "//section/p[contains(text(),'Length')]")
    WebElement lengthSong;
    @FindBy (xpath = "//form/input[@name='song[length]']")
    WebElement lengthSongValue;
    @FindBy (xpath = "//section/p[contains(text(),'Release Date')]")
    WebElement releasedSong;
    @FindBy (xpath = "//form/input[@name='song[released_on]']")
    WebElement releasedSongValue;
    @FindBy (xpath = "//section/pre")
    WebElement lyricsSong;
    @FindBy (xpath = "//form/textarea[@name='song[lyrics]']")
    WebElement lyricsSongValue;
    @FindBy (css= "#like p")
    WebElement numberOfLikeMessage;
    @FindBy (xpath = "//form/input[@value='Like']")
    WebElement clicLike;
    @FindBy (xpath = "//p/a[contains(text(),'edit this song')]")
    WebElement editSong;
    @FindBy (xpath = "//p/a[contains(text(),'back to songs index')]")
    WebElement backToSongButton;
    @FindBy (xpath = "//form/input[@value='delete this song']")
    WebElement deleteSongButton;
    @FindBy (xpath = "//footer/a[contains(text(),'log out')]")
    WebElement logOutButton;
    @FindBy (xpath = "//form/input[@value='Save Song']")
    WebElement saveSongAfterEdit;
    @FindBy (xpath = "//div/div[contains(text(),'Song successfully updated')]")
    WebElement messageSuccessfullyEdit;


    public void verifyElementsDetailsSong() {
        try {
            waitForElementVisible(titleSong);
            waitForElementVisible(releasedSong);
            waitForElementVisible(lengthSong);
            waitForElementVisible(lyricsSong);
            waitForElementVisible(numberOfLikeMessage);
            waitForElementVisible(clicLike);
            waitForElementVisible(editSong);
            waitForElementVisible(backToSongButton);
            waitForElementVisible(deleteSongButton);
            waitForElementVisible(logOutButton);
            System.out.println("Los elementos se pudieron localizar correctamente");
        } catch (Exception e) {
            throw new TimeoutException("No se pudo localizar el elemento");
        }

    }
    public void clicEditSong(){
            try{
                editSong.click();
            }catch(Exception e){
                throw new TimeoutException("No se dio clic al elemento");
            }
    }
    public void editSongPageValidation(){
        try{
            waitForElementVisible(titleSongValue);
            waitForElementVisible(lengthSongValue);
            waitForElementVisible(releasedSongValue);
            waitForElementVisible(releasedSongValue);
            waitForElementVisible(lyricsSongValue);
            waitForElementVisible(saveSongAfterEdit);
            waitForElementVisible(logOutButton);
            System.out.println("Los elementos se pudioeron localizar correctamente");
        }catch (Exception e){
            throw new TimeoutException("No se encontraron los elementos");
        }
    }
    public void clicBackToSongsIndex(){

    }
    public void clicLogOutButton(){

    }
    public int getNumberOfLikes() {
        String message = numberOfLikeMessage.getText();
        if(message.contains("Nobody")) {
            return 0;
        } else if (message.contains("once")) {
            return 1;
        } else {
            String[] partsOfMessage = message.split(" ");
            return Integer.parseInt(partsOfMessage[partsOfMessage.length - 2]);
        }
    }
    public void clicLikeASong(){
        clicLike.click();
    }
    public void editSongPageNewValues(String title, int length, String releaseDate, String lyrics ){
        try{
            titleSongValue.sendKeys(title);
            lengthSongValue.sendKeys(String.valueOf(length));
            releasedSongValue.sendKeys(releaseDate);
            lyricsSongValue.sendKeys(lyrics);
            System.out.println("Los valores pudieron ser ingresados correctamente");
        }catch(Exception e){
            throw new TimeoutException("Los valores no pudieron ser ingresados correcamente");
        }
    }
    public void clicSaveSongEdit(){
            try{
                saveSongAfterEdit.click();
            }catch(Exception e){
                throw new TimeoutException("No se pudo dar clic al botón de Guardar");
        }
    }
    public void validateSuccessEditSongs(){
        try{
            waitForElementVisible(messageSuccessfullyEdit);
            System.out.println("Mensaje de canción actualizada se muestra correctamente");
        }catch(Exception e){
            throw new TimeoutException("No se pudo validar el mensaje de actualizaco");
        }
    }
}
