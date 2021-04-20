package tqs.lab5;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeDemo {

  WebDriver driver;

  @FindBy(name = "fromPort")
  private By from;

  @FindBy(name = "toPort")
  private By to;

  @FindBy(css = ".btn-primary")
  private By btn;

  public BlazeDemo(WebDriver driver) {
    this.driver = driver;
    this.driver.get("https://blazedemo.com/");
    this.driver.manage().window().setSize(new Dimension(1440, 875));
    PageFactory.initElements(driver, this);
  }

  public By getFrom() {
    return from;
  }

  public By getTo() {
    return to;
  }

  public void setFrom(String testFrom) {
    driver.findElement(By.name("fromPort")).click();

    {
      WebElement dropdown = driver.findElement(By.name("fromPort"));
      dropdown
        .findElement(By.xpath("//option[. = '" + testFrom + "']"))
        .click();
    }
  }

  public void setTo(String testTo) {
    driver.findElement(By.name("toPort")).click();

    {
      WebElement dropdown = driver.findElement(By.name("toPort"));
      dropdown.findElement(By.xpath("//option[. = '" + testTo + "']")).click();
    }
  }

  public BlazeDemoReserve clickFindFlights() {
    driver.findElement(By.cssSelector(".btn-primary")).click();
    return new BlazeDemoReserve(this.driver);
  }
}
