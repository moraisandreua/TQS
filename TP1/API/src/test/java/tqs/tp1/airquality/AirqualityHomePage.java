package tqs.tp1.airquality;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class AirqualityHomePage {
    WebDriver driver;

    @FindBy(id="searchInput")
    private By searchInput;

    @FindBy(id="locationTitle")
    private By locationTitle;

    public AirqualityHomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:3000/");
        this.driver.manage().window().setSize(new Dimension(1440, 875));
        PageFactory.initElements(driver, this);
    }

    public void setSearchInput(String name){
        driver.findElement(By.id("searchInput")).sendKeys(name);
    }

    public void setEnter(){
        driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
    }

    public String getLocationTitle(){
        return driver.findElement(By.id("locationTitle")).getText();
    }
}
