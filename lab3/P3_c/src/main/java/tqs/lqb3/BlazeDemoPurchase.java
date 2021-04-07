import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeDemoPurchase {

  WebDriver driver;

  @FindBy(id = "inputName")
  private By name;

  @FindBy(id = "address")
  private By address;

  @FindBy(id = "city")
  private By city;

  @FindBy(id = "state")
  private By state;

  @FindBy(id = "zipCode")
  private By zipCode;

  @FindBy(id = "cardType")
  private By cardType;

  @FindBy(id = "creditCardNumber")
  private By creditCardNumber;

  @FindBy(id = "nameOnCard")
  private By nameOnCard;

  @FindBy(className = "checkbox")
  private By checkbox;

  @FindBy(className = "btn-primary")
  private By btn;

  public BlazeDemoPurchase(WebDriver driver) {
    this.driver = driver;
  }

  public void setName(String name) {
    driver.findElement(this.name).click();
    driver.findElement(this.name).sendKeys(name);
  }

  public void setAddress(String address) {
    driver.findElement(By.id("address")).click();
    
    driver.findElement(By.id("address")).sendKeys("rua");
  }

  public void setCity(String city) {
    driver.findElement(By.id("city")).click();
    
    driver.findElement(By.id("city")).sendKeys("cidade");
  }

  public void setState(String state) {
    driver.findElement(By.id("state")).click();
    
    driver.findElement(By.id("state")).sendKeys("estado");
  }

  public void setZipCode(String zipCode) {
    driver.findElement(By.id("zipCode")).click();
    
    driver.findElement(By.id("zipCode")).sendKeys("codigopostal");
  }

  public void setCardType(String cardType) {
    driver.findElement(this.cardType).click();

    {
      WebElement dropdown = driver.findElement(this.cardType);
      dropdown
        .findElement(By.xpath("//option[. = '" + cardType + "']"))
        .click();
    }
  }

  public void setCreditCardNumber(String creditCardNumber) {
    driver.findElement(By.id("creditCardNumber")).click();
    
    driver.findElement(By.id("creditCardNumber")).sendKeys("12345678");
  }

  public void setNameOnCard(String nameOnCard) {
    driver.findElement(By.id("nameOnCard")).click();
    
    driver.findElement(By.id("nameOnCard")).sendKeys("Andre M.");
  }

  public void clickCheckbox() {
    driver.findElement(By.cssSelector(".checkbox")).click();
  }

  public BlazeDemoConfirmation clickConfirm() {
    this.driver.findElement(this.btn).click();
    return new BlazeDemoConfirmation(this.driver);
  }
}
