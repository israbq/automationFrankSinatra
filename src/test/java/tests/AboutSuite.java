package tests;

import org.junit.Test;

public class AboutSuite extends BaseTest {
    @Test
    public void validateMessageAbout(){
        home.navigateToUrl("https://sinatra-internet-songbase.herokuapp.com/");
        home.verifyElements();
        home.clickLinkLogin();
        login.verifyElements();
        login.enterCredentials("frank","sinatra");
        songs.verifyLoginMessage();
        songs.clicAbout();
        about.validateElements();
        about.validateMessageAbout();
        about.clicLogOut();
        home.validateMessageLogOut();
    }
}
