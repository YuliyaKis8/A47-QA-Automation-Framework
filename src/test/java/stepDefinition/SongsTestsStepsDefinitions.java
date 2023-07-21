package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.BasePage.actions;

public class SongsTestsStepsDefinitions {
        WebDriver driver;
        WebDriverWait wait;
        public static String url = "https://qa.koel.app/";

        @Before
        public void openBrowser() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        @After
        public void closeBrowser() {
            driver.quit();
        }

        @Given("I click AllSongs menu")
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

