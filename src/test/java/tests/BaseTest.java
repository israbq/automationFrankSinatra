package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage login;
    protected HomePage home;
    protected ErrorPage error;
    protected SongsPage songs;
    protected AboutPage about;
    protected ContactPage contact;
    protected SongsDetailsPage songsDetail;

    @Before
    public void before() {
        driver = new ChromeDriver();
        login = new LoginPage(driver);
        home = new HomePage(driver);
        error = new ErrorPage(driver);
        about = new AboutPage(driver);
        contact = new ContactPage(driver);
        songs = new SongsPage(driver);
        songsDetail = new SongsDetailsPage(driver);
    }

    @After
    public void after() {
driver.quit();
    }
}

