package tqs.lab5;

import java.util.NoSuchElementException;

import org.graalvm.compiler.virtual.phases.ea.PartialEscapeBlockState;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions {

    private WebDriver driver;

    @Given("I am on the Google search page")
    public void i_am_on_the_google_search_page() {
        System.setProperty("webdriver.gecko.driver", "/opt/WebDriver/geckodriver");
        FirefoxOptions options = new FirefoxOptions().addPreference("browser.startup.homepage", "https://www.ua.pt");
        driver = new FirefoxDriver(options);
        driver.get("https://www.google.com/");
    }

    @When("I search for {string}")
    public void i_search_for(String string) {
        WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
        element.sendKeys(string);
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
    }

    @Then("the page title should start with {string}")
    public void the_page_title_should_start_with(String string) {
        new WebDriverWait(driver, 10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(string);
            }
        });
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
