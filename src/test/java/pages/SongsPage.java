package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SongsPage extends BasePage {
    public SongsPage(WebDriver driver){
        super(driver);
    }

    @FindBy (css=".flash") WebElement loginMessageTxt;
    @FindBy (css="section h1") WebElement songsHeader;
    @FindBy (css ="[href='/songs/new']") WebElement createSongLink;
    @FindBy (css="#songs") WebElement songsList;
    @FindBy (css="#title") WebElement titleSong;
    @FindBy (css="#length") WebElement lengthSong;
    @FindBy (css="#released_on") WebElement releasedSong;
    @FindBy (css="#lyrics") WebElement lyricsSong;
    @FindBy (css = "input[value='Save Song']") WebElement saveButton;
    @FindBy (css =".flash.notice") WebElement songSucessfullyAdded;
    @FindBy (css = "[href='/about']") WebElement clicAbout;
    @FindBy (css = "[href='/contact']") WebElement clicContact;
    @FindBy(css = "#songs a[href *= '/songs/']")
    List<WebElement> songLinks;


    public void verifyElements(){
        try {
            waitForElementVisible(songsHeader);
            waitForElementVisible(createSongLink);
            waitForElementVisible(songsList);
        } catch(Exception e){
            throw new NoSuchElementException("Los elementos no pudieron ser localizados");
        }
    }
    public void verifyLoginMessage(){

        waitForElementVisible(loginMessageTxt);
    }
    public void createNewSongClick(){

        createSongLink.click();
    }
    public void registerANewSongValidationPage() {
        try{
            waitForElementVisible(songsHeader);
            waitForElementVisible(titleSong);
            waitForElementVisible(lengthSong);
            waitForElementVisible(releasedSong);
            waitForElementVisible(lyricsSong);
            waitForElementVisible(saveButton);
            System.out.println("Los elementos están visibles");
        }catch(Exception e){
            throw new NoSuchElementException("Los elementos no pudieron ser localizados");
        }
    }
    public void enterValuesNewSong(String title, int length, String date, String lyrics) {
        try{
            titleSong.sendKeys(title);
            lengthSong.sendKeys(String.valueOf(length));
            releasedSong.sendKeys(date);
            lyricsSong.sendKeys(lyrics);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Los datos no pudieron ser ingresados");
        }
    }
    public void clicSaveSongNew(){
        try{
            saveButton.click();
        }catch(NoSuchElementException e){
            throw new NoSuchElementException("No se pudo guardar la canción");
        }
    }
    public void validateSuccessNewSongs(){
        try{
            waitForElementVisible(songSucessfullyAdded);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("No se pudo validar el guardado de canción");
        }
    }
    public void enterNullValuesNewSong(String title, Integer length, String date, String lyrics){
        try{
            titleSong.sendKeys(title);
            lengthSong.sendKeys(String.valueOf(length));
            releasedSong.sendKeys(date);
            lyricsSong.sendKeys(lyrics);
        }catch(Exception e){

        }
    }
    public void selectASong(String songName){
        boolean isFound = false;
        for (WebElement songLink : songLinks) {
            if (songLink.getText().equals(songName)){
                songLink.click();
                isFound = true;
                break;
            }
        }
        if(!isFound) {
            throw new NoSuchElementException(songName + " is not in the songList");
        }
    }

    public void clicDeleteSong(){

    }
    public void validateDeleteSongMessage(){

    }

    public void clicAbout(){
        clicAbout.click();

    }
    public void clicContact(){
        clicContact.click();
    }


}
