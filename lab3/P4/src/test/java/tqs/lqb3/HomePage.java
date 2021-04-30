package tqs.lqb3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    private static String PAGE_URL = "https://www.toptal.com";

    @FindBy(tagName = "h1")
    WebElement heading;

    @FindBy(how = How.LINK_TEXT, using = "Apply as a Freelancer")
    private WebElement developerApplyButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened() {
        return heading.getText().toString().contains("Hire the Top");
    }

    public void clickOnDeveloperApplyButton() {
        developerApplyButton.click();
    }
}
