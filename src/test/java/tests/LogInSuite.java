package tests;

import org.junit.Test;

public class LogInSuite extends BaseTest {


    @Test
    public void loginSuccessful(){
        home.navigateToUrl("https://sinatra-internet-songbase.herokuapp.com/");
        home.verifyElements();
        home.clickLinkLogin();
        login.verifyElements();
        login.enterCredentials("frank","sinatra");
        songs.verifyLoginMessage();
    }
    @Test
    public void loginEmpty(){
        home.navigateToUrl("https://sinatra-internet-songbase.herokuapp.com/");
        home.verifyElements();
        home.clickLinkLogin();
        login.verifyElements();
        login.enterCredentials("","");
        error.verifyElementsLoginEmpty();
    }
    @Test
    public void loginWrong(){
        home.navigateToUrl("https://sinatra-internet-songbase.herokuapp.com/");
        home.verifyElements();
        home.clickLinkLogin();
        login.verifyElements();
        login.enterCredentials("frank","Sinatra");
        error.verifyElementsLoginWrong();
    }
}
