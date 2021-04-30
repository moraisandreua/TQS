package tqs.lab5;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class StepDefinitions {
    BlazeDemo bd;
    BlazeDemoPurchase purchase;
    BlazeDemoConfirmation confirmacao;
    WebDriver driver;

    @Given("I want to go from {string} to {string}")
    public void i_want_to_go_from_to(String string, String string2) {
        System.setProperty("webdriver.gecko.driver", "/opt/WebDriver/geckodriver");
        FirefoxOptions options = new FirefoxOptions().addPreference("browser.startup.homepage", "https://www.ua.pt"); // completamente desnecessário...
        driver = new FirefoxDriver(options);
        bd = new BlazeDemo(driver);
        bd.setFrom(string);
        bd.setTo(string2);

        BlazeDemoReserve reserva = bd.clickFindFlights();
        purchase = reserva.clickChooseThisFlight();
    }

    @Given("My name is {string}")
    public void my_name_is(String string) {
        purchase.setName(string);
    }

    @Given("My address is {string}")
    public void my_address_is(String string) {
        purchase.setAddress(string);
    }

    @Given("My city is {string}")
    public void my_city_is(String string) {
        purchase.setCity(string);
    }

    @Given("My state is {string}")
    public void my_state_is(String string) {
        purchase.setState(string);
    }

    @Given("My zip code is {string}")
    public void my_zip_code_is(String string) {
        purchase.setZipCode(string);
    }

    @Given("My card type is {string}")
    public void my_card_type_is(String string) {
        purchase.setCardType(string);
    }

    @Given("My card number is {int}")
    public void my_card_number_is(Integer int1) {
        purchase.setCreditCardNumber(String.valueOf(int1));
    }

    @Given("My card name is {string}")
    public void my_card_name_is(String string) {
        purchase.setNameOnCard(string);
    }

    @Given("customer clicks on checkbox")
    public void customer_clicks_on_checkbox() {
        purchase.clickCheckbox();
    }

    @When("customer purchase")
    public void customer_purchase() {
        confirmacao = purchase.clickConfirm();
    }

    @Then("some text must appear {string}")
    public void some_text_must_appear(String string) {
        new WebDriverWait(driver, 10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(string);
            }
        });
    }
}
