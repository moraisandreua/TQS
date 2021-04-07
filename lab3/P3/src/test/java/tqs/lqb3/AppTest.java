package tqs.lqb3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import jdk.jfr.Timestamp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.github.bonigarcia.seljup.SeleniumJupiter;

/**
 * Unit test for simple App.
 */

@ExtendWith(SeleniumJupiter.class)
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    FirefoxDriver driver;

    public AppTest(FirefoxDriver driver){ this.driver = driver; }

    @Test
    void testWithOneFirefox(){
        driver.get("http://www.ua.pt");
        assertThat(driver.getTitle(), containsString("Universidade de Aveiro"));
    }

    @Test
    void testWithTwoFirefoxs(FirefoxDriver driver1, ChromeDriver driver2){
        driver1.get("http://www.seleniumhq.org/");
        driver2.get("http://www.junit.org/junit5/");
        assertThat(driver1.getTitle(), startsWith("Selenium"));
        assertThat(driver2.getTitle(), equalTo("JUnit 5"));
    }

    @Test
    void testWithHeadless(HtmlUnitDriver driver){
        driver.get("https://www.ua.pt");
        assertThat(driver.getTitle(), containsString("Universidade de Aveiro"));
    }
}
