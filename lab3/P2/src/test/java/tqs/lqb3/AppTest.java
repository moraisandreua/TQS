package tqs.lqb3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebElement;
import jdk.jfr.Timestamp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    WebDriver browser;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","/opt/WebDriver/geckodriver");
        FirefoxOptions options = new FirefoxOptions().addPreference("browser.startup.homepage", "https://www.ua.pt");
        browser=new FirefoxDriver(options);
    }

    @Test
    void site_header_is_on_home_page(){
        browser.get("http://www.saucelabs.com");
        WebElement href = browser.findElement(By.xpath("//a[@href='https://accounts.saucelabs.com/']"));
        assertTrue(href.isDisplayed());
    }
    
    @AfterEach
    void tearDown(){
        browser.close();
    }
}
