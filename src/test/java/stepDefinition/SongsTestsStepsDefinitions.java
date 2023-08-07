package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;

public class SongsTestsStepsDefinitions {
    private final BaseDefinitionsCommonSteps commonSteps;

    public SongsTestsStepsDefinitions(BaseDefinitionsCommonSteps commonSteps){
        this.commonSteps = commonSteps;
    }

        @When("I click AllSongs menu")
        public void clickAllSongs() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
        }

        @And("I double click first song")
        public void doubleClickFirstSong() {
            WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//tr[@class='song-item playing']//td[@class='title']")));
            actions.doubleClick(playListElement).perform();
        }

        @Then("Song is playing")
        public void songIsPlaying() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='pause-btn']"))).isDisplayed();
        }
}

