package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "email") WebElement emailInput;
    @FindBy(id = "pass") WebElement passInput;
    @FindBy(id = "send2") WebElement signInButton;
    @FindBy(css = ".page-title") WebElement dashboardTitle;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
    }

    public void login(String email, String password) {
        emailInput.sendKeys(email);
        passInput.sendKeys(password);
        signInButton.click();
    }

    public boolean isLoggedIn() {
        return dashboardTitle.getText().contains("My Account");
    }
}
