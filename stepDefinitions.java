package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.RegistrationPage;
import static org.junit.Assert.*;

public class RegistrationLoginSteps {

    WebDriver driver;
    RegistrationPage regPage;
    LoginPage loginPage;
    String generatedEmail;
    String password = "Test@12345";

    @Given("I open the Magento registration page")
    public void openRegistrationPage() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        regPage = new RegistrationPage(driver);
        regPage.open();
    }

    @When("I enter valid registration details")
    public void fillRegistration() {
        generatedEmail = "user" + System.currentTimeMillis() + "@example.com";
        regPage.register("First", "Last", generatedEmail, password);
    }

    @Then("I should see registration success message")
    public void verifyRegistration() {
        String message = regPage.getSuccessMessage();
        assertTrue(message.contains("Thank you for registering")); 
        driver.quit();
    }

    @Given("I open the Magento login page")
    public void openLoginPage() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @When("I log in with correct credentials")
    public void performLogin() {
        loginPage.login(generatedEmail, password);
    }

    @Then("I should be successfully logged in")
    public void verifyLogin() {
        assertTrue(loginPage.isLoggedIn());
        driver.quit();
    }
}
