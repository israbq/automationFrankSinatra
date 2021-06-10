package tests;

import org.junit.Test;

public class ContactSuite extends BaseTest {
    @Test
    public void sendMessage() {
        home.navigateToUrl("https://sinatra-internet-songbase.herokuapp.com/");
        home.verifyElements();
        home.clickLinkLogin();
        login.verifyElements();
        login.enterCredentials("frank", "sinatra");
        songs.verifyLoginMessage();
        songs.clicContact();
        contact.validateElements();
        contact.filledFields("Israel","israel@yopmail.com","Hola esta es una prueba");
        contact.clicSendMessage();
        contact.validateSuccessMessageSent();
    }
    @Test
    public void sendNullMessage(){
        home.navigateToUrl("https://sinatra-internet-songbase.herokuapp.com/");
        home.verifyElements();
        home.clickLinkLogin();
        login.verifyElements();
        login.enterCredentials("frank", "sinatra");
        songs.verifyLoginMessage();
        songs.clicContact();
        contact.validateElements();
        contact.filledFields("","","");
        contact.clicSendMessage();
        error.validateSendNullMessage();
    }
    @Test
    public void validateLogOutButton(){
        home.navigateToUrl("https://sinatra-internet-songbase.herokuapp.com/");
        home.verifyElements();
        home.clickLinkLogin();
        login.verifyElements();
        login.enterCredentials("frank", "sinatra");
        songs.verifyLoginMessage();
        songs.clicContact();
        contact.validateElements();
        contact.clicLogOutButton();
        home.validateMessageLogOut();
    }
}
