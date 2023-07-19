package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinitions {
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
    @Given("I open Login page")
    public void openLoginPage(){
        driver.get(url);
    }

    @When("I enter email {string}")
        public void i_enter_email(String email){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']"))).sendKeys(email);
        }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
    }
    @And("I submit")
    public void i_click_submit_btn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
    }
    @Then("I am logged into a website")
            public void userLoggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".avatar"))).isDisplayed());
    }


    @Then("I am not logged in")
    public void iAmNotLoggedIn() {
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
}
