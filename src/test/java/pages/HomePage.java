package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {
    String newPlaylistName = "Updated Playlist";
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    @FindBy(css = ".avatar")
    WebElement userAvatarIcon;

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    @FindBy(css = "li a.songs")
    WebElement allSongs;
    @FindBy(css = "[data-testid='play-btn']")
    WebElement playBtn;
    @FindBy(css = "span.meta.text-secondary span.meta")
    WebElement playlistDetails;
    @FindBy(css = "section#playlistWrapper td.title")
    WebElement numberOfSongs;

    public void chooseAllSongsList() {
        allSongs.click();
    }
    public WebElement hoverPlay() {
       hoverAction(playBtn);
        return playBtn;
    }
    public String getPlaylistDetails() {
        return playlistDetails.getText();
//        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public int countSongs(){

       return numberOfSongs.size();

//        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }
    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of songs found" + countSongs());
        for (WebElement e: songList){
            System.out.println(e.getText());
        }
    }

    public void choosePlaylistByName(String playlistName ) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains (text(),'Happy Holidays')]"))).click();
    }
    public boolean doesPlaylistExists(){
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" +newPlaylistName+"']")));
        return playListElement.isDisplayed();
    }
    public void enterNewPlaylistName() {
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));

        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);

    }

    public void doubleClickPlaylist() {
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='active']")));
        actions.doubleClick(playListElement).perform();
    }
}
