package tqs.tp1.airquality;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;


import java.util.*;
import java.util.concurrent.TimeUnit;

@ExtendWith(SeleniumJupiter.class)
class UiTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/opt/WebDriver/geckodriver");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    void testSearch() throws InterruptedException {
        AirqualityHomePage home = new AirqualityHomePage(driver);

        home.setSearchInput("Porto");

        home.setEnter();

        TimeUnit.SECONDS.sleep(2);

        assertThat(home.getLocationTitle(), is("Sobreiras-Lordelo do Ouro, Porto, Portugal"));

    }
}
