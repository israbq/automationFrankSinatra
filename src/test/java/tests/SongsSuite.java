package tests;

import org.junit.Assert;
import org.junit.Test;

public class SongsSuite extends BaseTest {
    @Test
    public void createNewSong() {
        home.navigateToUrl("https://sinatra-internet-songbase.herokuapp.com/");
        home.verifyElements();
        home.clickLinkLogin();
        login.verifyElements();
        login.enterCredentials("frank", "sinatra");
        songs.verifyLoginMessage();
        songs.verifyElements();
        songs.createNewSongClick();
        songs.registerANewSongValidationPage();
        songs.enterValuesNewSong("Isra Prueba", 300, "02/06/2021", "prueba de Israel canción");
        songs.clicSaveSongNew();
        songs.validateSuccessNewSongs();
    }

    @Test
    public void editASong() {
        home.navigateToUrl("https://sinatra-internet-songbase.herokuapp.com/");
        home.verifyElements();
        home.clickLinkLogin();
        login.verifyElements();
        login.enterCredentials("frank", "sinatra");
        songs.verifyLoginMessage();
        songs.verifyElements();
        songs.selectASong("Prueba");
        songsDetail.verifyElementsDetailsSong();
        songsDetail.clicEditSong();
        songsDetail.editSongPageValidation();
        songsDetail.editSongPageNewValues("Israel 2", 160, "07/06/2021", "Hola esta es una prueba de automation");
        songsDetail.clicSaveSongEdit();
        songsDetail.validateSuccessEditSongs();
    }

    @Test
    public void enterNullValuesNewSong() {
        home.navigateToUrl("https://sinatra-internet-songbase.herokuapp.com/");
        home.verifyElements();
        home.clickLinkLogin();
        login.verifyElements();
        login.enterCredentials("frank", "sinatra");
        songs.verifyLoginMessage();
        songs.verifyElements();
        songs.createNewSongClick();
        songs.registerANewSongValidationPage();
        songs.enterNullValuesNewSong("", null, "", "");
        error.validateNullValuesSongsPage();
    }

    @Test
    public void deleteASong() {
        home.navigateToUrl("https://sinatra-internet-songbase.herokuapp.com/");
        home.verifyElements();
        home.clickLinkLogin();
        login.verifyElements();
        login.enterCredentials("frank", "sinatra");
        songs.verifyLoginMessage();
        songs.verifyElements();
        songs.selectASong("Prueba");
        songsDetail.verifyElementsDetailsSong();
        songs.clicDeleteSong();
        songs.validateDeleteSongMessage();
    }

    @Test
    public void likeASong() {
        home.navigateToUrl("https://sinatra-internet-songbase.herokuapp.com/");
        home.verifyElements();
        home.clickLinkLogin();
        login.verifyElements();
        login.enterCredentials("frank", "sinatra");
        songs.verifyLoginMessage();
        songs.verifyElements();
        songs.selectASong("Prueba");
        songsDetail.verifyElementsDetailsSong();
        int numLikes = songsDetail.getNumberOfLikes();
        songsDetail.clicLikeASong();
        int numLikesAfter = songsDetail.getNumberOfLikes();
        Assert.assertEquals(numLikes, numLikesAfter - 1);
    }

    @Test
    public void validateBackSongIndexButton() {
        home.navigateToUrl("https://sinatra-internet-songbase.herokuapp.com/");
        home.verifyElements();
        home.clickLinkLogin();
        login.verifyElements();
        login.enterCredentials("frank", "sinatra");
        songs.verifyLoginMessage();
        songs.verifyElements();
        songs.selectASong("Prueba");
        songsDetail.clicBackToSongsIndex();
        songs.verifyElements();
    }

    @Test
    public void validateLogOutButton() {
        home.navigateToUrl("https://sinatra-internet-songbase.herokuapp.com/");
        home.verifyElements();
        home.clickLinkLogin();
        login.verifyElements();
        login.enterCredentials("frank", "sinatra");
        songs.verifyLoginMessage();
        songs.verifyElements();
        songs.selectASong("Prueba");
        songsDetail.clicLogOutButton();
        home.validateMessageLogOut();
    }


}
