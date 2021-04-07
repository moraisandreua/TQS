import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeDemoReserve {

  WebDriver driver;

  @FindBy(css="tr:nth-child(2) .btn")
  private By btn;

  public BlazeDemoReserve(WebDriver driver) {
    this.driver = driver;
  }

  public BlazeDemoPurchase clickChooseThisFlight() {
    this.driver.findElement(this.btn).click();
    return new BlazeDemoPurchase(this.driver);
  }
}